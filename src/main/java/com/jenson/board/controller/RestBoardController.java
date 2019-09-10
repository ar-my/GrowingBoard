package com.jenson.board.controller;

import com.jenson.board.entity.jpa.Notice;
import com.jenson.board.entity.redis.RecentlyNotice;
import com.jenson.board.repository.jpa.NoticeRepository;
import com.jenson.board.service.BoardService;
import com.jenson.board.service.NoticeBoardService;
import com.jenson.board.service.RecentlyNoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@RestController
@RequestMapping("v1/board")
public class RestBoardController {

    private BoardService<Notice> boardService;
    private RecentlyNoticeService redisBoardService;

    public RestBoardController(NoticeBoardService noticeBoardService,
                               RecentlyNoticeService recentlyNoticeService) {
        this.boardService = noticeBoardService;
        this.redisBoardService = recentlyNoticeService;
    }

    @GetMapping("notice")
    public ResponseEntity notices(Pageable pageable) {
        return ResponseEntity.ok(this.boardService.findAll(pageable));
    }

    @GetMapping("notices")
    public ResponseEntity noticeList() {
        return ResponseEntity.ok(this.boardService.findAll());
    }

    @GetMapping("notice/{id}")
    public ResponseEntity notice(@PathVariable long id) {
        return ResponseEntity.ok(this.boardService.search(id));
    }

    @PostMapping("notice")
    public ResponseEntity post(@RequestBody Notice notice) throws URISyntaxException {
        Notice result = this.boardService.save(notice);
        log.info("notice {}", result);
        RecentlyNotice recentlyNotice = new RecentlyNotice(result.getId());
        log.info("recently {}", recentlyNotice);
        this.redisBoardService.save(recentlyNotice);
        return ResponseEntity.created(new URI(ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUriString() + "/" + result.getId())).build();
    }

    @PutMapping("notice")
    public ResponseEntity put(@RequestBody Notice notice) {
        return ResponseEntity.ok(this.boardService.update(notice));
    }

    @DeleteMapping("notice/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        this.boardService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("notice/recently")
    public ResponseEntity recently() {
        return ResponseEntity.ok(this.redisBoardService.search("notice"));
    }
}
