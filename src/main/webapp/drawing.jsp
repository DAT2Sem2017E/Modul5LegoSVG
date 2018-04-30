<%-- 
    Document   : drawing
    Created on : Nov 11, 2017, 11:29:18 AM
    Author     : kasper
--%>

<%@page import="dk.cphbusiness.legohouse.presentation.SVGUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% int length = (request.getAttribute("length")==null)?15:(int)request.getAttribute("length");
//   int width = (request.getAttribute("width")==null)?15:(int)request.getAttribute("width");
   int height = (request.getAttribute("height")==null)?9:(int)request.getAttribute("height");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Control" method="POST">
            <input type="text" name="length" placeholder="length"/>
            <!--<input type="text" name="width" placeholder="width"/>-->
            <input type="text" name="height" placeholder="height"/>
            <input type="submit" value="Draw"/>
            </form>
        <h1>Wow - a wall</h1>
        <!-- lav SVG Kanvas der passer i størrelsen og og giver os et 
             logisk koordinat system der er 100 gange størrer -->
        <svg width="75%" 
             viewBox="0 0 <%=length*100+1%> <%=height*100+1%>">
        <!-- Benyt samme princip som tidligere til RenderUtils - her er det blot SVG vi genererer -->
        <%--<%= // new SVGUtil().house(length , width, height) %>--%>
        <%
        if(request.getAttribute("drawing") == null) {
//            out.print(new SVGUtil().house(length , width, height));
            String url = "Control?length="+length+"&height="+height;
            request.getRequestDispatcher(url).forward(request, response);
        } else {
            out.print(request.getAttribute("drawing"));
        }
        
        %>
        
        </svg>
    </body>
</html>
