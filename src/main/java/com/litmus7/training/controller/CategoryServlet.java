package com.litmus7.training.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("reqested delete");
		
		//
	    System.out.println(request.getAttribute("name"));
	    System.out.println(request.getAttribute("test1"));
		
		CategoryController obj = new  CategoryController();
		
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("delete")) {
			for(String id: request.getParameterValues("catid")) {
				try {
					System.out.println("Deleting cat with id: " + id);
					boolean status = obj.deleteCategoryById(Integer.parseInt(id));
					if(status == true) {
						System.out.println("Deleted");
					} else {
						System.out.println("Deletion failed");
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					response.sendRedirect("error.html");
				}
			}
			response.sendRedirect("login");
		}
		
	}

}
