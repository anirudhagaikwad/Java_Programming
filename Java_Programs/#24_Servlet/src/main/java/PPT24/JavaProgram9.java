package PPT24;

//The second servlet for http session tracking
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class JavaProgram9 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
		/*Declaration of the get method*/
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(false);
		/*Resuming the session created
										in the previous servlet using
										the same method that was used
										to create the session.
										The boolean parameter 'false'
										has been passed so that a new session
										is not created since the session already
										exists*/

		String n = (String)session.getAttribute("uname");
		out.print("Hello " + n);

		out.close();
	}
	catch (Exception e) {
		System.out.println(e);
	}
}
}
