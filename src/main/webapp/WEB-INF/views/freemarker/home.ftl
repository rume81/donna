<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	       
		<title>Donna</title>
	    <link rel="shortcut icon" href="${rc.contextPath}/css/common/images/favicon2.ico"/>
	    
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="Donna">
		<meta name="keywords" content="Donna">
		<meta name="author" content="Abdulla Al Monsur, Ole Ul Islam">
	
		<!-- Bootstrap Css -->
	    <link href="${rc.contextPath}/css/common/bootstrap.min.css" rel="stylesheet">	        
	    <!-- Style -->
		<link href="${rc.contextPath}/css/common/style.css" rel="stylesheet">	        
			
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="${rc.contextPath}/js/jquery.min.js"></script>
		<script src="${rc.contextPath}/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${rc.contextPath}/js/ajaxHelper.js"></script>
		
	    
	    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
	
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script type="text/javascript" src="${rc.contextPath}/js/jquery-1.10.2.js"></script>
		<script type="text/javascript" src="${rc.contextPath}/js/jquery-ui.js"></script>
		<script type="text/javascript" src="${rc.contextPath}/js/jquery.form.js"></script>
		<script type="text/javascript" src="${rc.contextPath}/js/jquery.blockUI.js"></script>
		<script type="text/javascript" src="${rc.contextPath}/js/custome/custome.js"></script>
	</head>
	<body>
        <div class="container">
            <header>
                <div class="home-header">
                    <div class="col-md-2">
                        <h3>Donna</h3>
                    </div>
                    <div class="col-md-4 col-md-offset-6 text-right">
                        <ul class="right-top-nav">
                            <li class="username">${currentuser.getFname()!''}</li>
                            <li class="user"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></li>
                            <li class="logout"><button type="button" onclick="logout('${rc.contextPath}')" class="btn btn-default">Log Out</button></li>
                        </ul>

                    </div>
                </div>
            </header>
            <div class="col-md-12">
                <div class="col-md-10 col-md-offset-1 task">
                    <ul class="home-task">
                        <li>
                            <a href="${rc.contextPath}/member"><p>${member!''}</p>
	                            <p class="home-member">new Member</p>
	                            <p>in last 7 days</p>                           
                            </a>
                        </li>
                        <li>
                            <a href="${rc.contextPath}/demand"><p>${demand!''}</p>
	                            <p class="home-member">new Demand</p>
	                            <p>in last 7 days</p>
                            </a>
                        </li>
                        <li>
                            <a href="${rc.contextPath}/supply"><p>${supply!''}</p>
	                            <p class="home-member">new Supply</p>
	                            <p>in last 7 days</p>
                            </a>
                        </li>
                        <li>
                            <a href="${rc.contextPath}/category"><p>${category!''}</p>
	                            <p class="home-member">new Category</p>
	                            <p>in last 7 days</p>
                            </a>
                        </li>
                        <li>
                            <a href="${rc.contextPath}/settlement"><p>${settlement!''}</p>
	                            <p class="home-member">new Settlement</p>
	                            <p>in last 7 days</p>
                            </a>
                        </li>
                        <li>
                            <a href="${rc.contextPath}/shipping"><p>${shipping!''}</p>
	                            <p class="home-member">new Shipping Method</p>
	                            <p>in last 7 days</p>
                            </a>
                        </li>
                        <li>
                            <a href="${rc.contextPath}/currency"><p>${currency!''}</p>
	                            <p class="home-member">new Currency</p>
	                            <p>in new last 7 days</p>
                            </a>
                        </li>
                        <li>
                            <a href="${rc.contextPath}/brand"><p>${brand!''}</p>
	                            <p class="home-member">new Brand</p>
	                            <p>in last 7 days</p>
                            </a>
                        </li>
                        <li>
                            <a href="${rc.contextPath}/transaction"><p>${trans!''}</p>
                            	<p class="home-member">new Transaction Log</p>
	                            <p>in last 7 days</p>
                            </a>
                        </li>

                    </ul>
                </div>
            </div>
			<footer>
	    		<p class="text-center">Copyright &copy;  2017 EY. All rights reserved.</p>
	        </footer>
        </div>
    </body>
</html>