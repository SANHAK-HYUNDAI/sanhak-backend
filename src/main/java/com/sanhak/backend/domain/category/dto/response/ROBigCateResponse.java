package com.sanhak.backend.domain.category.dto.response;

import lombok.Getter;

@Getter
public class ROBigCateResponse {

    private String name;
    private Double rate;

    public ROBigCateResponse(String name, Double rate) {
        this.name = name;
        this.rate = rate;
    }
}
