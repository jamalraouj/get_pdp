package com.get_pdp.get_pdp.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Setter
@Getter
public class ManagerStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Store store;

    public ManagerStore(Store store) {
        this.store = store;
    }

    public ManagerStore(Long id, Store store) {
        this.id = id;
        this.store = store;
    }

    public ManagerStore() {
    }
}
