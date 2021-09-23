package com.proyecto.local.rest;

import com.proyecto.local.modelo.Ventas;
import com.proyecto.local.service.VentasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path = "/")
public class VetnasRest {

    @Autowired
    private VentasService r;

    //////* Listar Ventas *//////
    @GetMapping(path = "/listVe", produces = "application/json")
    public List<Ventas> listarVentas() {
        return r.list();
    }

    //Agregar Categoria
    @PostMapping(path = {"/addVen"}, consumes = "application/json", produces = "application/json")
    public void registrarVentas(@Validated @RequestBody List<Ventas> c) {
         r.agregar(c);
    }

}
