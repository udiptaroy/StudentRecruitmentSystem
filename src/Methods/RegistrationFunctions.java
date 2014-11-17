package Methods;
import Pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;

import com.google.gson.Gson;

/**
 * Servlet implementation class LoginFunctions
 */
@WebServlet("/RegistrationFunctions")
public class RegistrationFunctions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrationFunctions() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String username;
		username=request.getParameter("uname");
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
		boolean res=uo.createAccount(user);
		if(res){
		createJsonObject(response,"true");
		HttpSession session=request.getSession();
		session.setAttribute("user",  username);
		}
		else
			createJsonObject(response,"false");
			}

	private void createJsonObject(HttpServletResponse response,String str) throws IOException{
		response.getWriter().write(new Gson().toJson(str));
		System.out.println("str is = "+str);
		System.out.println("response created");
	}
}
