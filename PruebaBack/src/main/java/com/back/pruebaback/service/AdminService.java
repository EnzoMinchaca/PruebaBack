package com.back.pruebaback.service;

import com.back.pruebaback.security.entity.Rol;
import com.back.pruebaback.security.enums.RolNombre;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    
    private boolean isAdmin = false;
    
    public boolean isThisAdmin(Set<Rol> roles) {
        for(Rol rol : roles) {
            if (rol.getRolNombre() == RolNombre.ROLE_ADMIN) {
                isAdmin = true;
                break;
            }
        }
        return isAdmin;
    }
    
}
