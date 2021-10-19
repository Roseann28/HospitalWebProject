<%--
  Created by IntelliJ IDEA.
  User: NJENGA
  Date: 2021-10-04
  Time: 10:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>

    .navbar {
        overflow: hidden;
        background-color: #333;
        font-family: Arial;
    }


    .navbar a {
        float: left;
        font-size: 16px;
        color: white;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
    }


    .dropdown {
        float: left;
        overflow: hidden;
    }


    .dropdown .dropbtn {
        font-size: 16px;
        border: none;
        outline: none;
        color: white;
        padding: 14px 16px;
        background-color: inherit;
        font-family: inherit;
        margin: 0;
    }


    .navbar a:hover, .dropdown:hover .dropbtn {
        background-color: red;
    }


    .dropdown-content {
        display: none;
        position: absolute;
        background-color: #f9f9f9;
        min-width: 160px;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        z-index: 1;
    }


    .dropdown-content a {
        float: none;
        color: black;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
        text-align: left;
    }


    .dropdown-content a:hover {
        background-color: #ddd;
    }


    .dropdown:hover .dropdown-content {
        display: block;
    }
</style>
<body>
        <div class="navbar">
            <button type="button">Delete</button>
            <button type="button">Update</button>
            <button type="button">Confirm</button>
        </div>

</body>
<script>
    let buttons= document.getElementsByTagName("button");
    let rows=document.getElementById(".rows");
    buttons.disabled=true;
    rows.addEventListener("click",activity);
    function activity() {
        buttons.disabled=false;
    }

</script>

</html>
