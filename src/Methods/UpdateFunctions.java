package Methods;
import Pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;
import java.util.ArrayList;

import com.google.gson.Gson;

/**
 * Servlet implementation class LoginFunctions
 */
@WebServlet("/UpdateFunctions")
public class UpdateFunctions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateFunctions() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String requestName = request.getParameter("requestName");
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("user");
		
		UserOperations up = new UserOperations();
		
		if(requestName.equalsIgnoreCase("getUserDetails")){
			
			User s = up.getUserDetails(username);
			 response.getWriter().write(new Gson().toJson(s));
				System.out.println("str is = "+s);
				System.out.println("response created");
		}
		
				
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("user");
		String name=null;
		name=request.getParameter("name");
		String pwd = null;
		pwd=request.getParameter("password");
		String email = null;
		email= request.getParameter("email");
		String address=null;
		address= request.getParameter("address");
		String state=null;
		state= request.getParameter("state");
		String country = null;
		country=request.getParameter("country");
		String ssn=null;
		ssn=request.getParameter("ssn");
		String county = null;
		county=request.getParameter("county");
		User user=new User(username,name,pwd,email,address,state,country,ssn,county);
		UserOperations uo= new UserOperations();
		
		boolean res=uo.updateAccount(user);
		if(res)
		createJsonObject(response,"true");
		else
			createJsonObject(response,"false");
			}

	private void createJsonObject(HttpServletResponse response,String str) throws IOException{
		response.getWriter().write(new Gson().toJson(str));
		System.out.println("str is = "+str);
		System.out.println("response created");
	}
}
