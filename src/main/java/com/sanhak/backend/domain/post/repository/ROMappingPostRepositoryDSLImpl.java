package com.sanhak.backend.domain.post.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.util.StringUtils;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sanhak.backend.domain.post.ROMappingPost;
import com.sanhak.backend.domain.post.dto.PostSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.sanhak.backend.domain.RO.QRepairOrder.repairOrder;
import static com.sanhak.backend.domain.article.QCafeArticle.cafeArticle;
import static com.sanhak.backend.domain.post.QROMappingPost.rOMappingPost;

@Repository
public class ROMappingPostRepositoryDSLImpl extends QuerydslRepositorySupport implements ROMappingPostRepositoryDSL {

    private final JPAQueryFactory jpaQueryFactory;
    private static final int NEED_CALCULATE = -1;

    public ROMappingPostRepositoryDSLImpl(JPAQueryFactory jpaQueryFactory) {
        super(ROMappingPost.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public Page<ROMappingPost> SearchPostWithPagination(PostSearch postSearch) {

        PageRequest pageRequest = PageRequest.of(postSearch.getPage(), postSearch.getSize());

        JPAQuery<ROMappingPost> query = jpaQueryFactory.select(rOMappingPost)
                .from(rOMappingPost)
                .leftJoin(rOMappingPost.repairOrder, repairOrder)
                .fetchJoin()
                .leftJoin(rOMappingPost.cafeArticle, cafeArticle)
                .fetchJoin()
                .where(
                        containsTitle(postSearch.getTitle()),
                        containsCafeName(postSearch.getCafeName()),
                        containsContent(postSearch.getContent()),
                        containsCategory(postSearch.getCategory())
                );

        int totalCount = postSearch.getTotalCount() == NEED_CALCULATE ? query.fetch().size() : postSearch.getTotalCount();
        List<ROMappingPost> result = this.getQuerydsl().applyPagination(pageRequest, query).fetch();

        return new PageImpl<>(result, pageRequest, totalCount);
    }

    private BooleanExpression containsTitle(String title) {
        if (StringUtils.isNullOrEmpty(title)) return null;
        return cafeArticle.title.contains(title);
    }

    private BooleanExpression containsCafeName(String cafeName) {
        if (StringUtils.isNullOrEmpty(cafeName)) return null;
        return cafeArticle.cafeName.contains(cafeName);
    }
    private BooleanExpression containsContent(String content) {
        if (StringUtils.isNullOrEmpty(content)) return null;
        return cafeArticle.content.contains(content);
    }

    private BooleanExpression containsCategory(String category) {
        if (StringUtils.isNullOrEmpty(category)) return null;
        return cafeArticle.category.contains(category);
    }
}
