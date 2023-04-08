package com.get_pdp.get_pdp.serviceI;

import com.get_pdp.get_pdp.dtos.ProductCompanyDto;
import com.get_pdp.get_pdp.entity.Company;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductCompanyService {
    public ResponseEntity save(ProductCompanyDto productCompanyDto);
    public List<Company> getAll();
    public ResponseEntity getById(Long id);
    public ResponseEntity update(ProductCompanyDto productCompanyDto);
    public ResponseEntity delete(Long id);

}
