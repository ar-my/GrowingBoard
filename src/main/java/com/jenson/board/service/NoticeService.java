package com.jenson.board.service;

import com.jenson.board.model.entity.Notice;
import com.jenson.board.repository.NoticeRepository;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service
public class NoticeService implements BoardService<Notice> {

    private NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @Override
    public List<Notice> findAll() {
        return this.noticeRepository.findAll();
    }

    @Override
    public Notice search(long id) {
        Optional<Notice> notice = this.noticeRepository.findById(id);

        if (notice.isPresent()) {
            return notice.get();
        } else {
            throw new NoResultException("request was not found. (request id = " + id + ")");
        }
    }

    @Override
    public Notice save(Notice notice) {
        return this.noticeRepository.save(notice);
    }

    @Override
    public void delete(long id) {
        this.noticeRepository.delete(this.search(id));
    }

    @Override
    public Notice update(Notice notice, long id) {
        Notice prevNotice = this.search(id);
        prevNotice.setTitle(notice.getTitle());
        prevNotice.setContent(notice.getContent());
        prevNotice.setUserId(notice.getUserId());
        return this.save(prevNotice);
    }
}
