package com.sanhak.backend.domain.post.service;

import com.sanhak.backend.domain.article.NaverArticle;
import com.sanhak.backend.domain.article.repository.NaverArticleRepository;
import com.sanhak.backend.domain.post.ROMappingPost;
import com.sanhak.backend.domain.post.dto.PostCrtDTO;
import com.sanhak.backend.domain.post.repository.ROMappingPostRepository;
import com.sanhak.backend.domain.ro.RepairOrder;
import com.sanhak.backend.domain.ro.repository.RepairOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ROMappingPostService {
    private final ROMappingPostRepository roMappingPostRepository;
    private final RepairOrderRepository repairOrderRepository;
    private final NaverArticleRepository naverArticleRepository;

    public Long deleteById(Long id) {
        roMappingPostRepository.deleteById(id);
        return id;
    }

    @Transactional
    public ROMappingPost create(PostCrtDTO dto) {
        RepairOrder repairOrder = repairOrderRepository.findById(dto.getRepairOrderId()).orElseThrow(IllegalArgumentException::new);
        NaverArticle naverArticle = naverArticleRepository.findById(dto.getNaverArticleId()).orElseThrow(IllegalArgumentException::new);

        ROMappingPost roMappingPost = ROMappingPost.builder()
                .naverArticle(naverArticle)
                .repairOrder(repairOrder)
                .build();

        return roMappingPostRepository.save(roMappingPost);
    }
}
