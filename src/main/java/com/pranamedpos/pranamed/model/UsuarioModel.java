package com.pranamedpos.pranamed.model;

import com.pranamedpos.pranamed.enums.RolUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(unique = true, nullable = false)
    private String documento;

    @Column(nullable = false)
    private String nombre;

    private String apellido;

    @Column(nullable = false)
    private String password; //hasheada

    @Column(nullable = false)
    private RolUsuario rolUsuario;

    @Column(nullable = false)
    private boolean activo;
}
