<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>
<form action="Add" method="post">
	<table id="formTable" class="formTable">
		<tbody>
			<tr>
				<td>Nimi:</td>
				<td>
					<input id="nameBox" name="name">
				</td>
			</tr>
			<tr>
				<td>Kood:</td>
				<td>
					<input id="codeBox" name="code">
				</td>
			</tr>
			<tr>
          		<td>Ülemüksus:</td>
          		<td>
          			<select id="superUnitCode" name="superUnitCode" >
        				<option value=""></option>
                        <c:forEach items="${selectUnit}" var="unit">
                                <option value="${unit.code}">${unit.name}</option>
                        </c:forEach>
        			</select>
	          </td>
	        </tr>
			<tr>
	          <td>Alamüksused:</td>
	          <td>            
	          </td>
	        </tr>
			<tr>
				<td align="right" colspan="2">
					<br>
					<input id="addButton" type="submit" value="Lisa">
				</td>
			</tr>
		</tbody>
	</table>
</form>
<%@ include file="footer.jsp" %>