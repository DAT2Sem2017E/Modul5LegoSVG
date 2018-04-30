package dk.cphbusiness.legohouse.presentation;

/**
 The purpose of SVGUtil is to...

 @author kasper
 * Modified by: Thomas
 */
public class SVGUtil {

    /**
     Draw a lego house from the long side (that is, width is unused)

     @param length
     
     @param height
     @return SVG string which draws the house
     */
    public String house( int length, int height ) {
        StringBuilder sb = new StringBuilder();
        for ( int layer = 0; layer <= height; layer++ ) {
            sb.append( layer( length, layer ) );
        }
        return sb.toString();
    }

    /**
     Alternates between filling in left or right end, and if corner stone is in
     left or
     right end.

     @param length
     @param height
     @return SVG string which draws a layer
     */
    private String layer( int length, int height ) {
        switch ( height % 4 ) {
            case 0:
                return layerRightward( length, height, true );
            case 1:
                return layerRightward( length, height, false );
            case 2:
                return layerLeftward( length, height, true );
            case 3:
                return layerLeftward( length, height, false );
        }
        return "";
    }

    private String layerRightward( int length, int yPos, boolean start ) {
        length = length - 2; // make room for a four brick seen from the end
        if ( start ) {
            return mainLayRightward( length, 0, yPos ) + brick( 2, length, yPos );
        } else {
            return brick( 2, 0, yPos ) + mainLayRightward( length, 2, yPos );
        }
    }

    private String layerLeftward( int length, int yPos, boolean start ) {
        length = length - 2;
        if ( start ) {
            return mainLayLeftward( length, 0, yPos ) + brick( 2, length, yPos );
        } else {
            return brick( 2, 0, yPos ) + mainLayLeftward( length, 2, yPos );
        }
    }

    private String mainLayRightward( int length, int xPos, int yPos ) {
        StringBuilder sb = new StringBuilder();
        while ( length >= 4 ) { // Place all the 4-bricks
            sb.append( brick( 4, xPos, yPos ) );
            length = length - 4;
            xPos = xPos + 4;
        }
        if ( length >= 2 ) { // Place the 2 brick (if needed)
            sb.append( brick( 2, xPos, yPos ) );
            length = length - 2;
            xPos = xPos + 2;
        }
        if ( length == 1 ) { // Place the 1 brick (if needed)
            sb.append( brick( 1, xPos, yPos ) );
        }
        return sb.toString();
    }

    private String mainLayLeftward( int length, int xPos, int yPos ) {
        StringBuilder sb = new StringBuilder();
        if ( ( length % 2 ) == 1 ) {// Place the 1 brick (if needed)
            sb.append( brick( 1, xPos, yPos ) );
            length--;
            xPos++;
        }
        if ( length % 4 == 2 ) {// Place the 2 brick (if needed)
            sb.append( brick( 2, xPos, yPos ) );
            length = length - 2;
            xPos = xPos + 2;
        }
        while ( length >= 4 ) {// Place the 4 bricks
            sb.append( brick( 4, xPos, yPos ) );
            length = length - 4;
            xPos = xPos + 4;
        }
        return sb.toString();
    }

//    collour brick sizes 1,2 and 4 differently:
    private static final String[] BRICK_COL = { "none", "#5555FF", "#00DD00", "none", "#FF0000" };

    private String brick( int size, int xPos, int yPos ) {
        // A one-brick is drawn as a 100x100 rectangle. A four-brick as a 400x100 rectangle
        // The excessive scaling is done to prevent the lines around the bricks to become
        // wery thick when scaled 
        // The colors are based on size, and stored in the static array above
        String res = "<rect x='" + xPos * 100 + "' y='" + yPos * 100 + "' width='" + size * 100 + "' height='100'"
                + "style=\"stroke: #000000; fill: " + BRICK_COL[ size ] + "\"/>";
        // Inside each brick is a text which says its size. The number must be placed in the middle
        // of the brick. The x coordinate is thus the same as the brick, plus 50% of the brick size
        // inaddition, I specify that the text is anchored in the middle.
        // The font size is set to 50px - which is half the height of the brick height
        // The y coordinate is then added 50 (to get to the middle, and the text baseline 
        // is specified to sit in the middle 
        res += "<text x='" + ( xPos * 100 + ( size * 100 ) / 2 ) + "' y='" + ( yPos * 100 + 50 ) + "' "
                + "font-family=\"Verdana\" font-size=\"50px\""
                + "text-anchor=\"middle\" alignment-baseline=\"middle\">"
                + size + "</text>\n";
        return res;
    }

}
