package com.get_pdp.get_pdp.controller;


import com.get_pdp.get_pdp.dtos.CompanyDto;
import com.get_pdp.get_pdp.entity.Company;
import com.get_pdp.get_pdp.serviceI.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/company")
class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping("/")
    public ResponseEntity<List<Company>>  getAll(){
       return companyService.getAll();
    }
    @PostMapping("/")
    public  ResponseEntity save(@RequestBody @Valid CompanyDto companyDto ){
        return ResponseEntity.ok(companyService.save(companyDto));
    }
}
