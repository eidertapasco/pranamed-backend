package com.pranamedpos.pranamed.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "compras_proveedores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder // Patrón de diseño mas limpio
public class CompraModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompra;

    @Column(nullable = false, unique = true)
    private String numeroFactura;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false)
    private BigDecimal total;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proveedor", nullable = false)
    private ProveedorModel proveedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioModel usuario;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (! (o instanceof CompraModel that)) return false;

        return numeroFactura != null && numeroFactura.equals(that.getNumeroFactura());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
