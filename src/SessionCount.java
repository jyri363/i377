

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SessionCount
 */
public class SessionCount extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// kasutan lihtsalt: http://www.mkyong.com/servlet/a-simple-httpsessionlistener-example-active-sessions-counter/ 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count = SessionCounterListener.getTotalActiveSession();
		response.getWriter().println("<html><head><title>Count</title></head><body>count: "+count+"</body></html>");
	}

}
