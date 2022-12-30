package com.sanhak.backend.domain.category.dto;

import com.sanhak.backend.domain.category.dto.response.CABigCateResponse;
import com.sanhak.backend.domain.category.dto.response.CASubCateResponse;
import com.sanhak.backend.domain.category.entity.CABigCategory;
import com.sanhak.backend.domain.category.entity.CASubCategory;
import org.springframework.stereotype.Component;

@Component
public class CategoryResponseAssembler {

    public CASubCateResponse createCASubCateResponse(CASubCategory category, Long sum) {
        double rate = (double) category.getCount() / sum;
        return new CASubCateResponse(category.getName(), category.getBigCategory().getName(), rate);
    }

    public CABigCateResponse createCABigCateResponse(CABigCategory category, Long sum) {
        double rate = (double) category.getCount() / sum;
        return new CABigCateResponse(category.getName(), rate);
    }
}
