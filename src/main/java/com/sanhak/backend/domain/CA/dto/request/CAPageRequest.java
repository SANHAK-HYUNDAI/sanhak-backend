package com.sanhak.backend.domain.CA.dto.request;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;

@NoArgsConstructor
@Setter
public class CAPageRequest {
    private static final int DEFAULT_SIZE = 4;
    private static final int DEFAULT_PAGE = 0;

    private Integer page;
    private Integer size;
    private String bigPhenom;

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

    public String getBigPhenom() {
        if (this.bigPhenom == null) {
            return "";
        }
        return this.bigPhenom;
    }

    public PageRequest getPageRequest() {
        return PageRequest.of(getPage(), getSize());
    }

}
