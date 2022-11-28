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

    @Column(name = "frequency")
    private Integer frequency;
}
