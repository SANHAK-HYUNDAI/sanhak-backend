package com.sanhak.backend.domain.keyword.repository;

import com.sanhak.backend.domain.keyword.entity.CAKeyword;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CAKeywordRepository extends JpaRepository<CAKeyword, String> {

    public List<CAKeyword> findTop50ByOrderByFrequencyDesc();
}
