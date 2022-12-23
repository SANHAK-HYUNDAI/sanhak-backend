package com.sanhak.backend.domain.category.dto.response;

import lombok.Getter;

@Getter
public class CABigCateResponse {

    private String name;
    private Double rate;

    public CABigCateResponse(String name, Double rate) {
        this.name = name;
        this.rate = rate;
    }
}
