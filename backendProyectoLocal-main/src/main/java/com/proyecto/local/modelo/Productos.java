package com.proyecto.local.modelo;



import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Productos implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
