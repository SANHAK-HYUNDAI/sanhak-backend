package com.sanhak.backend.domain.post.repository;

import com.sanhak.backend.domain.post.ROMappingPost;
import com.sanhak.backend.domain.post.dto.PostSearch;
import org.springframework.data.domain.Page;

public interface ROMappingPostRepositoryDSL {
    Page<ROMappingPost> SearchPostWithPagination(PostSearch postSearch);
}
