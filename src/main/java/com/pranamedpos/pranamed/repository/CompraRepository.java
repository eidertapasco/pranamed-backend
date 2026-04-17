package com.pranamedpos.pranamed.repository;

import com.pranamedpos.pranamed.model.CompraModel;
import com.pranamedpos.pranamed.model.ProveedorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CompraRepository extends JpaRepository<CompraModel, Long> {

    // Buscar una compra específica por el documento físico del proveedor
    Optional<CompraModel> findByNumeroFactura(String numeroFactura);

    // Historial de compras a un proveedor específico
    List<CompraModel> findByProveedor(ProveedorModel proveedor);

    // Compras en un rango de fechas — para reportes
    List<CompraModel> findByFechaBetween(LocalDateTime inicio, LocalDateTime fin);

    // Total gastado en compras en un período
    @Query("SELECT COALESCE(SUM(c.total), 0) FROM CompraModel c " +
            "WHERE c.fecha BETWEEN :inicio AND :fin")
    BigDecimal sumTotalByPeriodo(@Param("inicio") LocalDateTime inicio,
                                 @Param("fin") LocalDateTime fin);
}