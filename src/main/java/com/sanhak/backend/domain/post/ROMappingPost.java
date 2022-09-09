package com.sanhak.backend.domain.post;

import com.sanhak.backend.domain.article.NaverArticle;
import com.sanhak.backend.domain.comment.Comment;
import com.sanhak.backend.domain.ro.RepairOrder;
import com.sanhak.backend.global.TimeExtend;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity(name = "ro_mapping_post")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ROMappingPost extends TimeExtend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ro_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private RepairOrder repairOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "naver_article_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private NaverArticle naverArticle;

    @OneToMany(mappedBy = "roMappingPost", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public ROMappingPost(Long id, RepairOrder repairOrder, NaverArticle naverArticle) {
        this.id = id;
        this.repairOrder = repairOrder;
        this.naverArticle = naverArticle;
    }
}
