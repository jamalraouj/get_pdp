package com.get_pdp.get_pdp.repository;

import com.get_pdp.get_pdp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product , Long> {

}
