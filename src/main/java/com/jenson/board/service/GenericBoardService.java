package com.jenson.board.service;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

public class GenericBoardService<T> implements BoardService<T> {

    private JpaRepository<T, Long> repository;

    public GenericBoardService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    @Override
    public List<T> findAll() {
        return this.repository.findAll();
    }

    @Override
    public T search(long id) {
        Optional<T> notice = this.repository.findById(id);

        if (notice.isPresent()) {
            return notice.get();
        } else {
            throw new NoResultException("request was not found. (request id = " + id + ")");
        }
    }

    @Override
    public T save(T board) {
        return this.repository.save(board);
    }

    @Override
    public T update(T board) {
        return this.save(board);
    }

    @Override
    public void delete(long id) {
        this.repository.deleteById(id);
    }
}
