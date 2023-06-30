package com.nghiem.market.services;

import com.nghiem.market.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CrudServiceImpl<T> implements CrudService<T> {

    @Autowired
    private CrudRepository<T, UUID> crudRepository;

    @Override
    public T getById(UUID id) {
        return crudRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity", "id", id));
    }

    @Override
    public T create(T entity) {
        return crudRepository.save(entity);
    }

    @Override
    public T update(UUID id, T entity) {
        T existingEntity = getById(id);
        BeanUtils.copyProperties(entity, existingEntity);
        return crudRepository.save(existingEntity);
    }

    @Override
    public void delete(UUID id) {
        crudRepository.deleteById(id);
    }

    // Other CRUD methods can be added here...

}