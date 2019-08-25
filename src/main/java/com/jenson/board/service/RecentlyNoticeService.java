package com.jenson.board.service;

import com.jenson.board.entity.redis.RecentlyNotice;
import com.jenson.board.repository.redis.RecentlyNoticeRepository;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.Optional;

@Service
public class RecentlyNoticeService {

    private RecentlyNoticeRepository recentlyNoticeRepository;

    public RecentlyNoticeService(RecentlyNoticeRepository recentlyNoticeRepository) {
        this.recentlyNoticeRepository = recentlyNoticeRepository;
    }

    public RecentlyNotice search(String id) {
        Optional<RecentlyNotice> optRecentlyNotice = this.recentlyNoticeRepository.findById(id);
        if (optRecentlyNotice.isPresent()) {
            return optRecentlyNotice.get();
        } else {
            throw new NoResultException("request was not found. (request id = " + id + ")");
        }
    }

    public RecentlyNotice save(RecentlyNotice recentlyNotice) {
        return this.recentlyNoticeRepository.save(recentlyNotice);
    }

    public void delete(String id) {
        this.recentlyNoticeRepository.deleteById(id);
    }
}
