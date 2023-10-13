package com.ghizi.todolist.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ghizi.todolist.domain.model.user.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,UUID>  {
    
}
