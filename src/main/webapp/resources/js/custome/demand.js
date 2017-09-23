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

function insertAssociation(base) {
	//alert("Message");
	var selRowDem 	= jQuery('#selRowDem').val();
	var selRowSup 	= jQuery('#selRowSup').val();
	
	var fo = false;
	
	var msg = "Please Select</br>";
	
	if (selRowDem == "") {
		fo = true;
		msg = msg + "* Demand </br>";
	}
	if (selRowSup == "") {
		fo = true;
		msg = msg + "* Supply </br>";
	}
	
	if (fo) {
		showMsg(msg, "Error");
		return;
	}
	
	jQuery('#insert_association').ajaxForm({
		success : function(res) {
			if (res == 'OK') {
				jQuery('#'+selRowDem).addClass("association");
				jQuery('#'+selRowSup).addClass("association");
				showMsg("Assocition Between Demand and Supply done successfully");
				window.location.href = base + "/association";
			}

			if (res == 'ERROR') {
				showMsg("Have some error.");
			}
		},
		dataType : "text"
	}).submit();
}

function adddemand(base) {
	var demand_code 	= jQuery('#demand_code').val();
	var brand 			= jQuery('#brand').val();
	var category 		= jQuery('#category').val();
	var product_type 	= jQuery('#product_type').val();
	var product_name 	= jQuery('#product_name').val();
	var product_amount 	= jQuery('#product_amount').val();
	var unit_count 		= jQuery('#unit_count').val();
	var price_per_unit 	= jQuery('#price_per_unit').val();
	var currency_types 	= jQuery('#currency_types').val();
	var product_description = jQuery('#product_description').val();
	var shipping_address = jQuery('#shipping_address').val();

	var fo = false;
	
	var msg = "Please fill required field:</br>";
	if (demand_code == "") {
		fo = true;
		msg = msg + "* Demand code</br>";
	}
	if (brand == "") {
		fo = true;
		msg = msg + "* Brand</br>";
	}
	if (category == "") {
		fo = true;
		msg = msg + "* Category</br>";
	}
	if (product_type == "") {
		fo = true;
		msg = msg + "* Product Type</br>";
	}
	if (product_name == "") {
		fo = true;
		msg = msg + "* Product Name</br>";
	}
	
	if (product_amount == "") {
		fo = true;
		msg = msg + "* Product Amount</br>";
	}
	if (unit_count == "") {
		fo = true;
		msg = msg + "* Unit Count</br>";
	}
	if (price_per_unit == "") {
		fo = true;
		msg = msg + "* Price per Unit</br>";
	}
	
	if (currency_types == "") {
		fo = true;
		msg = msg + "* Currency Types</br>";
	}
	if (shipping_address == "") {
		fo = true;
		msg = msg + "* Shipping Address</br>";
	}

	if (fo) {
		showMsg(msg, "Error");
		// alert(msg);
		return;
	}

	jQuery('#add_demand').ajaxForm({
		success : function(res) {
			if (res == 'OK') {
				showMsg("Demand added successfully");
				window.location.href = base + "/demand";
			}

			if (res == 'ERROR') {
				showMsg("Have some error.");
			}
		},
		dataType : "text"
	}).submit();
}

function editDemand(base, id) {
	window.location.href=base+"/edit-demand/"+id;
}

function editdemandDetails(base){
	
	jQuery('#editdemand').ajaxForm({
    success:function(res) {
    	if(res == 'OK'){
    		window.location.href=base+"/demand";
	    }
     },
     dataType:"text"
   }).submit();
}

function deleteDemand(base, id) {
	
	var i = confirm("Archiving Demand id :"+id);
	
	if(i){
		window.location.href=base+"/deleteDemand/"+id;
	}
}

function deleteDemandImage(id) {
	
	var imid = jQuery('#old_demand_photos'+id).val();
	
	var param = jQuery('#delete_demand_photos').val();
	if(param==""){
		jQuery('#delete_demand_photos').val(imid);
	} else{
		jQuery('#delete_demand_photos').val(param+","+imid);
	}
	jQuery('#old_div_photos'+id).remove();
	
}

function addDemand(base) {
	window.location.href=base+"/add-demand";
}