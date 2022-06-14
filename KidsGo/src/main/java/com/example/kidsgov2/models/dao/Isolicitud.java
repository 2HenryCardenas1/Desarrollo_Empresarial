package com.example.kidsgov2.models.dao;

import com.example.kidsgov2.entities.Solicitud;
import org.springframework.data.repository.CrudRepository;

public interface Isolicitud extends CrudRepository<Solicitud, Long> {
}
