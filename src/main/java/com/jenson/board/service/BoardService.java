package com.jenson.board.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService<T> {
    Page<T> findAll(Pageable pageable);
    T search(long id);
    T save(T t);
    T update(T t);
    void delete(long id);
}
