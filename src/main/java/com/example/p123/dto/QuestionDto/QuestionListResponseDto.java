package com.example.p123.dto.QuestionDto;

import com.example.p123.entity.Question;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class QuestionListResponseDto {
    private Long id;
    private String title;
    private LocalDateTime createdAt;
    private String content;

    public QuestionListResponseDto(Question entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.createdAt = entity.getCreatedAt();
        this.content = entity.getContent();
    }
}