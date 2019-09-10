package com.jenson.board.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardService<T> {
    Page<T> findAll(Pageable pageable);
    List<T> findAll();
    T search(long id);
    T save(T t);
    T update(T t);
    void delete(long id);
}
