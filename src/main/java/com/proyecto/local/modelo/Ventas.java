package com.proyecto.local.modelo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.OneToOne;

@Entity
@Table(name = "Ventas")
public class Ventas {

    @Id
    @Column(name = "id_fac")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_fac;

    @Column(name = "num_fac")
    private int num_fac;

    @OneToOne
    @JoinColumn(name = "id_producto")
    private Productos id_producto;
    
    @OneToOne
    @JoinColumn(name = "cedula")
    private Clientes cedula;
    
    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "uni")
    private double uni;

    @Column(name = "total")
    private double total;

    @Column(name = "fecha")
    private Date fecha;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getVuni() {
        return uni;
    }

    public void setVuni(double Vuni) {
        this.uni = Vuni;
    }

    public double getVtotal() {
        return total;
    }

    public void setVtotal(double Vtotal) {
        this.total = Vtotal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Productos getId_producto() {
        return id_producto;
    }

    public void setId_producto(Productos id_producto) {
        this.id_producto = id_producto;
    }

    public int getNum_fac() {
        return num_fac;
    }

    public void setNum_fac(int num_fac) {
        this.num_fac = num_fac;
    }

    public int getId_fac() {
        return id_fac;
    }

    public void setId_fac(int id_fac) {
        this.id_fac = id_fac;
    }

    public double getUni() {
        return uni;
    }

    public void setUni(double uni) {
        this.uni = uni;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Clientes getCedula() {
        return cedula;
    }

    public void setCedula(Clientes cedula) {
        this.cedula = cedula;
    }
    
    
}
