package com.proyecto.local.service;

import com.proyecto.local.modelo.Productos;
import com.proyecto.local.repositorio.Rproductos;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductosService {

    static Date fecha = new Date();
    SimpleDateFormat objSDF = new SimpleDateFormat("dd-MM-yyyy");
    @Autowired
    private Rproductos ru;

    public List<Productos> list() {
        try {
            return ru.findAll();
        } catch (Exception e) {
        }
        return ru.findAll();
    }
    Date objDate = new Date();

    public Productos agregar(Productos u) {
        try {
            Productos pro = new Productos();
            pro.setCantidad_anterior(u.getCantidad_total());
            pro.setCantidad_nueva(u.getCantidad_nueva());
            pro.setCantidad_vendida(u.getCantidad_vendida());
            pro.setCantidad_total(pro.getCantidad_nueva() + pro.getCantidad_anterior() - pro.getCantidad_vendida());
            pro.setDescripcion(u.getDescripcion().toUpperCase());
            pro.setId_categoria(u.getId_categoria());
            pro.setId_codigo(u.getId_codigo());
            pro.setId_producto(u.getId_producto());
            pro.setPrecioventa(u.getPrecioventa());
            pro.setFecha(objDate);
            return ru.save(pro);
        } catch (Exception e) {
        }
        return ru.save(u);
    }

    public Productos buscarPro(int id) {
        return ru.findByproductos(id);
    }

    public Productos buscarid_producto(int id_producto) {
        return ru.findByid_producto(id_producto);
    }

    public Productos eliminar(int id) {
        Productos usuario = ru.findByproductos(id);

        if (usuario != null) {
            ru.delete(usuario);
        }
        return usuario;
    }
}
