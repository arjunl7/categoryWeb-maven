package com.litmus7.training.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.litmus7.training.dto.Category;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/categoryajax")
public class CategoryServletAJAX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServletAJAX() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryController obj = new  CategoryController();
		
		try {
			List<Category> catList = obj.getAllCategoriesCallProc();
			
//			String json = new Gson().toJson(catList);
			StringBuilder json = new StringBuilder(); 
			json.append("[");
			int i = 0;
			for (Category cat: catList) {
				i++;
				if(i == catList.size()) {
					json.append("{ \"id\": " + "\"" + cat.getID() + "\"" + ", \"name\":" + "\"" + cat.getName() + "\"" + "}");
				} else {
					json.append("{ \"id\": " + "\"" + cat.getID() + "\"" + ", \"name\":" + "\"" + cat.getName() + "\"" + "},");
				}
			}
			json.append("]");
			
			System.out.println(json.toString());
			PrintWriter writer = response.getWriter();
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    writer.write(json.toString());
		    writer.close();
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Destroying catrgoryajax servlet");
		super.destroy();
	}

}
