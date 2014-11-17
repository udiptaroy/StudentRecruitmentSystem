package Pojo;

public class Application {
	private int gre;
	private double ielts;
	private double gpa;
	private String interest;
	private String userName;
	private String programName;
	private String degreeTitle;
	private String Term;
	private int year;
	
	public Application(){
		
	}
	public Application (int Gre, double Ielts, double Gpa, String Interest,String uname,String pName,String degTitle,String term,int yr ){
		this.gre=Gre;
		this.ielts=Ielts;
		this.gpa=Gpa;
		this.interest=Interest;
		this.userName=uname;
		this.programName=pName;
		this.degreeTitle=degTitle;
		this.Term=term;
		this.year=yr;
	}


	public int getGre() {
		return gre;
	}

	public double getIelts() {
		return ielts;
	}

	public double getGpa() {
		return gpa;
	}

	public String getInterest() {
		return interest;
	}

	public String getUserName() {
		return userName;
	}

	public String getProgramName() {
		return programName;
	}

	public String getDegreeTitle() {
		return degreeTitle;
	}

	public String getTerm() {
		return Term;
	}

	public int getYear() {
		return year;
	}
	
	

}
