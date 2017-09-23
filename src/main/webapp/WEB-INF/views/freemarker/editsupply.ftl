<script type="text/javascript" src="${rc.contextPath}/js/custome/supply.js"></script>
<script type="text/javascript">
	var sph_id=1;
    $(document).ready(function(){
    	$("#delete_supply_photos").val("");
        $(".add-row").click(function(){
        	sph_id = sph_id+1;          
            var markup = "<div class='deman_photos'><input type='file' name='supply_photos"+sph_id+"' id='supply_photos"+sph_id +"' class='form-control' onchange=readURL(this,'supply_image"+sph_id+"',50,50)><img src='../images/avatar.png' alt='supply' height='50' width='50' name='supply_image"+sph_id+"' id='supply_image"+sph_id+"'/></div>";
            $(".demand_photos").append(markup);
            $("#sph_count").val(sph_id);
        });
    });    
</script>
<div class="col-md-10 open-account no-padding">
    <div class="col-sm-12 no-padding edit-heading">
        <div class="col-md-7">
            <h2>Edit Supply</h2>
        </div>
        <div class="col-md-5 user-id">
        </div>
    </div>
    <div class="col-md-7 col-md-offset-2 add-new-form">
        <form class="form-horizontal" name="edit_supply" id="edit_supply" action="${rc.contextPath}/editsupply" method="post" enctype="multipart/form-data">
            <input type="hidden" name="psid" id="psid" value="${supply.sid!''}">
            <div class="form-group">
                <label for="email" class="col-sm-4 control-label">Select Brand</label>
                <div class="col-sm-8">
                    <select class="form-control" name="brand" id="brand">
                        <#list brand as bn>
		                	<option value="${bn.brdc}" <#if supply.brdc == bn.brdc>selected</#if> >${bn.brdnj}</option>
		                </#list>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-4 control-label">Select Category</label>
                <div class="col-sm-8">
                    <select class="form-control" name="category" id="category">
                        <#list categories as cat>
		                	<option value="${cat.ctgc}" <#if supply.ctgc == cat.ctgc>selected</#if> >${cat.ctgnj}</option>
		                </#list>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label">Product type</label>
                <div class="col-sm-8">
                    <input type="text" name="product_type" class="form-control" id="product_type" value="${supply.pdtp!''}">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label">Product Name</label>
                <div class="col-sm-8">
                    <input type="text" name="product_name" class="form-control" id="product_name" value="${supply.pdnm!''}">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label">Amount of Product</label>
                <div class="col-sm-8">
                    <input type="text" name="product_amount" class="form-control" id="product_amount" value="${supply.dam!''}">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label">Unit of Count</label>
                <div class="col-sm-8">
                    <input type="text" name="unit_count"  id="unit_count" class="form-control" value="${supply.unt!''}">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label">Price per unit</label>
                <div class="col-sm-8">
                    <input type="text" name="price_per_unit"  id="price_per_unit" class="form-control" value="${supply.utp!''}">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label">Types of Currency</label>
                <div class="col-sm-8">
                    <select name="currency_types"  id="currency_types" class="form-control">
                    	<#list currencies as currency>
                    	<option value="${currency.curn}" <#if supply.curc!'' == currency.curn!''>selected</#if> >${currency.curn}</option>
                    	</#list>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label">Product Description</label>
                <div class="col-sm-8">
                    <input type="text" name="product_description"  id="product_description" class="form-control" value="${supply.pddc!''}">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label">Shipping Address</label>
                <div class="col-sm-8">
                    <input type="text" name="shipping_address"  id="shipping_address" class="form-control" value="${supply.sadr!''}">
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-4 control-label">Shipping Method Code</label>
                <div class="col-sm-8">
                    <select class="form-control" name="smtc" id="smtc">
                        <#list shipping as ship>
		                	<option value="${ship.smtc}"  <#if supply.smtc == ship.smtc>selected</#if> >${ship.smtc!''}</option>
		                </#list>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label">Photos</label>
                <button type="button" title="Add Image" class="add-row" value=""><img src="../images/Add.png" alt="Add Image" height="20" width="20"/></button>
                <input type="hidden" value="1" name="sph_count" id="sph_count"/>
                <input type="hidden" name="delete_supply_photos" id="delete_supply_photos" value=""/>
                <div class="col-sm-offset-4 col-sm-8 demand_photos">
                	<#list sph as dp>
                		<#assign ind = (dp?index + 1)>
	                    <div class="deman_photos" id="old_div_photos${ind}">
	                    	<button type="button" class="form-control" onclick="deleteSupplyImage('${ind}');">Remove Image<img src="../images/minus.png" alt="Add Image" height="20" width="20"/></button>
	                    	<input type="hidden" name="old_supply_photos${ind}" id="old_supply_photos${ind}" value="${dp.link.id!''}"/>
	                    	<img src="${dp.link.path!''}" alt="supply" height="50" width="50" name="old_supply_image${ind}" id="old_supply_image${ind}"/>
	                	</div>
                	</#list>
                	
            		<div class="deman_photos">
            			<input type="file" name="supply_photos1"  id="supply_photos1" class="form-control" onchange="readURL(this,'supply_image1',50,50)">
            			<img src="../images/avatar.png" alt="supply" height="50" width="50" name="supply_image1" id="supply_image1"/>
        			</div>
                	
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-12 account-button">
                    <button type="button" class="btn btn-default" onclick="window.location.href='${rc.contextPath}/supply'">Cancel</button>
                    <button type="button" class="btn btn-default" onclick="editSupplyDetails('${rc.contextPath}')">Update</button>
                </div>
            </div>
        </form>
    </div>
    
</div>