package com.sanhak.backend.domain.CA.service;

import com.sanhak.backend.domain.CA.dto.CAResponseAssembler;
import com.sanhak.backend.domain.CA.dto.response.CADetailResponse;
import com.sanhak.backend.domain.CA.dto.response.CASimpleResponse;
import com.sanhak.backend.domain.CA.dto.response.CAStatisticsResponse;
import com.sanhak.backend.domain.CA.entity.CafeArticle;
import com.sanhak.backend.domain.CA.repository.CARepository;
import com.sanhak.backend.domain.RO.dto.response.ROResponse;
import com.sanhak.backend.domain.RO.service.ROService;
import com.sanhak.backend.domain.category.dto.response.CABigCateResponse;
import com.sanhak.backend.domain.category.dto.response.CASubCateResponse;
import com.sanhak.backend.domain.category.service.CACategoryService;
import com.sanhak.backend.domain.keyword.dto.response.KeywordResponse;
import com.sanhak.backend.domain.keyword.service.CAKeywordService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CAService {
    private final CARepository caRepository;

    private final ROService roService;
    private final CACategoryService categoryService;
    private final CAKeywordService keywordService;

    private final CAResponseAssembler responseAssembler;

    public List<CASimpleResponse> getAllCAsByBigPhenom(String bigPhenom) {
        List<CASimpleResponse> result = caRepository.findCafeArticlesByBigPhenom(bigPhenom).stream()
                .map(cafeArticle -> responseAssembler.createCASimpleResponse(cafeArticle))
                .collect(Collectors.toUnmodifiableList());

        return result;
    }

    public CADetailResponse getDetailCAById(Long caId) {
        CafeArticle ca = caRepository.findById(caId)
                .orElseThrow(EntityNotFoundException::new);
        List<ROResponse> ros = roService.getRepairOrdersByCafeArticleId(caId);

        return responseAssembler.createCADetailResponse(ca, ros);
    }

    public CAStatisticsResponse getCAStatistics() {
        List<KeywordResponse> keywordResponses = keywordService.getTop50Keywords();
        List<CASubCateResponse> subCateResponses = categoryService.getAllSubCategories();
        List<CABigCateResponse> bigCateResponses = categoryService.getAllBigCategories();

        return responseAssembler.createCAStatisticsResponse(keywordResponses, bigCateResponses, subCateResponses);
    }
}
