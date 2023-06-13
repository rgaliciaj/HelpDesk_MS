package com.guatex.ronald.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import com.guatex.ronald.models.E_Usuario;
import com.guatex.ronald.models.pkgUsuario;
import com.guatex.ronald.utils.utils;

public class D_Usuario {
	private String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "HELPDATA";
	private String password = "ron1";

	utils util = new utils();

//	private Connection con = null;
//	private PreparedStatement ps = null;
//	private ResultSet rs = null;

//	public List<E_Usuario> getUser(String p_id) {
//		List<E_Usuario> listRespuesta = new LinkedList<>();
//		String sql = "";
//
//		con = new Conexion().getConexion();
//		sql = "SELECT *FROM USUARIO WHERE ID_USUARIO = ?";
//
//		try {
//			ps = con.prepareStatement(sql);
//			ps.setString(1, p_id);
//			rs = ps.executeQuery();
//
//			while (rs.next()) {
//				E_Usuario u = new E_Usuario();
//				u.setIdUser(quitaNulo(rs.getString(1)));
//				u.setUser(quitaNulo(rs.getString(2)));
//				u.setPassword(quitaNulo(rs.getString(3)));
//				listRespuesta.add(u);
//			}
//
//		} catch (SQLException e) {
//			System.out.println("Opps, error: ");
//			e.printStackTrace();
//		} finally {
//			try {
//				if (!rs.isClosed()) {
//					rs.close();
//					rs = null;
//
//				}
//				if (!ps.isClosed()) {
//					ps.close();
//					ps = null;
//				}
//				if (!con.isClosed()) {
//					con.close();
//					con = null;
//				}
//			} catch (SQLException e) {
//				System.out.println("Opps, error en cierre de conexiones: ");
//				e.printStackTrace();
//			}
//		}
//		
//		return listRespuesta;
//	}

	public pkgUsuario getUser(String user, String pass) {
		List<E_Usuario> datosList = new LinkedList<>();
		E_Usuario datos = new E_Usuario();
		String sql = "SELECT USUARIO, PASSWORD FROM USUARIO WHERE USUARIO = ? AND PASSWORD = ?";

		try (Connection con = DriverManager.getConnection(dbUrl, username, password);
				PreparedStatement ps = con.prepareStatement(sql)) {
			if(util.quitaNulo(user).isEmpty() && util.quitaNulo(pass).isEmpty()) {
				ps.setString(1, user);
				ps.setString(2, pass);
				try (ResultSet rs = ps.executeQuery()) {
					if (rs.next()) {
						return new pkgUsuario(sql, datosList, datos);
					} else {
						return new pkgUsuario("400", datosList, datos);
					}
				}
			} else {
				return new pkgUsuario("401", datosList, datos);
			}
		} catch (SQLException e) {
			System.out.println("Opps, error: ");
			e.printStackTrace();
		}
		return new pkgUsuario("500", datosList, datos);
	}

	public List<E_Usuario> getUsers() {
		List<E_Usuario> users = new LinkedList<>();
		String sql = "SELECT *FROM USUARIO";

		try (Connection con = DriverManager.getConnection(dbUrl, username, password);
				PreparedStatement ps = con.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					users.add(new E_Usuario(util.quitaNulo(rs.getString(1)), util.quitaNulo(rs.getString(2)),
							util.quitaNulo(rs.getString(3))));
				}
			}
		} catch (SQLException e) {
			System.out.println("Opps, error: ");
			e.printStackTrace();
		}

		return users;
	}

	public boolean createUser(E_Usuario datos) {
		boolean respuesta = false;
		String sql = "INSERT INTO USUARIO (USUARIO , PASSWORD) VALUES (?, ?)";

		try (Connection con = DriverManager.getConnection(dbUrl, username, password);
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, util.quitaNulo(datos.getUser()));
			ps.setString(2, util.quitaNulo(datos.getPassword()));
			if (ps.executeUpdate() > 0) {
				respuesta = true;
			}
		} catch (SQLException e) {
			System.out.println("Opps, error: ");
			e.printStackTrace();
		}
		return respuesta;
	}
}
