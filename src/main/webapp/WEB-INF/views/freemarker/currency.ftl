	<script>
	$(document).ready(function() {
		$('#currencyList').DataTable();
	})
	</script>
    <div class="col-md-10">
        <div class="col-md-6">
        	<h3><right>Currency Panel</right></h3>
        </div>
        <div class="col-md-6 text-right add-new-button no-padding">
        	<button type="submit" class="btn btn-default" onclick="addnewCurrency('${rc.contextPath}')">Add new</button>
        </div>
        <table id="currencyList" class="display table table-bordered" cellspacing="0" width="100%">
            <thead>
                <tr>
                    <th>Currency Code</th>
                    <th>Currency Name</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tfoot>
                <!--<tr>
                    <th>Currency Code</th>
                    <th>Currency Name</th>
                    <th>Action</th>
                </tr>-->
            </tfoot>
            <tbody>
				<#list ctg as c>
                <tr>
                    <td>${c.curc!''}</td>
                    <td>${c.curn!''}</td>
                    <td>
                        <div class="btn-group">
                            <button type="button" title="Edit category" class="btn btn-primary" onclick="editcurrency('${rc.contextPath}','${c.curc}')"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button>
                            
                            <button type="button" title="Delete category" class="btn btn-success" onclick="deletecurrency('${rc.contextPath}','${c.curc}')"><i class="fa fa-trash-o" aria-hidden="true"></i></button>
                            
                        </div>
                    </td>
                </tr>
				</#list>
            </tbody>
        </table>
    </div>