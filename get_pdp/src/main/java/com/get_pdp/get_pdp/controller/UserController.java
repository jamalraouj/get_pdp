package com.get_pdp.get_pdp.controller;

import com.get_pdp.get_pdp.dtos.LoginDto;
import com.get_pdp.get_pdp.dtos.SignUpDto;
import com.get_pdp.get_pdp.serviceImp.UserEntityServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserEntityServiceImp userEntityServiceImp;

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody SignUpDto signUpDto){
        return userEntityServiceImp.register(signUpDto);
    }
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDto loginDto ){
        return userEntityServiceImp.login(loginDto);
    }

}
