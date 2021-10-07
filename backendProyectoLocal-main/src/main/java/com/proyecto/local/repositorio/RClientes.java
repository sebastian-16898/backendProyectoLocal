package com.proyecto.local.repositorio;

import com.proyecto.local.modelo.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RClientes extends JpaRepository<Clientes, String> {

    @Query(value = "SELECT * FROM `clientes` WHERE `cedula`=?1", nativeQuery = true)
    Clientes FindByCliente(String cedula);
}
