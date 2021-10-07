package com.proyecto.local.service;

import com.proyecto.local.modelo.Clientes;
import com.proyecto.local.repositorio.RClientes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ClienteService {

    @Autowired
    private RClientes cli;

    public List<Clientes> list() {
        return cli.findAll();
    }

    public Clientes getCliente(String cedula) {
        return cli.FindByCliente(cedula);
    }

    public Clientes createCliente(Clientes cliente) {
        Clientes c = new Clientes();
        c.setApellido1(cliente.getApellido1().toUpperCase());
        c.setApellido2(cliente.getApellido2().toUpperCase());
        c.setCedula(cliente.getCedula());
        c.setCorreo(cliente.getCorreo());
        c.setDireccion(cliente.getDireccion().toUpperCase());
        c.setNombre1(cliente.getNombre1().toUpperCase());
        c.setNombre2(cliente.getNombre2().toUpperCase());
        return cli.save(c);
    }

}
