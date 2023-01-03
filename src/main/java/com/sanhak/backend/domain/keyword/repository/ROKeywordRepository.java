package com.sanhak.backend.domain.keyword.repository;

import com.sanhak.backend.domain.keyword.entity.ROKeyword;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ROKeywordRepository extends JpaRepository<ROKeyword, String> {

    public List<ROKeyword> findTop50ByOrderByFrequencyDesc();
}
