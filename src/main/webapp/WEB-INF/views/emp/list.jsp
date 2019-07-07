<%--
  Created by IntelliJ IDEA.
  User: 52489
  Date: 2019/7/7
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>员工列表</title>
</head>
<body>

<c:if test="${page == null || page.numberOfElement == 0 }">
    没有任何记录
</c:if>


</body>
</html>
