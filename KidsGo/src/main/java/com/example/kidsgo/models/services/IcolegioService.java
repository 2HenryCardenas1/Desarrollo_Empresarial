package com.example.kidsgo.models.services;

import com.example.kidsgo.entities.Colegio;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IcolegioService {

    public List<Colegio> findAll();
}
