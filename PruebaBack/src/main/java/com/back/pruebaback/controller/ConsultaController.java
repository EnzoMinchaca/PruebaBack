package com.back.pruebaback.controller;

import com.back.pruebaback.entity.Consulta;
import com.back.pruebaback.security.entity.Usuario;
import com.back.pruebaback.security.service.UsuarioService;
import com.back.pruebaback.service.ConsultaService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consulta")
@CrossOrigin(origins = "*")
public class ConsultaController {
    
    @Autowired
    private ConsultaService consultaService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("")
    public List<Consulta> getConsultas(@AuthenticationPrincipal UserDetails user) {
        
        String nameUser = user.getUsername();
        Optional<Usuario> usuario = usuarioService.getByNombreUsuario(nameUser);
        
        var consultas = consultaService.getAllConsultas();
        int idUser = usuario.get().getIdUsuario();
        List<Consulta> consultaId = new ArrayList<>();;
        
        for(Consulta con : consultas) {
            if (con.getIdUsuario() == idUser) {
                consultaId.add(con);
            }
        }
        return consultaId;
    }
    
}
