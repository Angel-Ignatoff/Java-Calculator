package com.example;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StoreUser")
public class StoreUser extends HttpServlet{
	private static final long serialVersionUID = 1;
                                                                                          //, IOExcepetion	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		DBUtility dbstore = new DBUtility();
		
		try {
			dbstore.connectToDB();
			dbstore.store_user(firstName, lastName, userName, password);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			request.setAttribute("prb", dbstore.getprbMessage());
			request.getRequestDispatcher("/Register.jsp").forward(request, response);
		}
	}

}
