package com.example.p123.dto;

import com.example.p123.entity.Notice;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class NoticeListResponseDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;


    public NoticeListResponseDto(Notice entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.createdAt = entity.getCreatedAt();
    }
}
