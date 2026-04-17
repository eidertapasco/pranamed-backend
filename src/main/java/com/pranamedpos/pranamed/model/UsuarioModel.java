package com.pranamedpos.pranamed.model;

import com.pranamedpos.pranamed.enums.RolUsuario;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder // Patrón de diseño mas limpio
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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RolUsuario rolUsuario;

    @Column(nullable = false)
    @Builder.Default // esto me asegura que tome el valor por defecto
    private boolean activo = true;

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (!(o instanceof UsuarioModel that))return false;

        return documento != null && documento.equals(that.getDocumento());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
