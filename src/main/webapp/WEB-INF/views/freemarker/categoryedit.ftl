<div class="col-md-10 open-account no-padding">
    <div class="col-sm-12 no-padding edit-heading">
        <div class="col-md-7">
            <h2>Edit Category</h2>
        </div>
        <div class="col-md-5 user-id">
            <div class="form-group">
                <label for="personal-id" class="col-sm-4 control-label">Category ID</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="piddisplay" name="piddisplay" value="${ctg.ctgc!''}" readonly>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-7 col-md-offset-2">
        <form class="form-horizontal" name="categoryeditform" id="categoryeditform" action="${rc.contextPath}/editcategory" method="post">
            <input type="hidden" id="ctgc" name="ctgc" value="${ctg.ctgc!''}">
            <div class="form-group">
                <label for="brand-name" class="col-sm-4 control-label">Category Name</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="ctgna" name="ctgna" value="${ctg.ctgna!''}">
                </div>
            </div>
            <div class="form-group">
                <label for="brand-namejp" class="col-sm-4 control-label">Category Name Japanese</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="ctgnj" name="ctgnj" value="${ctg.ctgnj!''}">
                </div>
            </div>
            <!--<div class="form-group">
                <label  class="col-sm-4 control-label">Account Created by</label>
                <label  class="col-sm-7 control-label">Admin Mr. Sina</label>
            </div>-->
            <div class="form-group">
                <div class="col-sm-12 account-button">
                    <button type="button" class="btn btn-default" onclick="window.location.href='${rc.contextPath}/category'";>Back</button>
                    <button type="button" class="btn btn-default" onclick="categorydetailedit('${rc.contextPath}')">Save</button>
                </div>
            </div>
        </form>
    </div>    
</div>