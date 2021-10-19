<html>
<head>
    <style>
        table,thead, th, td {
            border: 1px solid black;
            height:50px;
            width: 100%;
            border-collapse: collapse;
            background-color: white;
        }
        /*body{
            background-color: green;
        }*/
        table{
            width: 75%;
        }
        .topnav {
            background-color: #333;
            overflow: hidden;
        }

        /* Style the links inside the navigation bar */
        .topnav a {
            float: left;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }


        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }


        .topnav a.active {

            color: white;
        }
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
<div class="topnav" id="topnavbar"></div>
<div id="renderer"></div>

<script src="js/hospital.lib.js"></script>
<script src="js/app.js"></script>
<script src="js/service.table.js"></script>
<script src="js/patients.list.js"></script>
<script src="js/test.list.js"></script>
<script src="js/admit.list.js"></script>
<script src="js/ailment.list.js"></script>
<script src="js/basic.list.js"></script>
<script src="js/finance.list.js"></script>
<script src="js/staff.list.js"></script>
<script src="js/department.list.js"></script>

</body>
</html>
