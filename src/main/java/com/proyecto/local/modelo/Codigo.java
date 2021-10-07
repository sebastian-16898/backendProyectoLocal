package com.proyecto.local.modelo;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Codigos")
public class Codigo {

    @Id
    @Column(name = "id_codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_codigo;

    @Column(name = "codigoproducto", unique = true)
    private String codigoproducto;
    @Column(name = "fecha_create", updatable = false, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fecha_create;

    @Column(name = "fecha_update", updatable = true, nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fecha_update;

    public Calendar getFecha_create() {
        return fecha_create;
    }

    public void setFecha_create(Calendar fecha_create) {
        this.fecha_create = fecha_create;
    }

    public Calendar getFecha_update() {
        return fecha_update;
    }

    public void setFecha_update(Calendar fecha_update) {
        this.fecha_update = fecha_update;
    }

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
