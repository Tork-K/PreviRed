/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PreviRed.Controller;

import com.PreviRed.DAO.InUsuario;
import com.PreviRed.Entities.UsuarioEntities;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author estar
 */
// Servicio propocionados por la API 
@RestController
@RequestMapping("/")
public class UsuarioController {
    
    @Autowired
    private InUsuario user;
    
    // Servicio que permite actualizar solo el nombre del usuario
    @PutMapping("/update")
    public ResponseEntity<UsuarioEntities> actualizarUsuario(@RequestBody UsuarioEntities userData){
        
        UsuarioEntities us=user.getOne(userData.getId());
        
        if (user.existsById(userData.getId())){
            userData.setNombre(userData.getNombre());
            user.save(userData);
            
            return new ResponseEntity<>(us,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(us,HttpStatus.NOT_FOUND);
        }
    }
    
    // Servicio que permite la crecion de un nuevo Usuario
    @PostMapping("/create")
    public ResponseEntity<Void> crearUsuario(@RequestBody UsuarioEntities userData){
        try {
            user.save(userData);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Servicio que me permite extraer todos los registros 
    @GetMapping("/allUsers")
    public ResponseEntity<List<UsuarioEntities>> todosLosUsuarios(){
        return new ResponseEntity<>(user.findAll(),HttpStatus.OK);
    }
}
