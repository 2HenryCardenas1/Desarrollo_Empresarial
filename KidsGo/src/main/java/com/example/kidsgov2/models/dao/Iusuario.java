package com.example.kidsgov2.models.dao;

import com.example.kidsgov2.entities.ColegioRuta;
import com.example.kidsgov2.entities.Usuario;
import com.example.kidsgov2.entities.Viaje;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Iusuario extends CrudRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u WHERE u.email=?1")
    public Usuario findByUsername(String email);

    //Consulta para traer el viaje segun el id
    @Query("select v from Usuario u inner join  Persona p on p.idPersona = u.idUsuario inner join Viaje v on v.fkPersona.idPersona = p.idPersona where u.idUsuario = ?1")
    public List<Viaje> getViajeById(Long id);
}
