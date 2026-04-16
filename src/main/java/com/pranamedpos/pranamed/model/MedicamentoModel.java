package com.pranamedpos.pranamed.model;

import com.pranamedpos.pranamed.enums.TipoMedicamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medicamentos")
public class MedicamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedicamento;

    @Column(unique = true, nullable = false)
    private String sku;

    private String marca;

    @Column(nullable = false)
    private String nombre;

    private String descripcion;

    // Para poder filtrar reportes (Ej: Ver solo "SUPLEMENTOS" o "HOMEOPATICOS")
    private String categoria; //enums

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMedicamento tipo;

    @Column(nullable = true)
    private String medida;

    @Column(nullable = false)
    private LocalDate fechaVencimiento;

    @Column(name = "imagen_url")
    private String imagenUrl;

    // Este es el Precio de Compra (Costo para la tienda)
    @Column(nullable = false)
    private BigDecimal precioCompra;

    // Este es el Precio de Venta (Público)
    @Column(nullable = false)
    private BigDecimal precioVenta;

    // stock_actual: unidades disponibles actualmente
    @Column(nullable = false)
    private int stockActual;

    // stock_minimo: umbral mínimo antes de necesitar reabastecer
    @Column(nullable = false)
    private int stockMinimo;
}
