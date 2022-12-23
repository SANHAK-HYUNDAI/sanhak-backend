package com.sanhak.backend.domain.keyword.dto.response;

import lombok.Getter;

@Getter
public class KeywordResponse {

    private String word;
    private Integer frequency;

    public KeywordResponse(String word, Integer frequency) {
        this.word = word;
        this.frequency = frequency;
    }
}
