package com.example.kidsgo.models.services;

import com.example.kidsgo.entities.Colegio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public interface IcolegioService {

    public List<Colegio> findAll();

    public void save(Colegio colegio);



}
