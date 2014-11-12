package Pojo;

public class createApplication {
	private String username;
	private String programName;
	private String degTitle;
	private String term;
	private String year;
	private String status;
	
	public createApplication(String uname,String pName,String dtitle,String trm,String yr,String sts){
		this.username=uname;
		this.programName=pName;
		this.degTitle=dtitle;
		this.term=trm;
		this.year=yr;
		this.status=sts;
	}

	public String getUsername() {
		return username;
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
