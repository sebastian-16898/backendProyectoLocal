package com.proyecto.local.service;

import com.proyecto.local.modelo.Productos;
import com.proyecto.local.modelo.Ventas;
import com.proyecto.local.repositorio.RVentas;
import com.proyecto.local.repositorio.Rproductos;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentasService {

    @Autowired
    private RVentas rv;

    @Autowired
    private Rproductos rp;

    @Autowired
    private ProductosService sp;

    public List<Ventas> list() {
        return rv.findAll();
    }

    Date objDate = new Date();

    public int getMax(List<Ventas> l) {
        int max = 0;

        l = list();

        if (l.isEmpty()) {
            return max;
        } else {
            for (int i = 0; i < l.size(); i++) {
                if (l.get(i).getNum_fac() > max) {
                    max = l.get(i).getNum_fac();
                }
            }
            return max;
        }

    }

    public void agregar(List<Ventas> u) {

        Productos pro;
        int num = getMax(list()) + 1;
        for (int i = 0; i < u.size(); i++) {
            Ventas v = new Ventas();
            v.setNum_fac(num);
            v.setCantidad(u.get(i).getCantidad());
            v.setFecha(objDate);
            System.out.println(u.get(i).getId_producto());
            v.setId_producto(u.get(i).getId_producto());
            v.setVtotal(u.get(i).getVtotal());
            v.setVuni(u.get(i).getVuni());
            v.setCedula(u.get(i).getCedula());
            rv.save(v);

            pro = rp.findByid_producto(u.get(i).getId_producto().getId_producto());
            Productos produc = new Productos();
            produc.setCantidad_vendida(u.get(i).getCantidad());
            produc.setCantidad_anterior(pro.getCantidad_anterior());
            produc.setCantidad_nueva(0);
            produc.setCantidad_total(pro.getCantidad_total());
            produc.setDescripcion(pro.getDescripcion());
            produc.setFecha(objDate);
            produc.setId_categoria(pro.getId_categoria());
            produc.setId_codigo(pro.getId_codigo());
            produc.setId_producto(pro.getId_producto());
            produc.setPrecioventa(pro.getPrecioventa());

            sp.agregar(produc);

        }

    }

}
