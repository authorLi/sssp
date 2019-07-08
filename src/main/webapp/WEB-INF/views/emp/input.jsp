<%--
  Created by IntelliJ IDEA.
  User: 52489
  Date: 2019/7/7
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工添加</title>
    <script src="../webjars/jquery/3.3.1/jquery.min.js"></script>
    <script>
        $(function () {
            $('#lastName').change(function () {
                var val = $(this).val();
                val = $.trim(val);
                $(this).val(val);

                //改回原用户名可用
                var oldName = $("#old_lastName").val();
                oldName = $.trim(oldName);
                if (oldName != null && oldName != "" && oldName == val){
                    alert("用户名可用");
                    return ;
                }

                var url = "${pageContext.request.contextPath }/ajaxValidateLastName";
                var args = {"lastName":val,"date":new Date()};
                $.post(url,args,function (data) {
                    if (data == "0"){
                        alert("用户名可用");
                    }else if(data == "1"){
                        alert("用户名不可用");
                    }else{
                        alert("网络出错");
                    }
                })
            })
        })
    </script>
</head>
<body>
<c:set value="${pageContext.request.contextPath }/emp" var="url"></c:set>
<c:if test="${employee.id != null }">
    <c:set value="${pageContext.request.contextPath }/emp/${employee.id }" var="url"></c:set>
</c:if>
<form:form action="${url }" method="post" modelAttribute="employee">
    <c:if test="${employee.id != null }">
        <input type="hidden" id="old_lastName" value="${employee.lastName }">
        <form:hidden path="id" />
        <input type="hidden" name="_method" value="PUT" />
    </c:if>
    LastName:<form:input path="lastName" id="lastName" /><br/>
    Email:<form:input path="email" /><br/>
    Birth:<form:input path="birth" /><br/>
    Department:<form:select path="department.id" items="${departments }"
                            itemLabel="departName" itemValue="id"></form:select><br/>
    <input type="submit" value="提交" />
</form:form>
</body>
</html>
