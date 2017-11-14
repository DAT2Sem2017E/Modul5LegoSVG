<%-- 
    Document   : drawing
    Created on : Nov 11, 2017, 11:29:18 AM
    Author     : kasper
--%>

<%@page import="dk.cphbusiness.soft.legohousedraw.presentation.SVGUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% int length = 15; // get this from a request attribute
   int width = 9; // get this from a request attribute
   int height = 9; // ditto
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Wow - a wall</h1>
        <!-- lav SVG Kanvas der passer i størrelsen og og giver os et 
             logisk koordinat system der er 100 gange størrer -->
        <svg width="<%=length%>cm" height="<%=height%>cm" 
             viewBox="0 0 <%=length*100+1%> <%=height*100+1%>">
        <!-- Benyt samme princip som tidligere til RenderUtils - her er det blot SVG vi genererer -->
        <%= SVGUtil.house(length , width, height) %>
        </svg>
    </body>
</html>
