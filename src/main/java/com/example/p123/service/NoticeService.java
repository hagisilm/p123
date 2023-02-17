package com.example.p123.service;

import com.example.p123.dto.NoticeListResponseDto;
import com.example.p123.dto.NoticeResponseDto;
import com.example.p123.dto.NoticeSaveRequestDto;
import com.example.p123.dto.NoticeUpdateRequestDto;
import com.example.p123.entity.Notice;
import com.example.p123.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;

    @Transactional
    public Page<NoticeListResponseDto> findAllDesc(Pageable pageable){
        return noticeRepository.findAllDesc(pageable)
                .map(NoticeListResponseDto::new);
    }

    public NoticeResponseDto findById(Long id) {
        Notice entity = noticeRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 글이 없습니다. id=" + id));
        return new NoticeResponseDto(entity);
    }
    @Transactional
    public Long save(NoticeSaveRequestDto requestDto) {
        return noticeRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, NoticeUpdateRequestDto requestDto) {
        Notice notice = noticeRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 글이 없습니다. id=" + id));
        notice.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    @Transactional
    public void delete(Long id) {
        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        noticeRepository.delete(notice);
    }
}


