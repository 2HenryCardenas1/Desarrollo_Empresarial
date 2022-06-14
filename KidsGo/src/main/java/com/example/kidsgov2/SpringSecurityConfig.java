package com.example.kidsgov2;

import com.example.kidsgov2.handler.LoginSuccesHandler;
import com.example.kidsgov2.models.services.JPAuserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private LoginSuccesHandler successHandler;

    @Autowired
    private JPAuserDetailService jpAuserDetailService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/","/css/**","/js/**","/images/**","/scss/**").permitAll()
                //ADMIN
                .antMatchers("/listObject/listaPersonas").hasRole("ADMIN")
                .antMatchers("/listObject/listarViajes").hasRole("ADMIN")
                //CRUD
                //Add-Edit
                .antMatchers("/addObject/addColegios").hasRole("ADMIN")
                .antMatchers("/addObject/addViaje").hasRole("ADMIN")
                .antMatchers("/addObject/addVehiculo").hasRole("ADMIN")
                .antMatchers("/addObject/addRuta").hasRole("ADMIN")

                //ADMIN AND USERS
                .antMatchers("/listObject/listaRutas").hasAnyRole("ADMIN","USER")
                .antMatchers("/listObject/listaVehiculos").hasAnyRole("ADMIN","USER")
                .antMatchers("/listObject/listarColegios").hasAnyRole("ADMIN","USER")

                //ADD-EDIT
                .antMatchers("/addObject/addPersona").hasAnyRole("ADMIN","USER") //Usuario



                .and()
                .formLogin().successHandler(successHandler)
                .loginPage("/login").permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/error_403");
    }

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
        builder.userDetailsService(jpAuserDetailService)
                .passwordEncoder(passwordEncoder);
    }
}
