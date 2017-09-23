	<script>
	$(document).ready(function() {
		$('#brandList').DataTable();
	})
	</script>
    <div class="col-md-10">
        <div class="col-md-6">
        	<h3><right>Brand Panel</right></h3>
        </div>
        <div class="col-md-6 text-right add-new-button no-padding">
        	<button type="submit" class="btn btn-default" onclick="addnewbrand('${rc.contextPath}')">Add new</button>
        </div>
        <table id="brandList" class="display table table-bordered" cellspacing="0" width="100%">
            <thead>
                <tr>
                    <th>Brand Code</th>
                    <th>Brand Name</th>
                    <th>Brand Name Japanes</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tfoot>
                <!--<tr>
                    <th>Brand Code</th>
                    <th>Brand Name</th>
                    <th>Brand Name Japanes</th>
                    <th>Action</th>
                </tr>-->
            </tfoot>
            <tbody>
				<#list brd as b>
                <tr>
                    <td>${b.brdc!''}</td>
                    <td>${b.brdna!''}</td>
                    <td>${b.brdnj!''}</td>
                    
                    <td>
                        <div class="btn-group">
                            <button type="button" title="Edit Member" class="btn btn-primary" onclick="editBrand('${rc.contextPath}','${b.brdc}')"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button>
                            
                            <button type="button" title="Delete Member" class="btn btn-success" onclick="deleteBrand('${rc.contextPath}','${b.brdc}')"><i class="fa fa-trash-o" aria-hidden="true"></i></button>
                            
                        </div>
                    </td>
                </tr>
				</#list>
            </tbody>
        </table>
    </div>
