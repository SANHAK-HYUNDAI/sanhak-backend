package com.sanhak.backend.domain.RO.dto.response;

import com.sanhak.backend.domain.category.dto.response.ROBigCateResponse;
import com.sanhak.backend.domain.category.dto.response.ROSubCateResponse;
import com.sanhak.backend.domain.keyword.dto.response.KeywordResponse;
import java.util.List;
import lombok.Getter;

@Getter
public class ROStatisticsResponse {

    private List<KeywordResponse> keywords;
    private List<ROBigCateResponse> bigCategories;
    private List<ROSubCateResponse> subCategories;

    public ROStatisticsResponse(List<KeywordResponse> keywords,
                                List<ROBigCateResponse> bigCategories,
                                List<ROSubCateResponse> subCategories) {
        this.keywords = keywords;
        this.bigCategories = bigCategories;
        this.subCategories = subCategories;
    }
}
