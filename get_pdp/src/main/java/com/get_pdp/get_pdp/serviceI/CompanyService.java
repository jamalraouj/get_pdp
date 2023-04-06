package com.get_pdp.get_pdp.serviceI;

import com.get_pdp.get_pdp.dtos.CompanyDto;
import com.get_pdp.get_pdp.entity.Company;
import com.get_pdp.get_pdp.utils.JsonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {
    public ResponseEntity save(CompanyDto companyDto);
    public ResponseEntity update(Company company);
    public ResponseEntity delete(Company company);
    public ResponseEntity getById(Long id);
    public ResponseEntity getAll();


}
