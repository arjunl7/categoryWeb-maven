package com.litmus7.training.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.litmus7.training.dto.Category;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginjsp")
public class LoginServletJSP extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServletJSP() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	System.out.println("Login servlet init");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("Inside Login doGet, Username: " + request.getParameter("username") + " Password: " + request.getParameter("password"));
		
		CategoryController obj = new  CategoryController();
		
		try {
			List<Category> catList = obj.getAllCategoriesCallProc();
//			catList.forEach(cat -> System.out.println(cat.getID() + "\t" + cat.getName()));
			System.out.println("Login Servlet value3: " + getServletConfig().getServletContext().getInitParameter("param3"));
			
			PrintWriter writer = response.getWriter();
			String cssTag="<link rel='stylesheet' type='text/css' href='css/home.css'>";
			writer.println("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Insert title here</title>\r\n"
					+ cssTag
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "	<h5>Logged in</h5>\r\n"
					+ "<h2>Categories</h2>"
					+ "<form method=\"post\" action=\"category?action=delete\">"
					+ "<input type=\"submit\" class=\"delete-btn\" value=\"Delete\" onclick=\"return confirm('Are you sure?')\"/>"
					+ "<table>"
					+ "<tr> <th><input type=\"checkbox\" class=\"selectall-cat\">  Select All</th> "
					+ "<th>Catalogue ID</th> "
					+ "<th>Name</th> </tr>");
			
			catList.forEach(cat -> { 
				writer.println("<tr> <td><input type=\"checkbox\" name=\"catid\" value=" + cat.getID() + " class=\"checked-cat\"></td>");
				writer.println("<td>" + cat.getID() + "</td>");
				writer.println("<td>" + cat.getName() + "</td>" + "</tr>");
			});
			
			writer.println("</table>"
					+ "</form>"
					+ "<script src=\"js/home.js\"></script>"
					+ "</body>\r\n"
					+ "</html>");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Login doPost");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String lang = request.getParameter("language");
		String remember = request.getParameter("remember");
		
		System.out.println(lang);
		System.out.println(remember);
		
		//request scope
		request.setAttribute("key1", "value2");
		//session
		request.getSession().setAttribute("name", "arjun");
		//global
		getServletContext().setAttribute("test1", "val2");
		
		if(userName.equals("admin") && password.equals("12345")) {
			CategoryController obj = new  CategoryController();
			
			request.getSession().setAttribute("username", userName);
			request.getSession().setAttribute("lang", lang);
			request.getSession().setMaxInactiveInterval(10);
			
			if(remember == "on") {				
				
				Cookie ck = new Cookie("auth", "true");
				response.addCookie(ck);
			}
			
			
			//from req
			Cookie ckList[] = request.getCookies();
			for(Cookie ckItem: ckList) {
				System.out.println(ckItem.getName());
				System.out.println(ckItem.getValue());
			}
			
			try {
				List<Category> catList = obj.getAllCategories();
				request.setAttribute("categoryList", catList);
	//			doGet(request, response);
				getServletConfig().getServletContext()
					.getRequestDispatcher("/categoriesjsp.jsp")
					.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("error.html");			
		}
	}

}
