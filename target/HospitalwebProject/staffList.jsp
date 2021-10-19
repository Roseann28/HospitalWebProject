
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import="com.hospital.staff.model.Staff" %>
<html>
       <head>
       <style>
           <%String link="../images/hosipital.webp";%>
           body{
               background-image: url("<%=link%>");
               background-size: 1350px 800px;
               background-repeat: no-repeat;
           }
             .card-arrange{
                 display: flex;
             }
             .card{
                 border: 2px solid black;
                 margin: 20px;
                 background-color: rgba(238, 238, 247,0.9);
             }
             .card-img-top{
                 width: 150px;
                 height: 100px;
             }
        </style>
        </head>

        <body>
        <div class="card-arrange">
                        <%--<jsp:include page="navbar.jsp"/>

                        <jsp:include page="general_header.jsp"/>--%>
         <%List<Staff> staffs=new ArrayList<Staff>();
          staffs=(List)request.getAttribute("staffdata");
          for (Staff staff:staffs){%>
               <div class="card" style="width: 150px">
                   <img src="../images/person.jpg" class="card-img-top">
                    <div class="card-body">
                         <h5 class="card-title"><%=staff.getName()%></h5>
                         <h6 class="card-subtitle mb-2 text-muted"><%=staff.getDepartment()%></h6>
                         <p class="card-text"><%=staff.getSpecialisation()%></p>
                         <a href="../DoctorList.jsp" class="card-link">Details</a>
                    </div>
               </div>
          <%}%>
        </div>
        </body>
</html>