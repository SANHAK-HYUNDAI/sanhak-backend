package com.sanhak.backend.domain.post;

import com.sanhak.backend.domain.RO.RepairOrder;
import com.sanhak.backend.domain.RO.repository.RORepository;
import com.sanhak.backend.domain.article.CafeArticle;
import com.sanhak.backend.domain.article.repository.CARepository;
import com.sanhak.backend.domain.post.repository.ROMappingPostRepository;
import com.sanhak.backend.global.config.QueryDSLConfig;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@Import(QueryDSLConfig.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ROMappingPostTest {

    @Autowired
    private CARepository CARepository;
    @Autowired
    private RORepository roRepository;
    @Autowired
    private ROMappingPostRepository roMappingPostRepository;

    private Long roId, naId, roMappingPostId;

    @BeforeAll
    public void init() {
        CARepository.deleteAll();
        roRepository.deleteAll();
        roMappingPostRepository.deleteAll();

        RepairOrder ro = RepairOrder.builder()
                .cause("cause")
                .causePart("causePart")
                .causePartCluster("causePartCluster")
                .causePartNameKor("causePartNameKor")
                .causePartNameEng("causePartNameEng")
                .location("location")
                .partNumber("partNumber")
                .problematicSituation("problematicSituation")
                .specialNote("specialNote")
                .symptom("symptom")
                .vehicleType("vehicleType")
                .build();

        CafeArticle na = CafeArticle.builder()
                .cafeName("cafe name")
                .broadName("broad name")
                .userName("user name")
                .category("category")
                .content("content")
                .period(1)
                .title("title")
                .url("url")
                .viewCount(0L)
                .docCreatedAt(LocalDateTime.now())
                .isMailing(false)
                .build();

        ROMappingPost roMappingPost = ROMappingPost.builder()
                .repairOrder(ro)
                .cafeArticle(na)
                .build();
        roMappingPostRepository.save(roMappingPost);

        this.roId = ro.getId();
        this.naId = na.getId();
        this.roMappingPostId = roMappingPost.getId();
    }

    @Test
    @DisplayName("ROMappingPost : NA를 삭제하고 ROMappingPost가 같이 삭제되는지 확인")
    void deleteNAAndConfirmROMappingPost() throws Exception {
        //given
        //when
        roRepository.deleteById(roId);
        roRepository.flush();
        boolean isPresent = roMappingPostRepository
                .findById(roMappingPostId)
                .isPresent();

        //then
        assertThat(isPresent).isEqualTo(false);
    }

    @Test
    @DisplayName("ROMappingPost : RO를 삭제하고 ROMappingPost가 같이 삭제되는지 확인")
    void deleteROAndConfirmROMappingPost() throws Exception {
        //given
        //when
        CARepository.deleteById(naId);
        CARepository.flush();
        boolean isPresent = roMappingPostRepository
                .findById(roMappingPostId)
                .isPresent();

        //then
        assertThat(isPresent).isEqualTo(false);
    }
}