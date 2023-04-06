package com.get_pdp.get_pdp.utils;

import com.get_pdp.get_pdp.dtos.CompanyDto;
import com.get_pdp.get_pdp.entity.Company;
import org.modelmapper.ModelMapper;

public class DtoMapper {
     public static Company dtoToCompany(CompanyDto companyDto){
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(companyDto, Company.class);
    }
}
