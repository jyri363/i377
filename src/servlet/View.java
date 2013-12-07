package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Unit;
import dao.Dao;

/**
 * Servlet implementation class View
 */
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setAttribute("selectUnit", Dao.findAllUnits());
    	
    	viewUnit(request);
	    request.getRequestDispatcher("WEB-INF/jsp/view.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	    response.sendRedirect("Search");
	}
	
	private void viewUnit(HttpServletRequest request) {
		Unit unit = Dao.findById(Long.parseLong(request
                .getParameter("id")));
		request.setAttribute("name", unit.getName());
		request.setAttribute("code", unit.getCode());
       if(unit.getSuper_unit_id()!=null)
    	   request.setAttribute("superUnit",Dao.findById(unit.getSuper_unit_id()));
       request.setAttribute("child",Dao.findByChildId(unit.getId()));
	}

}
