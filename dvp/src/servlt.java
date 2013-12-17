

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlt
 */
@WebServlet("/servlt")
public class servlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); //Задаем формат ответа - HTML, текст
	    PrintWriter out = response.getWriter(); //Получаем объект, позволяющий записать контент в ответ 
	    out.write("<!DOCTYPE html>\n" + // Записываем в ответ HTML код простейшей странички
	       "<html>\n" +
	       "<head><title>A servlet without templates.</title></head>\n" +
	       "<body bgcolor=\"#fdf5e6\">\n" +
	       "<h1>Note:</h1>\n" +
	       "<p>This whole page was created via servlet</p>\n" +
	       "</body></html>"); 
	    //new comment1
	    //new com2
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
