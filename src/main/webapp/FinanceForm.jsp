<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: NJENGA
  Date: 2021-10-09
  Time: 05:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
</head>
<body>
<%
        String id;
        id=(String)request.getSession().getAttribute("id");
        System.out.println("ssssssssssssssssssssssss"+id);
                %>

<div id="financeForm"></div>
<script src="js/hospital.lib.js"></script>
<script src="js/Finances.js"></script>
<%--<script>
    $('select').change(function (){
        console.log($(this).value());
    });
</script>--%>

</body>
</html>
