/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.legohouse.presentation;

import dk.cphbusiness.legohouse.entity.Dimension;

/**
 *
 * @author thomas
 */
public class SVGCarportUtil {
    
    public String fullSVG(int canvasWidth, int canvasLength, Dimension dimension){
        
        int drawingStartX = dimension.getStartX();
        int drawingStartY = dimension.getStartY();
        int drawingWidth = dimension.getWidth();
        int drawingLength = dimension.getLength();
        int poleWidth = 10;
        int polesMaxDistance = 150;
        int numberPolesOneSide = (int) Math.ceil(drawingLength/polesMaxDistance);
        int polesAvgDistance = drawingLength/numberPolesOneSide;
        int eaves = 30; //Udhæng
        
        StringBuilder sb = new StringBuilder("<SVG width=\""+canvasWidth+"\" height=\""+canvasLength+"\" viewBox=\""+dimension.getStartX()+" "+dimension.getStartY()+" "+dimension.getWidth()+" "+dimension.getLength()+"\">");
        sb.append(rectangle(dimension.getStartX(),dimension.getStartY(),dimension.getWidth(),dimension.getLength()));
        sb.append("</SVG>");
        return sb.toString();
    }
    
    private String rectangle(int x, int y, int width, int length){
        String text = "<rect x=\""+x+"\" y=\""+y+"\" height=\""+length+"\" width=\""+width+"\" style=\"stroke:#000000; stroke-width: 3; fill: none\"/>";
        return text;
    }
    
    public static void main(String[] args) {
        SVGCarportUtil util = new SVGCarportUtil();
        System.out.println(util.fullSVG(300, 600, new Dimension(800, 800)));
    }
}
