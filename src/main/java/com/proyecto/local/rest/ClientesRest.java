package com.proyecto.local.rest;

import com.proyecto.local.modelo.Clientes;
import com.proyecto.local.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class ClientesRest {

    @Autowired
    private ClienteService sc;

    //////* Listar Usuario *//////
    @GetMapping(path = "/listClientes", produces = "application/json")
    public List<Clientes> listarUsuario() {
        return sc.list();
    }

    //Agregar Usuarios
    @PostMapping(path = {"/addCliente"}, consumes = "application/json", produces = "application/json")
    public Clientes registrarUsuario(@Validated @RequestBody Clientes c) {
        return sc.createCliente(c);
    }

    ////*Buscar Usuario por ID*//////
    @GetMapping(path = {"/findCLiente/{cedula}"})
    public Clientes buscarPorId(@PathVariable("cedula") String cedula) {
        return sc.getCliente(cedula);
    }

    //////* Editar USUARIO *//////
    @PutMapping(path = {"/editCliente/{cedula}"})
    //@PathVariable para enviar la variable
    public Clientes editarU(@PathVariable String cedula, @RequestBody Clientes per) {
        per.setCedula(cedula);
        return sc.createCliente(per);
    }

}
