package com.get_pdp.get_pdp.utils;

import com.get_pdp.get_pdp.dtos.CompanyDto;
import com.get_pdp.get_pdp.dtos.ProductDto;
import com.get_pdp.get_pdp.dtos.SignUpDto;
import com.get_pdp.get_pdp.dtos.StoreDto;
import com.get_pdp.get_pdp.entity.*;
import org.modelmapper.ModelMapper;

public class DtoMapper {
    public static Company dtoToCompany(CompanyDto companyDto){
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(companyDto, Company.class);
    }
    public static Product dtoToProduct(ProductDto productDto){
        ModelMapper modelMapper=new ModelMapper();
         Product product =modelMapper.map(productDto, Product.class);

        return product;
    }
    public static UserEntity signUpDtoToUserEntity(SignUpDto signUpDto){
        ModelMapper modelMapper=new ModelMapper();
        UserEntity userEntity = modelMapper.map(signUpDto, UserEntity.class);

        return userEntity;
    }
    public static ManagerStore signUpDtoToStoreManager(SignUpDto signUpDto){
//        ModelMapper modelMapper=new ModelMapper();
        ManagerStore managerStore = new ManagerStore();
        managerStore.setActive(true);
        managerStore.setEmail(signUpDto.getEmail());
        managerStore.setName(signUpDto.getName());
        managerStore.setLastName(signUpDto.getLastName());
        managerStore.setPassword(signUpDto.getPassword());
        managerStore.setRole(signUpDto.getRole());
        return managerStore;
    }

    public static Store storeDtoToStore(StoreDto storeDto) {
        ModelMapper modelMapper=new ModelMapper();
        Store store = modelMapper.map(storeDto , Store.class);
        return store;
    }
}
