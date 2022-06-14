package com.example.kidsgov2.models.services;

import com.example.kidsgov2.entities.Authority;
import com.example.kidsgov2.entities.Colegio;

import java.util.List;

public interface IauthorityService {
    public List<Authority> findAll();

    public void save(Authority authority);
}
