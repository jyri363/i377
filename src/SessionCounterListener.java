import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessionCounterListener implements HttpSessionListener {
  // http://www.mkyong.com/servlet/a-simple-httpsessionlistener-example-active-sessions-counter/
  private static int totalActiveSessions = 0;
 
  public static int getTotalActiveSession(){
	  return totalActiveSessions;
  }
 
  @Override
  public void sessionCreated(HttpSessionEvent event) {
	  totalActiveSessions++;
	  System.out.println("sessionCreated - add one session into counter");
  }
 
  @Override
  public void sessionDestroyed(HttpSessionEvent event) {

	  totalActiveSessions--;
	  
	  System.out.println("sessionDestroyed - deduct one session from counter");
  }	
}
