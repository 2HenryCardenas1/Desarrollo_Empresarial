package com.example.kidsgov2.models.services;
import com.example.kidsgov2.entities.Solicitud;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IsolicitudService {
    public List<Solicitud> findAll();
}
