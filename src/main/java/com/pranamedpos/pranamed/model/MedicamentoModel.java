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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMedicamento tipo;

    @Column(nullable = true)
    private String presentacion;

    @Column(name = "imagen_url")
    private String imagenUrl;

    @Column(nullable = false)
    private int stockMinimo;

    // Este es el Precio de Venta (Público)
    @Column(nullable = false)
    private BigDecimal precioVenta;

}
