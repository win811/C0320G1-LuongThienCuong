package JavaOverview;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@javax.servlet.annotation.WebServlet(name = "Servlet",urlPatterns = "/display-time")
public class DisplayTimeServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        PrintWriter writer = response.getWriter();
        Date today = new Date();
        writer.println("<html>");
        writer.println("<h1>Hello world</h1>");
        writer.println("<h2>" + today + "</h2>");
        writer.println("<h2> This website has been hacked by Cuong-Galilei </h2>");
        writer.println("</html>");
    }
}
