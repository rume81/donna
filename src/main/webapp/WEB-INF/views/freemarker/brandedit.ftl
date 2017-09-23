<div class="col-md-10 open-account no-padding">
	<div class="col-sm-12 no-padding edit-heading">
        <div class="col-md-7">
            <h2>Edit Brand</h2>
        </div>
        <div class="col-md-5 user-id">
            <div class="form-group">
                <label for="personal-id" class="col-sm-4 control-label">Personal ID</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="piddisplay" name="piddisplay" value="${brd.brdc!''}" readonly>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-7 col-md-offset-2">
        <form class="form-horizontal" name="brandeditform" id="brandeditform" action="${rc.contextPath}/editbrand" method="post">
        	<input type="hidden" id="bid" name="bid" value="${brd.brdc!''}">
            <div class="form-group">
                <label for="brand-name" class="col-sm-4 control-label">Brand Name</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" value="${brd.brdna!''}" id="bn" name="bn">
                </div>
            </div>
            <div class="form-group">
                <label for="brand-namejp" class="col-sm-4 control-label">Brand Name Japanese</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control"  value="${brd.brdnj!''}" id="bnj" name="bnj">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-12 account-button">
                    <button type="button" class="btn btn-default" onclick="window.location.href='${rc.contextPath}/brand'";>Back</button>
                    <button type="button" class="btn btn-default" onclick="branddetailedit('${rc.contextPath}')">Save</button>
                </div>
            </div>
        </form>
    </div>    
</div>