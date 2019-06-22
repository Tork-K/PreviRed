/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PreviRed.DTO;

import com.PreviRed.Entities.UsuarioEntities;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author estar
 */
// DTO que permite acceder ala entidad Usuarios 
public class Usuario {
    
    private Integer contraseña;
    private String email;
    private String nombre;
    @Autowired
    private UsuarioEntities userEntities;

    public Usuario() {
    }

    public Usuario(Integer contraseña, String email, String nombre) {
        this.contraseña = userEntities.getContraseña();
        this.email = userEntities.getEmail();
        this.nombre = userEntities.getNombre();
    }

    public Integer getContraseña() {
        return contraseña;
    }

    public void setContraseña(Integer contraseña) {
        this.contraseña = contraseña;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
