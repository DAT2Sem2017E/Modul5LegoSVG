package dk.cphbusiness.soft.legohousedraw.presentation;

/**
 The purpose of SVGUtil is to...

 @author kasper
 */
public class SVGUtil {

    /**
     Draw a lego house from the long side (that is, width is unused)

     @param length
     @param width (unused)
     @param height
     @return SVG string which draws the house
     */
    public static String house( int length, int width, int height ) {
        StringBuilder sb = new StringBuilder();
        for ( int layer = 1; layer <= height; layer++ ) {
            sb.append( layer( length, height ) );
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
    private static String layer( int length, int height ) {
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

    private static String layerRightward( int length, int yPos, boolean start ) {
        length = length - 2; // make room for a four brick seen from the end
        if ( start ) {
            return mainLayRightward( length, 0, yPos ) + brick( 2, length, yPos );
        } else {
            return brick( 2, 0, yPos ) + mainLayRightward( length, 2, yPos );
        }
    }

    private static String layerLeftward( int length, int yPos, boolean start ) {
        length = length - 2;
        if ( start ) {
            return mainLayLeftward( length, 0, yPos ) + brick( 2, length, yPos );
        } else {
            return brick( 2, 0, yPos ) + mainLayLeftward( length, 2, yPos );
        }
    }

    private static String mainLayRightward( int length, int xPos, int yPos ) {
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

    private static String mainLayLeftward( int length, int xPos, int yPos ) {
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

    private static String[] brickCol = { "none", "#0000FF", "#00FF00", "none", "#FF0000" };

    private static String brick( int size, int xPos, int yPos ) {
        String res = "<rect x='" + xPos * 100 + "' y='" + yPos * 100 + "' width='" + size * 100 + "' height='100'"
                + "style=\"stroke: #000000; fill: " + brickCol[ size ] + "\"/>";
        res += "<text x='" + ( xPos * 100 + ( size * 100 ) / 2 ) + "' y='" + ( yPos * 100 + 25 ) + "' "
                + "font-family=\"Verdana\" font-size=\"50px\""
                + "text-anchor=\"middle\" alignment-baseline=\"hanging\">"
                + size + "</text>\n";
        return res;
    }

}
