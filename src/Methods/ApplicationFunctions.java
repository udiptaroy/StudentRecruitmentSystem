package Methods;
import Pojo.Application;

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
@WebServlet("/ApplicationFunctions")
public class ApplicationFunctions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ApplicationFunctions() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String requestName = request.getParameter("requestName");
		UserOperations up = new UserOperations();
		
		if(requestName.equalsIgnoreCase("getProgramName")){
			ArrayList<String> s = up.getProgramName();
			 response.getWriter().write(new Gson().toJson(s));
				System.out.println("str is = "+s);
				System.out.println("response created");
		}else if(requestName.equalsIgnoreCase("getTitle")){
			ArrayList<String> s = up.getTitle();
		response.getWriter().write(new Gson().toJson(s));
			System.out.println("str is = "+s);
			System.out.println("response created");
		}
		else if(requestName.equalsIgnoreCase("getStatus")){
			HttpSession session=request.getSession();
			String username=(String)session.getAttribute("user");
			ArrayList<String> s = up.trackStatus(username);
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
		int gre=Integer.parseInt(request.getParameter("gre"));
		double ielts=Double.parseDouble(request.getParameter("ielts"));
		double gpa=Double.parseDouble(request.getParameter("gpa"));
		String interest=request.getParameter("interest");
		String program=request.getParameter("program");
		String title=request.getParameter("degree");
		String term=request.getParameter("term");
		int year =Integer.parseInt(request.getParameter("year"));
		Application app=new Application(gre,ielts,gpa,interest,username,program,title,term,year);
		UserOperations uo= new UserOperations();
		
		boolean res=uo.createApp(app);
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
