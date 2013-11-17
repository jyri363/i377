package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;

/**
 * Servlet implementation class Add
 */
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.getRequestDispatcher("WEB-INF/jsp/add.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    addUnit(request);
	    response.sendRedirect("Search");
	}
	
	private void addUnit(HttpServletRequest request) {
	    try {
	            new Dao().addUnit(request.getParameter("name"), request.getParameter("code"));
	    } catch (SQLException e) {
	            throw new RuntimeException(e);
	    }
	}
}
