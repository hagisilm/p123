package com.example.p123.dto.QuestionDto;

import com.example.p123.entity.Answer;
import com.example.p123.entity.Question;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class QuestionResponseDto {
    private Long id;
    private String title;
    private String content;
    private List<Answer> answers;
    private LocalDateTime createdAt;

    public QuestionResponseDto(Question entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.answers = entity.getAnswers();
        this.createdAt = entity.getCreatedAt();
    }
}