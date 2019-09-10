package com.jenson.board.repository.redis;

import com.jenson.board.entity.redis.RecentlyNotice;
import org.springframework.data.repository.CrudRepository;

public interface RecentlyNoticeRepository extends CrudRepository<RecentlyNotice, String> {
}
