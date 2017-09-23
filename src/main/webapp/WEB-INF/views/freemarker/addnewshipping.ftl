<div class="col-md-10 open-account">
    <h3 class="text-center">Adding New Shipping</h3>
    <div class="col-md-7 col-md-offset-2 add-new-form">
        <form class="form-horizontal" name="shippingform" id="shippingform" action="${rc.contextPath}/addshipping" method="post">
            <div class="form-group">
                <label for="Shipping-name" class="col-sm-4 control-label">Shipping Name</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="smtn" name="smtn">
                </div>
            </div>
            
            <!--<div class="form-group">
                <label  class="col-sm-4 control-label">Account Created by</label>
                <label  class="col-sm-7 control-label">Admin Mr. Sina</label>
            </div>-->
            <div class="form-group">
                <div class="col-sm-12 account-button">
                    <button type="button" class="btn btn-default" onclick="window.location.href='${rc.contextPath}/shipping'";>Back</button>
                    <button type="button" class="btn btn-default" onclick="shippingregistration('${rc.contextPath}')">Save</button>
                </div>
            </div>
        </form>
    </div>    
</div>