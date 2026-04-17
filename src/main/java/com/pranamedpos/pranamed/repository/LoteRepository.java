package com.pranamedpos.pranamed.repository;

import com.pranamedpos.pranamed.model.LoteModel;
import com.pranamedpos.pranamed.model.MedicamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface LoteRepository extends JpaRepository<LoteModel, Long> {

    // Todos los lotes de un medicamento específico
    List<LoteModel> findByMedicamento(MedicamentoModel medicamento);

    // Lotes que vencen antes de una fecha — para alertas de vencimiento
    List<LoteModel> findByFechaVencimientoBefore(LocalDate fecha);

    // Lotes con stock disponible — para saber qué se puede vender
    List<LoteModel> findByStockActualGreaterThan(int minimo);

    // Stock total de un medicamento sumando todos sus lotes
    @Query("SELECT COALESCE(SUM(l.stockActual), 0) FROM LoteModel l WHERE l.medicamento.idMedicamento = :idMedicamento")
    int sumStockByMedicamento(@Param("idMedicamento") Long idMedicamento);

    // Lotes de un medicamento que aún tienen stock y no han vencido
    @Query("SELECT l FROM LoteModel l WHERE l.medicamento.idMedicamento = :idMedicamento " +
            "AND l.stockActual > 0 AND l.fechaVencimiento > :hoy ORDER BY l.fechaVencimiento ASC")
    List<LoteModel> findLotesDisponibles(@Param("idMedicamento") Long idMedicamento,
                                         @Param("hoy") LocalDate hoy);
}
