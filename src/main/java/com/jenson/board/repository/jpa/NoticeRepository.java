package com.jenson.board.repository.jpa;

import com.jenson.board.entity.jpa.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

}
