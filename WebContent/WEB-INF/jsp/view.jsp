<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>
<form action="Add" method="post">
	<table id="formTable" class="formTable">
		<tbody>
			<tr>
				<td>Nimi:</td>
				<td>
					<input id="nameBox" name="name" disabled="${'true'}" value="${name}" />
				</td>
			</tr>
			<tr>
				<td>Kood:</td>
				<td>
					<input id="codeBox" name="code"  disabled="${'true'}" value="${code}" />
				</td>
			</tr>
			<tr>
          		<td>Ülemüksus:</td>
          		<td>
          			<select id="superUnitCode" name="superUnitCode" disabled="${'true'}" >
        				<option value=""></option>
        				<c:forEach items="${selectUnit}" var="unit">
                                <c:choose>
                                      <c:when test="${superUnit.id==unit.id}">
                                              <option value="${unit.id}" selected='selected'>${unit.name}</option>
                                      </c:when>
                                      <c:otherwise>
                                              <option value="${unit.id}">${unit.name}</option>
                                      </c:otherwise>
                                </c:choose>
                        </c:forEach>
        			</select>
	          </td>
	        </tr>
			<tr>
	          <td>Alamüksused:</td>
	          <td>   
	          <c:forEach items="${child}" var="unit" varStatus="status">
                      <span id="sub_${unit.code}">${unit.code}</span><c:if test="${status.last==false}">, </c:if>
              </c:forEach>         
	          </td>
	        </tr>
			<tr>
				<td align="right" colspan="2">
					<br />
					<a href="<c:url value="Search" />" id="backLink">Tagasi</a>
				</td>
			</tr>
		</tbody>
	</table>
</form>
<%@ include file="footer.jsp" %>