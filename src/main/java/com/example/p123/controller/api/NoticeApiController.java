package com.example.p123.controller.api;

import com.example.p123.dto.NoticeSaveRequestDto;
import com.example.p123.dto.NoticeUpdateRequestDto;
import com.example.p123.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class NoticeApiController {

    private final NoticeService noticeService;

    @PostMapping("/api/v1/notice")
    public Long save(@RequestBody NoticeSaveRequestDto requestDto){
        return noticeService.save(requestDto);
    }

    @PutMapping("/api/v1/notice/{id}")
    public Long update(@PathVariable Long id, @RequestBody NoticeUpdateRequestDto requestDto) {
        return noticeService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/notice/{id}")
    public Long delete(@PathVariable Long id) {
        noticeService.delete(id);
        return id;
    }
}
