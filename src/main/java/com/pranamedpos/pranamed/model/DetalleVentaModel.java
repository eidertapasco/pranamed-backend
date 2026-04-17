package com.pranamedpos.pranamed.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_ventas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder // Patrón de diseño mas limpio
public class DetalleVentaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleVenta;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private BigDecimal precioUnitario;

    @Column(nullable = false)
    private BigDecimal subtotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_venta", nullable = false)
    private VentaModel venta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_lote", nullable = false)
    private LoteModel lote;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof DetalleVentaModel that)) return false;

        return idDetalleVenta != null && idDetalleVenta.equals(that.getIdDetalleVenta());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
