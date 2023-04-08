package com.get_pdp.get_pdp.config.configspringsecurity;


import com.get_pdp.get_pdp.entity.Role;
import com.get_pdp.get_pdp.serviceImp.UserEntityServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAthFilter jwtAthFilter;
    private final UserEntityServiceImp userService;


    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{

        http
                .csrf().disable().cors().disable()//announce
//                .authorizeRequests()

//                .antMatchers("/").hasRole(Role.ADMIN.toString())
//                .antMatchers("/**/product/**").hasRole(Role.CLIENT.toString())
//                .antMatchers("/**/product/**").hasRole(Role.CLIENT.toString())
//                .antMatchers("/**/store/**").hasRole(Role.STORE_MANAGER.toString())
//                .antMatchers("/**/client/me" ,"/**/client/profile" ,"/**/client/my_profile").hasRole(Role.CLIENT.toString())
//                .and()
//                .userDetailsService(userDetailsService)
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAthFilter, UsernamePasswordAuthenticationFilter.class)
                ;
//                .httpBasic();
//        http.formLogin();
//        http.httpBasic();
        return http.build();


    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
               return userService.loadUserByUsername(email);

            }
        };
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)throws Exception{
        return config.getAuthenticationManager();
    }
//    public PasswordEncoder passwordEncoder() {
////        return NoOpPasswordEncoder.getInstance();
//        return new BCryptPasswordEncoder();
//    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
