<script type="text/javascript" src="${rc.contextPath}/js/custome/demand.js"></script>
<script type="text/javascript">
	var dph_id=1;
    $(document).ready(function(){
    	$("#delete_demand_photos").val("");
        $(".add-row").click(function(){
        	dph_id = dph_id+1;          
            var markup = "<div class='deman_photos'><input type='file' name='demand_photos"+dph_id+"' id='demand_photos"+dph_id +"' class='form-control' onchange=readURL(this,'demand_image"+dph_id+"',50,50)><img src='../images/avatar.png' alt='demand' height='50' width='50' name='demand_image"+dph_id+"' id='demand_image"+dph_id+"'/></div>";
            $(".demand_photos").append(markup);
            $("#dph_count").val(dph_id);
        });
    });    
</script>
<div class="col-md-10 open-account no-padding">
    <div class="col-sm-12 no-padding edit-heading">
        <div class="col-md-7">
            <h2>Edit Demand</h2>
        </div>
        <div class="col-md-5 user-id">
        </div>
    </div>
    <div class="col-xs-12">
        <form id="editdemand" name="editdemand" action="${rc.contextPath}/editdemand" method="post" enctype="multipart/form-data">
            <div class="form-group">
            	<input type="hidden" name="pdid" id="pdid" value="${demand.did!''}">
                <label for="email" class="col-sm-4 control-label">Select Brand</label>
                <div class="col-sm-8">
                    <select class="form-control" name="brand" id="brand">
                        <#list brand as bn>
                        <option value="${bn.brdc}" <#if demand.brdc == bn.brdc>selected</#if> >${bn.brdnj}</option>
                        </#list>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-4 control-label">Select Category</label>
                <div class="col-sm-8">
                    <select class="form-control" name="category" id="category">
                        <#list categories as cat>
                        <option value="${cat.ctgc}" <#if demand.ctgc == cat.ctgc>selected</#if> >${cat.ctgnj}</option>
                        </#list>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label">Product type</label>
                <div class="col-sm-8">
                    <input type="text" name="product_type" class="form-control" id="product_type" value="${demand.pdtp!''}">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label">Product Name</label>
                <div class="col-sm-8">
                    <input type="text" name="product_name" class="form-control" id="product_name" value="${demand.pdnm!''}">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label">Amount of Product</label>
                <div class="col-sm-8">
                    <input type="text" name="product_amount" class="form-control" id="product_amount" value="${demand.dam!''}">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label">Unit of Count</label>
                <div class="col-sm-8">
                    <input type="text" name="unit_count"  id="unit_count" class="form-control" value="${demand.unt!''}">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label">Price per unit</label>
                <div class="col-sm-8">
                    <input type="text" name="price_per_unit"  id="price_per_unit" class="form-control" value="${demand.utp!''}">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label">Types of Currency</label>
                <div class="col-sm-8">
                    <select name="currency_types"  id="currency_types" class="form-control">
                        <#list currencies as currency>
                        <option value="${currency.curn}" <#if demand.cur == currency.curn>selected</#if> >${currency.curn}</option>
                        </#list>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label">Product Description</label>
                <div class="col-sm-8">
                    <input type="text" name="product_description"  id="product_description" class="form-control" value="${demand.pddc!''}">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label">Shipping Address</label>
                <div class="col-sm-8">
                    <input type="text" name="shipping_address"  id="shipping_address" class="form-control" value="${demand.sadr!''}">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label">Photos</label>
                <button type="button" title="Add Image" class="add-row" value=""><img src="../images/Add.png" alt="Add Image" height="20" width="20"/></button>
                <input type="hidden" value="1" name="dph_count" id="dph_count"/>
                <input type="hidden" name="delete_demand_photos" id="delete_demand_photos" value=""/>
                <div class="col-sm-offset-4 col-sm-8 demand_photos">
                	<#list dph as dp>
                		<#assign ind = (dp?index + 1)>
	                    <div class="deman_photos" id="old_div_photos${ind}">
	                    	<button type="button" class="form-control" onclick="deleteDemandImage('${ind}');">Remove Image<img src="../images/minus.png" alt="Add Image" height="20" width="20"/></button>
	                    	<input type="hidden" name="old_demand_photos${ind}" id="old_demand_photos${ind}" value="${dp.link.id!''}"/>
	                    	<img src="${dp.link.path!''}" alt="demand" height="50" width="50" name="old_demand_image${ind}" id="old_demand_image${ind}"/>
	                	</div>
                	</#list>
                	
            		<div class="deman_photos">
            			<input type="file" name="demand_photos1"  id="demand_photos1" class="form-control" onchange="readURL(this,'demand_image1',50,50)">
            			<img src="../images/avatar.png" alt="demand" height="50" width="50" name="demand_image1" id="demand_image1"/>
        			</div>
                	
                </div>
            </div>
            
            <div class="form-group">
                <div class="col-sm-12 account-button">
                    <button type="button" class="btn btn-default" onclick="window.location.href='${rc.contextPath}/demand'">Cancel</button>
                    <button type="button" class="btn btn-default" onclick="editdemandDetails('${rc.contextPath}')">Update</button>
                </div>
            </div>
        </form>
    </div>