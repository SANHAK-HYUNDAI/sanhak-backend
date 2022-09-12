package com.sanhak.backend.domain.article.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CAResDTO {
    private Long id;
    private String cafeName;
    private String broadName;
    private String title;
    private String content;
    private Long viewCount;
    private String url;
    private Integer period;
    private String category;

    @Builder
    public CAResDTO(Long id, String cafeName, String broadName, String title, String content, Long viewCount, String url, Integer period, String category) {
        this.id = id;
        this.cafeName = cafeName;
        this.broadName = broadName;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.url = url;
        this.period = period;
        this.category = category;
    }
}
