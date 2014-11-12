
$(document).ready(function(){ 
	
	$.getJSON( "DecisionFunctions?requestName=getCreateApps", function(result) {
		   /*for (var i = 0; i < result.length; i++) {
			$('#dectl').append($("<tr>"));
	    	$('#dectl').append($("<td>"+result[i].username+"</td>"));
	    	$('#dectl').append($("<td>"+result[i].programName+"</td>"));
	    	$('#dectl').append($("<td>"+result[i].degTitle+"</td>"));
	    	$('#dectl').append($("<td>"+result[i].term+"</td>"));
	    	$('#dectl').append($("<td>"+result[i].year+"</td>"));
	    	$('#dectl').append($("<td></td>"));
	    	$('#dectl').append($("</tr>"));
	     
	    }*/
		var textToInsert = '';
		 
        for (var i = 0; i < result.length; i++) {
        	textToInsert  += '<tr><td>' + result[i].username + '</td>';
        	textToInsert  += '<td>' + result[i]. programName + '</td>';
        	textToInsert  += '<td>' + result[i]. degTitle + '</td>';
        	textToInsert  += '<td>' + result[i]. term + '</td>';
        	textToInsert  += '<td>' + result[i]. year + '</td>';
        	textToInsert  += '<td><select><option value="A">Accept</option><option value="D">Decline</option></select></td></tr>';
      }
        $("#dectl").append(textToInsert);	
	});
	            
       
     });
