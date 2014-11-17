package Pojo;

public class createApplication {
	private String A_id;
	private String username;
	private String programName;
	private String degTitle;
	private String term;
	private String year;
	private String status;
	
	public createApplication(String appid,String uname,String pName,String dtitle,String trm,String yr,String sts){
		this.username=uname;
		this.programName=pName;
		this.degTitle=dtitle;
		this.term=trm;
		this.year=yr;
		this.status=sts;
		this.A_id=appid;
	}

	public String getUsername() {
		return username;
	}
	public String getAid() {
		return A_id;
	}

	public String getProgramName() {
		return programName;
	}

	public String getDegTitle() {
		return degTitle;
	}

	public String getTerm() {
		return term;
	}

	public String getYear() {
		return year;
	}

	public String getStatus() {
		return status;
	}
	

}
