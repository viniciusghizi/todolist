package com.ghizi.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ghizi.todolist.domain.dto.payload.UsuarioDTO;
import com.ghizi.todolist.domain.dto.response.UsuarioResponseDTO;
import com.ghizi.todolist.repository.UsuarioRepository;
import com.ghizi.todolist.service.UsuarioService;

import jakarta.validation.Valid;

@RestController

public class UsuarioController {
    @Autowired
    UsuarioRepository repository;
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/")
    public UsuarioResponseDTO save(@Valid @RequestBody UsuarioDTO usuario) {
        return usuarioService.save(usuario);
    }

    @GetMapping("/list")
    public List<UsuarioResponseDTO> findAll() {
        return usuarioService.findAll();
    }
    
}
