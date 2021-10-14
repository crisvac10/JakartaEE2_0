package co.edu.unbosque.jakartaee1_0;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.plaf.synth.SynthTextAreaUI;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Cookie cookie = new Cookie("Propietario","crisvac");
        response.addCookie(cookie);
        // Hello

        out.println("<html><body>");
        out.println("<meta http-equiv ='refresh'  content = '10;  URL= form.html'>");
        out.println("</head> <body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
        out.println("<html><body>");
        out.println("<meta http-equiv ='refresh'  content = '10;  URL= form2.html'>");
        out.println("</head> <body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");







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


        } else {
            response.sendError(401);
        }
    }
    public void destroy() {
    }
}