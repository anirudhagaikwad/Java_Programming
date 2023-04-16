package PPT24;
/* Write a servlet application to print the current date and time.
---The most important advantage of using Servlet is that we can use all the methods available in core java. The Date class is available in java.util package.
Below program shows how to print the current date and time. We can use simple Date object with toString() to print current date and time.
*/

import java.io.*;
import javax.servlet.*;

public class JavaProgram4 extends GenericServlet
{
     //implement service()
     public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException
     {
          //set response content type
          res.setContentType("text/html");
          //get stream obj
          PrintWriter pw = res.getWriter();
          //write req processing logic
          java.util.Date date = new java.util.Date();
          pw.println("<h2>"+"Current Date & Time: " +date.toString()+"</h2>");
          //close stream object
          pw.close();
     }
}
