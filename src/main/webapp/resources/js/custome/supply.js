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

function addSupply(base) {
	window.location.href=base+"/add-supply";
}

function insertSupply(base) {
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

	jQuery('#add_supply').ajaxForm({
		success : function(res) {
			if (res == 'OK') {
				showMsg("Supply added successfully");
				window.location.href = base + "/supply";
			}

			if (res == 'ERROR') {
				showMsg("Have some error.");
			}
		},
		dataType : "text"
	}).submit();
}

function editSupply(base, id) {
	window.location.href=base+"/edit-supply/"+id;
}

function editSupplyDetails(base){
	
	jQuery('#edit_supply').ajaxForm({
    success:function(res) {
    	if(res == 'OK'){
    		window.location.href=base+"/supply";
	    }
     },
     dataType:"text"
   }).submit();
}

function deletesupply(base, id) {
	
	var i = confirm("Archiving Supply id :"+id);
	
	if(i){
		window.location.href=base+"/deletesupply/"+id;
	}
}

function deleteSupplyImage(id) {
	
	var imid = jQuery('#old_supply_photos'+id).val();
	
	var param = jQuery('#delete_supply_photos').val();
	if(param==""){
		jQuery('#delete_supply_photos').val(imid);
	} else{
		jQuery('#delete_supply_photos').val(param+","+imid);
	}
	
	jQuery('#old_div_photos'+id).remove();
	
}