package com.sanhak.backend.domain.post.service;

import com.sanhak.backend.domain.RO.RepairOrder;
import com.sanhak.backend.domain.RO.repository.RORepository;
import com.sanhak.backend.domain.article.CafeArticle;
import com.sanhak.backend.domain.article.repository.CARepository;
import com.sanhak.backend.domain.post.ROMappingPost;
import com.sanhak.backend.domain.post.dto.PostCrtDTO;
import com.sanhak.backend.domain.post.dto.PostDTO;
import com.sanhak.backend.domain.post.dto.PostSearch;
import com.sanhak.backend.domain.post.repository.ROMappingPostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ROMappingPostServiceTest {

    @InjectMocks
    private ROMappingPostService roMappingPostService;

    @Mock
    private ROMappingPostRepository roMappingPostRepository;
    @Mock
    private CARepository caRepository;
    @Mock
    private RORepository roRepository;


    @Test
    @DisplayName("페이징처리 결과 DTO변환 확인")
    public void SearchPostWithPaginationTest() throws Exception{
        //give
        PostSearch postSearch = PostSearch.builder().build();
        PageRequest pageable = PageRequest.of(1, 10);
        List<ROMappingPost> list = new ArrayList<>();

        LongStream.rangeClosed(1,10)
                .forEach(idx ->{
                    RepairOrder ro = RepairOrder.builder()
                            .id(idx)
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
                            .id(idx)
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
                            .id(idx)
                            .repairOrder(ro)
                            .cafeArticle(na)
                            .build();
                    list.add(roMappingPost);
                });
        given(roMappingPostRepository.SearchPostWithPagination(any())).willReturn(new PageImpl<>(list, pageable, 100));
        //when

        Page<PostDTO> result = roMappingPostService.searchPostWithPagination(postSearch);
        //then
        verify(roMappingPostRepository,times(1)).SearchPostWithPagination(any());
        for(int i=0;i<10;i++){
            assertThat(result.getContent().get(i)).isEqualTo(list.get(i).toDTO());
        }
    }
    
    @Test
    @DisplayName("post 생성 성공")
    public void createTest_success() throws Exception{
        //give
        PostCrtDTO crtDTO = PostCrtDTO.builder()
                .naverArticleId(123L)
                .repairOrderId(456L)
                .build();
        Long postId = 789L;
        given(roRepository.findById(any())).willReturn(Optional.of(RepairOrder.builder().build()));
        given(caRepository.findById(any())).willReturn(Optional.of(CafeArticle.builder().build()));
        given(roMappingPostRepository.save(any())).willReturn(ROMappingPost.builder().id(postId).build());

        //when
        ROMappingPost roMappingPost = roMappingPostService.create(crtDTO);
        //then
        verify(roRepository,times(1)).findById(crtDTO.getRepairOrderId());
        verify(caRepository,times(1)).findById(crtDTO.getNaverArticleId());
        assertThat(roMappingPost.getId()).isEqualTo(postId);
    }

    @Test
    @DisplayName("post 생성 실패")
    public void createTest_fail() throws Exception{
        //give
        PostCrtDTO crtDTO = PostCrtDTO.builder()
                .repairOrderId(456L)
                .build();
        Long postId = 789L;

        //when

        //then
        assertThrows(IllegalArgumentException.class, () ->{
            roMappingPostService.create(crtDTO);
        });
    }
    
    @Test
    @DisplayName("post 삭제 성공")
    public void deleteByIdTest_success() throws Exception{
        //give
        Long postId = 1L;

        doNothing().when(roMappingPostRepository).deleteById(any());

        //when
        Long deletedId = roMappingPostService.deleteById(postId);

        //then
        verify(roMappingPostRepository,times(1)).deleteById(any());
        assertThat(deletedId).isEqualTo(postId);
    }

    @Test
    @DisplayName("post 삭제 실패")
    public void deleteByIdTest_fail() throws Exception{
        //give
        Long notExistId =1L;

        doThrow(IllegalArgumentException.class).when(roMappingPostRepository).deleteById(notExistId);

        //when
        //then

        assertThrows(IllegalArgumentException.class, () -> roMappingPostService.deleteById(notExistId));
        verify(roMappingPostRepository,times(1)).deleteById(any());
    }
    
}