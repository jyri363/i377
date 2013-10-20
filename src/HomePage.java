

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomePage
 */
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter(); 
		HttpSession sess = request.getSession();
		Object param = request.getParameter("param");
		if(param != null)
            sess.setAttribute("param", param);
		response.setContentType("text/html");

		out.println("<html><head><title>Hello!</title></head><body>Hello<br />");
	
		out.println("Your session id is " +  sess.getId() + "<br />");

		out.println("Session attribute is " + sess.getAttribute("param"));	
		out.println("</body></html>");
	}

}
