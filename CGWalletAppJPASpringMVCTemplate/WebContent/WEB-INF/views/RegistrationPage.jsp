<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.error {
	color: red;
	font-weight: bold;
}
.head {
background: aqua;
border: thin;
}
</style>
</head>
<body bgcolor="AFD4D5">
	<div align="center" class="head">
		<h1><font color="blue">Welcome to Registration Page</font></h1>
	<hr/>
	</div>
 
	<table>
		<form:form action="registerCustomer" method="post"
			modelAttribute="customer">

			<tr>
				<td>Enter Name :</td>
				<td><form:input path="name" size="30" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>

			<tr>
				<td>Enter Mobile Number :</td>
				<td><form:input path="mobileNo" size="10" /></td>
				<td><form:errors path="mobileNo" cssClass="error" /></td>
			</tr>

			<tr>
				<td>Enter initial Balance :</td>
				<td><form:input path="wallet.balance" size="20" /></td>
				<td><form:errors path="wallet.balance" cssClass="error" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="REGISTER" /></td>
				<td></td>
			</tr>
		</form:form>
	</table>
</body>
</html>