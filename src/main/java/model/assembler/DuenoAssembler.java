package model.assembler;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.duenos;
import model.duenos;

public class DuenoAssembler {

	public static duenos assembleUserFrom(HttpServletRequest req) {
		duenos dueno = new duenos();
		String nombre = req.getParameter("nombreDueño");
		dueno.setNombreDueño(nombre);
		return dueno;
	}
}