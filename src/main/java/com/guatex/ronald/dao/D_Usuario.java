package com.guatex.ronald.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.guatex.ronald.beans.E_Usuario;
import com.guatex.ronald.utils.Conexion;

public class D_Usuario {
	private String dbUrl = "jdbc:oracle:thin:@dbserver:1521:xe";
	private String username = "HELPDATA";
	private String password = "ron1";
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

	public List<E_Usuario> getUser(String idUser) {
		List<E_Usuario> users = new LinkedList<>();
		String sql = "SELECT *FROM USUARIO WHERE ID_USUARIO = ?";

		try (Connection con = DriverManager.getConnection(dbUrl, username, password);
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, idUser);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					users.add(new E_Usuario(quitaNulo(rs.getString(1)), quitaNulo(rs.getString(2)),
							quitaNulo(rs.getString(3))));
				}
			}
		} catch (SQLException e) {
			System.out.println("Opps, error: ");
			e.printStackTrace();
		}

		return users;
	}

	public String quitaNulo(String var) {
		String respuesta = var.isEmpty() || var ==null ? var = "" : var.trim();
		return respuesta;
	}
}
