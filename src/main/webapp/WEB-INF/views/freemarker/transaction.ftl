<script>
	$(document).ready(function() {
		$('#tranList').DataTable();
	})
	</script>
    <div class="col-md-10">
        <div class="col-md-6">
        	<h3><right>Transaction Log Panel</right></h3>
        </div>
        <div class="col-md-6 text-right add-new-button no-padding">
        	<!--<button type="submit" class="btn btn-default" onclick="addnewbrand('${rc.contextPath}')">Add new</button>-->
        </div>
        <table id="tranList" class="display table table-bordered" cellspacing="0" width="100%">
            <thead>
                <tr>
                    <th>Log Code</th>
                    <th>Log Date/Time</th>
                    <th>Action Happend</th>
                    <th>Action Id</th>
                    <th>Location</th>
                    <th>Update Information</th>
                    <th>Update By</th>
                </tr>
            </thead>
            <!--<tfoot>
                <tr>
                    <th>Log Code</th>
                    <th>Log Date/Time</th>
                    <th>Action Happend</th>
                    <th>Action Id</th>
                    <th>Location</th>
                    <th>Update Information</th>
                    <th>Update By</th>
                </tr>
            </tfoot>-->
            <tbody>
				<#list tlog as l>
                <tr>
                    <td>${l.tsid!''}</td>
                    <td>${l.dtts!''}</td>
                    <td>${l.action!''}</td>
                    <td>${l.actionid!''}</td>
                    <td>${l.location!''}</td>
                    <td>${l.updatedinfo!''}</td>
                    <td>${l.changeby!''}</td>
                </tr>
				</#list>
            </tbody>
        </table>
    </div>
