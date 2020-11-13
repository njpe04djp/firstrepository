<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
<table border="1">
            <th>ID</th>
            <th>companyName</th>
            
            <c:forEach items="${message}" var="student">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.companyname}</td>
           
                </tr>
            </c:forEach>                 
        </table>  
</body>
</html>