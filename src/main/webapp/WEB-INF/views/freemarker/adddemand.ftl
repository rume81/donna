<script type="text/javascript" src="${rc.contextPath}/js/custome/demand.js"></script>

<script type="text/javascript">
	var dph_id=1;
    $(document).ready(function(){
        $(".add-row").click(function(){
        	dph_id = dph_id+1;          
            var markup = "<div class='deman_photos'><input type='file' name='demand_photos"+dph_id+"' id='demand_photos"+dph_id +"' class='form-control' onchange=readURL(this,'demand_image"+dph_id+"',50,50)><img src='images/avatar.png' alt='demand' height='50' width='50' name='demand_image"+dph_id+"' id='demand_image"+dph_id+"'/></div>";
            $(".demand_photos").append(markup);
            $("#dph_count").val(dph_id);
        });
    });    
</script>
<div class="col-sm-10 open-account">
    <h3 class="text-center">Add new Demand</h3>
    <div class="col-md-7 col-md-offset-2 add-new-form">
        <form class="form-horizontal" name="add_demand" id="add_demand" action="${rc.contextPath}/insertDemand" method="post" enctype="multipart/form-data">
            
            <div class="form-group">
                <label for="email" class="col-sm-4 control-label">Select Brand</label>
                <div class="col-sm-8">
                    <select class="form-control" name="brand" id="brand">
                        <#list brand as bn>
		                	<option value="${bn.brdc}">${bn.brdnj}</option>
		                </#list>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-4 control-label">Select Category</label>
                <div class="col-sm-8">
                    <select class="form-control" name="category" id="category">
                        <#list categories as cat>
		                	<option value="${cat.ctgc}">${cat.ctgnj}</option>
		                </#list>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label">Product type</label>
                <div class="col-sm-8">
                    <input type="text" name="product_type" class="form-control" id="product_type">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label">Product Name</label>
                <div class="col-sm-8">
                    <input type="text" name="product_name" class="form-control" id="product_name">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label">Amount of Product</label>
                <div class="col-sm-8">
                    <input type="text" name="product_amount" class="form-control" id="product_amount">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label">Unit of Count</label>
                <div class="col-sm-8">
                    <input type="text" name="unit_count"  id="unit_count" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label">Price per unit</label>
                <div class="col-sm-8">
                    <input type="text" name="price_per_unit"  id="price_per_unit" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label">Types of Currency</label>
                <div class="col-sm-8">
                    <select name="currency_types"  id="currency_types" class="form-control">
                    	<#list currencies as currency>
                    	<option value="${currency.curn}">${currency.curn}</option>
                    	</#list>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label">Product Description</label>
                <div class="col-sm-8">
                    <input type="text" name="product_description"  id="product_description" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label">Shipping Address</label>
                <div class="col-sm-8">
                    <input type="text" name="shipping_address"  id="shipping_address" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label">Photos</label>
                <button type="button" title="Add Image" class="add-row" value=""><img src="images/Add.png" alt="Add Image" height="20" width="20"/></button>
                <input type="hidden" value="1" name="dph_count" id="dph_count"/>
                <div class="col-sm-8 demand_photos">
                    <div class="deman_photos">
                    	<input type="file" name="demand_photos1"  id="demand_photos1" class="form-control" onchange="readURL(this,'demand_image1',50,50)">
                    	<img src="images/avatar.png" alt="demand" height="50" width="50" name="demand_image1" id="demand_image1"/>
                	</div>
                </div>
            </div>
            
            <div class="form-group">
                <div class="col-sm-12 account-button">
                    <button type="button" class="btn btn-default" onclick="window.location.href='${rc.contextPath}/demand'">Cancel</button>
                    <button type="button" class="btn btn-default" onclick="adddemand('${rc.contextPath}')">Add</button>
                </div>
            </div>
        </form>
    </div>
    
</div>