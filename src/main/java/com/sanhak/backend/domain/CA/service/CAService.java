package com.sanhak.backend.domain.CA.service;

import com.sanhak.backend.domain.CA.dto.CAResponseAssembler;
import com.sanhak.backend.domain.CA.dto.request.CAPageRequest;
import com.sanhak.backend.domain.CA.dto.response.CAPageResponse;
import com.sanhak.backend.domain.CA.dto.response.CADetailResponse;
import com.sanhak.backend.domain.CA.dto.response.CASimpleResponse;
import com.sanhak.backend.domain.CA.dto.response.CAStatisticsResponse;
import com.sanhak.backend.domain.CA.entity.CafeArticle;
import com.sanhak.backend.domain.CA.repository.CARepository;
import com.sanhak.backend.domain.RO.dto.response.ROResponse;
import com.sanhak.backend.domain.category.dto.response.CABigCateResponse;
import com.sanhak.backend.domain.category.dto.response.CASubCateResponse;
import com.sanhak.backend.domain.category.service.CACategoryService;
import com.sanhak.backend.domain.keyword.dto.response.KeywordResponse;
import com.sanhak.backend.domain.keyword.service.CAKeywordService;
import com.sanhak.backend.domain.similarity.entity.Similarity;
import com.sanhak.backend.domain.similarity.service.SimilarityService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CAService {
    private final CARepository caRepository;

    private final SimilarityService similarityService;
    private final CACategoryService caCategoryService;
    private final CAKeywordService keywordService;

    private final CAResponseAssembler responseAssembler;

    public Set<CASimpleResponse> getAllCAsByBigPhenom(String bigPhenom) {
        Set<CASimpleResponse> result = similarityService.getAllSimilaritiesByBigPhenom(bigPhenom).stream()
                .map(similarity -> responseAssembler.createCASimpleResponse(similarity.getCafeArticle()))
                .collect(Collectors.toUnmodifiableSet());

        return result;
    }

    public CADetailResponse getDetailCAById(Long caId) {
        CafeArticle ca = caRepository.findById(caId)
                .orElseThrow(EntityNotFoundException::new);
        List<ROResponse> ros = similarityService.getRepairOrdersByCafeArticle(ca);

        return responseAssembler.createCADetailResponse(ca, ros);
    }

    public CAStatisticsResponse getCAStatistics() {
        List<KeywordResponse> keywordResponses = keywordService.getTop50Keywords();
        List<CASubCateResponse> subCateResponses = caCategoryService.getAllSubCategories();
        List<CABigCateResponse> bigCateResponses = caCategoryService.getAllBigCategories();

        return responseAssembler.createCAStatisticsResponse(keywordResponses, bigCateResponses, subCateResponses);
    }
}
