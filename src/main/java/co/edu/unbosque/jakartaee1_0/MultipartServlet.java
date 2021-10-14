package co.edu.unbosque.jakartaee1_0;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(name = "multiPartServlet", value = "/multipart-Servlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1824,
            maxFileSize = 1024 * 1824 * 5,
            maxRequestSize = 1824 * 1824 * 5 * 5)
public class MultipartServlet extends HttpServlet{
    private String message;
    private String UPLOAD_DIRECTORY = "uploads";

    public void init(){ message = "Hello world";}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");

        String uploadPath = getServletContext().getRealPath("")+ File.separator + UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);
        if(!uploadDir.exists()) uploadDir.mkdir();

        String fileName = "";
        try{
            for(Part part: request.getParts()){
                fileName = part.getSubmittedFileName();
                part.write(uploadPath + File.separator + fileName);
            }

            request.setAttribute("message", "File " + fileName + " has upload successfully!");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

}
