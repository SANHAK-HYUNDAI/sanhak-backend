package com.sanhak.backend.domain.article;

import com.sanhak.backend.global.TimeExtend;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity(name = "cafe_article")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CafeArticle extends TimeExtend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cafe_name")
    private String cafeName;

    @Column(name = "broad_name")
    private String broadName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "view_count")
    private Long viewCount;

    @Column(name = "url")
    private String url;

    @Column(name = "period")
    private Integer period;

    @Column(name = "category")
    private String category;

    @Column(name = "doc_created_at")
    private LocalDateTime docCreatedAt;

    @Column(name = "is_mailing")
    private Boolean isMailing;

    @Builder
    public CafeArticle(Long id, String cafeName, String broadName, String userName, String title, String content, Long viewCount, String url, Integer period, String category, LocalDateTime docCreatedAt, Boolean isMailing) {
        this.id = id;
        this.cafeName = cafeName;
        this.broadName = broadName;
        this.userName = userName;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.url = url;
        this.period = period;
        this.category = category;
        this.docCreatedAt = docCreatedAt;
        this.isMailing = isMailing;
    }
}
