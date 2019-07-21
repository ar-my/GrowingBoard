package com.jenson.board.service;

import java.util.List;

public interface BoardService<T> {
    List<T> findAll();
    T search(long id);
    T save(T t);
    T update(T t, long id);
    void delete(long id);
}
