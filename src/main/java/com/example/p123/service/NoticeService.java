package com.example.p123.service;

import com.example.p123.dto.NoticeListResponseDto;
import com.example.p123.dto.NoticeSaveRequestDto;
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

    @Transactional
    public Long save(NoticeSaveRequestDto requestDto) {
        return noticeRepository.save(requestDto.toEntity()).getId();
    }

}
