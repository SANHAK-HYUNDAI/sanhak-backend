package com.sanhak.backend.domain.category.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "ro_sub_category")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ROSubCategory {
    @Id
    @Column(name = "cate_name")
    private String name;

    @Column(name = "count")
    private Long count;

    @ManyToOne(targetEntity = ROBigCategory.class)
    @JoinColumn(
            name = "big_cate_name",
            foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT)
    )
    private ROBigCategory bigCategory;

    public ROSubCategory(String name, Long count, ROBigCategory bigCategory) {
        this.name = name;
        this.count = count;
        this.bigCategory = bigCategory;
    }
}
