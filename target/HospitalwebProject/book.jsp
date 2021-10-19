<%@ page import="com.hospital.appointment.model.Book" %><%--
  Created by IntelliJ IDEA.
  User: NJENGA
  Date: 2021-09-30
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .inputform{

            width: 700px;
            height: 500px;
            background-color: rgba(238, 238, 247,0.9);
            display: flex;
            margin-top: 70px;
            margin-bottom: 50px;

        }
    </style>

</head>
<body>
<section class="inputform">
    <%String var=(String)session.getAttribute("array");
    System.out.println(var);%>

    <h3>Patients Form</h3>

    <form action="./appointment/save" method="POST">

        <hr/>
        <label>Name:</label><br>
        <input type="text" id="name" name="name"><br>

        <label>Email:</label><br>
        <input type="text" id="email" name="email"><br><br>

        <label >Age:</label><br>
        <input type="number" id="age" name="age"><br><br>

        <label>Date of birth:</label><br>
        <input type="date" id="dateOfBirth" name="dateOfBirth"><br><br>

        <label >National Id:</label><br>
        <input type="text" id="nationalId" name="nationalId"><br><br>

        <label >Location:</label><br>
        <input type="text" id="location" name="location"><br><br>

        <label >Payment Method:</label><br>
        <input type="text" id="paymentMethod" name="paymentMethod"><br><br>

        <input type="submit" value="Submit">
    </form>
</section>


</body>
</html>
