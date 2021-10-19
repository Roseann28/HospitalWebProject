<%@ page import="com.hospital.patients.model.Patient" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: NJENGA
  Date: 2021-10-06
  Time: 05:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Patient Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>National ID</th>
        <th>Payment Method</th>
        <th>Date of Birth</th>
        <th>Specialist</th>
        <th>Doctor</th>
    </tr>
    </thead>
    <tbody>
    <%List<Patient> patients=new ArrayList<Patient>();
        patients=(List)request.getAttribute("patientdata");
        for (Patient patient:patients){%>
    <tr>
        <td><%=patient.getId()%></td>
        <td><%=patient.getName()%></td>
        <td><%=patient.getEmail()%></td>
        <td><%=patient.getNationalId()%></td>
        <td><%=patient.getPaymentMethod()%></td>
        <td><%=patient.getDateOfBirth()%></td>
        <td><%=patient.getSpecialist()%></td>
        <td><%=patient.getDoctor()%></td>
        <%--<td><a href="../appointment/delete">Delete</a></td>--%>
        <td><a href="../order?id=<%=patient.getId()%>">Add</a></td>

        <%--<%session.setAttribute("deleteId",booking.getId());%>--%>
    </tr>
    <%}%>
    </tbody>
</table>

</body>
</html>
