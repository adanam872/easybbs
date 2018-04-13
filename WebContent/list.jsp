<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>목록</title>
</head>
<body>
	<center>		
		<table style="width: 60%; text-align: center;">
			<tr>
				<th> 번호	</th>
				<th> 제목	</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
			<c:forEach var="b" items="${list}">
		
			<tr>
				<td>${b.id }</td>
				<td><a href="./view?id=${b.id }">${b.title }</a></td>
				<td>${b.name }</td>
				<td>${b.date }</td>
			</tr>
			
			</c:forEach>
		</table>
		<p>	
		<a href="./list?currentPage=${currentPage-1 }">[이전]</a>
		<a href="./list?currentPage=${currentPage+1 }">[다음]</a> 
		</p>
		<br>
		<p> <a href="./write.jsp">글입력</a> </p>
	</center>
</body>
</html>