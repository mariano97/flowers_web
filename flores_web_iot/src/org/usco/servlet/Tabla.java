package org.usco.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.usco.dao.DatosDAO;
import org.usco.implement.DatosImpl;
import org.usco.model.Datos;

@WebServlet("/tabla")
public class Tabla extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DatosDAO dao = new DatosImpl();
		
		List<Datos> datos = dao.list();
		
		RequestDispatcher listar = req.getRequestDispatcher("/index.jsp");
		
		req.setAttribute("datos_tabla", datos);
		
		listar.forward(req, resp);
		
		
	}

	
	
}
