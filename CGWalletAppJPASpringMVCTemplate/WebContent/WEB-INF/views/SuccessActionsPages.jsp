<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.head {
background: aqua;
border: thin;
}
</style>
</head>
<body bgcolor="AFD4D5">
	<div >
		<div align="right">
			<a href="">SignOut</a>
		</div>
		<div align="center" class="head">
		<h2><font color="green" ><marquee direction="right"> Welcome</marquee></font></h2>
			<h4>Name: ${customer.name }</h4>
			<h4>Mobile Number:${customer.mobileNo}</h4>
			<h4>Wallet Balance: ${customer.wallet.balance }</h4>
		<hr />
		</div>
		
		<div align="center">
			<h2>Menu</h2>
			<br> 
			<form action="Deposit" method="post">
			<table>
			<tr><td><input type="submit" value="Deposit"/></td></tr>
			</table>
			</form>
			<form action="Withdraw" method="post">
			<table>
			<tr><td><input type="submit" value="Withdraw"/></td></tr>
			</table>
			</form>
			<form action="FundTransfer" method="post">
			<table>
			<tr><td><input type="submit" value="Fund Transfer"/></td></tr>
			</table>
			</form>
			<form action="ShowTransactions" method="post">
			<table>
			<tr><td><input type="submit" value="Show transactions"/></td></tr>
			</table>
			</form>
			
		</div>
	</div>
</body>
</html>