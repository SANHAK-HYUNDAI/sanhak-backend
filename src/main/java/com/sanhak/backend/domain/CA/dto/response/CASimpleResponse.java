package com.sanhak.backend.domain.CA.dto.response;

import lombok.Getter;

@Getter
public class CASimpleResponse {

    private String cafeName;
    private String title;
    private String keywords;

    public CASimpleResponse(String cafeName, String title, String keywords) {
        this.cafeName = cafeName;
        this.title = title;
        this.keywords = keywords;
    }
}
