

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
		// esiteks teeme veidi lihtsamaks.
		PrintWriter out = response.getWriter(); 
		HttpSession sess = request.getSession();
		Object param = request.getParameter("param");
		// teiseks kasutan tuima htmli koodi (tegelkult peaks jsp.-s seda tegema)
		response.setContentType("text/html");

		out.println("<html><head><title>Hello!</title></head><body>Hello<br />");
		// Nüüd peab mingid sessi jamad lisama, õnneks on selle kohta googlis olemas!
		out.println("Your session id is " +  sess.getId() + "<br />");
		sess.setAttribute("param", param);
		out.println("Session attribute is " + param);	
		out.println("</body></html>");
		// Nüüd peaks testima või vähemalt kontrollima, kas asi töötab, kuid kahjuks pole mul praegu aega
	}

}
