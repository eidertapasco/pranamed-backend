package com.pranamedpos.pranamed.repository;

import com.pranamedpos.pranamed.enums.TipoMedicamento;
import com.pranamedpos.pranamed.model.MedicamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicamentoRepository extends JpaRepository<MedicamentoModel, Long> {

    // SKU es único — útil al registrar un medicamento nuevo
    Optional<MedicamentoModel> findBySku(String sku);

    boolean existsBySku(String sku);

    // Buscador del catálogo por nombre parcial
    List<MedicamentoModel> findByNombreContainingIgnoreCase(String nombre);

    // Filtrar por tipo (jarabe, cápsulas, cremas...)
    List<MedicamentoModel> findByTipo(TipoMedicamento tipo);
}
