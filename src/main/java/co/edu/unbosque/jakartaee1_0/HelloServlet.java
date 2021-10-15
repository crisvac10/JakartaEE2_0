package co.edu.unbosque.jakartaee1_0;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.plaf.synth.SynthTextAreaUI;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {

        String username = request.getParameter("user");
        String password = request.getParameter("password");
        System.out.println("user:" + username);
        System.out.println("Password:"+ password);

        Cookie c = new Cookie("User",username);
        c.setMaxAge(20);
        response.addCookie(c);
        if (username.equals("crvacar") && password.equals("crvacar2020")) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<meta http-equiv='refresh' content='0; URL= form2.html'>");
            out.println("</html>");
        }else if(username.equals("user") && password.equals("12345")){
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<meta http-equiv='refresh' content='0; URL= form.html'>");
            out.println("</html>");

        } else {
            response.sendError(401);
        }


    }
    public void destroy() {
    }
}