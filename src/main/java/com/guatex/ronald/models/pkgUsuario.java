/**
 * 
 */
package com.guatex.ronald.models;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Ron
 *
 */
public class pkgUsuario {
	private String codigo = "";
	private String mensaje = "";
	private E_Usuario datos = new E_Usuario();
	List<E_Usuario> datosList = new LinkedList<>();
	
	public pkgUsuario() {}
	
	public pkgUsuario(String codigo, List<E_Usuario> datosList, E_Usuario datos) {
		this.codigo = codigo;
		if(codigo.equalsIgnoreCase("500")) {
			this.mensaje = "Error en el servidor.";
		} else if (codigo.equalsIgnoreCase("400")) {
			this.mensaje = "Credenciales inválidas.";
		} else if (codigo.equalsIgnoreCase("401")) {
			this.mensaje = "Falta ingresar un parámetro.";
		} else if (codigo.equalsIgnoreCase("200")) {
			this.mensaje = "ok";
		}
	}
//
//	public pkgUsuario(String codigo, ) {
//		this.codigo = codigo;
//		this.mensaje = mensaje;
//		this.datos = datos;
//	}
//	
//	public pkgUsuario(String codigo, String mensaje, ) {
//		this.codigo = codigo;
//		this.mensaje = mensaje;
//		this.datosList = datosList;
//	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public E_Usuario getDatos() {
		return datos;
	}
	public void setDatos(E_Usuario datos) {
		this.datos = datos;
	}
	public List<E_Usuario> getDatosList() {
		return datosList;
	}
	public void setDatosList(List<E_Usuario> datosList) {
		this.datosList = datosList;
	}
	
	
}
