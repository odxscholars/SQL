<%--
  Created by IntelliJ IDEA.
  User: shems
  Date: 4/16/2023
  Time: 3:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "java.util.*, assetManagement.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <form action = "createtransfer_processing.jsp">
    <jsp:useBean id="A" class="assetManagement.assets" scope="session" />

    <select id = "assets" name ="assets">
      <%
        A.assets_fortransfer();
        for (int i = 0; i < A.asset_idlist.size(); i++) { %>
        <option value = "<%= A.asset_idlist.get(i)%>"><%= A.asset_namelist.get(i)%>
          <% } %>


        </option>
    </select><br>
    From location: <input type = "text" name = "from_location" id = "from_location" /> <br>
    To location: <input type = "text" name = "to_location" id = "to_location" /> <br>
    <input type = "submit" value = "Submit Transfer" />
  </form>

</body>
</html>
