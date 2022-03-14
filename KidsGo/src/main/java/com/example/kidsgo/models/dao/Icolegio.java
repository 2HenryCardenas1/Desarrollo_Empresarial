package com.example.kidsgo.models.dao;

import com.example.kidsgo.entities.Colegio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


public interface Icolegio extends CrudRepository<Colegio,Long> {
}
