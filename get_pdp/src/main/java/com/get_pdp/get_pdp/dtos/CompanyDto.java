package com.get_pdp.get_pdp.dtos;

import com.get_pdp.get_pdp.entity.Store;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class CompanyDto {
    private Long id;
    @NotNull(message = "@NOTNULL has true")
    @NotEmpty(message = "name of company is null.")
    @Pattern(message = "name has a special character." , regexp = "[^A-Za-z0-9]")
    private String name;
    private String description;
    private boolean is_active;
    private Set<Long> stores;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public Set<Long> getStores() {
        return stores;
    }

    public void setStores(Set<Long> stores) {
        this.stores = stores;
    }
}
