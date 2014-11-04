package Methods;
import Pojo.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
public class UserOperations {
public boolean createAccount(User user){
	boolean result=false;
	PreparedStatement preparedstatement=null, preparedstatement1 = null,preparedstatement3=null,preparedstatement4=null;
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
			 preparedstatement1=conn.prepareStatement("insert into User values ('"+uname+"','"
					 +name+"','"+pwd+"','"+address+"','"+email+"')");
			result=preparedstatement1.execute();
			preparedstatement3=conn.prepareStatement("insert into prospective_students values ('A1236',"+uname+"')");
			result=preparedstatement3.execute();
			if(country.equals("US")&& state.equals("NC")){
				preparedstatement4=conn.prepareStatement("insert into instate values ('"+uname+"',"+ssn+"',"+county+"','A1236')");
				result=preparedstatement3.execute();
			}
			else if(country.equals("US") && !(state.equals("NC"))){
				preparedstatement4=conn.prepareStatement("insert into outstate values ('"+uname+"',"+ssn+"',"+state+"','A1236')");
				result=preparedstatement4.execute();
			}
			else if(!country.equals("US")){
				preparedstatement4=conn.prepareStatement("insert into international values ('"+uname+"',"+country+"','A1236')");
				result=preparedstatement4.execute();
			}
				
			conn.close();
	       return result;
	    }catch (SQLException sql) {

	        System.out.println(sql.getMessage());
	        return result;
	          }
	
}
public static void main(String[] args){
	User user=new User(">MNFN","fdb,em","grehghg","fwg@wwg.c","rege","NC","US","123-34-1234","MK");
	UserOperations uo=new UserOperations();
	System.out.println(uo.createAccount(user));
	
	
}
}
