

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MultipleValueFieldHandlerServlet
 */
@WebServlet("/MultipleValueFieldHandlerServlet")
public class MultipleValueFieldHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultipleValueFieldHandlerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		String[] enteredValue;
		enteredValue = request.getParameterValues("options");
		response.setContentType("text/html");
		request.setAttribute("enteredValue", enteredValue);//setAttribute in request for send to another servlet
		try{
			request.getRequestDispatcher("ConfirmationServlet").forward(request, response);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
