package com.get_pdp.get_pdp.serviceImp;

import com.get_pdp.get_pdp.config.configspringsecurity.JwtUtils;
import com.get_pdp.get_pdp.dtos.LoginDto;
import com.get_pdp.get_pdp.dtos.SignUpDto;
import com.get_pdp.get_pdp.entity.ManagerStore;
import com.get_pdp.get_pdp.entity.Role;
import com.get_pdp.get_pdp.entity.UserEntity;
import com.get_pdp.get_pdp.repository.UserEntityRepository;
import com.get_pdp.get_pdp.utils.DtoMapper;
import com.get_pdp.get_pdp.utils.JsonResponse;
import com.get_pdp.get_pdp.utils.vm.ResponseVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
@Service
public class UserEntityServiceImp implements UserDetailsService {
    @Autowired
    UserEntityRepository userEntityRepository;
//    @Autowired
//    ManagerStoreRepository managerStoreRepository;
    @Autowired
    JwtUtils jwtUtils;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<UserEntity> getAllUsers(){
        return userEntityRepository.findAll();
    }
//    public UserEntity findByEmail(String email){}
//    public UserEntity register(RegisterDTO registerDTO){}

    public ResponseEntity register(SignUpDto signUpDto) {
        Optional<UserEntity> user = userEntityRepository.findUserEntityByEmail(signUpDto.getEmail());
        JsonResponse res = new JsonResponse();
        if (user.isPresent()) {
            UserEntity u = DtoMapper.signUpDtoToUserEntity(signUpDto);
            res.setMessage("This Email is exist");
            return ResponseEntity.ok(res);
        }
        String hashedPassword = passwordEncoder.encode(signUpDto.getPassword());

        if (signUpDto.getRole() != Role.ADMIN  || signUpDto.getRole() == null) {
            UserEntity userEntity = DtoMapper.signUpDtoToUserEntity(signUpDto);
            userEntity.setPassword(hashedPassword);
            userEntityRepository.save(userEntity);
                res.setMessage("Success.");
                return ResponseEntity.ok(res);
        }
        else {
            res.setMessage("ERROR");
            return new ResponseEntity<>(res , HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity login(LoginDto loginDto){

        Optional<UserEntity> user = userEntityRepository.findUserEntityByEmail(loginDto.getEmail());
        System.out.println(user);
        if(user.isPresent() && user.get().isActive()){
            return ResponseEntity.ok(new ResponseVm( HttpStatus.ACCEPTED , "Success" ,Collections.singletonList(jwtUtils.generateToken(new User(user.get().getEmail(),user.get().getPassword(), Collections.singleton(new SimpleGrantedAuthority(user.get().getRole().toString()))))) ));
        }
        return ResponseEntity.ok(new ResponseVm(HttpStatus.BAD_REQUEST , "ERROR : Email not exist or your account is banned."));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> userOptional = (userEntityRepository.findUserEntityByEmail(email));
        if (userOptional.isEmpty())
            throw new UsernameNotFoundException("user with email "+email+" not found");
        return new User(userOptional.get().getEmail(),userOptional.get().getPassword(), Collections.singleton(new SimpleGrantedAuthority("ROLE_"+userOptional.get().getRole().toString())));

    }

    public ResponseEntity findByEmail(String email){
        Optional<UserEntity> user = Optional.empty();
        JsonResponse res = new JsonResponse();
        if(email == null || email == ""){
            res.setMessage("You must adding email");
        }else {
            user = userEntityRepository.findUserEntityByEmail(email);
            if(user.isPresent()){
                return ResponseEntity.ok(user.get());
            }
            else {
                res.setMessage("This email does not exist");
            }
        }
        return ResponseEntity.ok(res);
    }
}
