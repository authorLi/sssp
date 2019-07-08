<%--
  Created by IntelliJ IDEA.
  User: 52489
  Date: 2019/7/7
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>员工列表</title>
    <script src="../webjars/jquery/3.3.1/jquery.min.js"></script>
    <script>
        $(function () {
            $('.delete').click(function () {
                var label = $(this).next(":hidden").val();
                var flag = confirm("确定要删除" + label + "的信息吗?");
                if (flag) {
                    var url = $(this).attr("href");
                    $('#_form').attr("action",url);
                    $('#_method').val("DELETE");
                    $('#_form').submit();
                }
            });
        })
    </script>
</head>
<body>

<form method="post" id="_form">
    <input type="hidden" id="_method" name="_method" />
</form>

<c:if test="${info eq null || info.numberOfElements eq 0}">
    没有任何记录
</c:if>
<br/>
<c:if test="${info != null}">
    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>LastName</th>
            <th>Email</th>
            <th>Birth</th>
            <th>CreateTime</th>
            <th>Department</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${info.content }" var="emp">
            <tr>
                <th>${emp.id }</th>
                <th>${emp.lastName }</th>
                <th>${emp.email }</th>
                <th>
                    <fmt:formatDate value="${emp.birth }" pattern="yyyy-MM-dd" />
                </th>
                <th>
                    <fmt:formatDate value="${emp.createTime }" pattern="yyyy-MM-dd hh:mm:ss" />
                </th>
                <th>${emp.department.departName }</th>
                <th><a href="${pageContext.request.contextPath }/emp/${emp.id }" >Edit</a> </th>
                <th>
                    <a href="${pageContext.request.contextPath }/emp/${emp.id }" class="delete" onclick="return false">Delete</a>
                    <input type="hidden" value="${emp.lastName }" />
                </th>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="8">共${info.totalElements}条记录，共${info.totalPages}页，当前第${info.number + 1}页
                <c:if test="${info.number != 0}"><a href="?pageNum=${info.number + 1 - 1}">上一页</a></c:if>
                <c:if test="${info.number + 1 != info.totalPages}"><a href="?pageNum=${info.number + 1 + 1}">下一页</a></c:if>
            </td>
        </tr>
    </table>
</c:if>


</body>
</html>
