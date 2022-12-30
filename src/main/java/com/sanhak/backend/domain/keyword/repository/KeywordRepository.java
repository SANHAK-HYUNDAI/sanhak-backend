package com.sanhak.backend.domain.keyword.repository;

import com.sanhak.backend.domain.keyword.entity.Keyword;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {

    public List<Keyword> findTop50ByOrderByFrequencyDesc();
}
