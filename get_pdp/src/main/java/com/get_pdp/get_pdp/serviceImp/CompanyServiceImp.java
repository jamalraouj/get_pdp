package com.get_pdp.get_pdp.serviceImp;

import com.get_pdp.get_pdp.dtos.CompanyDto;
import com.get_pdp.get_pdp.entity.Company;
import com.get_pdp.get_pdp.repository.CompanyRepository;
import com.get_pdp.get_pdp.serviceI.CompanyService;
import com.get_pdp.get_pdp.utils.CompanyMapper;
import com.get_pdp.get_pdp.utils.DtoMapper;
import com.get_pdp.get_pdp.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CompanyServiceImp implements CompanyService {


    @Autowired
    CompanyRepository companyRepository;
    @Override
    public ResponseEntity save(CompanyDto companyDto) {
        Company c = DtoMapper.dtoToCompany(companyDto);
        companyRepository.save(c);
        return ResponseEntity.ok(c);
    }

    @Override
    public ResponseEntity update(Company company) {
        return null;
    }

    @Override
    public ResponseEntity delete(Company company) {
        return null;
    }

    @Override
    public ResponseEntity getById(Long id) {
        JsonResponse res = new JsonResponse();
        Optional<Company> company = companyRepository.findById(id);
        if(company.isPresent()){
            res.setMessage("company is found");
            return  ResponseEntity.ok(company.get());
        }
        return ResponseEntity.ok(res);
    }

    @Override
    public ResponseEntity<List<Company>> getAll() {
        return ResponseEntity.ok(companyRepository.findAll());
    }
}
