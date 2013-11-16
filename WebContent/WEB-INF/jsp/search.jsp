<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>search</title>
<link rel="stylesheet" href='<c:url value="/style.css" />' />
</head>
<body>
	<form action="Search" method="post">
	        <input id="searchStringBox" value="" name="searchString" /> <input
	                id="filterButton" type="submit" value="Filtreeri" /> <br /> <br />
	
		<table id="listTable" class="listTable">
		        <thead>
		                <tr>
		                        <th scope="col">Nimi</th>
		                        <th scope="col">Kood</th>
		                        <th scope="col"></th>
		                </tr>
		        </thead>
		        <tbody>
		                <c:forEach var="unit" items="${searchResults}">
		                  <tr>
		                          <td>
		                                  <div id="row_${unit.code}">${unit.name}</div>
		                          </td>
		                          <td>
		                                  ${unit.code}
		                          </td>
		                  </tr>
		          </c:forEach>
		        </tbody>
		</table>
	</form>
</body>
</html>