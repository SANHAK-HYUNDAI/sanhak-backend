package com.sanhak.backend.domain.CA.dto.response;

import lombok.Getter;

@Getter
public class CASimpleResponse {

    private Long id;
    private String cafeName;
    private String title;
    private String keywords;

    public CASimpleResponse(Long id, String cafeName, String title, String keywords) {
        this.id = id;
        this.cafeName = cafeName;
        this.title = title;
        this.keywords = keywords;
    }
}
