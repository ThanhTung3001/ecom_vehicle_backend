package com.nghiem.market.services;

import java.util.UUID;

public interface CrudService<T> {

    T getById(UUID id);

    T create(T entity);

    T update(UUID id, T entity);

    void delete(UUID id);

    // Other CRUD methods can be added here...
}