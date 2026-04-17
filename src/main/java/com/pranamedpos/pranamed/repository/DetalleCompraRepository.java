package com.pranamedpos.pranamed.repository;

import com.pranamedpos.pranamed.model.CompraModel;
import com.pranamedpos.pranamed.model.DetalleCompraModel;
import com.pranamedpos.pranamed.model.MedicamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetalleCompraRepository extends JpaRepository<DetalleCompraModel, Long> {

    // Todos los ítems de una compra específica
    List<DetalleCompraModel> findByCompra(CompraModel compra);

    // En qué compras ha aparecido un medicamento
    List<DetalleCompraModel> findByMedicamento(MedicamentoModel medicamento);
}
