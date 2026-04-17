package com.pranamedpos.pranamed.repository;

import com.pranamedpos.pranamed.model.ClienteModel;
import com.pranamedpos.pranamed.model.VentaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface VentaRepository extends JpaRepository<VentaModel, Long> {

    // Buscar por el numero de factura de un cliente
    Optional<VentaModel> findByNumeroTicket(String numeroTicket);

    // Ventas (compras) de un cliente - nota: el campo en VentaModel se llama "cliente", no "idCliente"
    List<VentaModel> findByCliente(ClienteModel cliente);

    // Ventas en un rango de fechas — fecha es LocalDateTime, no LocalDate
    List<VentaModel> findByFechaBetween(LocalDateTime inicio, LocalDateTime fin);

    // Ingresos totales en un período
    @Query("SELECT COALESCE(SUM(v.total), 0) FROM VentaModel v " +
            "WHERE v.fecha BETWEEN :inicio AND :fin")
    BigDecimal sumTotalByPeriodo(@Param("inicio") LocalDateTime inicio,
                                 @Param("fin") LocalDateTime fin);

    // Ingresos totales históricos
    @Query("SELECT COALESCE(SUM(v.total), 0) FROM VentaModel v")
    BigDecimal sumarIngresosTotales();

    long countByFechaGreaterThanEqual(LocalDateTime fecha);
}
