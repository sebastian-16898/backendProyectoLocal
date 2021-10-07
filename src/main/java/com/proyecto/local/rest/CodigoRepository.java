package com.proyecto.local.rest;

import com.proyecto.local.modelo.Codigo;
import com.proyecto.local.service.CodigosService;
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
public class CodigoRepository {

    @Autowired
    private CodigosService r;

    //////* Listar Codigo *//////
    @GetMapping(path = "/listCodigo", produces = "application/json")
    public List<Codigo> listarCodigo() {
        return r.list();
    }

    //Agregar Codigo
    @PostMapping(path = {"/addCodigo"}, consumes = "application/json", produces = "application/json")
    public Codigo registrarCodigo(@Validated @RequestBody Codigo c) {
        return r.agregar(c);
    }

    ////*Buscar Codigo*//////
    @GetMapping(path = {"/findCodigo/{codigoproducto}"})
    public Codigo buscarPordescripcion(@PathVariable("codigoproducto") String codigoproducto) {
        return r.buscarPro(codigoproducto);
    }

    //////* Editar Codigo *//////
    @PutMapping(path = {"/editCodigo/{id_codigo}"})
    //@PathVariable para enviar la variable
    public Codigo editarC(@PathVariable int id_codigo, @RequestBody Codigo per) {
        per.setId_codigo(id_codigo);
        return r.agregar(per);
    }

    //////* Delete Codigo *//////
    @DeleteMapping(path = {"/deleteCodigo/{codigoproducto}"})
    public Codigo delCodigo(@PathVariable("codigoproducto") String codigoproducto) {
        return r.eliminar(codigoproducto);
    }
}
