package com.proyecto.local.service;

import com.proyecto.local.modelo.Productos;
import com.proyecto.local.repositorio.Rproductos;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductosService {

	static Date fecha = new Date();
	SimpleDateFormat objSDF = new SimpleDateFormat("dd-MM-yyyy");
	GregorianCalendar gc = new GregorianCalendar();
	@Autowired
	private Rproductos ru;

	public List<Productos> list() {
		try {
			return ru.findAll();
		} catch (Exception e) {
		}
		return ru.findAll();
	}

	Date objDate = new Date();

	public Productos agregar(Productos u) {
		try {
			Productos pro = new Productos();
			pro.setCantidad_anterior(u.getCantidad_total());
			pro.setCantidad_nueva(u.getCantidad_nueva());
			pro.setCantidad_vendida(u.getCantidad_vendida());
			pro.setCantidad_total(pro.getCantidad_nueva() + pro.getCantidad_anterior() - pro.getCantidad_vendida());
			pro.setDescripcion(u.getDescripcion().toUpperCase());
			pro.setId_categoria(u.getId_categoria());
			pro.setId_codigo(u.getId_codigo());
			pro.setId_producto(u.getId_producto());
			pro.setPrecioventa(u.getPrecioventa());
			pro.setFecha(objDate);
			if (u.getId_producto() > 0) {
				pro.setFecha_update(gc);
			} else {
				pro.setFecha_create(gc);
			}
			pro.setFoto(u.getFoto());
			return ru.save(pro);
		} catch (Exception e) {
		}
		return ru.save(u);
	}

	public Productos buscarPro(int id) {
		return ru.findByproductos(id);
	}

	public Productos buscarid_producto(int id_producto) {
		return ru.findByid_producto(id_producto);
	}

	public Productos eliminar(int id) {
		Productos pro = ru.findByproductos(id);

		if (pro != null) {
			ru.delete(pro);
		}
		return pro;
	}

	public Productos agregarImagen(int id_producto, MultipartFile archivo) throws IOException {
		Productos pro = ru.findByid_producto(id_producto);
		if (!archivo.isEmpty()) {
			String nombreArchivo = archivo.getOriginalFilename();
			String nomante = pro.getFoto();
			if (nomante != null && nomante.length() > 0) {
				Path rutaarchivoanterior = (Path) Paths.get("c://Temp//uploads").resolve(nomante).toAbsolutePath();
				File archivoanterior = rutaarchivoanterior.toFile();
				if (archivoanterior.exists() && archivoanterior.canRead()) {
					archivoanterior.delete();
				}
			} else {
				Path rutaarchivoanterior = (Path) Paths.get("c://Temp//uploads").resolve(archivo.getOriginalFilename())
						.toAbsolutePath();
				File archivoanterior = rutaarchivoanterior.toFile();
				if (archivoanterior.exists() && archivoanterior.canRead()) {
					archivoanterior.delete();
				}
			}

			Path rutaarchivo = (Path) Paths.get("c://Temp//uploads").resolve(nombreArchivo).toAbsolutePath();
			Files.copy(archivo.getInputStream(), rutaarchivo);
			pro.setFoto(nombreArchivo);
			ru.save(pro);
			return pro;
		} else {
			return null;
		}
	}

}
