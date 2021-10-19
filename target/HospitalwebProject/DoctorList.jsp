<%--
  Created by IntelliJ IDEA.
  User: NJENGA
  Date: 2021-10-06
  Time: 07:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.hospital.appointment.model.Book"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Doctor</title>
</head>
<body>
    <%HttpSession httpSession=request.getSession();
        List<Book> bookings=new ArrayList<Book>();
        bookings=(List)httpSession.getAttribute("bookdata");
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
