function showMsg(msg,tit) {
	$("#dialog").dialog({
		title:tit,
	    show: {
	    	effect: "blind",
	        duration: 500
	    },
	    hide: {
	        effect: "blind",
	        duration: 500
	    }
	}).html(msg);
}

function logout(base){
	window.location.href=base+"/user/logout";
}

function editMember(base, id)
{
	window.location.href=base+"/memberedit/"+id;
}

function memberregistration(base,callFrom){
	var firstname = jQuery('#first-name').val();
	var email = jQuery('#email').val();
	var password = jQuery('#password').val();
	var confirmpassword = jQuery('#confirm-password').val();
	
	var fo = false;
	var msg = "Please fill required field:</br>";
	if(firstname == "")
	{
		fo = true;
		msg = msg + "* First Name</br>";
	}
	if(email == "")
	{
		fo = true;
		msg = msg + "* Email</br>";
	}
	if(password == "")
	{
		fo = true;
		msg = msg + "* Password</br>";
	}
	if(confirmpassword == "")
	{
		fo = true;
		msg = msg + "* Confirm-Password</br>";
	}
	if(password != confirmpassword)
	{
		fo = true;
		msg = msg + "* Password not matched with Confirm-Password</br>";
	}
		
	if(fo)
	{
		showMsg(msg,"Error");
		//alert(msg);
		return;
	}
	
	jQuery('#registrationform').ajaxForm({
    success:function(res) {
    	if(res == 'OK'){
    		if(callFrom == 1){
    			showMsg("Dear "+firstname+",</br>Your account was successfully Created. </br>Please Verify your account by checking your mail shortly.","Register Successfull");
    		} else{
    			window.location.href=base+"/member";
    			showMsg("Member account was successfully Created. </br>He/She can Verify his/her account by checking his/her mail shortly.","Register Successfull");
    		}
	 	   	
	    }
    	
    	if(res == 'PASS'){
    		showMsg("Password not Matched.");
    	}
    	
    	if(res == 'EXIST'){
    		showMsg("User already exist with this email address.</br>Please try with another email.");
    	}
    	
    	if(res == 'ERROR'){
    		showMsg("Have some error.");
    	}
     },
     dataType:"text"
   }).submit();
}



function memberdetail(base){
	jQuery('#msform').ajaxForm({
    success:function(res) {
    	if(res == 'OK'){
    		window.location.href=base+"/";
	    }
    	
    	/*if(res == 'PASS'){
    		showMsg("Password not Matched.");
    	}
    	
    	if(res == 'ERROR'){
    		showMsg("Have some error.");
    	}*/
     },
     dataType:"text"
   }).submit();
}

function memberdetailedit(base){
	if($('#fname').val()=='') {
		showMsg("First Name required","Error");
		return;
	}
	
	if($('#fdname').val()=='') {
		showMsg("First Name Japanese required","Error");
		return;
	}
	
	if($('#lname').val()==''){
		showMsg("Last Name required","Error");
		return;
	}
	
	if($('#ldname').val()==''){
		showMsg("Last Name Japanese required","Error");
		return;
	}
	
	if($('#fname').val()=='') {
		showMsg("Fast Name required","Error");
		return;
	}
	
	if($('#adr').val()==''){
		showMsg("Address required","Error");
		return;
	}
	
	if($('#adrj').val()==''){
		showMsg("Address Japanes required","Error");
		return;
	}
	
	if($('#cna').val()==''){
		showMsg("Company name","Error");
		return;
	}
	
	if($('#cnj').val()==''){
		showMsg("Company name required","Error");
		return;
	}
	
	jQuery('#formedit').ajaxForm({
    success:function(res) {
    	if(res == 'OK'){
    		window.location.href=base+"/member";
	    }
    	
    	/*if(res == 'PASS'){
    		showMsg("Password not Matched.");
    	}
    	
    	if(res == 'ERROR'){
    		showMsg("Have some error.");
    	}*/
     },
     dataType:"text"
   }).submit();
}

function deleteMember(base, id)
{
	var i = confirm("Archiving user id :"+id);
	
	if(i){
		window.location.href=base+"/memberdelete/"+id;
	}
}

function addnewmember(base)
{
	window.location.href=base+"/addnewmember";
}

