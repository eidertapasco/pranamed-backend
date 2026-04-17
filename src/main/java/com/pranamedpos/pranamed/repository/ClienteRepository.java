package com.pranamedpos.pranamed.repository;

import com.pranamedpos.pranamed.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

    // Buscar cliente por documento para login o validación
    Optional<ClienteModel> findByDocumento(String documento);

    // Verificar si ya existe un cliente con ese documento antes de crearlo
    boolean existsByDocumento(String documento);

    // Buscar por email (para notificaciones o recuperación)
    Optional<ClienteModel> findByEmail(String email);
}
