<%--
  Created by IntelliJ IDEA.
  User: NJENGA
  Date: 2021-10-04
  Time: 08:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.hospital.appointment.model.Book"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>


<html>
<head>
    <style>
        table, th, td {
            border: 1px solid black;
            height:50px;
            width: 100%;
            border-collapse: collapse;
            background-color: white;
        }
        body{
            background-color: green;
        }
        table{
            width: 75%
        }
    </style>

<body>


<%--<jsp:include page="general_header.jsp"/>--%>

<table>
    <thead>
    <tr>
        <th>Patient Id</th>
        <th>Name</th>
        <th>Age</th>
        <th>Email</th>
        <th>National ID</th>
        <th>Location</th>
        <th>Payment Method</th>
        <th>Date of Birth</th>
    </tr>
    </thead>
    <tbody>
    <%List<Book> bookings=new ArrayList<Book>();

        bookings=(List)request.getSession().getAttribute("bookdata");
        for (Book booking:bookings){%>
    <tr>
        <td><%=booking.getId()%></td>
        <td><%=booking.getName()%></td>
        <td><%=booking.getAge()%></td>
        <td><%=booking.getEmail()%></td>
        <td><%=booking.getNationalId()%></td>
        <td><%=booking.getLocation()%></td>
        <td><%=booking.getPaymentMethod()%></td>
        <td><%=booking.getDateOfBirth()%></td>
        <%--<td><a href="../appointment/delete">Delete</a></td>--%>
        <td><a href="./delete?id=<%=booking.getId()%>">Delete</a></td>
        <%session.setAttribute("array",booking.getId());%>
        <td><a href="../book.jsp">Updating</a></td>
        <td><a href="../order?id=<%=booking.getId()%>">Confirm</a></td>

        <%--<%session.setAttribute("deleteId",booking.getId());%>--%>
    </tr>
    <%}%>
    </tbody>
</table>

</body>

</html>

