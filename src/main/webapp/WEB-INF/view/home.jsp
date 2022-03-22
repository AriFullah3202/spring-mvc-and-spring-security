<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
</head>
<body>


    <%@ include file="includes/base.jsp" %>  
	<%= "hello world"  %>
	<br> Current time:
	<%=Calendar.getInstance().getTime()%>
	<br>
	<a href="/dopost">post</a>
	<h1>Post</h1>


	<c:forEach var="temp" items="${catagories}">
	    <button class="btn btn-lg btn-dark"><a href="${temp.cid}" onclick="myfunction()">${temp.name}</a></button>
	
		<br>
	</c:forEach>
	
	<%-- <form:form action="">
	  <form:input path="ptitle" />
	</form:form>
	    --%>
	
    
	<c:forEach var="temppostbyCatid" items="${allpostbyCatid}">
	<div>
	   ${temppostbyCatid.ptitle}
	  <br>
	
	</div>
	
	</c:forEach>

  <div class = "row">
	<c:forEach var="tempPost" items="${posts}">
		<div class ="col-sm-4">
		<div class="card h -100 mb-4">
			${tempPost.pid}
			<h3>${tempPost.ptitle}</h3>
			${tempPost.pcontent} ${tempPost.catid}
         </div>
		</div>

		<br>
	</c:forEach>
	</div>
	
	
	<c:forEach var="tempp" items="${catagories}">
	 <c:url var="catid" value="/getCatid/">
	  <c:param name="cid" value="${tempp.cid}"></c:param>
	 </c:url>
	
	 <a href="${catid}">hello</a>
	 </c:forEach>
	<div class="row">
	<c:forEach var="tempPost" items="${msg}">
		<div class= "col-sm-4">
		<div class="card h -100 mb-4">
			${tempPost.pid}
			<h3>${tempPost.ptitle}</h3>
			${tempPost.pcontent} ${tempPost.catid}
         </div>
		</div>

		<br>
	</c:forEach>
	</div>
	
	
	<a href="/My-Website/viewPost/1"> 1</a>
<a href="/My-Website/viewPost/2"> 2</a>
<a href="/My-Website/viewPost/3"> 3</a>
<a href="/My-Website/viewPost/4"> 4</a>
<a href="/My-Website/viewPost/5"> 5</a>
<img alt="myPhotos" src="/My-Website/UrlToResourceFolder/images/01.jpg">
 <%@ include file="includes/footer.jsp" %>  
</body>


</html>