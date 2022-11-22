package com.sanhak.backend.domain.post.repository;

import com.sanhak.backend.domain.RO.RepairOrder;
import com.sanhak.backend.domain.RO.repository.RORepository;
import com.sanhak.backend.domain.article.CafeArticle;
import com.sanhak.backend.domain.article.repository.CARepository;
import com.sanhak.backend.domain.post.ROMappingPost;
import com.sanhak.backend.domain.post.dto.PostSearch;
import com.sanhak.backend.global.config.QueryDSLConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.LongStream;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@Import(QueryDSLConfig.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ROMappingPostRepositoryTest {

    @Autowired
    private ROMappingPostRepository roMappingPostRepository;
    @Autowired
    private RORepository roRepository;
    @Autowired
    private CARepository caRepository;

    @BeforeAll
    void init() {
        LongStream.rangeClosed(1L,25L)
                .forEach(idx ->{
                    RepairOrder ro = RepairOrder.builder()
                            .cause("cause"+idx)
                            .causePart("causePart"+idx)
                            .causePartCluster("causePartCluster"+idx)
                            .causePartNameKor("causePartNameKor"+idx)
                            .causePartNameEng("causePartNameEng"+idx)
                            .location("location"+idx)
                            .partNumber("partNumber"+idx)
                            .problematicSituation("problematicSituation"+idx)
                            .specialNote("specialNote"+idx)
                            .symptom("symptom"+idx)
                            .vehicleType("vehicleType"+idx)
                            .build();

                    CafeArticle na = CafeArticle.builder()
                            .cafeName("cafe name"+idx)
                            .broadName("broad name"+idx)
                            .userName("user name"+idx)
                            .category("category"+idx)
                            .content("content"+idx)
                            .period(1)
                            .title("title"+idx)
                            .url("url"+idx)
                            .viewCount(0L)
                            .docCreatedAt(LocalDateTime.now())
                            .isMailing(false)
                            .build();

                    ROMappingPost roMappingPost = ROMappingPost.builder()
                            .repairOrder(ro)
                            .cafeArticle(na)
                            .build();
                    roMappingPostRepository.save(roMappingPost);
                });
    }


    @Test
    @DisplayName("페이징 처리 테스트_검색 조건 없을 때 ")
    public void SearchPostWithPaginationTest_with_no_searchOptions() throws Exception{
        //give
        PostSearch ps = PostSearch.builder().build();
        //when
        Page<ROMappingPost> result = roMappingPostRepository.SearchPostWithPagination(ps);
        //then
        assertThat(result.getTotalPages()).isEqualTo(3);
        assertThat(result.getTotalElements()).isEqualTo(25);
        List<ROMappingPost> lists = result.getContent();
        LongStream.rangeClosed(1,10)
                .forEach(idx ->{
                    assertThat(lists.get((int) idx - 1).getId()).isEqualTo(idx);
                    assertThat(lists.get((int) idx - 1).getCafeArticle().getId()).isEqualTo(idx);
                    assertThat(lists.get((int) idx - 1).getRepairOrder().getId()).isEqualTo(idx);
                });
    }

    @Test
    @DisplayName("페이징 처리 테스트_카페 글 제목으로 검색 ")
    public void SearchPostWithPaginationTest_with_title() throws Exception{
        //give
        String title = "title1";
        PostSearch ps = PostSearch.builder().title(title).build();
        //when
        Page<ROMappingPost> result = roMappingPostRepository.SearchPostWithPagination(ps);
        //then
        assertThat(result.getTotalPages()).isEqualTo(2);
        assertThat(result.getTotalElements()).isEqualTo(11);
    }

    @Test
    @DisplayName("페이징 처리 테스트_카페 글 내용으로 검색 ")
    public void SearchPostWithPaginationTest_with_content() throws Exception{
        //give
        String content = "content2";
        PostSearch ps = PostSearch.builder().content(content).build();
        //when
        Page<ROMappingPost> result = roMappingPostRepository.SearchPostWithPagination(ps);
        //then
        assertThat(result.getTotalPages()).isEqualTo(1);
        assertThat(result.getTotalElements()).isEqualTo(7);
    }
}