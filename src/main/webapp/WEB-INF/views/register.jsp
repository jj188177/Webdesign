<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>register</title>
</head>
<body>

<sf:form action ="registerSuccess" method="POST" modelAttribute="register_customer">
    email: <sf:input path="email" type="text" value = "${email}" /> ${emailERROR} <br>
    Password: <sf:input path="password" type="text" value = "${password}" /> ${passwordERROR} <br>
    fist name: <sf:input path="firstName" type="text" value = "${firstName}" />${firstNameERROR} <br>
    last name: <sf:input path="lastName" type="text" value = "${lastName}" />${lastNameERROR} <br>
    user name: <sf:input path="username" type="text" value = "${username}" /> ${userNameERROR} <br>
    address: <sf:input path="address" type="text" value = "${address}" /> ${addressERROR} <br>
    <input type="submit" value="register">
    ${ERROR}
</sf:form>

</body>
</html>