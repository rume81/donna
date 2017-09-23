<div class="col-md-10 open-account">
    <h3 class="text-center">Adding New Category</h3>
    <div class="col-md-7 col-md-offset-2 add-new-form">
        <form class="form-horizontal" name="categoryform" id="categoryform" action="${rc.contextPath}/addcategory" method="post">
            <div class="form-group">
                <label for="brand-name" class="col-sm-4 control-label">Category Name</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="ctgna" name="ctgna">
                </div>
            </div>
            <div class="form-group">
                <label for="brand-namejp" class="col-sm-4 control-label">Category Name Japanese</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="ctgnj" name="ctgnj">
                </div>
            </div>
            <!--<div class="form-group">
                <label  class="col-sm-4 control-label">Account Created by</label>
                <label  class="col-sm-7 control-label">Admin Mr. Sina</label>
            </div>-->
            <div class="form-group">
                <div class="col-sm-12 account-button">
                    <button type="button" class="btn btn-default" onclick="window.location.href='${rc.contextPath}/category'";>Back</button>
                    <button type="button" class="btn btn-default" onclick="categoryregistration('${rc.contextPath}')">Save</button>
                </div>
            </div>
        </form>
    </div>    
</div>