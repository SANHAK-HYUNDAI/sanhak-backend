package com.sanhak.backend.domain.similarity.dto.response;

import com.sanhak.backend.domain.RO.dto.response.ROResponse;
import lombok.Getter;

@Getter
public class SimilarityResponse {

    private Long caId;
    private ROResponse roResponse;

    public SimilarityResponse(Long caId, ROResponse roResponse) {
        this.caId = caId;
        this.roResponse = roResponse;
    }
}