package PPT24;

/*
Write a JAVA servlet program for http session tracking
*/
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class JavaProgram8 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		try { /*Declaration of the get method*/

			response.setContentType("text/html"); // Setting the content type to text
			PrintWriter out = response.getWriter();

			String n = request.getParameter("userName"); /*Fetching the contents of
												the userName field from the form*/
			out.print("Welcome " + n); // Printing the username

			HttpSession session = request.getSession(); /* Creating a new session*/

			session.setAttribute("uname", n);
			/*Setting a variable uname
								containing the value as the fetched
								username as an attribute of the session
								which will be shared among different servlets
								of the application*/

			out.print("<a href='nine'>visit</a>"); // Link to the second servlet

			out.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
