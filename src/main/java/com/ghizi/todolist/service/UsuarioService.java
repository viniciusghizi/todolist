package com.ghizi.todolist.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ghizi.todolist.domain.dto.payload.UsuarioDTO;
import com.ghizi.todolist.domain.dto.response.UsuarioResponseDTO;
import com.ghizi.todolist.domain.model.user.Usuario;
import com.ghizi.todolist.repository.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsuarioService {
    @Autowired
    UsuarioRepository repository;
    
    public UsuarioResponseDTO save(UsuarioDTO newUser) {
        Usuario usuario = repository.save(new Usuario(newUser));
        UsuarioResponseDTO usuarioResponse = new UsuarioResponseDTO(usuario.getUsername(), usuario.getName());
        log.info("Created a new user []", usuarioResponse);
        return usuarioResponse;
    }

    public List<UsuarioResponseDTO> findAll() {
        List<Usuario> usuarios = repository.findAll();
        List<UsuarioResponseDTO> usuariosResponse = new ArrayList<>();

        log.info("Localizado [] usuários na base de dados", usuarios.size());
        
        for (int i = 0; i < usuarios.size(); i++) {
            usuariosResponse.add(new UsuarioResponseDTO(usuarios.get(i).getUsername(), usuarios.get(i).getName()));
        }

        return usuariosResponse;
    }
}
