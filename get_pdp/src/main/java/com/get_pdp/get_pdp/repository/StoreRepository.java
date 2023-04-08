package com.get_pdp.get_pdp.repository;

import com.get_pdp.get_pdp.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store , Long> {
}
