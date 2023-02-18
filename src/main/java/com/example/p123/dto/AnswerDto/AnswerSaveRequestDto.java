package com.example.p123.dto.AnswerDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerSaveRequestDto {
    private Long userId;
    private Long questionId;
    private String comment;
}
