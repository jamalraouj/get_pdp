package com.get_pdp.get_pdp.dtos;

import com.get_pdp.get_pdp.entity.ProductCategory;
import com.get_pdp.get_pdp.entity.ProductCompany;
import com.get_pdp.get_pdp.entity.Store;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@Builder
public class ProductDto {
    private Long id;
    @NotEmpty(message = "product name is empty.")
    private String productName;
    @NotEmpty(message = "product ref is empty.")
    private String productRef;
    @NotEmpty(message = "product price is empty.")
    private double price;
    @NotEmpty(message = "product quantity is empty.")
    private Long quantity;
    private String image;
    private String description;
    @NotEmpty(message = "company can not be empty")
    private Long productCompany;
    @NotEmpty(message = "product category can not be empty")
    private ProductCategory productCategory;
    @NotEmpty(message = "store can not be empty")
    private Long store;
}
