package com.sanhak.backend.domain.category.dto.response;

import lombok.Getter;

@Getter
public class ROSubCateResponse {

    private String subCateName;
    private String bigCateName;
    private Double rate;

    public ROSubCateResponse(String subCateName, String bigCateName, Double rate) {
        this.subCateName = subCateName;
        this.bigCateName = bigCateName;
        this.rate = rate;
    }
}
