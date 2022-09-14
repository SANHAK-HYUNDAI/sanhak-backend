package com.sanhak.backend.domain.post.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
@NoArgsConstructor
public class PostResDTO {
    private List<PostDTO> dtoList;

    private int totalPage;
    private int page;
    private int size;
    private long totalElementCount;

    private int startIndex,endIndex;

    private boolean hasPrev,hasNext;

    private List<Integer> pageIndexList;

    @Builder
    public PostResDTO(Page<PostDTO> result) {
        dtoList = result.getContent();
        totalPage = result.getTotalPages();
        totalElementCount = result.getTotalElements();
        makePageList(result.getPageable());
    }

    private void makePageList(Pageable pageable) {
        this.page=pageable.getPageNumber();
        this.size = pageable.getPageSize();

        int tempEnd=(int)(Math.ceil(page/10.0))*10;

        startIndex= tempEnd-9;
        endIndex=totalPage>tempEnd ? tempEnd : totalPage;

        hasPrev=startIndex>1;
        hasNext=totalPage>tempEnd;

        pageIndexList= IntStream.rangeClosed(startIndex,endIndex).boxed().collect(Collectors.toList());
    }
}
