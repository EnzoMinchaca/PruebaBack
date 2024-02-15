package com.back.pruebaback.controller;

import com.back.pruebaback.security.entity.Usuario;
import com.back.pruebaback.security.service.UsuarioService;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Controller {
    
    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping("/User")
    public Optional<Usuario> inicio(@AuthenticationPrincipal UserDetails user) {
        log.info("Usuario que hizo login: " + user.getUsername());
        String nameUser = user.getUsername();
        Optional<Usuario> usuario = usuarioService.getByNombreUsuario(nameUser);
        return usuario;
    }
}
