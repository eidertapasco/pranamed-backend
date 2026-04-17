package com.pranamedpos.pranamed.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder // Patrón de diseño mas limpio
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column(nullable = false)
    private String nombre;

    private String apellido;

    @Column(nullable = false, unique = true)
    private String documento;

    @Column(unique = true)
    private String telefono;

    @Column(unique = true)
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ClienteModel that)) return false;

        return documento != null && documento.equals(that.getDocumento());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
