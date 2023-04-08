package com.get_pdp.get_pdp.serviceImp;

import com.get_pdp.get_pdp.dtos.StoreDto;
import com.get_pdp.get_pdp.entity.Store;
import com.get_pdp.get_pdp.repository.StoreRepository;
import com.get_pdp.get_pdp.serviceI.StoreService;
import com.get_pdp.get_pdp.utils.DtoMapper;
import com.get_pdp.get_pdp.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StoreServiceImp implements StoreService {
    @Autowired
    StoreRepository storeRepository;
    JsonResponse res = new JsonResponse();
    @Override
    public ResponseEntity save(StoreDto storeDto) {
       Store store = DtoMapper.storeDtoToStore(storeDto);
        storeRepository.save(store);
        return ResponseEntity.ok(store);
    }

    @Override
    public List<Store> getAll() {
        return storeRepository.findAll();
    }

    @Override
    public ResponseEntity update(StoreDto storeDto) {
        return null;
    }

    @Override
    public ResponseEntity delete(Long id) {
        if(storeRepository.existsById(id)){
            storeRepository.deleteById(id);
            res.setMessage("Success");
            ResponseEntity.status(HttpStatus.ACCEPTED).body(res);
        }
        res.setMessage("not found");
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
    }

    @Override
    public ResponseEntity getById(Long id) {
        Optional<Store> store = storeRepository.findById(id);
        if(store.isPresent()){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(store.get());
        }
        res.setMessage("Store Not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
    }
}
