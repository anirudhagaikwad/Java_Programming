package PPT24;

/* Write a Servlet application to count the total number of visits on your website.

--When first time servlet runs then session is created and value of the counter will be zero and after access of servlet again, the counter value will be increased by one.
*/


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JavaProgram1 extends HttpServlet
{
     //Instance variable used for counting hits on this servlet
     private int iHitCounter;

     //init method just initializes the hitCounter to zero
     public void init() throws ServletException
     {
          iHitCounter = 0;
     }
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
     {
          PrintWriter out =  response.getWriter();
          out.println("<form><fieldset style='width:15%'>");
          out.println("<h3>Welcome to my website !</h3><hr>");
          out.println("You are visitor number: "+ (++iHitCounter));
          out.println("</fieldset></form>");
     }
     public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
     {
          doGet(request, response);
     }
}
