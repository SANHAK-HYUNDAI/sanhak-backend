package com.sanhak.backend.domain.category.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "ro_sub_category")
public class ROSubCategory {
    @Id
    @Column(name = "cate_name")
    private String name;

    @Column(name = "count")
    private Long count;

    @ManyToOne(targetEntity = CABigCategory.class)
    @JoinColumn(
            name = "big_cate_name",
            foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT)
    )
    private CABigCategory bigCategory;
}
