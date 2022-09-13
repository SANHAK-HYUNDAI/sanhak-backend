package com.sanhak.backend.domain.post;

import com.sanhak.backend.domain.article.CafeArticle;
import com.sanhak.backend.domain.comment.Comment;
import com.sanhak.backend.domain.RO.RepairOrder;
import com.sanhak.backend.domain.post.dto.PostDTO;
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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ro_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private RepairOrder repairOrder;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ca_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CafeArticle cafeArticle;

    @OneToMany(mappedBy = "roMappingPost", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public ROMappingPost(Long id, RepairOrder repairOrder, CafeArticle cafeArticle) {
        this.id = id;
        this.repairOrder = repairOrder;
        this.cafeArticle = cafeArticle;
    }

    public PostDTO toDTO() {
        return PostDTO.builder()
                .id(this.id)
                .caResDTO(this.cafeArticle.toDTO())
                .roResDTO(this.repairOrder.toDTO())
                .build();
    }
}
