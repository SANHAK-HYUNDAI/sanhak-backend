package com.sanhak.backend.domain.category.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "ca_sub_category")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    public CASubCategory(String name, Long count, CABigCategory bigCategory) {
        this.name = name;
        this.count = count;
        this.bigCategory = bigCategory;
    }
}
