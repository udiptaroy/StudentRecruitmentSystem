package Methods;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Pojo.AppDecisionList;
import Pojo.DBConnection;
import Pojo.createApplication;

public class AdminOps {
	Connection conn=DBConnection.getInstance().getConnection();
	public ArrayList<createApplication> fetchApplications(){
		PreparedStatement preparedstatement=null, preparedstatement1 = null;
		ArrayList<createApplication> ca=new ArrayList<createApplication>();	
		  try {
			   
			  preparedstatement=conn.prepareStatement("use project_2;");
				preparedstatement.execute();
				 String sql="select af.U_Name,aph.programname,ad.title,apf.term,apf.year,af.status from app_for apf, applicationfills af, academicprogram_has aph,"
						 +" "+"academicdegree ad where apf.a_id=af.a_id  and aph.program_id=apf.program_id and ad.degreeid=apf.degreeid and af.status is null";
				 preparedstatement1=conn.prepareStatement(sql);
				 ResultSet rs=preparedstatement1.executeQuery();
				 while(rs.next()){
					createApplication c=new createApplication(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),""+rs.getInt(5),rs.getString(6)); 	
					 	ca.add(c);
				 }
				preparedstatement1.execute();
		       return ca;
		    }catch (SQLException sql) {

		        System.out.println(sql.getMessage());
		        return ca;
		          }

}
	
	public String updateEntireApplication(ArrayList<AppDecisionList> input){
		String result = "SUCCESS";
		for (AppDecisionList eachItem : input){
			if(updateApplications(eachItem.getId(),eachItem.getStatus()) == false){
				result = "Error in updating application";
				break;
			}
		}
		return result;
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
