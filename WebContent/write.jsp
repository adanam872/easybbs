<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 입력</title>
</head>
<body>
	<form action="./write" method="post">
		<div>이름 : </div>
	    <div><input name="name" id="name" type="text"/></div>
	    <div>비밀번호 : </div>
	    <div><input name="password" id="password" type="password"/></div>
	    <div>제목 : </div>
	    <div><input name="title" id="title" type="text"/></div>
	    <div>내용 : </div>
	    <div><textarea name="content" id="content" rows="5" cols="50"></textarea></div>
	    <div>
	        <input type="submit" value="글입력"/>
	        <input type="reset" value="초기화"/>
	    </div>
	</form>
</body>
</html>