import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RedirectTest2",urlPatterns = "/RedirectTest2")
public class RedirectTest2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int firstNumber = Integer.parseInt(request.getParameter("firstNumber"));
        int secondNumber = Integer.parseInt(request.getParameter("secondNumber"));
        if (firstNumber == 1 && secondNumber == 1) {
            request.setAttribute("sum", firstNumber + secondNumber);
            request.getRequestDispatcher("web/Test/process-redirect-test2.jsp").forward(request,response);
        } else {
            response.sendRedirect("web/Test/test2.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
