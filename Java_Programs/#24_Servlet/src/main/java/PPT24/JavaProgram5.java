package PPT24;

/*
Create an Html page that contains 4 option buttons Java, UNIX, DDBMS, OOSE and 2 buttons Submit and Reset. When the user clicks on Submit button the server responds by adding cookie containing the selected Subject and sends the html page to the client. Program should not allow duplicate cookie to be written.
                    
--Information which is stored on the client machine is called cookies. It has parameters like name, value, path, host, expires and connection type.

In this example, when we click on submit button after checking the value, the cookies add selected value.
*/

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;  
public class JavaProgram5 extends HttpServlet
{  
     public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
     {
          res.setContentType("text/html");
          PrintWriter pw = res.getWriter();
          Cookie []c = req.getCookies();
          int id=1;
          if(c!=null) id = c.length+1;
               String value = req.getParameter("course");
          Cookie newCookie = new Cookie("course:"+id,value);
          res.addCookie(newCookie);  
          pw.println("<h4>Cookie added with value "+value+"</h4>");
     }

}
