/**
 * Created by viacheslav on 24.04.14.
 */

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletTst extends HttpServlet {
    protected void doGet (HttpServletRequest request, HttpServletResponse response){
        try{
           response.setCharacterEncoding("UTF-8");
           response.setContentType("text/html");
           PrintWriter printWriter = response.getWriter();
           printWriter.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
           printWriter.println("<h1>");
           printWriter.println("я читаю это!!!!!!!!!!!!!!!!!!!!!!!!!!!!22");
           printWriter.println("</h1>");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
