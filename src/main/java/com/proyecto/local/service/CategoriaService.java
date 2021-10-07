package com.proyecto.local.service;

import com.proyecto.local.modelo.Categoria;
import com.proyecto.local.modelo.Productos;
import com.proyecto.local.repositorio.Rcategoria;
import com.proyecto.local.repositorio.Rproductos;
import java.util.GregorianCalendar;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    GregorianCalendar gc = new GregorianCalendar();
    @Autowired
    private Rcategoria ru;

    @Autowired
    private Rproductos pro;

    public List<Categoria> list() {
        return ru.findAll();
    }

    public Categoria agregar(Categoria u) {
        try {
            Categoria ca = new Categoria();
            ca.setDescripcion(u.getDescripcion().toUpperCase());
            ca.setId_categoria(u.getId_categoria());
            if (u.getId_categoria() > 0) {
                ca.setFecha_update(gc);
            } else {
                ca.setFecha_create(gc);
            }
            return ru.save(ca);
        } catch (Exception e) {
        }
        return ru.save(u);
    }

    public Categoria buscarC(String d) {
        return ru.findByDescipcion(d);
    }

    public Categoria eliminar(String d) {
        Categoria usuario = ru.findByDescipcion(d);

        if (usuario != null) {
            List<Productos> p = pro.categoria(usuario.getId_categoria());
            for (int i = 0; i < p.size(); i++) {
                pro.delete(p.get(i));
            }
            ru.delete(usuario);
        }
        return usuario;
    }
}
