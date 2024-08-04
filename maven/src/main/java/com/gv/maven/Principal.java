package com.gv.maven;

import java.util.Date;
import java.util.List;

import com.gv.contriller.Estudiante;
import com.gv.dao.Dao;

public class Principal {

		 public static void main(String[] args) {
		        Dao estudianteDAO = new Dao();

		        // Crear nuevo estudiante
		        Estudiante nuevoEstudiante = new Estudiante(0, null, null, null, null, null, null, null, null, null);
		        nuevoEstudiante.setNombre("Gabriela");
		        nuevoEstudiante.setApellido("Villagran");
		        nuevoEstudiante.setFechaNacimiento(new Date());
		        nuevoEstudiante.setGenero("f");
		        nuevoEstudiante.setDireccion("Los ocotes zona 25, capitalina");
		        nuevoEstudiante.setTelefono("4652-0678");
		        nuevoEstudiante.setCorreoElectronico("avillagranc3@miumg.edu.gt");
		        nuevoEstudiante.setGrado("4rto");
		        nuevoEstudiante.setFechaInscripcion(new Date());
		        estudianteDAO.insertarEstudiante(nuevoEstudiante);

		        // Obtener estudiante por ID
		        Estudiante estudiante = estudianteDAO.obtenerEstudiante(1);
		        if (estudiante != null) {
		            System.out.println("Estudiante ID: " + estudiante.getId());
		            System.out.println("Nombre: " + estudiante.getNombre());
		            System.out.println("Apellido: " + estudiante.getApellido());
		        } else {
		            System.out.println("Estudiante no encontrado.");
		        }

		        // Obtener todos los estudiantes
		        List<Estudiante> estudiantes = estudianteDAO.obtenerTodosEstudiantes();
		        for (Estudiante est : estudiantes) {
		            System.out.println("ID: " + est.getId() + ", Nombre: " + est.getNombre() + ", Apellido: " + est.getApellido());
		        }

		        // Actualizar un estudiante
		        if (estudiante != null) {
		            estudiante.setNombre("Alyson Actualizado");
		            estudianteDAO.actualizarEstudiante(estudiante);
		        }

		        // Eliminar un estudiante
		        estudianteDAO.eliminarEstudiante(1);
		    }
		

	}


