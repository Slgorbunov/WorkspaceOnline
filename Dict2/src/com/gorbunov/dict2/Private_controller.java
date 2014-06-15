package com.gorbunov.dict2;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Private_controller
 */
@WebServlet(name = "private_controller", urlPatterns = {"/private/yourDictionary.xhtml"})
public class Private_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = Logger.getLogger(Private_controller.class.getName());   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Private_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		LOGGER.info("Start processRequest.");
        response.setContentType("text/html;charset=UTF-8");
        if ("/private/yourDictionary.xhtml".equals(request.getServletPath())){
            request.setAttribute("name", request.getUserPrincipal().getName()); 
            request.getRequestDispatcher("/private/yourDictionary.jsp").forward(request, response);
            LOGGER.info("Redirect");
            LOGGER.info(request.getAttribute("name").toString());
        }
        else if ("/logout".equals(request.getServletPath())){
        	LOGGER.info("Logout");
            HttpSession session = request.getSession(false);
            if (session!= null){
                session.invalidate();
            }
            response.sendRedirect("/");
        }
    }

}
