<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
    <title>Bank Services</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!--      <script type="text/javascript" src="lib/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="lib/angular-1.4.8/angular.min.js"></script>
    <script type="text/javascript" src="lib/angular-1.4.8/angular-resource.js"></script>
    <script type="text/javascript" src="lib/angular-1.4.8/angular-route.js"></script>
    <script type="text/javascript" src="app.js"></script>
    <script type="text/javascript" src="service.js"></script>
    <script type="text/javascript" src="loginController.js"></script>
    <script type="text/javascript" src="paymentController.js"></script> -->
</head>
<body >
<br><br>
<center><img src="http://rhemawest.co.za/wp-content/uploads/2014/02/Payfast-Banner.jpg"/></center>
<div class="container">
    <br><br>
    <div class="col-sm-offset-1 col-sm-10">
        <h2>Enter Your Personal Bank Detail's :</h2>
        <br><br>
    </div>
    <br><br>
    <% double amount=(Double)request.getAttribute("amount");
    	String id = (String)request.getAttribute("id");
    	int account_no = (Integer) request.getAttribute("account");%>
    <form class="form-horizontal" role="form" action = "http://DIN51002651.corp.capgemini.com:8080/Banking/validate" method="post">
        <div class="form-group">
            <label class="control-label col-sm-2" for="email">Login Id:</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" name="user" id="email" placeholder="Enter Your Login Id" ng-model="username"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="pwd">Password:</label>
            <div class="col-sm-5">
                <input type="password" class="form-control" name="pass" id="pwd" placeholder="Enter Your Password" ng-model="passwor"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                    <label><input type="checkbox"> Remember Me</label>
                </div>
            </div>
        </div>
        <div>
        <input type="hidden" name = "amount" value =<%=amount %>>
          <INPUT TYPE="HIDDEN" NAME="pay_id" VALUE=<%=id %>>
          <INPUT TYPE="HIDDEN" NAME="account_no" VALUE=<%=account_no%>>
    <!--       <input type="hidden" name = "amount" value ="amount"> -->
    
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit"  value="Login">
            </div>
        </div>
    </form>
</div>

</body>
</html>
