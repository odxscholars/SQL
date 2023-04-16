<%--
  Created by IntelliJ IDEA.
  User: shems
  Date: 4/15/2023
  Time: 4:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import = "java.util.*, assetManagement.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:useBean id="A" class="assetManagement.assets" scope="session"/>
    <%
        //receive values
        String v_assetName = request.getParameter("asset_name");
        A.asset_name = v_assetName;
        int status = A.register_asset();
        if (status == 1) {
    %>
    <h1>Registering Asset Successful</h1>
    <%
        } else {
    %>
    <h1>Registering Asset Failed</h1>
    <%
        }
    %>





</body>
</html>
