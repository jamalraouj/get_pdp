package com.get_pdp.get_pdp.controller;


import com.get_pdp.get_pdp.dtos.ProductDto;
import com.get_pdp.get_pdp.entity.Product;
import com.get_pdp.get_pdp.serviceI.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody ProductDto productDto){
        return productService.save(productDto);
    }

    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/")
    public ResponseEntity getBuId(@RequestParam("id") Long id){
        return productService.getById(id);
    }

    @DeleteMapping("/")
    public ResponseEntity deleteById(@RequestParam("id") Long id){
        return productService.delete(id);
    }
}
