package com.sanhak.backend.domain.post.repository;

import com.sanhak.backend.domain.post.ROMappingPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ROMappingPostRepository extends JpaRepository<ROMappingPost, Long>, ROMappingPostRepositoryDSL {
    void deleteById(Long id);
}
