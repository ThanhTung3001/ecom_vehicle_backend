package com.nghiem.market.services;

import com.nghiem.market.entities.BaseEntity;
import com.nghiem.market.exceptions.ResourceNotFoundException;
import com.nghiem.market.repository.GenericRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CrudServiceImpl<T extends BaseEntity> implements CrudService<T> {

    private final GenericRepository<T> crudRepository;

    public CrudServiceImpl(GenericRepository<T> crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public T getById(UUID id) {
        try {
            return crudRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity", "id", id));
        }catch (Exception ex){
            throw ex;
        }

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

    @Override
    public List<T> getAll() {
        return crudRepository.findAll();
    }

    // Other CRUD methods can be added here...

}