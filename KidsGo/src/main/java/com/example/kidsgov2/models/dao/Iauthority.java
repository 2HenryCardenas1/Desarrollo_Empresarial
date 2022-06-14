package com.example.kidsgov2.models.dao;

import com.example.kidsgov2.entities.Authority;
import com.example.kidsgov2.entities.ColegioRuta;
import org.springframework.data.repository.CrudRepository;

public interface Iauthority extends CrudRepository<Authority,Long> {
}
