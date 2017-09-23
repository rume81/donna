function myKeyPress(base,e){
    if(e.keycode == 13){
    	loginValided(base);
    }
}

function loginValided(base){
	
	var pid = jQuery('#pid').val();
	var pass = jQuery('#password').val();
	
	if(pid == '')
	{
		jQuery('#errorMsg').html('* Please insert member id').show();
		return false;
	} else{
		jQuery('#errorMsg').html('').hide();
	}
	
	if(pass == '')
	{
		jQuery('#errorMsg').html('* Please enter your password').show();
		return false;
	} else{
		jQuery('#errorMsg').html('').hide();
	}
	
	var pars =  pid+"~"+pass;
	ajaxHelper.complexAjaxExecute(base+"/users/valideduser", pars, function(res){
		
	   	if(res=="-1"){
	   		jQuery('#errorMsg').html('Invalid member id or password').show();
	    } else if(res=="-2"){
	   		jQuery('#errorMsg').html('Please check your mail and verify your account').show();
	    } else if(res=="-3"){
	    	jQuery('#errorMsg').html('').hide();
	    	window.location.href=base+"/memberdetailregistration";
	    } else{
	    	jQuery('#errorMsg').html('').hide();
	    	window.location.href=base+"/home";
	    }
	 });
}

function logout(base){
	
	var pars =  "";
	ajaxHelper.complexAjaxExecute(base+"/user/logout", pars, function(res){
	   	if(res!="-1"){
	   		window.location.href=base+"/user/login";
	    }
	 });
}