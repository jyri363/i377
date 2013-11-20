package servlet;

import dao.Dao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchString = request.getParameter("searchString");
		String delete = request.getParameter("do");
		Dao dao = new Dao();
		
		//PrintWriter out = response.getWriter(); 
		try {
			if ("delete".equals(delete)) {
				int id = Integer.parseInt(request.getParameter("id"));
				new Dao().deleteUnit(id);
			}
			if (searchString == null || searchString.equals("")) {
                request.setAttribute("searchResults", dao.findAllUnits());
	        } else {
	            request.setAttribute("searchResults", dao.search(searchString));
	        }
			//out.println(dao.findAllUnits());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		request.getRequestDispatcher("WEB-INF/jsp/search.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchString = request.getParameter("searchString");
		request.setAttribute("searchString", searchString);
        response.sendRedirect("Search?searchString=" + searchString);
	}

}
