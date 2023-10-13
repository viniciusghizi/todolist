package com.ghizi.todolist.domain.model.user;


import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.ghizi.todolist.domain.dto.payload.UsuarioDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="users")
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @Getter
    @Setter
    @GeneratedValue(generator = "uuid")
    private UUID id;
    
    @Getter
    @Setter
    @Column(unique = true)
    private String username;

    @Getter
    @Setter
    private String name;
    
    @Getter
    @Setter
    @CreationTimestamp
    private LocalDateTime createdAt;

    private String password;

    public String getPassword() {
        return com.ghizi.todolist.utils.CriptoValidator.encrypt(this.password);
    }

    public void setPassword(String password) {
        this.password = com.ghizi.todolist.utils.CriptoValidator.encrypt(password);
    }

    public Usuario (UsuarioDTO data) {
        this.username = data.username();
        this.name = data.name();
        this.setPassword(data.password());
    }
    

}
