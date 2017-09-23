<div class="col-md-10 open-account">
    <h3 class="text-center">Adding New Currency</h3>
    <div class="col-md-7 col-md-offset-2 add-new-form">
        <form class="form-horizontal" name="currencyform" id="currencyform" action="${rc.contextPath}/addcurrency" method="post">
            <div class="form-group">
                <label for="brand-name" class="col-sm-4 control-label">Currency Name</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="curn" name="curn">
                </div>
            </div>
            
            <!--<div class="form-group">
                <label  class="col-sm-4 control-label">Account Created by</label>
                <label  class="col-sm-7 control-label">Admin Mr. Sina</label>
            </div>-->
            <div class="form-group">
                <div class="col-sm-12 account-button">
                    <button type="button" class="btn btn-default" onclick="window.location.href='${rc.contextPath}/currency'";>Back</button>
                    <button type="button" class="btn btn-default" onclick="currencyregistration('${rc.contextPath}')">Save</button>
                </div>
            </div>
        </form>
    </div>    
</div>