package com.gv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gv.connection.Conexion;
import com.gv.contriller.Estudiante;

public class Dao {
	public void insertarEstudiante(Estudiante estudiante) {
		String sql = "INSERT INTO estudiantes (nombre, apellido, fecha_nacimiento, genero, direccion, telefono, correo_electronico, grado, fecha_inscripcion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, estudiante.getNombre());
			pstmt.setString(2, estudiante.getApellido());
			pstmt.setDate(3, new java.sql.Date(estudiante.getFechaNacimiento().getTime()));
			pstmt.setString(5, estudiante.getDireccion());
			pstmt.setString(6, estudiante.getTelefono());
			pstmt.setString(7, estudiante.getCorreoElectronico());
			pstmt.setString(8, estudiante.getGrado());
			pstmt.setDate(9, new java.sql.Date(estudiante.getFechaInscripcion().getTime()));
			pstmt.executeUpdate();
			System.out.println("Estudiante insertado con exito.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	// Metodo Obtener los estudiantes

	public Estudiante obtenerEstudiante(int id) {
		Estudiante estudiante = null;
		String sql = "SELECT * FROM estudiantes where id = ?";
		try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				estudiante = new Estudiante(id, sql, sql, null, sql, sql, sql, sql, sql, null);
				estudiante.setId(rs.getInt("id"));
				estudiante.setNombre(rs.getString("nombre"));
				estudiante.setApellido(rs.getString("apellido"));
				estudiante.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
				estudiante.setGenero(rs.getString("genero"));
				estudiante.setDireccion(rs.getString("direccion"));
				estudiante.setTelefono(rs.getString("telefono"));
				estudiante.setCorreoElectronico(rs.getString("correo_electronico"));
				estudiante.setGrado(rs.getString("grado"));
				estudiante.setFechaInscripcion(rs.getDate("fecha_inscripcion"));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return estudiante;
	}
	public List<Estudiante> obtenerTodosEstudiantes() {
        List<Estudiante> estudiantes = new ArrayList<>();
        String sql = "SELECT * FROM estudiantes";
        try (Connection conn = Conexion.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Estudiante estudiante = new Estudiante(0, sql, sql, null, sql, sql, sql, sql, sql, null);
                estudiante.setId(rs.getInt("id"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                estudiante.setGenero(rs.getString("genero"));
                estudiante.setDireccion(rs.getString("direccion"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setCorreoElectronico(rs.getString("correo_electronico"));
                estudiante.setGrado(rs.getString("grado"));
                estudiante.setFechaInscripcion(rs.getDate("fecha_inscripcion"));
                estudiantes.add(estudiante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudiantes;
    }

	public void actualizarEstudiante(Estudiante estudiante) {
		String sql = "UPDATE estudiantes SET nombre = ?, apellido = ?, fecha_nacimiento = ?, genero = ?, direccion = ?, telefono = ?, correo_electronico = ?, grado = ?, fecha_inscripcion = ? WHERE id = ?";
		try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, estudiante.getNombre());
			pstmt.setString(2, estudiante.getApellido());
			pstmt.setDate(3, new java.sql.Date(estudiante.getFechaNacimiento().getTime()));
			pstmt.setString(4, estudiante.getGenero());
			pstmt.setString(5, estudiante.getDireccion());
			pstmt.setString(6, estudiante.getTelefono());
			pstmt.setString(7, estudiante.getCorreoElectronico());
			pstmt.setString(8, estudiante.getGrado());
			pstmt.setDate(9, new java.sql.Date(estudiante.getFechaInscripcion().getTime()));
			pstmt.setInt(10, estudiante.getId());
			pstmt.executeUpdate();
			System.out.println("Estudiante actualizado con éxito.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void eliminarEstudiante(int id) {
		String sql = "DELETE FROM estudiantes WHERE id = ?";
		try (Connection conn = Conexion.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			System.out.println("Estudiante eliminado con éxito.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

