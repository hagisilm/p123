package com.example.p123.controller.api;

import com.example.p123.dto.AnswerDto.AnswerSaveRequestDto;
import com.example.p123.dto.AnswerDto.ResponseDto;
import com.example.p123.dto.QuestionDto.QuestionSaveRequestDto;
import com.example.p123.dto.QuestionDto.QuestionUpdateRequestDto;
import com.example.p123.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class QuestionApiController {

    private final QuestionService questionService;

    @PostMapping("/api/v1/question")
    public Long save(@RequestBody QuestionSaveRequestDto requestDto) {
        return questionService.save(requestDto);
    }

    @PutMapping("/api/v1/question/{id}")
    public Long update(@PathVariable Long id, @RequestBody QuestionUpdateRequestDto requestDto) {
        System.out.println(requestDto.getContent());
        System.out.println(requestDto.getTitle());
        return questionService.update(id, requestDto);
    }
    @PostMapping("/api/question/{questionId}/answer")
    public ResponseDto<Integer> answerSave(@RequestBody AnswerSaveRequestDto answerSaveRequestDto) {
        questionService.commentSave(answerSaveRequestDto);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
    @DeleteMapping("/api/v1/question/{id}")
    public Long delete(@PathVariable Long id) {
        questionService.delete(id);
        return id;
    }
    @DeleteMapping("/api/question/{questionId}/answer/{answerId}")
    public ResponseDto<Integer> answerDelete(@PathVariable Long answerId) {
        questionService.commentDelete(answerId);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

}
