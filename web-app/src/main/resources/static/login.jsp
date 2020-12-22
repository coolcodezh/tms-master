<%--
  Created by IntelliJ IDEA.
  User: leyi
  Date: 2020/10/13
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList" contentType="text/html;charset=utf-8" language="java" %>
<%@ page import="java.util.LinkedList" %>
<html>
<head>
    <title>系统登录(JSP)</title>
</head>
<body>
    <h1>TMS系统登录</h1>
    <%@ include file="header.jsp" %>

    <form method="post" action="">
        <label>用户名:</label>
    </form>

    <%
        String s1 = "Hello World";
        int a = 3, b=5;
        int c = a+b;
        int[] arr = {1,3,5,7,9};
        //在Java代码中拼接网页代码
        out.write("<select>");
        for (int i = 0; i < arr.length; i++) {
            out.write("<option value="+arr[i]+">"+arr[i]+"</option>");
        }
        out.write("</select>");
    %>

    <%-- 在网页中拼接java代码 --%>
    <select>
    <%
        for (int i = 0; i < arr.length; i++) {
    %>
        <option value="<%=arr[i]%>"><%=arr[i]%></option>
    <%
        }
    %>
    </select>


    <%! public int add(int x, int y) {
        return x+y;
    } %>

    <input type="text" value="<%=s1+"-JSP" %>">

    <%@ include file="footer.jsp"%>
</body>
</html>
