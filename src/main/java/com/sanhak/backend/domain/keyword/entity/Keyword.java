package com.sanhak.backend.domain.keyword.entity;

import com.sanhak.backend.domain.CA.entity.CafeArticle;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "keyword")
public class Keyword {
    @Id
    @Column(name = "word")
    private String word;

    @Column(name = "similarity")
    private Double similarity;


    @ManyToOne(targetEntity = CafeArticle.class)
    @JoinColumn(
            name = "ca_id",
            foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT)
    )
    private CafeArticle cafeArticle;
}
