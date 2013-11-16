<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>
	<form action="Search" method="get">
        <input id="searchStringBox" name="searchString" value="${param.searchString}" />
        <input id="filterButton" value="Filtreeri" type="submit">
        <br /> <br />
	
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
<%@ include file="footer.jsp" %>