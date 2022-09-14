package com.sanhak.backend.domain.post.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PostSearch {
    private static final int NEED_CALCULATE = -1;
    // 필수
    @Min(value = 0L)
    private Integer page;
    @Min(value = 1L)
    private Integer size;
    // 선택
    private Integer totalCount;
    private String cafeName;
    private String category;
    private String title;
    private String content;
    private LocalDateTime registerAt;

    public Integer getPage() {
        return page == null ? 0 : page;
    }

    public Integer getSize() {
        return size == null ? 10 : size;
    }

    public Integer getTotalCount() {
        return totalCount == null ? NEED_CALCULATE : totalCount;
    }

    public String getTitle() {
        return title == null ? null :title;
    }

    public String getCafeName() {
        return cafeName == null ? null : cafeName;
    }

    public String getCategory() {
        return category == null ? null : category;
    }

    public String getContent() {
        return content == null ? null : content;
    }

    @Builder
    public PostSearch(Integer page, Integer size, String cafeName, String category, String title, String content, LocalDateTime registerAt) {
        this.page = page;
        this.size = size;
        this.cafeName = cafeName;
        this.category = category;
        this.title = title;
        this.content = content;
        this.registerAt = registerAt;
    }
}
