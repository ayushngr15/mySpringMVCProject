<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		<h1><font color="blue">Enter the Details for Fund Transfer:</font></h1>
	</div>
<hr>
	<form action="fundTransfer" method="post">
          <table>
             <tr>
				<td>Enter Mobile Number :</td>
				<td><input type="text" name="mobileNo1" size="10" /></td>
			</tr>
			<tr>
				<td>Enter Transferee Mobile Number :</td>
				<td><input type="text" name="mobileNo2" size="10" /></td>
			</tr>
			<tr>
				<td>Enter Amount :</td>
				<td><input type="text" name="amount" size="10" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Transfer" /></td>
				<td></td>
			</tr>
	</table>
	</form>
</body>
</html>