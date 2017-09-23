    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Donna</title>
        <link rel="shortcut icon" type="image/png" href="images/fevicon.png"/>

        <link href="${rc.contextPath}/css/common/font-awesome.min.css" rel="stylesheet" />
        <link href="${rc.contextPath}/css/common/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="${rc.contextPath}/css/common/jquery-ui.css">
        <link href="${rc.contextPath}/css/common/responsive.css" rel="stylesheet" />
        <link href="${rc.contextPath}/css/common/style.css" rel="stylesheet" />
        
        
        <script type="text/javascript" src="${rc.contextPath}/js/jquery.min.js"></script>
        <script type="text/javascript" src="${rc.contextPath}/js/jquery.easing.min.js"></script>

        <script type="text/javascript" src="${rc.contextPath}/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${rc.contextPath}/js/custome/custome.js"></script>
    </head>
    <body>
    	<div id="dialog" title="Basic dialog"></div>
        <div class="container">
        	<header>
                <div class="home-header">
                    <div class="col-md-2">
                        <h3>Donna</h3>
                    </div>
                    <div class="col-md-4 col-md-offset-6 text-right">
                        <ul class="right-top-nav">
                            <li class="username">User name</li>
                            <li class="user"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></li>
                            <li class="logout"><button type="button"  onclick="logout('${rc.contextPath}')" class="btn btn-default">Log Out</button></li>
                        </ul>
                    </div>
                </div>
            </header>
            <h3>Please fill those information to complete your profile</h3>
            <form id="msform" name="msform" class="form-horizontal member-edit-form" action="${rc.contextPath}/addmemberdetails" method="post">
               	<input type="hidden" value="1" id="pagenum" name="pagenum"/>
                <!-- fieldsets -->
                <fieldset>
                    <div class="col-md-6">
                        <h2 class="fs-title">English</h2>   
                        <div class="form-group">
                        	<input type="hidden" value="${currentuser.pid!''}" id="pid" name="pid"/>
                            <label class="col-sm-3 control-label">First name</label>
                            <div class="col-sm-9">
                                <input type="text" id="fname" name="fname" value="${currentuser.fname!''}" class="form-control" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Last name</label>
                            <div class="col-sm-9">
                                <input type="text" id="lname" name="lname" value="${currentuser.lname!''}" class="form-control" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Middle name</label>
                            <div class="col-sm-9">
                                <input type="text" id="mname" name="mname" value="${currentuser.mname!''}" class="form-control" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Nick name</label>
                            <div class="col-sm-9">
                                <input type="text" id="nname" name="nname" value="${currentuser.nname!''}" class="form-control" >
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <h2 class="fs-title">Japanese</h2>                  
                        <div class="form-group">
                            <label class="col-sm-3 control-label">First name</label>
                            <div class="col-sm-9">
                                <input type="text" id="fdname" name="fdname" value="${currentuser.fdname!''}" class="form-control" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Last name</label>
                            <div class="col-sm-9">
                                <input type="text" id="ldname" name="ldname" value="${currentuser.ldname!''}" class="form-control" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Middle name</label>
                            <div class="col-sm-9">
                                <input type="text"  id="mdname" name="mdname" value="${currentuser.mdname!''}" class="form-control" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Nick name</label>
                            <div class="col-sm-9">
                                <input type="text" id="ndname" name="ndname" value="${currentuser.ndname!''}" class="form-control" >
                            </div>
                        </div>
                    </div>

                    <input type="button" name="next" class="next action-button" value="Next" />

                </fieldset>

                <fieldset>                   
                    <div class="col-md-6">
                        <h2 class="fs-title">English</h2>   
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Address</label>
                            <div class="col-sm-9">
                                <textarea class="form-control" id="adr" name="adr" rows="3">${currentuser.adr!''}</textarea>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Company name</label>
                            <div class="col-sm-9">
                                <input type="text" id="cna" name="cna" value="${currentuser.cna!''}" class="form-control" >
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <h2 class="fs-title">Japanese</h2>   
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Address</label>
                            <div class="col-sm-9">
                                <textarea class="form-control" id="adrj" name="adrj" rows="3">${currentuser.adrj!''}</textarea>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Company name</label>
                            <div class="col-sm-9">
                                <input type="text" id="cnj" name="cnj" value="${currentuser.cnj!''}" class="form-control" >
                            </div>
                        </div>
                    </div>
                    <input type="button" name="previous" class="previous action-button" value="Previous" />
                    <input type="button" name="next" class="next action-button" value="Next" />
                </fieldset>
                
                <fieldset>
                    <h2 class="fs-title">Choose the Settlement Option</h2>
                    <div class="col-md-4 col-xs-6 col-md-offset-4">
                        <select class="form-control"  id="stlc" name="stlc">
                        <#list settlement as set>
                            <option value="${set.stlc}">${set.stlc}</option>
                         </#list>
                        </select>
                    </div>
                    <input type="button" name="previous" class="previous action-button" value="Previous" />
                    <input type="button" name="button" class="submit action-button" value="Submit" onclick="memberdetail('${rc.contextPath}')"/>
                </fieldset>
            </form>
        </div>
        <!-- multistep form -->
        <script type="text/javascript" src="${rc.contextPath}/js/jquery-1.10.2.js"></script>
		<script type="text/javascript" src="${rc.contextPath}/js/jquery-ui.js"></script>
		<script type="text/javascript" src="${rc.contextPath}/js/jquery.form.js"></script>
		<script type="text/javascript" src="${rc.contextPath}/js/custome/form.js"></script>
        

    </body>
