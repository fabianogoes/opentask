<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="Open Task - Open Source Project to Manager Task">
    <meta name="author" content="Fabiano Góes">
    <link rel="shortcut icon" href="${ pageContext.request.contextPath }/resources/img/opentask-logo.png" />

    <title>${ initParam.project }</title>

    <!-- Bootstrap core CSS -->
    <link href="${ pageContext.request.contextPath }/resources/css/bootstrap.css" rel="stylesheet">

    <link href="${ pageContext.request.contextPath }/resources/css/footer.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="${ pageContext.request.contextPath }/resources/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${ pageContext.request.contextPath }/resources/css/navbar-fixed-top.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="${ pageContext.request.contextPath }/resources/js/bootstrap/3.3.6/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="${ pageContext.request.contextPath }/resources/js/bootstrap/3.3.6/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <!-- Fixed navbar -->
	<nav class="navbar navbar-default navbar-fixed-top">
    		
    		<div class="container">
	        <div class="navbar-header">
	        		<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
		            <span class="sr-only">Toggle navigation</span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
	            		<span class="icon-bar"></span>
	          	</button>
	          	<a class="navbar-brand" href="#">
	          		<img alt="Open Task" height="40px" src="${ pageContext.request.contextPath }/resources/img/opentask-logo.png">
	          	</a>
	        </div>
        		
        		<div id="navbar" class="navbar-collapse collapse">
        		
	          	<ul class="nav navbar-nav navbar-right">
	            		<li class="dropdown">
	              		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
	              			<img alt="Usuário Logado" height="40px" src="${ pageContext.request.contextPath }/resources/img/default-avatar.png"> <span class="caret"></span>
	              		</a>
	              		<ul class="dropdown-menu">
	              			<li class="dropdown-header">Usuário logado:</li>
	                			<li><a href="#">Fabiano Góes</a></li>
	                			<li role="separator" class="divider"></li>
	                			<li><a href="#">Perfil</a></li>
	                			<li><a href="#">Configurações</a></li>
	                			<li role="separator" class="divider"></li>
	                			<li><a href="#">Sair</a></li>
	              		</ul>
	            		</li>
	          	</ul>
          	
        		</div><!--/.nav-collapse -->
        
      </div><!-- /.container -->
      
    </nav><!-- /.navbar -->

	<div class="container">

		<div class="jumbotron">
        		<h1><img alt="Open Task" height="150px" src="${ pageContext.request.contextPath }/resources/img/opentask-logo.png"> ${ initParam.project }.</h1>
        		<hr/>
        		<p>Open Source Project to Manager Task.</p>
      	</div>

		<footer class="footer">
			<hr/>
			<span class="pull-right">
				<img alt="Open Task" height="20px" src="${ pageContext.request.contextPath }/resources/img/opentask-logo.png"> 
				<a href="#">
					${ initParam.project }.in 2016 - ${ initParam.version }
				</a>
			</span>
		</footer>

    </div> <!-- /.container -->


    	<!-- Bootstrap core JavaScript ================================================== -->
    	<!-- Placed at the end of the document so the pages load faster -->
    	<script src="${ pageContext.request.contextPath }/resources/js/jquery/1.11.3/jquery.min.js"></script>
    	<script>window.jQuery || document.write('<script src="${ pageContext.request.contextPath }/resources/js/vendor/jquery.min.js"><\/script>')</script>
    	<script src="${ pageContext.request.contextPath }/resources/js/bootstrap/3.3.6/bootstrap.min.js"></script>
    	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    	<script src="${ pageContext.request.contextPath }/resources/js/bootstrap/3.3.6/ie10-viewport-bug-workaround.js"></script>
    	
  </body>
</html>
