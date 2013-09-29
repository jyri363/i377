

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

/**
 * Servlet implementation class SessionCount
 */
public class SessionCount extends HttpServlet {
	// kasutan lihtsalt: http://www.mkyong.com/servlet/a-simple-httpsessionlistener-example-active-sessions-counter/ 
	// ei ole kindel, kas asi töötab!
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("<html><head><title>Count</title></head><body>count: "+ SessionCounterListener.getTotalActiveSession()+"</body></html>");
	}

}
