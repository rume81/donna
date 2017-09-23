<div class="col-md-10 open-account">
    <h3 class="text-center">Add New Member</h3>
    <div class="col-md-7 col-md-offset-2 add-new-form">
        <form class="form-horizontal" name="registrationform" id="registrationform" action="${rc.contextPath}/addmember" method="post">
            <div class="form-group form-radio">
                <input type="radio" name="accounttype" value="ADMIN" />Administrator
                <input type="radio" name="accounttype" value="NUSER" checked/> General User
                <input type="radio" name="accounttype" value="SUSER"/> Special User
            </div>
            <div class="form-group">
                <label for="first-name" class="col-sm-4 control-label">First Name</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="first-name" name="first-name">
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-4 control-label">Email</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="email" name="email">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-4 control-label">Password</label>
                <div class="col-sm-8">
                    <input type="password" class="form-control" id="password" name="password">
                </div>
            </div>
            <div class="form-group">
                <label for="confirm-password" class="col-sm-4 control-label">Confirm Password</label>
                <div class="col-sm-8">
                    <input type="password" class="form-control" id="confirm-password" name="confirm-password">
                </div>
            </div>
            <!--<div class="form-group">
                <label  class="col-sm-4 control-label">Account Created by</label>
                <label  class="col-sm-7 control-label">Admin Mr. Sina</label>
            </div>-->
            <div class="form-group">
                <div class="col-sm-12 account-button">
                    <button type="button" class="btn btn-default" onclick="window.location.href='${rc.contextPath}/member'";>Back</button>
                    <button type="button" class="btn btn-default" onclick="memberregistration('${rc.contextPath}',2)">Save</button>
                </div>
            </div>
        </form>
    </div>    
</div>