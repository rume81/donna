	<script type="text/javascript" src="${rc.contextPath}/js/custome/supply.js"></script>
	<script>
	$(document).ready(function() {
		$('#supplyList').DataTable();
	})
	</script>
    <div class="col-md-10">
        <div class="col-md-6">
        	<h3><right>Supply Panel</right></h3>
        </div>
        <div class="col-md-6 text-right add-new-button no-padding">
        	<button type="submit" class="btn btn-default" onclick="addSupply('${rc.contextPath}')">Add new</button>
        </div>
        <table id="supplyList" class="display table table-bordered" cellspacing="0" width="100%">
            <thead>
                <tr>
                    <th>Supply id</th>
                    <th>Brand code</th>
                    <th>Category code</th>
                    <th>Product Type</th>
                    <th>Product Name</th>
                    <th>Amount</th>
                    <th>Unit</th>
                    <th>Price</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tfoot>
                <!--<tr>
                    <th>Supply id</th>
                    <th>Brand code</th>
                    <th>Category code</th>
                    <th>Product Type</th>
                    <th>Product Name</th>
                    <th>Amount</th>
                    <th>Unit</th>
                    <th>Price</th>
                    <th>Action</th>
                </tr>-->
            </tfoot>
            <tbody>
				<#list sup as sp>
                <tr>
                    <td>${sp.sid!''}</td>
                    <td>${sp.brdc!''}</td>
                    <td>${sp.ctgc!''}</td>
                    <td>${sp.pdtp!''}</td>
                    <td>${sp.pdnm!''}</td>
                    <td>${sp.dam!''}</td>
                    <td>${sp.unt!''}</td>
                    <td>${sp.utp!''}</td>
                    <td>
                        <div class="btn-group">
                            <button type="button" title="Edit Member" class="btn btn-primary" onclick="editSupply('${rc.contextPath}','${sp.sid}')"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button>                            
                            <button type="button" title="Delete Member" class="btn btn-success" onclick="deletesupply('${rc.contextPath}','${sp.sid}')"><i class="fa fa-trash-o" aria-hidden="true"></i></button>
                        </div>
                    </td>
                </tr>
			</#list>	
            </tbody>
        </table>
    </div>
