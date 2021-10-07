package com.proyecto.local.repositorio;

import com.proyecto.local.modelo.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RVentas extends JpaRepository<Ventas, Integer> {

    @Query(value = "SELECT MAX(v.num_fac) FROM ventas v", nativeQuery = true)
    Ventas findByV();

}
