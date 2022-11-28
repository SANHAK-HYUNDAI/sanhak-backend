package com.sanhak.backend.domain.category.entity;


import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "ca_sub_category")
public class CASubCategory {
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
