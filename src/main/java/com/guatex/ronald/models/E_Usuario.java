package com.guatex.ronald.models;

public class E_Usuario {
	private String idUser = "";
	private String user = "";
	private String password = "";
	
	public E_Usuario() {
		
	}
	
	public E_Usuario(String idUser, String user, String password) {
		this.idUser = idUser;
		this.user = user;
		this.password = password;
	}
	
	public E_Usuario(String user, String password) {
		this.user = user;
		this.password = password;
	}
	
	
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
