package com.get_pdp.get_pdp.serviceI;

import com.get_pdp.get_pdp.dtos.ProductDto;
import com.get_pdp.get_pdp.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public ResponseEntity save(ProductDto productDto);
    public ResponseEntity getById(Long id);
    public List<Product> getAll();
    public ResponseEntity delete(Long id);
    public ResponseEntity update(ProductDto productDto);
}
