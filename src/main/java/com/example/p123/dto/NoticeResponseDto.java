package com.example.p123.dto;

import com.example.p123.entity.Notice;

import java.time.LocalDateTime;

public class NoticeResponseDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createAt;

    public NoticeResponseDto(Notice entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.createAt = entity.getCreatedAt();
    }
}
