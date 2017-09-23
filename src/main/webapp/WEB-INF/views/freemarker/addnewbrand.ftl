<div class="col-md-10 open-account">
    <h3 class="text-center">Adding New Brand</h3>
    <div class="col-md-7 col-md-offset-2 add-new-form">
        <form class="form-horizontal" name="brandform" id="brandform" action="${rc.contextPath}/addbrand" method="post">
            <div class="form-group">
                <label for="brand-name" class="col-sm-4 control-label">Brand Name</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="bn" name="bn">
                </div>
            </div>
            <div class="form-group">
                <label for="brand-namejp" class="col-sm-4 control-label">Brand Name Japanese</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="bnj" name="bnj">
                </div>
            </div>
            <!--<div class="form-group">
                <label  class="col-sm-4 control-label">Account Created by</label>
                <label  class="col-sm-7 control-label">Admin Mr. Sina</label>
            </div>-->
            <div class="form-group">
                <div class="col-sm-12 account-button">
                    <button type="button" class="btn btn-default" onclick="window.location.href='${rc.contextPath}/brand'";>Back</button>
                    <button type="button" class="btn btn-default" onclick="brandregistration('${rc.contextPath}')">Save</button>
                </div>
            </div>
        </form>
    </div>    
</div>