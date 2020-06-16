package JavaOverview;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductDiscount",urlPatterns = "/display-discount")
public class ProductDiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productDescription = request.getParameter("productDescription");
        float productPrice = Float.parseFloat(request.getParameter("productPrice"));
        float discountPercent = Float.parseFloat(request.getParameter("discountPercent"));
        float discountAmount = productPrice * (discountPercent/100);
        float discountPrice = productPrice - discountAmount;
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1> Product Description : " + productDescription + "<h1/>");
        writer.println("<h1> Product Price : " + productPrice + "<h1/>");
        writer.println("<h1> Discount Percent : " + discountPercent + "%<h1/>");
        writer.println("<h2> Discount Amount : " + discountAmount + "<h2/>");
        writer.println("<h2> Discount Price : " + discountPrice + "<h2/>");
        writer.println("</html>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
