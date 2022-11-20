package com.sanhak.backend.domain.comment.repository;

import com.sanhak.backend.domain.RO.RepairOrder;
import com.sanhak.backend.domain.article.CafeArticle;
import com.sanhak.backend.domain.comment.Comment;
import com.sanhak.backend.domain.post.ROMappingPost;
import com.sanhak.backend.domain.post.repository.ROMappingPostRepository;
import com.sanhak.backend.global.config.QueryDSLConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@Import(QueryDSLConfig.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CommentRepositoryTest {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ROMappingPostRepository roMappingPostRepository;

    private long savedPostId;

    @BeforeAll
    public void init() {
        RepairOrder ro = RepairOrder.builder()
                .cause("cause")
                .causePart("causePart")
                .causePartCluster("causePartCluster")
                .causePartNameKor("causePartNameKor")
                .causePartNameEng("causePartNameEng")
                .location("location")
                .partNumber("partNumber")
                .problematicSituation("problematicSituation")
                .specialNote("specialNote")
                .symptom("symptom")
                .vehicleType("vehicleType")
                .build();

        CafeArticle ca = CafeArticle.builder()
                .cafeName("cafe name")
                .broadName("broad name")
                .userName("user name")
                .category("category")
                .content("content")
                .period(1)
                .title("title")
                .url("url")
                .viewCount(0L)
                .docCreatedAt(LocalDateTime.now())
                .isMailing(false)
                .build();

        ROMappingPost post = ROMappingPost.builder()
                .repairOrder(ro)
                .cafeArticle(ca)
                .build();

        this.savedPostId = roMappingPostRepository.saveAndFlush(post).getId();
    }

    @Test
    @DisplayName("CommentRepository : id가 들어갔을 때 삭제되는지 확인")
    void deleteById() throws Exception {
        ROMappingPost post = roMappingPostRepository.findById(this.savedPostId).orElseThrow();

        Comment comment = Comment.builder()
                .content("hello world")
                .roMappingPost(post)
                .build();
        Long savedCommentId = commentRepository.saveAndFlush(comment).getId();
        long beforeCnt = commentRepository.count();

        commentRepository.deleteById(savedCommentId);
        long afterCnt = commentRepository.count();

        assertThat(afterCnt).isEqualTo(beforeCnt - 1);
    }
}