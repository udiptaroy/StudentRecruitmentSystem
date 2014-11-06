package Methods;
import Pojo.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
public class UserOperations {
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
		  Connection conn=DBConnection.getInstance().getConnection();
		  preparedstatement=conn.prepareStatement("use project_2;");
			preparedstatement.execute();
			 preparedstatement1=conn.prepareStatement("call createaccount('"+uname+"','"+name+"','"+pwd+"','"+email+"','"+address+"','"+state+"','"+country+"','"+ssn+"','"+county+"')");
			preparedstatement1.execute();
			result=true;	
			conn.close();
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
			result=preparedstatement1.execute();
				
			conn.close();
	       return result;
	    }catch (SQLException sql) {

	        System.out.println(sql.getMessage());
	        return result;
	          }

}
public static void main(String[] args){
	User user=new User(",jwhrjt2","fdb,em","gDWFrehghg","fwg@wwg.c","rege","GA","IN","123-34-1234","MK");
	UserOperations uo=new UserOperations();
	System.out.println(uo.updateAccount(user));
	
	
}
}
