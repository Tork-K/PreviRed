/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PreviRed.Controller;

import com.PreviRed.DAO.InUsuario;
import com.PreviRed.DTO.Usuario;
import com.PreviRed.Entities.UsuarioEntities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author estar
 */
@RestController
@RequestMapping("/")
public class loginController {
    
    @Autowired
    private InUsuario user;
       
    @PostMapping
    public ResponseEntity<Void> inicioSesion(@RequestBody UsuarioEntities userData){
        UsuarioEntities us =user.findByNombreAndContraseña(userData.getNombre(), userData.getContraseña());
        if (us != null){
            if (us.getContraseña()==(userData.getContraseña())){
                return new ResponseEntity<>(HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
