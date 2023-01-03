package com.sanhak.backend.domain.RO.service;

import com.sanhak.backend.domain.CA.dto.response.CAStatisticsResponse;
import com.sanhak.backend.domain.RO.dto.request.ROPageRequest;
import com.sanhak.backend.domain.RO.dto.response.ROPageResponse;
import com.sanhak.backend.domain.RO.dto.response.ROResponse;
import com.sanhak.backend.domain.RO.dto.response.ROStatisticsResponse;
import com.sanhak.backend.domain.RO.repository.RORepository;
import com.sanhak.backend.domain.category.dto.response.CABigCateResponse;
import com.sanhak.backend.domain.category.dto.response.CASubCateResponse;
import com.sanhak.backend.domain.category.dto.response.ROBigCateResponse;
import com.sanhak.backend.domain.category.dto.response.ROSubCateResponse;
import com.sanhak.backend.domain.category.service.ROCategoryService;
import com.sanhak.backend.domain.keyword.dto.response.KeywordResponse;
import com.sanhak.backend.domain.keyword.service.ROKeywordService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ROService {

    private final ROKeywordService keywordService;
    private final ROCategoryService roCategoryService;

    private final RORepository roRepository;

    public ROPageResponse getROs(ROPageRequest roPageRequest) {
        Page<ROResponse> result = roRepository.findAll(roPageRequest.getPageRequest())
                .map(repairOrder -> new ROResponse(repairOrder));
        return new ROPageResponse(result);
    }

    public ROStatisticsResponse getROStatistics() {
        List<KeywordResponse> keywordResponses = keywordService.getTop50Keywords();
        List<ROSubCateResponse> subCateResponses = roCategoryService.getTop10SubCategories();
        List<ROBigCateResponse> bigCateResponses = roCategoryService.getTop10BigCategories();

        return new ROStatisticsResponse(keywordResponses, bigCateResponses, subCateResponses);
    }
}
