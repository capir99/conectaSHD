
function getContent(destino) {
    //var url = /content/;
    var url = "";
    //create url to request fragment
    if (destino != "") {
		url = url + destino;
		//load fragment and replace content
        $('#replace_content').load(url);
	}
       
};
	
function getContentPagination(mod,pag) {
    //var url = /content/;
    var url = "";
    //create url to request fragment
    if (mod != "" &&  pag != "") {
		url = url + mod + "/" + pag;
		//load fragment and replace content
        $('#replace_content').load(url);
	}
       
};
     
function showAlert(){
  if($("#message").find("div#myAlert2").length==0){
    $("#message").append("<div class='alert alert-success alert-dismissable' id='myAlert2'> <button type='button' class='close' data-dismiss='alert'  aria-hidden='true'>&times;</button> ${message}");
  }
  $("#msg").css("display", "");
};


function validMessage(){
	var text = $('#msg').val();
	var typ = $('#typ').val();
	if (text != '') {
		switch (typ) {
		case "s":
		   $('#alert').attr('class', 'alert alert-success alert-dismissable');	
		   break;
		case "w":
		   $('#alert').attr('class', 'alert alert-warning alert-dismissable');
		   break;
		case "e":
		   $('#alert').attr('class', 'alert alert-danger alert-dismissable');
		   break;
		}
		$('.container').show().delay(4000).fadeOut();
		$('#message').html(text);
		
	}
	
};	
 

	
window.onload = function() {

  var url = "";
  //const queryString = window.location.search;
  //const urlParams = new URLSearchParams(queryString);
  //const param1 = urlParams.get('obj');
  //const param2 = urlParams.get('sen');
  const msg = $('#msg').val();
  const obj = $('#obj').val();
  const sen = $('#sen').val();
  if ( (obj != null || obj != '' ) && (sen != null || sen != '') ) {
	url = url + obj + "/";
	url = url + sen;
     $('#replace_content').load(url);
  }
 
};



 
//*************************************************************************************************** */ 

			

