package com.palindrom.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Repository<T> {

    private final Map<Long, T> data = new HashMap<>();
    private Long currentId = 1L;

    public List<T> findAll() {
        return new ArrayList<>(data.values());
    }

    public <S extends T> S save(S entity) {
        data.put(currentId++, entity);
        return entity;
    }

    public <S extends T> S save(Long id, S entity) {
        data.put(id, entity);
        return entity;
    }

    public Optional<T> findById(Long id) {
        return Optional.ofNullable(data.get(id));
    }

    public Long getFreeId() {
        return currentId;
    }
}
