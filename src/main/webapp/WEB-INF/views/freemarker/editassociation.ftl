<script type="text/javascript" src="${rc.contextPath}/js/custome/demand.js"></script>
<script>
/*function myFunction() {
    var table = document.getElementById('memberList'),
  cells = table.getElementsByTagName('tr');
	
  //alert(cells[0][0]);
for (var i = 0, len = cells.length; i < len; i++) {
  cells[i].onclick = function() {
    alert(this.innerHTML);
  };
}
}*/
	
    $(document).ready(function () {
    	var selected = [];
    
        var table = $('#memberList').DataTable();
        
        var table2 = $('#supplyList').DataTable();
        
        $('#memberList tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            table.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    } );
    
    $('#supplyList tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            table.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    } );
    
    $('#memberList tbody').on( 'click', 'tr', function () {
    	var rowid= table.row( this ).index() ;
    	$('#selRowDem').val($('#ro'+rowid).val());
	} );
	
	$('#supplyList tbody').on( 'click', 'tr', function () {
    	var rowid= table2.row( this ).index() ;
    	$('#selRowSup').val($('#sro'+rowid).val());
	} );
    
    })
    
</script>
<div class="col-sm-10">
	<div class="col-xs-12 text-center association-button no-padding">
		<form name="insert_association" id="insert_association" action="${rc.contextPath}/editassociation" method="post">
				<input type="hidden" name="demandid" id="selRowDem" value=""/>
				<input type="hidden" name="supplyid" id="selRowSup" value=""/>
	         	<button type="button" class="btn btn-default" onclick="insertAssociation('${rc.contextPath}')">Assciation</button>
         </form>
    </div>
	<div class="col-sm-6 col-xs-12 association-demand">				
		<table id="memberList" class="display table table-bordered" cellspacing="0" width="100%">
		    <thead>
		        <tr>
		            <th>DID</th>
		            <th>BRDC</th>
		            <th>BRDNJ</th>
		            <th>CTGC</th>
		            <th class="hidden-xs hidden-sm">UNT</th>
		        </tr>
		    </thead>
		    <tfoot>
		        <tr>
		            <th>DID</th>
		            <th>BRDC</th>
		            <th>BRDNJ</th>
		            <th>CTGC</th>
		            <th class="hidden-xs hidden-sm">UNT</th>
		        </tr>
		    </tfoot>
		    <tbody>
		    <#assign ro=0>
		    <#list demand as dem>
		        <tr>
		            <td>${dem.did}
					<input type="hidden" id="ro${ro}" value="${dem.did}"/>
					</td>
		            <td>${dem.brdc!''}</td>
		            <td>${dem.brdnj!''}</td>
		            <td>${dem.ctgc!''}</td>
		            <td class="hidden-xs hidden-sm">${dem.unt!''}</td>
		        </tr>
		        <#assign ro=ro+1>
		        </#list>
		    </tbody>
		</table>
	</div>
	<div class="col-sm-6 col-xs-12 association-supply">
		<table id="supplyList" class="display table table-bordered" cellspacing="0" width="100%">
            <thead>
                <tr>
                    <th>Supply id</th>
                    <th>Brand code</th>
                    <th>Category code</th>
                    <th>Product Name</th>
                    <th>Unit</th>
                </tr>
            </thead>
            <tfoot>
                <!--<tr>
                    <th>Supply id</th>
                    <th>Brand code</th>
                    <th>Category code</th>
                    <th>Product Name</th>
                    <th>Unit</th>
                </tr>-->
            </tfoot>
            <tbody>
            	<#assign ro1=0>
				<#list sup as sp>
                <tr>
                    <td>${sp.sid!''}</td>
                    <input type="hidden" id="sro${ro1}" value="${sp.sid}"/>
                    <td>${sp.brdc!''}</td>
                    <td>${sp.ctgc!''}</td>
                    <td>${sp.pdnm!''}</td>
                    <td>${sp.unt!''}</td>
                </tr>
                <#assign ro1=ro1+1>
			</#list>	
            </tbody>
        </table>
	</div>
</div>
