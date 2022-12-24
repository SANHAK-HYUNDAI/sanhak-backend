package com.sanhak.backend.domain.CA.dto;

import com.sanhak.backend.domain.CA.dto.response.CADetailResponse;
import com.sanhak.backend.domain.CA.dto.response.CAPageResponse;
import com.sanhak.backend.domain.CA.dto.response.CASimpleResponse;
import com.sanhak.backend.domain.CA.dto.response.CAStatisticsResponse;
import com.sanhak.backend.domain.CA.entity.CafeArticle;
import com.sanhak.backend.domain.RO.dto.response.ROResponse;
import com.sanhak.backend.domain.category.dto.response.CABigCateResponse;
import com.sanhak.backend.domain.category.dto.response.CASubCateResponse;
import com.sanhak.backend.domain.keyword.dto.response.KeywordResponse;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class CAResponseAssembler {

    public CASimpleResponse createCASimpleResponse(CafeArticle ca) {
        return new CASimpleResponse(ca.getId(),ca.getCafeName(), ca.getTitle(), ca.getKeywords());
    }

    public CADetailResponse createCADetailResponse(CafeArticle ca, List<ROResponse> roResponses) {
        return CADetailResponse.builder()
                .cafeName(ca.getCafeName())
                .boardName(ca.getBoardName())
                .writer(ca.getWriter())
                .title(ca.getTitle())
                .content(ca.getContent())
                .url(ca.getUrl())
                .createdAt(ca.getCreatedAt())
                .keywords(ca.getKeywords())
                .ros(roResponses)
                .build();
    }

    public CAPageResponse createCAPageResponse(Page<CASimpleResponse> result) {
        return new CAPageResponse(result);
    }

    public CAStatisticsResponse createCAStatisticsResponse(List<KeywordResponse> keywords,
                                                           List<CABigCateResponse> bigCategories,
                                                           List<CASubCateResponse> subCategories) {
        return new CAStatisticsResponse(keywords,
                bigCategories,
                subCategories);
    }

}
