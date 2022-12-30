package com.sanhak.backend.domain.keyword.entity;

import com.sanhak.backend.domain.CA.entity.CafeArticle;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "keyword")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Keyword {
    @Id
    @Column(name = "word")
    private String word;

    @Column(name = "frequency")
    private Integer frequency;

    public Keyword(String word, Integer frequency) {
        this.word = word;
        this.frequency = frequency;
    }
}
