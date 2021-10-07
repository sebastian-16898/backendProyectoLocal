package com.proyecto.local.repositorio;

import com.proyecto.local.modelo.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface Rusuario extends JpaRepository<Usuario, Integer> {

    @Query(value = "SELECT * FROM usuario WHERE id_usuario = ?1", nativeQuery = true)
    Usuario findByUsuario(int id_usuario);
    
    @Query(value = "SELECT * FROM usuario WHERE useri = ?1", nativeQuery = true)
    Usuario findByUser(String user);
}
