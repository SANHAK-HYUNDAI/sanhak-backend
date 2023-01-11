package com.sanhak.backend.domain.CA.dto.response;

import java.util.Objects;
import lombok.Getter;

@Getter
public class CASimpleResponse {

    private Long id;
    private String cafeName;
    private String title;
    private String keywords;

    public CASimpleResponse(Long id, String cafeName, String title, String keywords) {
        this.id = id;
        this.cafeName = cafeName;
        this.title = title;
        this.keywords = keywords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CASimpleResponse that = (CASimpleResponse) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getCafeName(),
                that.getCafeName()) && Objects.equals(getTitle(), that.getTitle()) && Objects.equals(
                getKeywords(), that.getKeywords());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCafeName(), getTitle(), getKeywords());
    }
}
