package com.sanhak.backend.domain.post.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostCrtDTO {
    Long repairOrderId;
    Long naverArticleId;

    @Builder
    public PostCrtDTO(Long repairOrderId, long naverArticleId) {
        this.repairOrderId = repairOrderId;
        this.naverArticleId = naverArticleId;
    }

}
