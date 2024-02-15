package com.back.pruebaback.security.service;

import com.back.pruebaback.security.entity.Rol;
import com.back.pruebaback.security.enums.RolNombre;
import com.back.pruebaback.security.repository.RolRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RolService {
    
    @Autowired
    RolRepository rolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
        return rolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol) {
        rolRepository.save(rol);
    }
}
