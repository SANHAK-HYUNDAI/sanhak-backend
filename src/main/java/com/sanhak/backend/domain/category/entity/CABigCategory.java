package com.sanhak.backend.domain.category.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "ca_big_category")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CABigCategory {
    @Id
    @Column(name = "cate_name")
    private String name;

    @Column(name = "count")
    private Long count;

    public CABigCategory(String name, Long count) {
        this.name = name;
        this.count = count;
    }
}
