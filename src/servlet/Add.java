package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Unit;
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
		Unit unit = new Unit();
		unit.setName(request.getParameter("name"));
        unit.setCode(request.getParameter("code"));
	    new Dao().addUnit(unit);
	}
}
