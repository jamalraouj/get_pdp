package com.get_pdp.get_pdp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "name of company is null.")
    @Pattern(message = "name has a special character." , regexp = "^\\w\\s")
    private String name;
    private String description;
    private boolean is_active;
    @OneToMany
    private Set<Store> stores;

    public Company(String name, String description, boolean is_active) {
        this.name = name;
        this.description = description;
        this.is_active = is_active;
    }
    public void addStore(Store store) {
        this.stores.add(store);
    }
}
