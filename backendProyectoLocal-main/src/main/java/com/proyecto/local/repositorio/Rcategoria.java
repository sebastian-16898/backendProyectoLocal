package com.proyecto.local.repositorio;

import com.proyecto.local.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Rcategoria extends JpaRepository<Categoria, Integer> {

    @Query(value = "SELECT * FROM categoria WHERE descripcion = ?1", nativeQuery = true)
    Categoria findByDescipcion(String descripcion);

}
