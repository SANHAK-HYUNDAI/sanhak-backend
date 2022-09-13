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
    private CAResDTO caResDTO;
    private ROResDTO roResDTO;

    @Builder
    public PostDTO(Long id, CAResDTO caResDTO, ROResDTO roResDTO) {
        this.id =id;
        this.caResDTO = caResDTO;
        this.roResDTO = roResDTO;
    }
}
