package com.proyecto.local.service;

import com.proyecto.local.modelo.Usuario;
import com.proyecto.local.repositorio.Rusuario;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Usuarioservice {

    GregorianCalendar gc = new GregorianCalendar();
    @Autowired
    private Rusuario ru;

    public List<Usuario> list() {
        return ru.findAll();
    }

    public Usuario agregar(Usuario u) {
        try {
            Usuario usu = new Usuario();
            usu.setApellido(u.getApellido().toUpperCase());
            usu.setCedula(u.getCedula());
            usu.setClave(u.getClave());
            usu.setCorreo(u.getCorreo());
            usu.setId_usuario(u.getId_usuario());
            usu.setNombre(u.getNombre().toUpperCase());
            usu.setUseri(u.getUseri());
            usu.setPerfil(u.getPerfil());
            if (u.getId_usuario() > 0) {
                usu.setFecha_update(gc);
            } else {
                usu.setFecha_create(gc);
            }
            return ru.save(usu);
        } catch (Exception e) {
            return null;
        }
    }

    public Usuario buscarC(int id) {
        return ru.findByUsuario(id);
    }

    public Usuario buscarCUser(String user) {
        return ru.findByUser(user);
    }

    public Usuario eliminar(int id) {
        Usuario usuario = ru.findByUsuario(id);

        if (usuario != null) {
            ru.delete(usuario);
        }
        return usuario;
    }
}
