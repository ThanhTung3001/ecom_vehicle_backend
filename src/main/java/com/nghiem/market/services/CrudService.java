package com.nghiem.market.services;

import com.nghiem.market.entities.BaseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface CrudService<T extends BaseEntity> {

    T getById(UUID id) throws Exception;

    T create(T entity)throws Exception ;

    T update(UUID id, T entity) throws Exception;

    void delete(UUID id) throws Exception;

    List<T> getAll() throws Exception ;

    // Other CRUD methods can be added here...
}