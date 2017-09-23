	<script>
	$(document).ready(function() {
		$('#memberList').DataTable();
	})
	</script>
    <div class="col-md-10 no-padding">
        <div class="col-md-6">
        	<h3><right>Member Panel</right></h3>
        </div>
        <div class="col-md-6 text-right add-new-button no-padding">
        	<#if currentuser.msta=='ADMIN'>
        	<button type="submit" class="btn btn-default" onclick="addnewmember('${rc.contextPath}')">Add new</button>
        	</#if>
        </div>
        <table id="memberList" class="display table table-bordered" cellspacing="0" width="100%">
            <thead>
                <tr>
                    <th>Member id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Mid Name</th>
                    <th>Nick Name</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Company Name</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tfoot>
                <!--<tr>
                    <th>Member id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Mid Name</th>
                    <th>Nick Name</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Company Name</th>
                    <th>Action</th>
                </tr>-->
            </tfoot>
            <tbody>
				<#list mem as m>
                <tr>
                    <td>${m.pid!''}</td>
                    <td>${m.fname!''} <#if m.fdname?has_content>(${m.fdname!''})</#if></td>
                    <td>${m.lname!''} <#if m.ldname?has_content>(${m.ldname!''})</#if></td>
                    <td>${m.mname!''} <#if m.mdname?has_content>(${m.mdname!''})</#if></td>
                    <td>${m.nname!''} <#if m.ndname?has_content>(${m.ndname!''})</#if></td>
                    <td>${m.mad!''}</td>
                    <td>${m.adr!''} <#if m.adrj?has_content>(${m.adrj!''})</#if></td>
                    <td>${m.cna!''} <#if m.cnj?has_content>(${m.cnj!''})</#if></td>
                    <td>
                        <div class="btn-group">
                            <button type="button" title="Edit Member" class="btn btn-primary" onclick="editMember('${rc.contextPath}','${m.pid}')"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button>
                            <#if currentuser.msta=='ADMIN'>
                            <button type="button" title="Delete Member" class="btn btn-success" onclick="deleteMember('${rc.contextPath}','${m.pid}')"><i class="fa fa-trash-o" aria-hidden="true"></i></button>
                            </#if>
                        </div>
                    </td>
                </tr>
				</#list>
            </tbody>
        </table>
    </div>
