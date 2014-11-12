package Methods;
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
@WebServlet("/LoginFunctions")
public class LoginFunctions extends HttpServlet {
	HttpSession session;
	private static final long serialVersionUID = 1L;
       
    public LoginFunctions() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String username;
		username=request.getParameter("uname2");
		String pwd = null;
		pwd=request.getParameter("password2");
		UserOperations uo= new UserOperations();
		boolean res=uo.login(username, pwd);
		if(res){
			HttpSession session=request.getSession();
			session.setAttribute("user",  username);
			createJsonObject(response,"true");
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
