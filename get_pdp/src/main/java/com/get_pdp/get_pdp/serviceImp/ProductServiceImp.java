package com.get_pdp.get_pdp.serviceImp;

import com.get_pdp.get_pdp.dtos.ProductDto;
import com.get_pdp.get_pdp.entity.Product;
import com.get_pdp.get_pdp.repository.ProductRepository;
import com.get_pdp.get_pdp.serviceI.ProductService;
import com.get_pdp.get_pdp.utils.DtoMapper;
import com.get_pdp.get_pdp.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ProductServiceImp implements ProductService {
    @Autowired
    ProductRepository productRepository;
    JsonResponse res = new JsonResponse();
    @Override
    public ResponseEntity save(ProductDto productDto) {
        Product product = DtoMapper.dtoToProduct(productDto);

        productRepository.save(product);
        System.out.println(product);
        res.setMessage("Success");
        return ResponseEntity.ok(res) ;
    }

    @Override
    public ResponseEntity getById(Long id) {
        Optional<Product> product =  productRepository.findById(id);
        if(product.isPresent()){
            return ResponseEntity.ok(product.get());
        }
        JsonResponse res = new JsonResponse();
        res.setMessage("Not found.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public ResponseEntity delete(Long id) {

       if( productRepository.existsById(id)) {
           productRepository.deleteById(id);
           res.setMessage("Success");
           return ResponseEntity.ok(res);
       }
       res.setMessage("Not found");
       return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
    }

    @Override
    public ResponseEntity update(ProductDto productDto) {
        return null;
    }
}
