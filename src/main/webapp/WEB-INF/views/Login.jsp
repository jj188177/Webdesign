<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<sf:form action ="home" method="POST" modelAttribute="login_customer">
    email: <sf:input path="email" type="text" value="${email}" /> ${emailERROR} <br>
    Password: <sf:input path="password" type="password" value = "${password}"/> ${passwordERROR}<br>
    <input type="submit" value="Login">
</sf:form>
${OK}

<hr>
<a href="register">register here</a>


</body>
</html>