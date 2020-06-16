package JSP_JSTL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ActorServlet",urlPatterns = "/List-Actor")
public class ActorServlet extends HttpServlet {
    private static final List<Actor> LIST_ACTOR = new ArrayList<>();
    static {
        LIST_ACTOR.add(new Actor("Arisa Misato","26","Janpan","Điều Tuyệt Vời Nhất","Arisa_Misato.PNG"));
        LIST_ACTOR.add(new Actor("Yumeno Aika","26","Janpan","Con Dâu Đáng Thương","Yumeno_Aika.PNG"));
        LIST_ACTOR.add(new Actor("Maeda Momoko","28","Janpan","Mỹ Nữ Kiêu Sa","Maeda_Momoko.PNG"));
        LIST_ACTOR.add(new Actor("Melody Mark","27","America","Học Sinh Loli","Melody_Mark.PNG"));
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list_actor",LIST_ACTOR);
        request.getRequestDispatcher("JSP-JSTL/list-actor.jsp").forward(request,response);
    }
}
