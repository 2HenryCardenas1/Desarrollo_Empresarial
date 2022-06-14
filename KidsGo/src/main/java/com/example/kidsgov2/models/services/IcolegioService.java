package com.example.kidsgov2.models.services;

import com.example.kidsgov2.entities.Colegio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public interface IcolegioService {

    public List<Colegio> findAll();

    public void save(Colegio colegio);

    public Colegio findOne(Long id);

    public void remove(Long id);

    void  deleteByColegioId(Long id);



}
