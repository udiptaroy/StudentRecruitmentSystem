package Methods;
import Pojo.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
public class UserOperations {
	 Connection conn=DBConnection.getInstance().getConnection();
public boolean createAccount(User user){
	boolean result=false;
	PreparedStatement preparedstatement=null, preparedstatement1 = null;
	  try {
		  String uname=user.getUsername();
		  String name=user.getName();
		  String pwd=user.getPassword();
		  String email=user.getEmail();
		  String address=user.getAddress();
		  String state=user.getState();
		  String country=user.getCountry();
		  String ssn=user.getSsn();
		  String county=user.getCounty();
		 		  preparedstatement=conn.prepareStatement("use project_2;");
			preparedstatement.execute();
			 preparedstatement1=conn.prepareStatement("call createaccount('"+uname+"','"+name+"','"+pwd+"','"+email+"','"+address+"','"+state+"','"+country+"','"+ssn+"','"+county+"')");
			preparedstatement1.execute();
			result=true;	
			return result;
	    }catch (SQLException sql) {

	        System.out.println(sql.getMessage());
	        return result;
	          }
	
}
public boolean updateAccount(User user){
	boolean result=false;
	PreparedStatement preparedstatement=null, preparedstatement1 = null;
	  try {
		  
		  String uname=user.getUsername();
		  String name=user.getName();
		  String pwd=user.getPassword();
		  String email=user.getEmail();
		  String address=user.getAddress();
		  String state=user.getState();
		  String country=user.getCountry();
		  String ssn=user.getSsn();
		  String county=user.getCounty();
		  Connection conn=DBConnection.getInstance().getConnection();
		  preparedstatement=conn.prepareStatement("use project_2;");
			preparedstatement.execute();
			 preparedstatement1=conn.prepareStatement("call updateaccount('"+uname+"','"+name+"','"+pwd+"','"+email+"','"+address+"','"+state+"','"+country+"','"+ssn+"','"+county+"')");
			preparedstatement1.execute();
			result=true;
	       return result;
	    }catch (SQLException sql) {

	        System.out.println(sql.getMessage());
	        return result;
	          }

}

public String createApp(Application app){
	String result="";
	PreparedStatement preparedstatement=null, preparedstatement1 = null;
	
	  try {
		 int gre=app.getGre();
		 double ielts=app.getIelts();
		 double gpa=app.getGpa();
		 String interest=app.getInterest();
		 String username=app.getUserName();
		 String programName=app.getProgramName();
		 String degTitle=app.getDegreeTitle();
		 String term=app.getTerm();
		 int year=app.getYear();
			  preparedstatement=conn.prepareStatement("use project_2;");
			preparedstatement.execute();
			 preparedstatement1=conn.prepareStatement("call createApp("+gre+","+ielts+","+gpa+",'"+interest+"','"+username+"','"+programName+"','"+degTitle+"','"+term+"',"+year+")");
			preparedstatement1.execute();
			result="SUCCESS";	
       return result;
	    }catch (SQLException sql) {
	    	result = sql.getMessage();
	        System.out.println(sql.getMessage());
	        return result;
	          }

}

public ArrayList<String> trackStatus(String username){
	PreparedStatement preparedstatement=null, preparedstatement1 = null;
	ArrayList<String> status=new ArrayList<String>();
	  try {
		  	 
		 	  preparedstatement=conn.prepareStatement("use project_2;");
			preparedstatement.execute();
			 String sql="select aph.programname,ad.title,apf.term,apf.year,af.status from app_for apf, applicationfills af, academicprogram_has aph,"
					 +" "+"academicdegree ad where apf.a_id=af.a_id  and aph.program_id=apf.program_id and ad.degreeid=apf.degreeid and af.U_Name='"+username+"'";
			 preparedstatement1=conn.prepareStatement(sql);
			 ResultSet rs=preparedstatement1.executeQuery();
			 while(rs.next()){
				 	status.add(username);
				 	status.add(rs.getString(1));
			 		status.add(rs.getString(2));
			 		status.add(rs.getString(3));
			 		status.add(""+rs.getInt(4));
			 		status.add(rs.getString(5));
			 }
			preparedstatement1.execute();
	       return status;
	    }catch (SQLException sql) {

	        System.out.println(sql.getMessage());
	        return status;
	          }

}

public boolean login(String username, String pwd){
	boolean result=false;
	PreparedStatement preparedstatement=null, preparedstatement1 = null;
	  try {
		  	  preparedstatement=conn.prepareStatement("use project_2;");
			preparedstatement.execute();
			 String sql="select * from User where U_name='"+username+"' and password='"+pwd+"'";
			 preparedstatement1=conn.prepareStatement(sql);
			 ResultSet rs=preparedstatement1.executeQuery();
			 while(rs.next())
			result=true;
	       return result;
	    }catch (SQLException sql) {

	        System.out.println(sql.getMessage());
	        return result;
	          }

}

public ArrayList<String> getProgramName(){
	ArrayList<String> program=new ArrayList<String>();
	PreparedStatement preparedstatement=null, preparedstatement1 = null;
	  try {
		  	  preparedstatement=conn.prepareStatement("use project_2;");
			preparedstatement.execute();
			 String sql="select programname from AcademicProgram_Has";
			 preparedstatement1=conn.prepareStatement(sql);
			 ResultSet rs=preparedstatement1.executeQuery();
			 while(rs.next())
				 program.add(rs.getString("programname"));
	       return program;
	    }catch (SQLException sql) {

	        System.out.println(sql.getMessage());
	        return program;
	          }

}


public ArrayList<String> getTitle(){
	ArrayList<String> title=new ArrayList<String>();
	PreparedStatement preparedstatement=null, preparedstatement1 = null;
	  try {
		  	  preparedstatement=conn.prepareStatement("use project_2;");
			preparedstatement.execute();
			 String sql="select title from AcademicDegree";
			 preparedstatement1=conn.prepareStatement(sql);
			 ResultSet rs=preparedstatement1.executeQuery();
			 while(rs.next())
				 title.add(rs.getString("title"));
	       return title;
	    }catch (SQLException sql) {

	        System.out.println(sql.getMessage());
	        return title;
	          }

}


public static void main(String[] args){
	//User user=new User(",jwhrjt2","fdb,em","gDWFrehghg","fwg@wwg.c","rege","GA","IN","123-34-1234","MK");
	
	//Application app=new Application(312,7.2,3.5,"IT",",jwhrjt2","IT","MS","Spring",2015);
	UserOperations uo=new UserOperations();
	//uo.createAccount(user);
	System.out.println(uo.trackStatus("Udipta"));
	
	
}
}
