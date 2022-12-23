package com.sanhak.backend.domain.CA.dto.response;

import com.sanhak.backend.domain.category.dto.response.CABigCateResponse;
import com.sanhak.backend.domain.category.dto.response.CASubCateResponse;
import com.sanhak.backend.domain.keyword.dto.response.KeywordResponse;
import java.util.List;
import lombok.Getter;

@Getter
public class CAStatisticsResponse {

    private List<KeywordResponse> keywords;
    private List<CABigCateResponse> bigCategories;
    private List<CASubCateResponse> subCategories;

    public CAStatisticsResponse(List<KeywordResponse> keywords,
                                List<CABigCateResponse> bigCategories,
                                List<CASubCateResponse> subCategories) {
        this.keywords = keywords;
        this.bigCategories = bigCategories;
        this.subCategories = subCategories;
    }
}
