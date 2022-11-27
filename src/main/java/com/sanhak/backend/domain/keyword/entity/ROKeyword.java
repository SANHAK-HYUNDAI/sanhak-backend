package com.sanhak.backend.domain.keyword.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "ro_keyword")
public class ROKeyword {
    @Id
    @Column(name = "word")
    private String word;
    @Column(name = "count")
    private Long count;
}