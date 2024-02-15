package com.back.pruebaback.service;

import com.back.pruebaback.entity.Consulta;
import com.back.pruebaback.repository.ConsultaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConsultaService {
    
    @Autowired
    ConsultaRepository consultaRepository;
    
    public List<Consulta> getAllConsultas() {
        return consultaRepository.findAll();
    }
    
    public void saveConsulta(Consulta consulta) {
        consultaRepository.save(consulta);
    }
    
    public void deleteConsulta(Consulta consulta) {
        consultaRepository.delete(consulta);
    }
    
    public Optional<Consulta> findConsultaById(Consulta consulta) {
        return consultaRepository.findById(consulta.getIdConsulta());
    }
    
}
