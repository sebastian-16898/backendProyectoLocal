package com.proyecto.local.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "productos")
public class Productos implements Serializable {

    @Id
    @Column(name = "id_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_producto;

    @OneToOne
    @JoinColumn(name = "id_categoria")
    private Categoria id_categoria;

    @OneToOne
    @JoinColumn(name = "id_codigo")
    private Codigo id_codigo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precioventa")
    private Double precioventa;

    @Column(name = "cantidad_nueva")
    private int cantidad_nueva;

    @Column(name = "cantidad_anterior")
    private int cantidad_anterior;

    @Column(name = "cantidad_vendida")
    private int cantidad_vendida;

    @Column(name = "cantidad_total")
    private int cantidad_total;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "foto")
    private String foto;

    @Column(name = "descuento")
    private double descuento;

    @Column(name = "precio_mayor")
    private double precio_mayor;

    @Column(name = "precio_descuento")
    private double precio_descuento;

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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getPrecio_mayor() {
        return precio_mayor;
    }

    public void setPrecio_mayor(double precio_mayor) {
        this.precio_mayor = precio_mayor;
    }

    public double getPrecio_descuento() {
        return precio_descuento;
    }

    public void setPrecio_descuento(double precio_descuento) {
        this.precio_descuento = precio_descuento;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public Categoria getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Categoria id_categoria) {
        this.id_categoria = id_categoria;
    }

    public Codigo getId_codigo() {
        return id_codigo;
    }

    public void setId_codigo(Codigo id_codigo) {
        this.id_codigo = id_codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(Double precioventa) {
        this.precioventa = precioventa;
    }

    public int getCantidad_nueva() {
        return cantidad_nueva;
    }

    public void setCantidad_nueva(int cantidad_nueva) {
        this.cantidad_nueva = cantidad_nueva;
    }

    public int getCantidad_anterior() {
        return cantidad_anterior;
    }

    public void setCantidad_anterior(int cantidad_anterior) {
        this.cantidad_anterior = cantidad_anterior;
    }

    public int getCantidad_vendida() {
        return cantidad_vendida;
    }

    public void setCantidad_vendida(int cantidad_vendida) {
        this.cantidad_vendida = cantidad_vendida;
    }

    public int getCantidad_total() {
        return cantidad_total;
    }

    public void setCantidad_total(int cantidad_total) {
        this.cantidad_total = cantidad_total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
