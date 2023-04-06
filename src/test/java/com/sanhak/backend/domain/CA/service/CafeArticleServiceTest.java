package com.sanhak.backend.domain.CA.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.sanhak.backend.domain.CA.dto.CAResponseAssembler;
import com.sanhak.backend.domain.CA.dto.response.CADetailResponse;
import com.sanhak.backend.domain.CA.dto.response.CASimpleResponse;
import com.sanhak.backend.domain.CA.dto.response.CAStatisticsResponse;
import com.sanhak.backend.domain.CA.entity.CafeArticle;
import com.sanhak.backend.domain.CA.repository.CARepository;
import com.sanhak.backend.domain.RO.repository.RORepository;
import com.sanhak.backend.domain.RO.service.ROService;
import com.sanhak.backend.domain.category.dto.response.CABigCateResponse;
import com.sanhak.backend.domain.category.dto.response.CASubCateResponse;
import com.sanhak.backend.domain.category.service.CACategoryService;
import com.sanhak.backend.domain.category.service.ROCategoryService;
import com.sanhak.backend.domain.keyword.dto.response.KeywordResponse;
import com.sanhak.backend.domain.keyword.service.CAKeywordService;
import com.sanhak.backend.domain.keyword.service.ROKeywordService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class CafeArticleServiceTest {

    @Mock private CAKeywordService keywordService;
    @Mock private CACategoryService categoryService;
    @Mock private  ROService roService;

    @Mock private CARepository caRepository;

    @Spy private CAResponseAssembler responseAssembler;

    @InjectMocks
    private CAService caService;

    @Test
    public void getAllCAsByBigPhenom() throws Exception{
        //given
        String bigPhenom = "bigPhenom";
        given(caRepository.findCafeArticlesByBigPhenom(bigPhenom)).willReturn(List.of());
        //when
        caService.getAllCAsByBigPhenom(bigPhenom);
        //then
        verify(caRepository, times(1)).findCafeArticlesByBigPhenom(bigPhenom);
    }
    @Test
    public void getDetailCAById() throws Exception{
        //given
        Long caId = 1L;
        CafeArticle ca = CafeArticle.builder().id(caId).build();
        given(roService.getRepairOrdersByCafeArticleId(caId)).willReturn(List.of());
        given(caRepository.findById(caId)).willReturn(Optional.of(ca));
        //when
        caService.getDetailCAById(caId);
        //then
        verify(roService, times(1)).getRepairOrdersByCafeArticleId(caId);
        verify(caRepository, times(1)).findById(caId);
    }

    @Test
    public void getCAStatistics() throws Exception{
        //given
        List<KeywordResponse> topKeywords = createTopKeywords();
        List<CABigCateResponse> bigCategories = createBigCategories();
        List<CASubCateResponse> subCategories = createSubCategories();

        given(keywordService.getTop50Keywords()).willReturn(topKeywords);
        given(categoryService.getAllBigCategories()).willReturn(bigCategories);
        given(categoryService.getAllSubCategories()).willReturn(subCategories);
        //when
        CAStatisticsResponse result = caService.getCAStatistics();
        CAStatisticsResponse answer = responseAssembler.createCAStatisticsResponse(topKeywords, bigCategories,
                subCategories);
        //then
        verify(keywordService, times(1)).getTop50Keywords();
        verify(categoryService, times(1)).getAllSubCategories();
        verify(categoryService, times(1)).getAllBigCategories();
    }

    private List<KeywordResponse> createTopKeywords() {
        List<KeywordResponse> keywords = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            keywords.add(new KeywordResponse("dummy", i));
        }
        return keywords;
    }

    private List<CABigCateResponse> createBigCategories() {
        List<CABigCateResponse> categories = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            categories.add(new CABigCateResponse("dummy", (long)i));
        }
        return categories;
    }

    private List<CASubCateResponse> createSubCategories() {
        List<CASubCateResponse> categories = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            categories.add(new CASubCateResponse("dummy","dummy", (double)i/10));
        }
        return categories;
    }
}
