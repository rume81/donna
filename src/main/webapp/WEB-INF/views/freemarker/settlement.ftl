<script type="text/javascript" src="${rc.contextPath}/js/custome/settlement.js"></script>
<script>
$(document).ready(function() {
	$('#settlementList').DataTable();
})
</script>
    <div class="col-md-10">
        <div class="col-md-6">
        	<h3><right>Settlement Panel</right></h3>
        </div>
        <div class="col-md-6 text-right add-new-button no-padding">
        	<button type="submit" class="btn btn-default" onclick="addSettlement('${rc.contextPath}')">Add new</button>
        </div>
        <table id="settlementList" class="display table table-bordered" cellspacing="0" width="100%">
            <thead>
                <tr>
                    <th>Serial Number</th>
                    <th>Serial Text</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
				<#list set as s>
                <tr>
                    <td>${s.stlc!''}</td>
                    <td>${s.stln!''}</td>
                    <td>
                        <div class="btn-group">
                            <button type="button" title="Edit Member" class="btn btn-primary" onclick="editSettlement('${rc.contextPath}','${s.stlc}')"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button>                            
                            <button type="button" title="Delete Member" class="btn btn-success" onclick="deleteSettlement('${rc.contextPath}','${s.stlc}')"><i class="fa fa-trash-o" aria-hidden="true"></i></button>                            
                        </div>
                    </td>
                </tr>
				</#list>
            </tbody>
        </table>
    </div>
