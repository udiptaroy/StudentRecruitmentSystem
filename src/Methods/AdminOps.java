package Methods;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Pojo.DBConnection;

public class AdminOps {
	Connection conn=DBConnection.getInstance().getConnection();
	public void fetchApplications(){
		PreparedStatement preparedstatement=null, preparedstatement1 = null;
		
		  try {
			   
			  preparedstatement=conn.prepareStatement("use project_2;");
				preparedstatement.execute();
				 String sql="select * from applicationfills af where af.status is null";
				 preparedstatement1=conn.prepareStatement(sql);
				 ResultSet rs=preparedstatement1.executeQuery();
				 while(rs.next())
					 System.out.println(rs.getInt(1)+"   "+rs.getDouble(2)+"   "+rs.getDouble(3)+"   "+rs.getInt(4)+"   "+rs.getString(5)+"   "+rs.getString(6)+"   "+rs.getString(7));
					    
		    }catch (SQLException sql) {

		        System.out.println(sql.getMessage());
		        	
	}

}
	public boolean updateApplications(int A_id, String status){
		PreparedStatement preparedstatement=null, preparedstatement1 = null;
		boolean result=false;
		  try {
			  
					  preparedstatement=conn.prepareStatement("use project_2;");
				preparedstatement.execute();
				 preparedstatement1=conn.prepareStatement("update ApplicationFills af set af.status='"+status+"' where af.a_id="+A_id);
				preparedstatement1.execute();
				result=true;	
		       return result;
		    }catch (SQLException sql) {

		        System.out.println(sql.getMessage());
		        return result;
		          }

}

	public static void main(String[] args){
		AdminOps ao= new AdminOps();
ao.fetchApplications();
	}
}
