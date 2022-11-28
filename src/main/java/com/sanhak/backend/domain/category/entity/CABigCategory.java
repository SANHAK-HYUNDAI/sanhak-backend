package com.sanhak.backend.domain.category.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "ca_big_category")
public class CABigCategory {
    @Id
    @Column(name = "cate_name")
    private String name;

    @Column(name = "count")
    private Long count;
}
