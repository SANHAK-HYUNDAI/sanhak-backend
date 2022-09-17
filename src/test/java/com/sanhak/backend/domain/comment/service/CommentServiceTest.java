package com.sanhak.backend.domain.comment.service;

import com.sanhak.backend.domain.comment.repository.CommentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CommentServiceTest {
    @Mock
    private CommentRepository commentRepository;
    @InjectMocks
    private CommentService commentService;

    @Test
    @DisplayName("CommentService : id가 정상 삭제되었을 때 id값을 반환하는 지 확인")
    void deleteById() throws Exception{
        //given
        long id = 1234567L;

        //when
        Long removedId = commentService.deleteById(id);

        //then
        assertThat(removedId).isEqualTo(id);
    }
}