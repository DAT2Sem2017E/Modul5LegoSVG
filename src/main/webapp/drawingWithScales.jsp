<%-- 
    Document   : drawingWithScales
    Created on : Nov 14, 2017, 11:35:00 AM
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
        <title>Wall Page</title>
    </head>
    <body>
        <h1>Wow - an even better wall</h1>
        <!-- lav SVG Kanvas der passer i størrelsen og og giver os et 
             logisk koordinat system der er 100 gange størrer -->
        <svg width="75%" 
             viewBox="0 0 <%=length*100 + 200%> <%=height*100 + 200%>">
            <defs>
                <marker id="beginArrow" 
                    markerWidth="9" markerHeight="9" 
                    refX="0" refY="4" 
                    orient="auto">
                    <path d="M0,4 L8,0 L8,8 L0,4" style="fill: #000000;" />
                </marker>
                <marker id="endArrow" 
                    markerWidth="9" markerHeight="9" 
                    refX="8" refY="4" 
                    orient="auto">
                    <path d="M0,0 L8,4 L0,8 L0,0" style="fill: #000000;" />
                </marker>
            </defs>
            <svg x="200" y="0" width="<%=length*100%>" height="<%=height*100%>" 
                viewBox="0 0 <%=length * 100 + 1%> <%=height * 100 + 1%>">
                <%= SVGUtil.house( length, width, height ) %>
            </svg>
            <!-- Vertical line -->
            <line x1="100"  y1="0" x2="100" y2="<%=height*100%>" 
                style="stroke:#006600;
                       marker-start: url(#beginArrow);
                       marker-end: url(#endArrow);"/>
            <text x="140" y="<%=height*100/2%>"
                  font-size="40px"
                  text-anchor="middle"
                  style="writing-mode: tb;">Height: <%=height%></text>
            <!-- Horizontal line %-->
            <line x1="200"  y1="<%=height*100+100%>" x2="<%=length*100+200%>"   y2="<%=height*100+100%>" 
                style="stroke:#006600;
                       marker-start: url(#beginArrow);
                       marker-end: url(#endArrow);"/>
            <text x="<%=length*100/2+200%>" y="<%=height*100+80%>"
                  font-size="40px"
                  text-anchor="middle">Width: <%=length%></text>
        </svg>
    </body>
</html>
