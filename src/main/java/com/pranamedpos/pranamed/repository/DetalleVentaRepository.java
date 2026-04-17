package com.pranamedpos.pranamed.repository;

import com.pranamedpos.pranamed.model.DetalleVentaModel;
import com.pranamedpos.pranamed.model.LoteModel;
import com.pranamedpos.pranamed.model.VentaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface DetalleVentaRepository extends JpaRepository<DetalleVentaModel, Long> {

    // Ítems de una venta específica
    List<DetalleVentaModel> findByVenta(VentaModel venta);

    // Qué ventas han consumido un lote específico
    List<DetalleVentaModel> findByLote(LoteModel lote);

    // Utilidad real: (precio venta - precio compra del lote) * cantidad
    // Se cruza DetalleVenta con DetalleCompra a través del Lote
    @Query("SELECT COALESCE(SUM((dv.precioUnitario - dc.precioUnitario) * dv.cantidad), 0) " +
            "FROM DetalleVentaModel dv " +
            "JOIN dv.lote l " +
            "JOIN l.detalleCompra dc")
    BigDecimal calcularUtilidadTotal();
}
