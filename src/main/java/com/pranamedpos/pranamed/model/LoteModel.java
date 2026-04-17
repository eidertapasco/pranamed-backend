package com.pranamedpos.pranamed.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lote")
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
    private MedicamentoModel idMedicamento;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medicamento", nullable = false)
    private DetalleCompraModel idDetalleCompra;
}
