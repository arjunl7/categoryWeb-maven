package com.litmus7.training.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServletLoad
 */
//@WebServlet("/testservlet")	
//@WebServlet(name = "testinit", urlPatterns = { "/testservlet" }, initParams = {
//		@WebInitParam(name = "param1", value = "param1value"),
//		@WebInitParam(name = "param2", value = "param2Value"), })
public class TestServletLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServletLoad() {
        super();
        // TODO Auto-generated constructor stub	
        System.out.println("Test Servlet constructor");
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	System.out.println("Test Servlet init " + getServletConfig().getInitParameter("param1"));
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
		// TODO Auto-generated method stub
		System.out.println("Test Servlet value: " + getServletConfig().getInitParameter("param1"));
		System.out.println("Test Servlet value3: " + getServletConfig().getServletContext().getInitParameter("param3"));
//		doGet(request, response);
		response.sendRedirect("test.html");
	}

}
