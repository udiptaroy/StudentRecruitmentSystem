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
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;

/**
 * Servlet implementation class DecisionFunctions
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
		   Gson gson = new Gson();
		   AdminOps adm = new AdminOps();
		   String result = ""; 
		    Map<String,String[]> uiData = request.getParameterMap();
		    Iterator entries = uiData.entrySet().iterator();
		
		    while (entries.hasNext()) {
		      Entry<String, String[]> thisEntry = (Entry) entries.next();
		      Object key = thisEntry.getKey();
		      String[] value = thisEntry.getValue();
		      if(adm.updateApplications(Integer.parseInt(value[0]), value[6]) == true)
		    	  result = "SUCCESS";
		      else{
		    	  result = "Error in saving application for user "+ value[1];
		    	  break;
		      }
		    }
		    
		    createJsonObject(response,result);
			}
	
	private void createJsonObject(HttpServletResponse response,String str) throws IOException{
		response.getWriter().write(new Gson().toJson(str));
		System.out.println("str is = "+str);
		System.out.println("response created");
	}
}
