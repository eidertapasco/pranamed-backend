package com.pranamedpos.pranamed.repository;

import com.pranamedpos.pranamed.enums.RolUsuario;
import com.pranamedpos.pranamed.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    // Login — buscas por documento que es el identificador único del usuario
    Optional<UsuarioModel> findByDocumento(String documento);

    // Solo usuarios activos (los desactivados no deben poder operar)
    List<UsuarioModel> findByActivoTrue();

    // Filtrar por rol (ver todos los administradores, por ejemplo)
    List<UsuarioModel> findByRolUsuario(RolUsuario rol);

    boolean existsByDocumento(String documento);
}
