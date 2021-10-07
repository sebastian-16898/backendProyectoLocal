package com.proyecto.local.rest;

import com.proyecto.local.modelo.Usuario;
import com.proyecto.local.service.Usuarioservice;
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
public class UsuarioRest {

    @Autowired
    private Usuarioservice r;

    //////* Listar Usuario *//////
    @GetMapping(path = "/listU", produces = "application/json")
    public List<Usuario> listarUsuario() {
        return r.list();
    }

    //Agregar Usuarios
    @PostMapping(path = {"/addU"}, consumes = "application/json", produces = "application/json")
    public Usuario registrarUsuario(@Validated @RequestBody Usuario c) {
        return r.agregar(c);
    }

    ////*Buscar Usuario por ID*//////
    @GetMapping(path = {"/findU/{id}"})
    public Usuario buscarPorId(@PathVariable("id") int id) {
        return r.buscarC(id);
    }

    ////*Buscar Usuario por CEDULA*//////
    @GetMapping(path = {"/findUs/{user}"})
    public Usuario buscarPorUser(@PathVariable("user") String user) {
        return r.buscarCUser(user);
    }

    //////* Editar USUARIO *//////
    @PutMapping(path = {"/editU/{cedula}"})
    //@PathVariable para enviar la variable
    public Usuario editarU(@PathVariable String cedula, @RequestBody Usuario per) {
        per.setCedula(cedula);
        return r.agregar(per);
    }

    @DeleteMapping(path = {"/delete/{id_usuario}"})
    public Usuario delUsuario(@PathVariable("id_usuario") int id_usuario) {
        return r.eliminar(id_usuario);
    }

}
