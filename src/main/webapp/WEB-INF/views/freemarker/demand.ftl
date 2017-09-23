<script type="text/javascript" src="${rc.contextPath}/js/custome/demand.js"></script>
<script>
    $(document).ready(function () {
        $('#memberList').DataTable();
    })
</script>
<div class="col-sm-10">
    <div class="col-md-6">
        <h3>Demand Panel</h3>
    </div>
    <div class="col-md-6 text-right add-new-button no-padding">
         <button type="submit" class="btn btn-default" onclick="addDemand('${rc.contextPath}')" >Add new</button>
    </div>
    <table id="memberList" class="display table table-bordered" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>DID</th>
                <th>BRDC</th>
                <th>BRDNJ</th>
                <th>CTGC</th>
                <th class="hidden-xs hidden-sm">CTGNJ</th>
                <th class="hidden-xs hidden-sm">PDDP</th>
                <th class="hidden-xs hidden-sm">DAM</th>
                <th class="hidden-xs hidden-sm">UNT</th>
                <th>UTP</th>
                <th>CURC</th>
                <th>PDDC</th>
                <th>Action</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>DID</th>
                <th>BRDC</th>
                <th>BRDNJ</th>
                <th>CTGC</th>
                <th class="hidden-xs hidden-sm">CTGNJ</th>
                <th class="hidden-xs hidden-sm">PDDP</th>
                <th class="hidden-xs hidden-sm">DAM</th>
                <th class="hidden-xs hidden-sm">UNT</th>
                <th>UTP</th>
                <th>CURC</th>
                <th>PDDC</th>
                <th>Action</th>
            </tr>
        </tfoot>
        <tbody>
        <#list demand as dem>
            <tr>
                <td>${dem.did}</td>
                <td>${dem.brdc!''}</td>
                <td>${dem.brdnj!''}</td>
                <td>${dem.ctgc!''}</td>
                <td class="hidden-xs hidden-sm">${dem.ctgnj!''}</td>
                <td class="hidden-xs hidden-sm">${dem.pdtp!''}</td>
                <td class="hidden-xs hidden-sm">${dem.dam!''}</td>
                <td class="hidden-xs">${dem.unt!''}</td>
                <td>${dem.utp!''}</td>
                <td>${dem.cur!''}</td>
                <td>${dem.pddc!''}</td>
                <td>
                    <div class="btn-group">
                        <button type="button" title="Edit Demand" class="btn btn-primary" onclick="editDemand('${rc.contextPath}','${dem.did}')"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button>
                        <button type="button" title="Delete Demand" class="btn btn-success" onclick="deleteDemand('${rc.contextPath}','${dem.did}')"><i class="fa fa-trash-o" aria-hidden="true"></i></button>
                    </div>
                </td>
            </tr>
            </#list>
        </tbody>
    </table>
</div>
