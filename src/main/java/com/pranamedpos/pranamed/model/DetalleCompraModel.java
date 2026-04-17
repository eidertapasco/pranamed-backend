package com.pranamedpos.pranamed.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_compras_proveedores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder // Patrón de diseño mas limpio
public class DetalleCompraModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleCompra;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private BigDecimal precioUnitario;

    @Column(nullable = false)
    private BigDecimal subtotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_compra", nullable = false)
    private CompraModel compra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medicamento", nullable = false)
    private MedicamentoModel medicamento;
    
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (!(o instanceof DetalleCompraModel that)) return false;

        return idDetalleCompra != null && idDetalleCompra.equals(that.getIdDetalleCompra());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
