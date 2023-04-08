package com.get_pdp.get_pdp.serviceI;

import com.get_pdp.get_pdp.dtos.StoreDto;
import com.get_pdp.get_pdp.entity.Store;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StoreService {
    public ResponseEntity save(StoreDto storeDto);
    public List<Store> getAll();
    public ResponseEntity update(StoreDto storeDto);
    public ResponseEntity delete (Long id);
    public ResponseEntity getById(Long id);
}
