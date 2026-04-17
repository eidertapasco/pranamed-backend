package com.pranamedpos.pranamed.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "proveedores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder // Patrón de diseño mas limpio
public class ProveedorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProveedor;

    private String nombreEmpresa;

    @Column(nullable = false)
    private String personaContacto;

    @Column(nullable = false, unique = true)
    private String telefonoContacto;

    private String emailContacto;

    private String direccionContacto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if(!(o instanceof ProveedorModel that)) return false;

        return telefonoContacto != null && telefonoContacto.equals(that.getTelefonoContacto());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
