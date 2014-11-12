
$(document).ready(function(){ 
    $("#frm5").submit( function()
            {
              value = $('#frm5').serialize();
                $.ajax({
             	type: "POST",
                 url: "LoginFunctions",
                 data: value,
                 dataType: "json",
                 //if received a response from the server
                 success: function(data) {
                	 window.location="http://localhost:8080/StudentRecruitmentSystem/Decision.html";
               /*  alert(data);
                          $("#msgid").html("");
                          $("#msgid").append("<b>Server data:</b> " + data + "");*/
                 	if(data =="true")
                 		  window.location="http://localhost:8080/StudentRecruitmentSystem/Decision.html";
                 	else{
                 		alert("User not found");
                 	}
                 	
                      
                 },
                 //If there was no resonse from the server
                 error: function(jqXHR, textStatus, errorThrown){
                      console.log("Something really bad happened " + textStatus);
                       $("#msgid").html(jqXHR.responseText);
                 },
                 
                 //capture the request before it was sent to server
                 beforeSend: function(jqXHR, settings){
                     settings.data += "&dummyData=whatever";
                     //disable the button until we get the response
                     $('#frm5').attr("disabled", true);
                 },
                 
                 //this is called after the response or error functions are finsihed
                 //so that we can take some action
                 complete: function(jqXHR, textStatus){
                     //enable the button 
                     $('#frm5').attr("disabled", false);
                 }
       
             });  
             
            }
            
         );
	            });

   