function addnewbrand(base)
{
	window.location.href=base+"/addnewbrand";
}

function brandregistration(base)
{
	var bn = jQuery('#bn').val();
	var bnj = jQuery('#bnj').val();
	
	var fo = false;
	var msg = "Please fill required field:</br>";
	if(bn == "")
	{
		fo = true;
		msg = msg + "* Brand Name</br>";
	}
	if(bnj == "")
	{
		fo = true;
		msg = msg + "* Brand Name Japanese</br>";
	}
			
	if(fo)
	{
		showMsg(msg,"Error");
		//alert(msg);
		return;
	}
	
	jQuery('#brandform').ajaxForm({
    success:function(res) {
    	if(res == 'OK'){
    		//showMsg("Brand was successfully Created.","Successfull");
    		window.location.href=base+"/brand";
    	}
    	
    	/*if(res == 'PASS'){
    		showMsg("Password not Matched.");
    	}
    	
    	if(res == 'EXIST'){
    		showMsg("User already exist with this email address.</br>Please try with another email.");
    	}*/
    	
    	if(res == 'ERROR'){
    		showMsg("Have some error.");
    	}
     },
     dataType:"text"
   }).submit();
}

function editBrand(base, id)
{
	window.location.href=base+"/brandedit/"+id;
}

function branddetailedit(base){
	var bn = jQuery('#bn').val();
	var bnj = jQuery('#bnj').val();
	
	var fo = false;
	var msg = "Please fill required field:</br>";
	if(bn == "")
	{
		fo = true;
		msg = msg + "* Brand Name</br>";
	}
	if(bnj == "")
	{
		fo = true;
		msg = msg + "* Brand Name Japanese</br>";
	}
			
	if(fo)
	{
		showMsg(msg,"Error");
		//alert(msg);
		return;
	}
		
	jQuery('#brandeditform').ajaxForm({
    success:function(res) {
    	if(res == 'OK'){
    		window.location.href=base+"/brand";
	    }
    	
    	/*if(res == 'PASS'){
    		showMsg("Password not Matched.");
    	}
    	
    	if(res == 'ERROR'){
    		showMsg("Have some error.");
    	}*/
     },
     dataType:"text"
   }).submit();
}

function deleteBrand(base, id)
{
	var i = confirm("Archiving Brand id :"+id);
	
	if(i){
		window.location.href=base+"/branddelete/"+id;
	}
}

function addnewCategory(base)
{
	window.location.href=base+"/addnewcategory";
}

function categoryregistration(base)
{
	var bn = jQuery('#ctgna').val();
	var bnj = jQuery('#ctgnj').val();
	
	var fo = false;
	var msg = "Please fill required field:</br>";
	if(bn == "")
	{
		fo = true;
		msg = msg + "* Category Name</br>";
	}
	if(bnj == "")
	{
		fo = true;
		msg = msg + "* Category Name Japanese</br>";
	}
			
	if(fo)
	{
		showMsg(msg,"Error");
		//alert(msg);
		return;
	}
	
	jQuery('#categoryform').ajaxForm({
    success:function(res) {
    	if(res == 'OK'){
    		//showMsg("Brand was successfully Created.","Successfull");
    		window.location.href=base+"/category";
    	}
    	if(res == 'ERROR'){
    		showMsg("Have some error.");
    	}
     },
     dataType:"text"
   }).submit();
}

function editcategory(base, id)
{
	window.location.href=base+"/categoryedit/"+id;
}

function deletecategory(base, id)
{
	var i = confirm("Archiving Category id :"+id);
	
	if(i){
		window.location.href=base+"/categorydelete/"+id;
	}
}

function categorydetailedit(base){
	var bn = jQuery('#bn').val();
	var bnj = jQuery('#bnj').val();
	
	var fo = false;
	var msg = "Please fill required field:</br>";
	if(bn == "")
	{
		fo = true;
		msg = msg + "* Brand Name</br>";
	}
	if(bnj == "")
	{
		fo = true;
		msg = msg + "* Brand Name Japanese</br>";
	}
			
	if(fo)
	{
		showMsg(msg,"Error");
		//alert(msg);
		return;
	}
		
	jQuery('#categoryeditform').ajaxForm({
    success:function(res) {
    	if(res == 'OK'){
    		window.location.href=base+"/category";
	    }
    	
    	/*if(res == 'PASS'){
    		showMsg("Password not Matched.");
    	}
    	
    	if(res == 'ERROR'){
    		showMsg("Have some error.");
    	}*/
     },
     dataType:"text"
   }).submit();
}

