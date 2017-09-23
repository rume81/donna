	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="description" content="Donna"/>
	<meta name="keywords" content="Donna"/>
	<link rel="shortcut icon" href="${rc.contextPath}/css/common/images/favicon2.ico"/>
	<title>Donna</title>
	<link href="${rc.contextPath}/css/common/bootstrap.min.css" rel="stylesheet">
	<link href="${rc.contextPath}/css/common/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" href="${rc.contextPath}/css/common/jquery-ui.css"/>
	<link rel="stylesheet" href="${rc.contextPath}/css/common/style.css">
	      
	<script src="${rc.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript" src="${rc.contextPath}/js/jquery-1.10.2.js"></script>
	<script src="${rc.contextPath}/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${rc.contextPath}/js/ajaxHelper.js"></script>
	<script type="text/javascript" src="${rc.contextPath}/js/jquery-ui.js"></script>
	<script type="text/javascript" src="${rc.contextPath}/js/jquery.form.js"></script>
	<script type="text/javascript" src="${rc.contextPath}/js/custome/custome.js"></script>
	
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
	        
	</head>
    <body>
        <div id="dialog" title="Basic dialog"></div>
        <div class="container">
            <div class="col-md-12 no-padding">
            	<div class="col-md-2 no-padding dashborad-menu no-padding">
                </div>
				<div class="col-md-10 open-account">
				    <h3 class="text-center">Opening New Account</h3>
				    <div class="col-md-7 col-md-offset-2 add-new-form">
				        <form class="form-horizontal" name="registrationform" id="registrationform" action="${rc.contextPath}/addmember" method="post">
				            <div class="form-group form-radio">
				            	<input type="hidden" name="accounttype" id="account-type" value="NUSER"/>
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
				                    <button type="button" class="btn btn-default" onclick="window.location.href='${rc.contextPath}/'">Cancel</button>
				                    <button type="button" class="btn btn-default" onclick="memberregistration('${rc.contextPath}',1)">Sign Up</button>
				                </div>
				            </div>
				        </form>
				    </div>    
				</div>
			</div>

            <footer>
                <p class="text-center">Copyright &copy;  2017 WebHawks IT. All rights reserved.</p>
            </footer>
        </div>
          
    </body>