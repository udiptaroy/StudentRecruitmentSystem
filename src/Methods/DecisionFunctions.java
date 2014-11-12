package Methods;
import Pojo.Application;
import Pojo.createApplication;
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
@WebServlet("/DecisionFunctions")
public class DecisionFunctions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DecisionFunctions() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String requestName = request.getParameter("requestName");
			AdminOps ao=new AdminOps();
		if(requestName.equalsIgnoreCase("getCreateApps")){
			ArrayList<createApplication> ca = ao.fetchApplications();
			 response.getWriter().write(new Gson().toJson(ca));
				System.out.println("str is = "+ca);
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
