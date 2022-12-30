package com.sanhak.backend.domain.CA.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "cafe_article")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CafeArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ca_id")
    private Long id;

    @Column(name = "cafe_name")
    private String cafeName;//: 카페이름

    @Column(name = "board_name")
    private String boardName;//: 게시판이름

    @Column(name = "writer")
    private String writer;//: 작성자

    @Column(name = "title")
    private String title;//: 제목

    @Column(name = "content")
    private String content;//: 내용

    @Column(name = "url")
    private String url;//: 주소

    @Column(name = "created_at")
    private LocalDateTime createdAt;// :  생성일, 작성일

    @Column(name = "keywords")
    private String keywords;// : CA 키워드5개

    @Builder
    public CafeArticle(Long id, String cafeName, String boardName, String writer, String title, String content,
                       String url, LocalDateTime createdAt, String keywords) {
        this.id = id;
        this.cafeName = cafeName;
        this.boardName = boardName;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.url = url;
        this.createdAt = createdAt;
        this.keywords = keywords;
    }
}
