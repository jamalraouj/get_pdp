package com.get_pdp.get_pdp.entity;

import lombok.*;

import javax.persistence.*;
@Entity
@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String productRef;
    private double price;
    private Long quantity;
    private String image;
    private String description;
    @ManyToOne
    private ProductCompany productCompany;
    private ProductCategory productCategory;
    @ManyToOne
    private Store store;


    public Product() {

    }
}
