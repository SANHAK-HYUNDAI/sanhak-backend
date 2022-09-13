package com.sanhak.backend.domain.post.service;

import com.sanhak.backend.domain.article.CafeArticle;
import com.sanhak.backend.domain.article.repository.CARepository;
import com.sanhak.backend.domain.post.ROMappingPost;
import com.sanhak.backend.domain.post.dto.PostCrtDTO;
import com.sanhak.backend.domain.post.dto.PostDTO;
import com.sanhak.backend.domain.post.dto.PostSearch;
import com.sanhak.backend.domain.post.repository.ROMappingPostRepository;
import com.sanhak.backend.domain.RO.RepairOrder;
import com.sanhak.backend.domain.RO.repository.RORepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ROMappingPostService {
    private final ROMappingPostRepository roMappingPostRepository;
    private final RORepository roRepository;
    private final CARepository caRepository;

    public Page<PostDTO> searchPostWithPagination(PostSearch postSearch) {
        Page<PostDTO> result = roMappingPostRepository
                .SearchPostWithPagination(postSearch)
                .map(ROMappingPost::toDTO);
        return result;
    }

    public Long deleteById(Long id) {
        roMappingPostRepository.deleteById(id);
        return id;
    }

    @Transactional
    public ROMappingPost create(PostCrtDTO dto) {
        RepairOrder repairOrder = roRepository
                .findById(dto.getRepairOrderId())
                .orElseThrow(IllegalArgumentException::new);
        CafeArticle cafeArticle = caRepository
                .findById(dto.getNaverArticleId())
                .orElseThrow(IllegalArgumentException::new);

        ROMappingPost roMappingPost = ROMappingPost.builder()
                .cafeArticle(cafeArticle)
                .repairOrder(repairOrder)
                .build();

        return roMappingPostRepository.save(roMappingPost);
    }
}
