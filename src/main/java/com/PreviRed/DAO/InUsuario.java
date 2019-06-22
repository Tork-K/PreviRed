/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PreviRed.DAO;

import com.PreviRed.Entities.UsuarioEntities;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author estar
 */

// Interfas que permite persistir sobre la BD para Usuarios tabla/entidad
@Repository("usuarioRepository")
public interface InUsuario extends JpaRepository<UsuarioEntities, Serializable>{
    
    public abstract UsuarioEntities findByNombreAndContraseña(String nombre,Integer contraseña);
    
}
