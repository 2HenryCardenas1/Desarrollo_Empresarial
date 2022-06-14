package com.example.kidsgov2.models.services;
//Contenedor de info de acuerdo a roles

import com.example.kidsgov2.entities.Authority;
import com.example.kidsgov2.entities.Usuario;
import com.example.kidsgov2.models.dao.Iusuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("JPAuserDetailService")
public class JPAuserDetailService implements UserDetailsService {

    @Autowired
    private Iusuario iUsuarioDao;

    private Logger logger = LoggerFactory.getLogger(JPAuserDetailService.class);

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = iUsuarioDao.findByUsername(username);

        if (usuario == null) {
            logger.error("Error login: No existe el usuario '" + username + "'");
            throw new UsernameNotFoundException("Username " + username + " no existe en el sistema");
        }

        List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();
        for (Authority authority : usuario.getAuthorities()) {
            logger.info("Roles: ".concat(authority.getRolUser()));
            authorityList.add(new SimpleGrantedAuthority(authority.getRolUser()));
        }

        if (authorityList.isEmpty()) {
            logger.error("Error login: Usuario '" + username + "' No tiene roles asignados");
            throw new UsernameNotFoundException("Error login: Usuario '" + username + "' No tiene roles asignados");
        }

        final Long idUser = usuario.getIdUsuario();
        logger.info("ID user: "+idUser);
        logger.info("ID Persona: "+ usuario.getPersona().getIdPersona());

        return new User(usuario.getEmail(), usuario.getPassword(), usuario.isEstado(), true, true, true, authorityList);
    }





}


