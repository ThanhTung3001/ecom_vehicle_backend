package com.nghiem.market.controllers;

import com.nghiem.market.dto.mapper.Branchs.BranchCreate;
import com.nghiem.market.dto.mapper.Branchs.BranchDto;
import com.nghiem.market.entities.products.Branch;
import com.nghiem.market.services.CrudService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/branch")
public class BranchController extends BaseController<Branch, BranchDto, BranchCreate> {
    public BranchController(CrudService<Branch> crudService, ModelMapper mapper) {
        super(crudService, mapper);

//        this.getEntityId = User::getId;
        this.getEntityType = BranchDto.class;
        this.createEntityType = BranchCreate.class;
        this.entityType = Branch.class;

    }

    // Other CRUD API endpoints can be added here...

}