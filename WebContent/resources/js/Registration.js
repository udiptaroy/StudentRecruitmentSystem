
$(document).ready(function(){ 
	$("#lblDisplayMsg").text("");
	$("#lblDisplayMsg1").text("");
     });

function mySubmitFunction(){
	value = $('#frm1').serialize();
    $.ajax({
 	type: "POST",
     url: "LoginFunctions",
     data: value,
     dataType: "json",
     success: function(data) {
     	if(data =="true"){
     		  window.location="http://localhost:8080/StudentRecruitmentSystem/StudentHome.html";
     	}
     	else{
     		//alert("User not found");
     		$("#lblDisplayMsg").text("User not found in System. Kindly register.");
     	}
     }
});
}

function mySubmitFunctionForm2(){
	 value = $('#frm2').serialize();
     $.ajax({
  	type: "POST",
      url: "RegistrationFunctions",
      data: value,
      dataType: "json",
      //if received a response from the server
      success: function(data) {
      	if(data =="true"){
      		  window.location="http://localhost:8080/StudentRecruitmentSystem/StudentHome.html";
      	}
      	else{
      		//alert("User not found");
      		$("#lblDisplayMsg1").text("Error in registration");
      	}
      	
           
      }
     });
}