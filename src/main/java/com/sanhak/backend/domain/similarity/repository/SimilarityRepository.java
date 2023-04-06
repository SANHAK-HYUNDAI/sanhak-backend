package com.sanhak.backend.domain.similarity.repository;

import com.sanhak.backend.domain.similarity.entity.Similarity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimilarityRepository extends JpaRepository<Similarity,Long> {
}
