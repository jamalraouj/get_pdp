package com.get_pdp.get_pdp.dtos;

import com.get_pdp.get_pdp.entity.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class SignUpDto {
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}
