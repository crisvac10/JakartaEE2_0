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
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("Propietario","crisvac");
        response.addCookie(cookie);
        // Hello
        String username = request.getParameter("user");
        String password = request.getParameter("password");
        if (username.equals("crvacar") && password.equals("crvacar2020")){
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<meta http-equiv='refresh'  content = '10;  URL= form2.html'>");
            out.println("</html>");
        }else if(username.equals("user") && password.equals("12345")){
            request.getRequestDispatcher("MultipartServlet").forward(request, response);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<meta http-equiv='refresh'  content = '2;  URL= form.html'>");
            out.println("</html>");

        }else{
            response.sendError(401);
        }


    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String username = request.getParameter("user");
        String password = request.getParameter("password");
        System.out.println("user:" + username);
        System.out.println();
        if (username.equals("crvacar") && password.equals("crvacar2020")) {
            // Hello
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1> Hello " + username + "</h1>");
            out.println("</body></html>");
        }else if(username.equals("user") && password.equals("12345")){
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1> Hello " + username + "</h1>");
            out.println("</body></html>");

        } else {
            response.sendError(401);
        }
    }
    public void destroy() {
    }
}