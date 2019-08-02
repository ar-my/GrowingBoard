package com.jenson.board.service;

import com.jenson.board.model.entity.Notice;
import com.jenson.board.repository.NoticeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NoticeService extends GenericBoardService<Notice> {

    public NoticeService(NoticeRepository noticeRepository) {
        super(noticeRepository);
    }
}
