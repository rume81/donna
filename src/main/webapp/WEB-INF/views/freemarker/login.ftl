<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja" lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="description" content="Donna"/>
<meta name="keywords" content="Donna"/>
<link rel="shortcut icon" href="${rc.contextPath}/css/common/images/favicon2.ico"/>
<title>Donna</title>
<link href="${rc.contextPath}/css/common/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="${rc.contextPath}/css/common/style.css">
      
<script src="${rc.contextPath}/js/jquery.min.js"></script>
<script src="${rc.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${rc.contextPath}/js/ajaxHelper.js"></script>
<script type="text/javascript" src="${rc.contextPath}/js/custome/login.js"></script>

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
        <div class="col-md-4 col-md-offset-4 login col-sm-6 col-sm-offset-3">
            <h2 class="text-center">Donna</h2>
            <h4 class="text-center">Log In</h4>
            <form>
                <div class="form-group">
                    <label for="email">Member Id</label>
                    <input type="text" class="form-control" id="pid" placeholder="P0000000001" value="">
                </div>
                <div class="form-group">
                    <label for="pwd">Password</label>
                    <input type="password" class="form-control" id="password" placeholder="********" value="">
                </div>
                <button type="button" class="btn btn-default">Cancel</button>
                <button type="button" class="btn btn-default" onclick="loginValided('${rc.contextPath}');">Log in</button>
            </form>
            <span class="error" id="errorMsg"></span>
            <p class="text-center"><a href="${rc.contextPath}/registration"> Registration </a></p>
        </div>
    </div>
</body>
</html>