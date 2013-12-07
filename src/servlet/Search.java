package servlet;

import dao.Dao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchString = request.getParameter("searchString");
		String delete = request.getParameter("do");
		
		if ("delete".equals(delete)) {
			Long id = (long) Integer.parseInt(request.getParameter("id"));
			Dao.deleteUnit(id);
		}
		if (searchString == null || searchString.equals("")) {
		    request.setAttribute("searchResults", Dao.findAllUnits());
		} else {
		    request.setAttribute("searchResults", Dao.search(searchString));
		}
		//out.println(dao.findAllUnits());
		request.getRequestDispatcher("WEB-INF/jsp/search.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchString = request.getParameter("searchString");
		request.setAttribute("searchString", searchString);
        response.sendRedirect("Search?searchString=" + searchString);
	}

}
