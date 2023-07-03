package com.nghiem.market.controllers;

import com.nghiem.market.dto.ResponseApi;
import com.nghiem.market.entities.BaseEntity;
import com.nghiem.market.exceptions.ResourceNotFoundException;
import com.nghiem.market.services.CrudService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api")

public abstract class BaseController<T extends BaseEntity, TGet, TCreate> {

    @Autowired
    public ModelMapper mapper;
    @Autowired
    private CrudService<T> crudService;
    private Class<TGet> getEntityType;

    private Class<TCreate> createEntityType;

    private Class<T> entityType;

    @GetMapping("/{id}")

    public ResponseEntity getById(@PathVariable UUID id) {

        try {
            T entity = crudService.getById(id);
            var response = mapper.map(entity, getEntityType);
            return ResponseEntity.ok().body(response);
        } catch (ResourceNotFoundException exception) {
            return ResponseEntity.status(404).body(new ResponseApi<T>(404, "Not found entity", null, null));
        }

    }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody TCreate entity) {

        var createEntity = mapper.map(entity, entityType);
        createEntity.prePersist();
        T createdEntity = crudService.create(createEntity);
        return ResponseEntity.created(URI.create("/api/" + getEntityId(createdEntity))).body(createdEntity);
    }

    @PutMapping("/{id}")


    public ResponseEntity<T> update(@PathVariable UUID id, @RequestBody T entity) {
        T updatedEntity = crudService.update(id, entity);
        return ResponseEntity.ok().body(updatedEntity);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        crudService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Other CRUD API endpoints can be added here...

    private Long getEntityId(T entity) {
        // Implement this method to get the ID of the entity
        // For example, if the entity has a 'getId()' method, you can call it
        // Otherwise, you need to add a 'BaseEntity' interface as I explained earlier
        return null;
    }

}