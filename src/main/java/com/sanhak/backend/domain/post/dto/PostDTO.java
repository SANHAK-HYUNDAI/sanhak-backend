package com.sanhak.backend.domain.post.dto;

import com.sanhak.backend.domain.RO.dto.ROResDTO;
import com.sanhak.backend.domain.article.dto.CAResDTO;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostDTO {

    private Long id;
    private CAResDTO cafeArticle;
    private ROResDTO repairOrder;

    @Builder
    public PostDTO(Long id, CAResDTO cafeArticle, ROResDTO repairOrder) {
        this.id =id;
        this.cafeArticle = cafeArticle;
        this.repairOrder = repairOrder;
    }
}
