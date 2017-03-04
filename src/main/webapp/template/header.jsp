<%
    if (session.getAttribute("id") == null || session.getAttribute("id").equals("")) response.sendRedirect("/login.jsp");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="../plugin/bootstrap-table/dist/bootstrap-table.css">

    <link href="../plugin/datepicker/datepicker3.css" rel="stylesheet">

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

    <!-- Latest compiled and minified JavaScript -->
    <script src="../plugin/bootstrap-table/dist/bootstrap-table.js"></script>



    <script src="../plugin/datepicker/bootstrap-datepicker.js"></script>


</head>
<body>

