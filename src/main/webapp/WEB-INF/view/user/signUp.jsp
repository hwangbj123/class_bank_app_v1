<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/view/layout/header.jsp" %>

<!-- start main.jsp -->
<div class="col-sm-8">
	<h2>회원 가입</h2>
	<h5>어서오세요 환영합니다</h5>
	<div class="bg-light p-md-5 h-75">
		<form action="/user/sign-up" method="post">
		  <div class="form-group">
		    <label for="username">Username : </label>
		    <input type="text" class="form-control" placeholder="Enter username" id="username" name="username">
		  </div>
		  <div class="form-group">
		    <label for="pwd">Password : </label>
		    <input type="password" class="form-control" placeholder="Enter password" id="pwd" name="password">
		  </div>
		  <div class="form-group">
		    <label for="fullname">Fullname : </label>
		    <input type="text" class="form-control" placeholder="Enter fullname" id="fullname" name="fullname">
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</div>
<!-- end of main.jsp -->

<%@ include file="/WEB-INF/view/layout/footer.jsp" %>
</body>
</html>