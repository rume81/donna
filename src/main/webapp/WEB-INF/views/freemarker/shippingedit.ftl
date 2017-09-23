<div class="col-md-10 open-account no-padding">
    <div class="col-sm-12 no-padding edit-heading">
        <div class="col-md-7">
            <h2>Edit Shipping</h2>
        </div>
        <div class="col-md-5 user-id">
            <div class="form-group">
                <label for="shipping-id" class="col-sm-4 control-label">Shipping ID</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="piddisplay" name="piddisplay" value="${ctg.smtc!''}" readonly>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-7 col-md-offset-2">
        <form class="form-horizontal" name="shippingeditform" id="shippingeditform" action="${rc.contextPath}/editshipping" method="post">
            <input type="hidden" id="smtc" name="smtc" value="${ctg.smtc!''}">
            <div class="form-group">
                <label for="brand-name" class="col-sm-4 control-label">Shipping Name</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="smtn" name="smtn" value="${ctg.smtn!''}">
                </div>
            </div>
            <!--<div class="form-group">
                <label  class="col-sm-4 control-label">Account Created by</label>
                <label  class="col-sm-7 control-label">Admin Mr. Sina</label>
            </div>-->
            <div class="form-group">
                <div class="col-sm-12 account-button">
                    <button type="button" class="btn btn-default" onclick="window.location.href='${rc.contextPath}/shipping'";>Back</button>
                    <button type="button" class="btn btn-default" onclick="shippingdetailedit('${rc.contextPath}')">Save</button>
                </div>
            </div>
        </form>
    </div>    
</div>