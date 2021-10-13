<%@ page isThreadSafe="false" import="java.util.List,java.util.ArrayList" %>
<%@ page import="com.litmus7.training.dto.Category" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%//String lang = String.valueOf(session.getAttribute("lang"));%>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="com.litmus7.training.i18n.Messages"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel='stylesheet' type='text/css' href='css/categories.css'>
</head>
<body>
	<%
		String username = String.valueOf(session.getAttribute("username"));
		String val = String.valueOf(request.getAttribute("key1"));
		//String lang = String.valueOf(session.getAttribute("lang"));
	%>
	<div class="container">
		<ul>
			<c:forEach  items="${request.cookies}" var="cookieItem">
				<li>
					<p><c:out value="${cookieItem.name}. ${cookieItem.value}"></c:out></p>
				</li>
			</c:forEach>
		</ul>
		
		<p>
			Message: <fmt:message key="currency"/>
		</p>
		
		<h4><%=username %></h4>
		<h4>${val}</h4>
		<h2>Categories</h2>
		<div class="cat-container">
			<!--ul class="cat-list">
				<%
					List<Category> catList = (List<Category>) request.getAttribute("categoryList");
				
					for(Category cat: catList) {
				%>	
					<li>
						<p><%=cat.getID()%>. <%=cat.getName()%></p>
					</li>
				<%
					}
				%>
			</ul-->
			
			<ul class="cat-list">
				<c:forEach  items="${categoryList}" var="cat" varStatus="loop">
					<li>
						<p><c:out value="${loop.index + 1}. ${cat.getName()}"></c:out></p>
						<c:if test="${loop.index == 0 }"><p>Zero</p></c:if>
					</li>
				</c:forEach>	
				<c:forTokens items="josn,jack,miya" delims="," var="name">
					<c:out value="${name} "/>
				</c:forTokens>		
			</ul>
		</div>
	</div>
</body>
</html>