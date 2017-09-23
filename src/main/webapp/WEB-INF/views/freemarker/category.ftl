	<script>
	$(document).ready(function() {
		$('#categoryList').DataTable();
	})
	</script>
    <div class="col-md-10">
        <div class="col-md-6">
        	<h3><right>Category Panel</right></h3>
        </div>
        <div class="col-md-6 text-right add-new-button no-padding">
        	<button type="submit" class="btn btn-default" onclick="addnewCategory('${rc.contextPath}')">Add new</button>
        </div>
        <table id="categoryList" class="display table table-bordered" cellspacing="0" width="100%">
            <thead>
                <tr>
                    <th>Category Code</th>
                    <th>Category Name</th>
                    <th>Category Name Japanes</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tfoot>
                <!--<tr>
                    <th>Category Code</th>
                    <th>Category Name</th>
                    <th>Category Name Japanes</th>
                    <th>Action</th>
                </tr>-->
            </tfoot>
            <tbody>
				<#list ctg as c>
                <tr>
                    <td>${c.ctgc!''}</td>
                    <td>${c.ctgna!''}</td>
                    <td>${c.ctgnj!''}</td>
                    <td>
                        <div class="btn-group">
                            <button type="button" title="Edit category" class="btn btn-primary" onclick="editcategory('${rc.contextPath}','${c.ctgc!''}')"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button>
                           
                            <button type="button" title="Delete category" class="btn btn-success" onclick="deletecategory('${rc.contextPath}','${c.ctgc!''}')"><i class="fa fa-trash-o" aria-hidden="true"></i></button>
                            
                        </div>
                    </td>
                </tr>
				</#list>
            </tbody>
        </table>
    </div>