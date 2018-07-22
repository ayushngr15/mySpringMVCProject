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
	<div align="center" class="head">
		<h1>Enter the Details:</h1>
	<hr>
	</div>
	
	<form action="showTransactions" method="post">
		<table>
			<tr>
				<td>Enter Mobile Number :</td>
				<td><input type="text" name="mobileNo" size="10" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Show Transactions" /></td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>