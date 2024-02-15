package com.back.pruebaback.controller;

import com.back.pruebaback.domain.AirPollution;
import com.back.pruebaback.domain.Weather5Days;
import com.back.pruebaback.domain.WeatherData;
import com.back.pruebaback.dto.Mensaje;
import com.back.pruebaback.entity.Consulta;
import com.back.pruebaback.security.entity.Usuario;
import com.back.pruebaback.security.service.UsuarioService;
import com.back.pruebaback.service.ClimaService;
import com.back.pruebaback.service.ConsultaService;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "*")
public class WeatherController {
    
    @Autowired
    private ConsultaService consultaService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private ClimaService climaService;
    
    
    //PARA USUARIOS
    
    @GetMapping("/weather/{city}")
    public ResponseEntity<?> getWeather(@PathVariable("city") String city, @AuthenticationPrincipal UserDetails user) {
        
        WeatherData wd = climaService.getWeatherByCityName(city);
        String nameUser = user.getUsername();
        Optional<Usuario> usuario = usuarioService.getByNombreUsuario(nameUser);
        
        Consulta consulta = new Consulta();
        consulta.setCity(city);
        consulta.setTipoConsulta("Actual");
        consulta.setFecha(LocalDateTime.now());
        consulta.setRespuesta(wd.toString());
        consulta.setIdUsuario(usuario.get().getIdUsuario());
        consultaService.saveConsulta(consulta);
        
        return new ResponseEntity<>(wd, HttpStatus.OK);
    }
    
    @GetMapping("/weather/forecast/{city}")
    public ResponseEntity<?> getForecast(@PathVariable("city") String city, @AuthenticationPrincipal UserDetails user) {
        
        Weather5Days w5 = climaService.getForecastByCityName(city);
        String nameUser = user.getUsername();
        Optional<Usuario> usuario = usuarioService.getByNombreUsuario(nameUser);
        
        Consulta consulta = new Consulta();
        consulta.setCity(city);
        consulta.setTipoConsulta("Pronostico5dias");
        consulta.setFecha(LocalDateTime.now());
        consulta.setRespuesta(w5.toString());
        consulta.setIdUsuario(usuario.get().getIdUsuario());
        consultaService.saveConsulta(consulta);
        
        return new ResponseEntity<>(w5, HttpStatus.OK);
    }
    
    @GetMapping("/weather/air-pollution/{city}")
    public ResponseEntity<?> getAirPollution(@PathVariable("city") String city, @AuthenticationPrincipal UserDetails user) {

        AirPollution air = climaService.getAirPollutionByCityName(city);
        String nameUser = user.getUsername();
        Optional<Usuario> usuario = usuarioService.getByNombreUsuario(nameUser);

        Consulta consulta = new Consulta();
        consulta.setCity(city);
        consulta.setTipoConsulta("ContaminacionAire");
        consulta.setFecha(LocalDateTime.now());
        consulta.setRespuesta(air.toString());
        consulta.setIdUsuario(usuario.get().getIdUsuario());
        consultaService.saveConsulta(consulta);
        
        return new ResponseEntity<>(air, HttpStatus.OK);
    }
    
    //PARA ADMINISTRADORES
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/{city}")
    public ResponseEntity<?> getWeatherAdmin(@PathVariable("city") String city, @AuthenticationPrincipal UserDetails user) {
        
        WeatherData wd = climaService.getWeatherByCityName(city);
        String nameUser = user.getUsername();
        Optional<Usuario> usuario = usuarioService.getByNombreUsuario(nameUser);
        
        Consulta consulta = new Consulta();
        consulta.setCity(city);
        consulta.setTipoConsulta("Actual");
        consulta.setFecha(LocalDateTime.now());
        consulta.setRespuesta(wd.toString());
        consulta.setIdUsuario(usuario.get().getIdUsuario());
        consultaService.saveConsulta(consulta);
        
        return new ResponseEntity<>(wd, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/forecast/{city}")
    public ResponseEntity<?> getForecastAdmin(@PathVariable("city") String city, @AuthenticationPrincipal UserDetails user) {
        
        Weather5Days w5 = climaService.getForecastByCityName(city);
        String nameUser = user.getUsername();
        Optional<Usuario> usuario = usuarioService.getByNombreUsuario(nameUser);
        
        Consulta consulta = new Consulta();
        consulta.setCity(city);
        consulta.setTipoConsulta("Pronostico5dias");
        consulta.setFecha(LocalDateTime.now());
        consulta.setRespuesta(w5.toString());
        consulta.setIdUsuario(usuario.get().getIdUsuario());
        consultaService.saveConsulta(consulta);
        
        return new ResponseEntity<>(w5, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/air-pollution/{city}")
    public ResponseEntity<?> getAirPollutionAdmin(@PathVariable("city") String city, @AuthenticationPrincipal UserDetails user) {

        AirPollution air = climaService.getAirPollutionByCityName(city);
        String nameUser = user.getUsername();
        Optional<Usuario> usuario = usuarioService.getByNombreUsuario(nameUser);

        Consulta consulta = new Consulta();
        consulta.setCity(city);
        consulta.setTipoConsulta("ContaminacionAire");
        consulta.setFecha(LocalDateTime.now());
        consulta.setRespuesta(air.toString());
        consulta.setIdUsuario(usuario.get().getIdUsuario());
        consultaService.saveConsulta(consulta);
        
        return new ResponseEntity<>(air, HttpStatus.OK);
    }
}
