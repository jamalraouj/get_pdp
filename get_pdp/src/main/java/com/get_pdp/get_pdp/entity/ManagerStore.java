package com.get_pdp.get_pdp.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Setter
@Getter
public class ManagerStore extends UserEntity {

    @OneToOne
    private Store store;

    public ManagerStore(Store store) {
        this.store = store;
    }



    public ManagerStore() {
    }
}
