package com.proyecto.local.rest;

import com.proyecto.local.modelo.Productos;
import com.proyecto.local.service.ProductosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path = "/")
public class ProductosRest {

    @Autowired
    private ProductosService r;

    //////* Listar productos *//////
    @GetMapping(path = "/listPro", produces = "application/json")
    public List<Productos> listarUsuario() {
        return r.list();
    }

    //Agregar productos
    @PostMapping(path = {"/addProucto"}, consumes = "application/json", produces = "application/json")
    public Productos registrarUsuario(@Validated @RequestBody Productos c) {
        return r.agregar(c);
    }

    ////*Buscar Usuario por ID*//////
    @GetMapping(path = {"/findPro/{id}"})
    public Productos buscarPorId(@PathVariable("id") int id) {
        return r.buscarPro(id);
    }
    
    ////*Buscar Usuario por Codigopro//////
    @GetMapping(path = {"/findid_codigo/{id_producto}"})
    public Productos buscarPorCodigo(@PathVariable("id_producto") int id_producto) {
        return r.buscarid_producto(id_producto);
    }

    //////* Editar Productos *//////
    @PutMapping(path = {"/editPro/{id}"})
    //@PathVariable para enviar la variable
    public Productos editarU(@PathVariable int id, @RequestBody Productos per) {
        per.setId_producto(id);
        per.setCantidad_vendida(0);
        return r.agregar(per);
    }

    @DeleteMapping(path = {"/deletePro/{id_productos}"})
    public Productos delUsuario(@PathVariable("id_productos") int id_productos) {
        return r.eliminar(id_productos);
    }

}
