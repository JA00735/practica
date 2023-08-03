package com.practica.usuarioservice.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practica.usuarioservice.usuario.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Integer> {

}
