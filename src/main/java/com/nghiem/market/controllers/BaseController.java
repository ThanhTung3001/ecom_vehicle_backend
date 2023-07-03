package com.nghiem.market.controllers;

import com.nghiem.market.dto.ResponseApi;
import com.nghiem.market.entities.BaseEntity;
import com.nghiem.market.exceptions.ResourceNotFoundException;
import com.nghiem.market.services.CrudService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")

public abstract class BaseController<T extends BaseEntity, TGet,TCreate> {

    public final CrudService<T> crudService;

    public final ModelMapper mapper;

    public Class<TGet> getEntityType;

    public Class<TCreate> createEntityType;

    public Class<T> entityType;

    public BaseController(CrudService<T> crudService, ModelMapper mapper) {
        this.crudService = crudService;
        this.mapper = mapper;
    }
    @GetMapping
    public ResponseEntity<Object> getAll() throws Exception {
        var result  = crudService.getAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/{id}")

    public ResponseEntity<Object> getById(@PathVariable UUID id) {

        try {
            T entity = crudService.getById(id);
            var response = mapper.map(entity, getEntityType);
            return ResponseEntity.ok().body(response);
        } catch (ResourceNotFoundException exception) {
            return ResponseEntity
                    .status(404)
                    .body(
                    new ResponseApi<T>(404, "Not found entity", null, null)
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody TCreate entity) throws Exception {

        var createEntity = mapper.map(entity,entityType);
        createEntity.prePersist();
        T createdEntity = crudService.create(createEntity);
        return ResponseEntity.created(URI.create("/api/" + getEntityId(createdEntity))).body(createdEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable UUID id, @RequestBody T entity) throws Exception {
        T updatedEntity = crudService.update(id, entity);
        return ResponseEntity.ok().body(updatedEntity);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Void> delete(@PathVariable UUID id) throws Exception {
        crudService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Other CRUD API endpoints can be added here...

    private UUID getEntityId(T entity) {
        // Implement this method to get the ID of the entity
        // For example, if the entity has a 'getId()' method, you can call it
        // Otherwise, you need to add a 'BaseEntity' interface as I explained earlier
        return null;
    }

}