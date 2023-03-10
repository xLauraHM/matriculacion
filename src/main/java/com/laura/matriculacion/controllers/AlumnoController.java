package com.laura.matriculacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laura.matriculacion.models.Alumno;
import com.laura.matriculacion.services.AlumnoService;

@RestController
public class AlumnoController {

    @Autowired
    AlumnoService alumnoService;

    @GetMapping("/alumnos")
    List<Alumno> all(){
        return alumnoService.findAll();
    }
    
    @GetMapping("/alumnos/{id}")
    Alumno findContacto(@PathVariable int id){
        return alumnoService.findById(id);
    }

    @DeleteMapping("/alumnos/{id}")
    void deleteContacto(@PathVariable int id){
        alumnoService.deleteById(id);
    }

    @PostMapping("/alumnos")
    Alumno crearContacto(@RequestBody Alumno alumno){
        alumnoService.save(alumno);
        return alumno;
    }

    @PutMapping("/alumnos/{id}")
    void modificarContacto(@PathVariable int id, @RequestBody Alumno alumno){
        alumnoService.update(id, alumno);
    }
}
