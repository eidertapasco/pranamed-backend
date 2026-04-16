package com.pranamedpos.pranamed.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "proveedores")
public class ProveedorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProveedor;

    private String nombreEmpresa;

    @Column(nullable = false)
    private String personaContacto;

    @Column(nullable = false)
    private String telefonoContacto;

    private String emailContacto;

    private String direccionContacto;
}
