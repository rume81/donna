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

function addSettlement(base) {
	window.location.href=base+"/add-settlement";
}

function insertSettlement(base) {
	var stln 	= jQuery('#stln').val();

	var fo = false;
	var msg = "Please fill required field:</br>";
	if (stln == "") {
		fo = true;
		msg = msg + "* Settlement Name</br>";
	}

	if (fo) {
		showMsg(msg, "Error");
		// alert(msg);
		return;
	}

	jQuery('#add_settlement').ajaxForm({
		success : function(res) {
			if (res == 'OK') {
				showMsg("Settlement added successfully");
				window.location.href = base + "/settlement";
			}

			if (res == 'ERROR') {
				showMsg("Have some error.");
			}
		},
		dataType : "text"
	}).submit();
}

function editSettlement(base, id) {
	window.location.href=base+"/edit-settlement/"+id;
}

function editSettlementDetails(base){
	
	jQuery('#edit_settlement').ajaxForm({
    success:function(res) {
    	if(res == 'OK'){
    		window.location.href=base+"/settlement";
	    }
     },
     dataType:"text"
   }).submit();
}

function deleteSettlement(base, id) {
	var i = confirm("Archiving Supply id :"+id);	
	if(i){
		window.location.href=base+"/settlementdelete/"+id;
	}
}