	<script>
	$(document).ready(function() {
		$('#shippingList').DataTable();
	})
	</script>
    <div class="col-md-10">
        <div class="col-md-6">
        	<h3><right>Shipping Panel</right></h3>
        </div>
        <div class="col-md-6 text-right add-new-button no-padding">
        	<button type="submit" class="btn btn-default" onclick="addnewShipping('${rc.contextPath}')">Add new</button>
        </div>
        <table id="shippingList" class="display table table-bordered" cellspacing="0" width="100%">
            <thead>
                <tr>
                    <th>Shipping Code</th>
                    <th>Shipping Name</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tfoot>
                <!--<tr>
                    <th>Shipping Code</th>
                    <th>Shipping Name</th>
                    <th>Action</th>
                </tr>-->
            </tfoot>
            <tbody>
            	<#list ctg as c>
				<tr>
                    <td>${c.smtc!''}</td>
                    <td>${c.smtn!''}</td>
                    <td>
                        <div class="btn-group">
                            <button type="button" title="Edit shipping" class="btn btn-primary" onclick="editshipping('${rc.contextPath}','${c.smtc}')"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button>
                            
                            <button type="button" title="Delete shipping" class="btn btn-success" onclick="deleteshipping('${rc.contextPath}','${c.smtc}')"><i class="fa fa-trash-o" aria-hidden="true"></i></button>
                           
                        </div>
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>