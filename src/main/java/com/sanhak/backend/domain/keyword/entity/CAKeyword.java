package com.sanhak.backend.domain.keyword.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "ca_keyword")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CAKeyword {
    @Id
    @Column(name = "word")
    private String word;

    @Column(name = "frequency")
    private Integer frequency;

    public CAKeyword(String word, Integer frequency) {
        this.word = word;
        this.frequency = frequency;
    }
}
