package com.proyecto.local.repositorio;

import com.proyecto.local.modelo.Codigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Rcodigos extends JpaRepository<Codigo, Integer> {

    @Query(value = "SELECT * FROM codigos WHERE codigoproducto =?1 ", nativeQuery = true)
    Codigo findByDescrip(String codigoproducto);
}
