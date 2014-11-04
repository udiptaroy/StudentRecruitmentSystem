package Pojo;

public class User {
private String username;
private String name;
private String password;
private String email;
private String address;
private String state;
private String country;
private String ssn;
private String county;

public User(String UName,String Name,String Pwd,String Email,String Addrs,String State,String Cntry,String SSN,String Cnty){
	this.username=UName;
	this.name=Name;
	this.password=Pwd;
	this.email=Email;
	this.address=Addrs;
	this.state=State;
	this.country=Cntry;
	this.ssn=SSN;
	this.county=Cnty;
}

public String getUsername() {
	return username;
}

public String getName() {
	return name;
}

public String getPassword() {
	return password;
}

public String getEmail() {
	return email;
}

public String getAddress() {
	return address;
}

public String getState() {
	return state;
}

public String getCountry() {
	return country;
}

public String getSsn() {
	return ssn;
}

public String getCounty() {
	return county;
}

}
