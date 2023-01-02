package com.sanhak.backend.domain.keyword.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "ro_keyword")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ROKeyword {

    @Id
    @Column(name = "word")
    private String word;

    @Column(name = "frequency")
    private Integer frequency;

    public ROKeyword(String word, Integer frequency) {
        this.word = word;
        this.frequency = frequency;
    }
}
