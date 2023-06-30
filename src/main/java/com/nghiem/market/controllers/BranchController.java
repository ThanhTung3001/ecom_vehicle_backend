package com.nghiem.market.controllers;

import com.nghiem.market.dto.mapper.Branchs.BranchCreate;
import com.nghiem.market.dto.mapper.Branchs.BranchDto;
import com.nghiem.market.entities.products.Branch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/branch")
public class BranchController extends BaseController<Branch, BranchDto, BranchCreate> {


    // Other CRUD API endpoints can be added here...

}