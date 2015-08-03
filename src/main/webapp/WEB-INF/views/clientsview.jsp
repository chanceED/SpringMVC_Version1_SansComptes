<%@ page language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()
%>/resources/css/style.css">
</head>
<body>
  
  <span style="float: right">
    <a href="?lang=fr">French</a> 
    | 
    <a href="?lang=en">English</a>
</span>

<h2>Bankonet Spring MVC: <spring:message code="client.title"/></h2>
<div id="formClient" class="cadre">
	<f:form action="/BankonetSpringMVC/saveClient" method="post" modelAttribute="client">
	<table  class="table1">
		<tr>
			<td> <spring:message code="client.id"/> </td>
			<td>${client.id}<f:input type="hidden" path="id"/></td>
		
		</tr>
		<tr>
			<td><spring:message code="client.lastname"/> </td>
			<td><f:input path="nom"/></td>
			<td><f:errors path="nom" class="errors"/></td>
			
		</tr>
		<tr>
			<td><spring:message code="client.firstname"/></td>
			<td><f:input path="prenom"/></td>
			<td><f:errors path="prenom" class="errors"/></td>
			
		</tr>
		<tr>
			<td><spring:message code="client.login"/></td>
			<td><f:input path="login"/></td>
			<td><f:errors path="login" class="errors"/></td>
		
		</tr>
		<tr>
			<td><spring:message code="client.password"/></td>
			<td><f:input path="motDePasse"/></td>
			<td><f:errors path="motDePasse" class="errors"/></td>
			
		</tr>
		
		<tr>
		 <td><input type="submit" value="<spring:message code="client.save"/>"/></td>
        </tr>
		
		</table>
	</f:form>
</div>
<br>
<br>
		
	
<div id="tabClients" class="cadre" >
	<table class="tabStyle1"border="1" >
	<thead>
	<tr>
		<th><spring:message code="client.id"/></th>
		<th><spring:message code="client.lastname"/></th>
		<th><spring:message code="client.firstname"/></th>
		<th><spring:message code="client.login"/></th>
		<th><spring:message code="client.password"/></th>
		<th></th>
		<th></th>
		<!--  <th></th>
		<th></th>-->	
	</tr>
	
	</thead>
	<tbody>
	<c:forEach items="${clients}" var="c">
	<tr>
	<td>${c.id}</td>
	<td>${c.nom}</td>
	<td>${c.prenom}</td>
	<td>${c.login}</td>
	<td>xxxxxxxxxxx</td>
	<td><a href="/BankonetSpringMVC/deleteClient?id=${c.id}"><spring:message code="client.delete"/></a></td>
	<td><a href="/BankonetSpringMVC/editClient/${c.id}"><spring:message code="client.edit"/></a></td>
	<!--  <td><a href=""><spring:message code="client.listeComptesCourants"/></a></td>
	<td><a href=""><spring:message code="client.listeComptesEpargnes"/></a></td>-->
	</tr>
	</c:forEach>
	</table>
</div>
 </body>
       
</html>