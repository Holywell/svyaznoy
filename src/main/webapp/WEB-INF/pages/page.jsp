<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="table" id="tbl">
    <tr>
        <th colspan="2">
            Телефонные номера
        </th>
    </tr>
    <tr id="tableHead">
        <th>
            Телефон
        </th>
        <th>
            Дата обработки
        </th>
    </tr>

</table>

<ul class="pagination">
    <li>
        <a href="#" aria-label="Previous">
            <span aria-hidden="true">&laquo;</span>
        </a>
    </li>
    >
    <c:set var="mxp" value="${page.totalPages}"/>
    <c:forEach var="i" begin="1" end="10">
        <c:if test="${p < mxp}">
            <li><a href="javascript:void(0)" class="page" data-id="${i}"
                   style="<c:out value="${i == p ? 'color: red': ''}" />">${i}</a></li>
        </c:if>
    </c:forEach>
    <li><a href="#">....</a></li>
    <li><a href="?page=${page.totalPages}"> ${page.totalPages}</a></li>

    <li>
        <a href="#" aria-label="Next">
            <span aria-hidden="true">&raquo;</span>
        </a>
    </li>
</ul>
