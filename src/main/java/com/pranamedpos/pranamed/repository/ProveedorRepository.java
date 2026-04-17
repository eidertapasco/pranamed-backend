package com.pranamedpos.pranamed.repository;

import com.pranamedpos.pranamed.model.ProveedorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProveedorRepository extends JpaRepository<ProveedorModel, Long> {

    // Buscar proveedores por nombre (búsqueda parcial, sin importar mayúsculas)
    List<ProveedorModel> findByPersonaContactoContainingIgnoreCase(String personaContacto);

    List<ProveedorModel> findByTelefonoContacto(String telefonoContacto);
}