//Currency
function addnewCurrency(base)
{
	window.location.href=base+"/addnewcurrency";
}

function currencyregistration(base)
{
	var curn = jQuery('#curn').val();
	
	var fo = false;
	var msg = "Please fill required field:</br>";
	if(curn == "")
	{
		fo = true;
		msg = msg + "* Currency Name</br>";
	}
			
	if(fo)
	{
		showMsg(msg,"Error");
		//alert(msg);
		return;
	}
	
	jQuery('#currencyform').ajaxForm({
    success:function(res) {
    	if(res == 'OK'){
    		//showMsg("Brand was successfully Created.","Successfull");
    		window.location.href=base+"/currency";
    	}
    	if(res == 'ERROR'){
    		showMsg("Have some error.");
    	}
     },
     dataType:"text"
   }).submit();
}

function editcurrency(base, id)
{
	window.location.href=base+"/currencyedit/"+id;
}

function currencydetailedit(base){
	var curn = jQuery('#curn').val();
	
	var fo = false;
	var msg = "Please fill required field:</br>";
	if(curn == "")
	{
		fo = true;
		msg = msg + "* Currency Name</br>";
	}
				
	if(fo)
	{
		showMsg(msg,"Error");
		//alert(msg);
		return;
	}
		
	jQuery('#currencyeditform').ajaxForm({
    success:function(res) {
    	if(res == 'OK'){
    		window.location.href=base+"/currency";
	    }
    	
    	/*if(res == 'PASS'){
    		showMsg("Password not Matched.");
    	}
    	
    	if(res == 'ERROR'){
    		showMsg("Have some error.");
    	}*/
     },
     dataType:"text"
   }).submit();
}

function deletecurrency(base, id)
{
	var i = confirm("Archiving Currency code :"+id);
	
	if(i){
		window.location.href=base+"/currencydelete/"+id;
	}
}

//Shipping
function addnewShipping(base)
{
	window.location.href=base+"/addnewshipping";
}

function shippingregistration(base)
{
	var smtn = jQuery('#smtn').val();
	
	var fo = false;
	var msg = "Please fill required field:</br>";
	if(smtn == "")
	{
		fo = true;
		msg = msg + "* Shipping Name</br>";
	}
			
	if(fo)
	{
		showMsg(msg,"Error");
		//alert(msg);
		return;
	}
	
	jQuery('#shippingform').ajaxForm({
    success:function(res) {
    	if(res == 'OK'){
    		//showMsg("Brand was successfully Created.","Successfull");
    		window.location.href=base+"/shipping";
    	}
    	if(res == 'ERROR'){
    		showMsg("Have some error.");
    	}
     },
     dataType:"text"
   }).submit();
}

function editshipping(base, id)
{
	window.location.href=base+"/shippingedit/"+id;
}

function shippingdetailedit(base){
	var smtn = jQuery('#smtn').val();
	
	var fo = false;
	var msg = "Please fill required field:</br>";
	if(smtn == "")
	{
		fo = true;
		msg = msg + "* Shipping Name</br>";
	}
				
	if(fo)
	{
		showMsg(msg,"Error");
		//alert(msg);
		return;
	}
		
	jQuery('#shippingeditform').ajaxForm({
    success:function(res) {
    	if(res == 'OK'){
    		window.location.href=base+"/shipping";
	    }
    	
    	/*if(res == 'PASS'){
    		showMsg("Password not Matched.");
    	}
    	
    	if(res == 'ERROR'){
    		showMsg("Have some error.");
    	}*/
     },
     dataType:"text"
   }).submit();
}

function deleteshipping(base, id)
{
	var i = confirm("Archiving Shipping code :"+id);
	
	if(i){
		window.location.href=base+"/shippingdelete/"+id;
	}
}

function readURL(input,id,width,height) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#'+id)
                .attr('src', e.target.result)
                .width(width)
                .height(height);
        };

        reader.readAsDataURL(input.files[0]);
    }
}
