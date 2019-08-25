package com.jenson.board.service;

import com.jenson.board.entity.jpa.Notice;
import com.jenson.board.repository.jpa.NoticeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class NoticeBoardService extends GenericBoardService<Notice> {

    public NoticeBoardService(NoticeRepository noticeRepository) {
        super(noticeRepository);
    }

    //몹시 중요
    @Transactional
    @Override
    public Notice update(Notice board) {
        Notice notice = super.search(board.getId());
        notice.setTitle(board.getTitle());
        notice.setContent(board.getContent());
        notice.setUserId(board.getUserId());
        return notice;
    }
}