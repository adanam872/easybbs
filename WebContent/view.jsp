<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 보기</title>
</head>
<body>

	<table>
		<tr>
			<td>작성자</td>
			<td>${board.name }</td>
			<td>작성일</td>
			<td>${board.date }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan="3">${board.title }</td>
		</tr>
		<tr>
			<td colspan="4">${board.content }</td>
		</tr>
		<tr>
			<td><a href="<c:url value='/modify?id=${board.id}'/>">수정</a></td>
			<td><a href="<c:url value='/remove?id=${board.id}'/>">삭제</a></td>
		</tr>
	</table>
</body>
</html>