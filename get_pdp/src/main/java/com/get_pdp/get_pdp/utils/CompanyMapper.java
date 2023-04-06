package com.get_pdp.get_pdp.utils;

import com.get_pdp.get_pdp.dtos.CompanyDto;
import com.get_pdp.get_pdp.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface CompanyMapper {
    Company U = Mappers.getMapper(Company.class);

    Company toEntity(CompanyDto companyDto);
    CompanyDto toDto(Company company);
}
