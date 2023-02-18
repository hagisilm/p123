package com.example.p123.dto.QuestionDto;

import com.example.p123.entity.Question;
import com.example.p123.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class QuestionSaveRequestDto {
    private String title;
    private String content;
    private User user;

    @Builder
    public QuestionSaveRequestDto(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public Question toEntity() {
        return Question.builder()
                .title(title)
                .content(content)
                .user(user)
                .build();
    }
}