package com.proyecto.local.rest;

import com.proyecto.local.modelo.Categoria;
import com.proyecto.local.service.CategoriaService;
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
public class CategoriasRest {

    @Autowired
    private CategoriaService r;

    //////* Listar Categoria *//////
    @GetMapping(path = "/listCate", produces = "application/json")
    public List<Categoria> listarCategoria() {
        return r.list();
    }

    //Agregar Categoria
    @PostMapping(path = {"/addCate"}, consumes = "application/json", produces = "application/json")
    public Categoria registrarCategoria(@Validated @RequestBody Categoria c) {
        return r.agregar(c);
    }

    ////*Buscar Categoria por Descipcion*//////
    @GetMapping(path = {"/findCate/{descripcion}"})
    public Categoria buscarPorId(@PathVariable("descripcion") String d) {
        return r.buscarC(d);
    }

    //////* Editar Categoria *//////
    @PutMapping(path = {"/editCate/{id_categoria}"})
    //@PathVariable para enviar la variable
    public Categoria editarC(@PathVariable int id_categoria, @RequestBody Categoria per) {
        per.setId_categoria(id_categoria);
        return r.agregar(per);
    }

    //Eliminar Categoria
    @DeleteMapping(path = {"/deleteCate/{descipcion}"})
    public Categoria delCategoria(@PathVariable("descipcion") String descipcion) {
        return r.eliminar(descipcion);
    }
}
