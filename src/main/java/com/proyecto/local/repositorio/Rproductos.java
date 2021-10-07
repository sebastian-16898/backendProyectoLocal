package com.proyecto.local.repositorio;

import com.proyecto.local.modelo.Productos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Rproductos extends JpaRepository<Productos, Integer> {

    @Query(value = "SELECT * FROM productos WHERE id_producto = ?1", nativeQuery = true)
    Productos findByproductos(int id);

    @Query(value = "SELECT * FROM productos WHERE id_producto = ?1", nativeQuery = true)
    Productos findByid_producto(int id_producto);

    @Query(value = "SELECT * FROM productos WHERE id_codigo = ?1", nativeQuery = true)
    List<Productos> codigos(int id_codigo);

    @Query(value = "SELECT * FROM productos WHERE id_categoria = ?1", nativeQuery = true)
    List<Productos> categoria(int id_ccategoria);

}
