package com.sanhak.backend.domain.comment;

import com.sanhak.backend.domain.post.ROMappingPost;
import com.sanhak.backend.global.TimeExtend;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity(name = "comment")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends TimeExtend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "post_id",
            foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ROMappingPost roMappingPost;

    @Builder
    public Comment(Long id, String content, ROMappingPost roMappingPost) {
        this.id = id;
        this.content = content;
        this.roMappingPost = roMappingPost;
    }
}
