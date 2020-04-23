<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <title>Payment</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<br><br>
<center><img src="http://rhemawest.co.za/wp-content/uploads/2014/02/Payfast-Banner.jpg"></center>
 <% int account_no = (Integer) request.getAttribute("account_no");
 	String user=(String) request.getAttribute("user");
 	double amount=(Double)request.getAttribute("amount");
 	String id = (String)request.getAttribute("id");
 	%>
<div class="container">
    <br><br>
    <div class="col-sm-offset-1 col-sm-10">
        <center><h2>Please Check Your Details :</h2></center>
        <br><br>
    </div>
    <br><br>
    <form class="form-horizontal" role="form" action="http://DIN51002651.corp.capgemini.com:8080/Banking/transaction?" method="post">
        <div class="form-group">
        	<div class="col-sm-4"></div>
        	<div class="col-sm-5">
            <label align = "center"class="control-label" >Merchant Account Number : <%= request.getAttribute("account_no") %></label>
            </div>
        </div>
         <div class="form-group">
        	 <div class="col-sm-4"></div>
        	 <div class="col-sm-5">
            <label class="control-label " for="pwd">Name : <%= request.getAttribute("username") %></label>
            </div>
        </div>
        <div class="form-group">
         <div class="col-sm-4"></div>
          <div class="col-sm-5">
            <label class="control-label" for="pwd">Amount : &#8377;<%= request.getAttribute("amount") %></label>
             </div>
        </div>
        
        <div>
      
        	<input type="hidden" name="user" value=<%=user %>>
         <INPUT TYPE="HIDDEN" NAME="merchant_account_no" VALUE=<%=account_no%>>
        <input type="hidden" name="amount" value=<%=amount%>>
        	<input type="hidden" name="id" value=<%=id%>> 
        	
        </div>
        <div class="form-group">        
            
            <div class="col-sm-4"></div>
             <div class="col-sm-5">
                <input  type="submit" value="Make Payment Now">
                  </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
