package com.example.p123.service;

import com.example.p123.dto.AnswerDto.AnswerSaveRequestDto;
import com.example.p123.dto.QuestionDto.QuestionListResponseDto;
import com.example.p123.dto.QuestionDto.QuestionResponseDto;
import com.example.p123.dto.QuestionDto.QuestionSaveRequestDto;
import com.example.p123.dto.QuestionDto.QuestionUpdateRequestDto;
import com.example.p123.entity.Answer;
import com.example.p123.entity.Question;
import com.example.p123.repository.AnswerRepository;
import com.example.p123.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    @Transactional(readOnly = true)
    public Page<QuestionListResponseDto> findAllDesc(Pageable pageable){
        return questionRepository.findAllDesc(pageable)
                .map(QuestionListResponseDto::new);
    }
    public QuestionResponseDto findById(Long id) {
        Question entity = questionRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 질문이 없습니다. id=" + id));
        return new QuestionResponseDto(entity);
    }
    @Transactional
    public Long save(QuestionSaveRequestDto requestDto) {
        return questionRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public void delete(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 질문이 없습니다. id = " + id));
        questionRepository.delete(question);
    }
    @Transactional
    public Long update(Long id, QuestionUpdateRequestDto requestDto) {
        Question question = questionRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 질문이 없습니다. id=" + id));
        question.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }
    @Transactional
    public void commentSave(AnswerSaveRequestDto answerSaveRequestDto) {
        Answer answer;
        answer = new Answer(
                answerSaveRequestDto.getComment(),
                questionRepository.findById(answerSaveRequestDto.getQuestionId()).orElseThrow(() -> new IllegalArgumentException("질문 찾기 실패"))
        );
        answerRepository.save(answer);
    }
    @Transactional
    public void commentDelete(Long answerId) {
        answerRepository.deleteById(answerId);
    }

}
