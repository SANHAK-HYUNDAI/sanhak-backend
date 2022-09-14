package com.sanhak.backend.domain.article.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CAResDTO {
    private Long id;
    private String cafeName;
    private String broadName;
    private String userName;
    private String title;
    private String content;
    private Long viewCount;
    private String url;
    private Integer period;
    private String userName;
    private String category;
    private LocalDateTime docCreatedAt;
    private Boolean isMailing;

    @Builder
    public CAResDTO(Long id, String cafeName, String broadName, String userName, String title, String content, Long viewCount, String url, Integer period, String category, LocalDateTime docCreatedAt, Boolean isMailing) {
        this.id = id;
        this.cafeName = cafeName;
        this.broadName = broadName;
        this.userName = userName;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.url = url;
        this.period = period;
        this.userName=userName;
        this.category = category;
        this.docCreatedAt = docCreatedAt;
        this.isMailing = isMailing;
    }
}
