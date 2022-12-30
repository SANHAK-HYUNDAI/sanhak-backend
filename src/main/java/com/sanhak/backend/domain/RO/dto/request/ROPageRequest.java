package com.sanhak.backend.domain.RO.dto.request;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;

@NoArgsConstructor
@Setter
public class ROPageRequest {

    private static final int DEFAULT_SIZE = 5;
    private static final int DEFAULT_PAGE = 0;

    private Integer page;

    protected Integer size;

    public Integer getPage() {
        if (this.page == null) {
            return DEFAULT_PAGE;
        }
        return this.page;
    }

    public Integer getSize() {
        if (this.size == null) {
            return DEFAULT_SIZE;
        }
        return this.size;
    }

    public PageRequest getPageRequest() {
        return PageRequest.of(getPage(), getSize());
    }
}
