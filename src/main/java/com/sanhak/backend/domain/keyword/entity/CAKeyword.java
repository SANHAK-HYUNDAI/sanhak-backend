package com.sanhak.backend.domain.keyword.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "ca_keyword")
public class CAKeyword {
    @Id
    @Column(name = "word")
    private String word;
    @Column(name = "count")
    private Long count;
}
