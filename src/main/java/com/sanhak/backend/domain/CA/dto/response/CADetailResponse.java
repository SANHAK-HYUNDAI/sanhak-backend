package com.sanhak.backend.domain.CA.dto.response;

import com.sanhak.backend.domain.RO.dto.response.ROResponse;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CADetailResponse {

    private String cafeName;
    private String boardName;
    private String writer;
    private String title;
    private String content;
    private String url;
    private LocalDateTime createdAt;
    private String keywords;

    private List<ROResponse> ros;

    @Builder
    public CADetailResponse(String cafeName, String boardName, String writer, String title, String content,
                            String url, LocalDateTime createdAt, String keywords,
                            List<ROResponse> ros) {
        this.cafeName = cafeName;
        this.boardName = boardName;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.url = url;
        this.createdAt = createdAt;
        this.keywords = keywords;
        this.ros = ros;
    }
}
