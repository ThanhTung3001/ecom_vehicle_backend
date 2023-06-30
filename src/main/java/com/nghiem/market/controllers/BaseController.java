package com.nghiem.market.controllers;

import com.nghiem.market.services.CrudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@Api(tags = "crud")
public abstract class BaseController<T> {

    @Autowired
    private CrudService<T> crudService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Get entity by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Entity found"),
            @ApiResponse(code = 404, message = "Entity not found")
    })
    public ResponseEntity<T> getById(@PathVariable UUID id) {
        T entity = crudService.getById(id);
        return ResponseEntity.ok().body(entity);
    }

    @PostMapping
    @ApiOperation(value = "Create entity")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Entity created"),
            @ApiResponse(code = 400, message = "Bad request")
    })
    public ResponseEntity<T> create(@RequestBody T entity) {
        T createdEntity = crudService.create(entity);
        return ResponseEntity.created(URI.create("/api/" + getEntityId(createdEntity))).body(createdEntity);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update entity by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Entity updated"),
            @ApiResponse(code = 404, message = "Entity not found")
    })
    public ResponseEntity<T> update(@PathVariable UUID id, @RequestBody T entity) {
        T updatedEntity = crudService.update(id, entity);
        return ResponseEntity.ok().body(updatedEntity);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete entity by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Entity deleted"),
            @ApiResponse(code = 404, message = "Entity not found")
    })
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