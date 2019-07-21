package com.jenson.board.controller;

import com.jenson.board.model.entity.Notice;
import com.jenson.board.service.BoardService;
import com.jenson.board.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@RestController
@RequestMapping("/board")
public class RestBoardController {

    private BoardService<Notice> boardService;

    public RestBoardController(NoticeService noticeService) {
        this.boardService = noticeService;
    }

    @GetMapping("notice")
    public ResponseEntity<?> notices() {
        return ResponseEntity.ok(this.boardService.findAll());
    }

    @GetMapping("notice/{id}")
    public ResponseEntity<?> notice(@PathVariable long id) {
        return ResponseEntity.ok(this.boardService.search(id));
    }

    @PostMapping("notice")
    public ResponseEntity<?> post(@RequestBody Notice notice) throws URISyntaxException {
        Notice result = this.boardService.save(notice);
        return ResponseEntity.created(new URI(ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUriString() + "/" + result.getId())).build();
    }

    @PutMapping("notice/{id}")
    public ResponseEntity<?> put(@RequestBody Notice notice, @PathVariable long id) {
        return ResponseEntity.ok(this.boardService.update(notice, id));
    }

    @DeleteMapping("notice/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        this.boardService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
