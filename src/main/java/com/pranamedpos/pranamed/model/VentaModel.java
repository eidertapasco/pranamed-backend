package com.pranamedpos.pranamed.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ventas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder // Patrón de diseño mas limpio
public class VentaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenta;

    @Column(nullable = false, unique = true)
    private String numeroTicket; //es la factura del cliente

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false)
    private BigDecimal total;

    private String direccionEnvio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    private ClienteModel cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioModel usuario;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof VentaModel that)) return false;

        return numeroTicket != null && numeroTicket.equals(that.getNumeroTicket());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
