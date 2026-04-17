package com.pranamedpos.pranamed.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "lote")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder // Patrón de diseño mas limpio
public class LoteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLote;

    @Column(nullable = false)
    private LocalDate fechaVencimiento;

    @Column(nullable = false)
    private int stockActual;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medicamento", nullable = false)
    private MedicamentoModel medicamento;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_detalle_compra", nullable = false)
    private DetalleCompraModel detalleCompra;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof LoteModel that)) return false;

        return idLote != null && idLote.equals(that.getIdLote());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
