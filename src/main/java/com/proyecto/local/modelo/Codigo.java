package com.proyecto.local.modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Codigos")
public class Codigo  {

    @Id
    @Column(name = "id_codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_codigo;

    @Column(name = "codigoproducto", unique = true)
    private String codigoproducto;

    public int getId_codigo() {
        return id_codigo;
    }

    public void setId_codigo(int id_codigo) {
        this.id_codigo = id_codigo;
    }

  

    public String getCodigoproducto() {
        return codigoproducto;
    }

    public void setCodigoproducto(String codigoproducto) {
        this.codigoproducto = codigoproducto;
    }

  

}
