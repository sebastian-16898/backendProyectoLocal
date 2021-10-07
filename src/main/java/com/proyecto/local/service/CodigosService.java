package com.proyecto.local.service;

import com.proyecto.local.modelo.Codigo;
import com.proyecto.local.modelo.Productos;
import com.proyecto.local.repositorio.Rcodigos;
import com.proyecto.local.repositorio.Rproductos;
import java.util.GregorianCalendar;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodigosService {

    @Autowired
    private Rcodigos ru;

    @Autowired
    private Rproductos pro;
    GregorianCalendar gc = new GregorianCalendar();

    public List<Codigo> list() {
        return ru.findAll();
    }

    public Codigo agregar(Codigo u) {
        Codigo c = new Codigo();
        c.setId_codigo(u.getId_codigo());
        c.setCodigoproducto(u.getCodigoproducto().toUpperCase());
        if (u.getId_codigo() > 0) {
            c.setFecha_update(gc);
        } else {
            c.setFecha_create(gc);
        }
        return ru.save(c);
    }

    public Codigo buscarPro(String codigoproducto) {
        return ru.findByDescrip(codigoproducto);
    }

    public Codigo eliminar(String codigo) {
        Codigo usuario = ru.findByDescrip(codigo);
        try {

            if (usuario != null) {
                List<Productos> pr = pro.codigos(usuario.getId_codigo());
                for (int i = 0; i < pr.size(); i++) {
                    pro.delete(pr.get(i));
                }
                ru.delete(usuario);

            }
        } catch (Exception e) {
        }
        return usuario;

    }
}
