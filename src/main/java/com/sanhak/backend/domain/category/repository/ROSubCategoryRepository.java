package com.sanhak.backend.domain.category.repository;

import com.sanhak.backend.domain.category.entity.CASubCategory;
import com.sanhak.backend.domain.category.entity.ROSubCategory;
import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ROSubCategoryRepository extends JpaRepository<ROSubCategory, String> {

    @EntityGraph(attributePaths = "bigCategory")
    public List<ROSubCategory> findAll();
}
