	     <div class="col-md-10 open-account no-padding">
            <div class="col-sm-12 no-padding edit-heading">
                <div class="col-md-7">
                    <h2>Edit Profile</h2>
                </div>
                <div class="col-md-5 user-id">
                    <div class="form-group">
                        <label for="personal-id" class="col-sm-4 control-label">Personal ID</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="piddisplay" name="piddisplay" value="${mem.pid!''}" readonly>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xs-12">
                <form id="formedit" name="formedit" action="${rc.contextPath}/editmemberdetails" method="post">
                	<input type="hidden" id="pid" name="pid" value="${mem.pid!''}">
                    <div class="form-group col-sm-4">
                        <label for="first-name">First name</label>
                        <input type="text" class="form-control" id="fname" name="fname" value="${mem.fname!''}">
                    </div>
                    <div class="form-group col-sm-4">
                        <label for="last-name">Last name</label>
                        <input type="text" class="form-control" id="lname" name="lname" value="${mem.lname!''}">
                    </div>
                    <div class="form-group col-sm-4">
                        <label for="middle-name">Middle name</label>
                        <input type="text" class="form-control" id="mname" name="mname" value="${mem.mname!''}">
                    </div>
                    
                    <div class="form-group col-sm-4">
                        <label for="first-name-jp">First name(Japanese)</label>
                        <input type="text" class="form-control" id="fdname" name="fdname" value="${mem.fdname!''}">
                    </div>
                    <div class="form-group col-sm-4">
                        <label for="last-name-jp">Last name(Japanese)</label>
                        <input type="text" class="form-control" id="ldname" name="ldname" value="${mem.ldname!''}">
                    </div>
                    <div class="form-group col-sm-4">
                        <label for="middle-name-jp">Middle name(Japanese)</label>
                        <input type="text" class="form-control" id="mdname" name="mdname" value="${mem.mdname!''}">
                    </div>
                    <div class="form-group col-sm-4">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="mad" name="mad" value="${mem.mad!''}" readonly>
                    </div>
                    <div class="form-group col-sm-4">
                        <label for="address">Address</label>
                        <input type="text" class="form-control" id="adr" name="adr" value="${mem.adr!''}">
                    </div>
                    <div class="form-group col-sm-4">
                        <label for="address-jp">Address(Japanese)</label>
                        <input type="text" class="form-control" id="adrj" name="adrj" value="${mem.adrj!''}">
                    </div>
                    
                    <div class="form-group col-sm-4">
                        <label for="company-name">Company name</label>
                        <input type="text" class="form-control" id="cna" name="cna"  value="${mem.cna!''}">
                    </div>
                    <div class="form-group col-sm-4">
                        <label for="company-name-jp">Company name(Japanese)</label>
                        <input type="text" class="form-control" id="cnj" name="cnj" value="${mem.cnj!''}">
                    </div>
                    <!--<div class="form-group col-sm-4">
                        <label for="settlement">Settlement Option</label>
                        <select class="form-control" id="settlement">
                            <option value="1">ST0001</option>
                            <option value="1">ST0002</option>
                            <option value="1">ST0003</option>
                            <option value="1">ST0004</option>
                            <option value="1">ST0005</option>
                        </select>
                    </div>-->

                    <div class="form-group edit-button">
                        <div class="col-sm-12">
                            <button type="button" class="btn btn-default cancel-button" onclick="window.location.href='${rc.contextPath}/member'">Cancel</button>
                            <button type="button" class="btn btn-default" onclick="memberdetailedit('${rc.contextPath}')">Save</button>                                                                       
                        </div>
                    </div>
                </form>
            </div>