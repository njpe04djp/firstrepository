<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
            <th>ID</th>
            <th>companyName</th>
            <th>Address</th>
            <th>Email</th>
            <th>Phone</th>
            <th>salesName</th>
            <th>salesPhone</th>
            <th>salesEmail</th>
            <c:forEach items="${message}" var="student">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.companyname}</td>
                    <td>${student.address}</td>
                    <td>${student.email}</td>
                    <td>${student.phone}</td>
                    <td>${student.salesName}</td>
                    <td>${student.salesPhone}</td>
                    <td>${student.salesEmail}</td>
                    
                </tr>
            </c:forEach>                 
        </table>
</body>
</html>