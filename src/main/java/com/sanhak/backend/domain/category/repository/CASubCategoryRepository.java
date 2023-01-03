package com.sanhak.backend.domain.category.repository;

import com.sanhak.backend.domain.category.entity.CASubCategory;
import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CASubCategoryRepository extends JpaRepository<CASubCategory, String> {

    @EntityGraph(attributePaths = "bigCategory")
    public List<CASubCategory> findAll();
}
