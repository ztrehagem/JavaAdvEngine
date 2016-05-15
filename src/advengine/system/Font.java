package advengine.system;

import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import org.newdawn.slick.TrueTypeFont;

public class Font {

	private static final Font i = new Font();

	private org.newdawn.slick.Font font;

	private Font() {
		// font = new TrueTypeFont( new java.awt.Font( null, java.awt.Font.PLAIN, 16 ), true );
		try {
			java.awt.Font f = java.awt.Font.createFont( java.awt.Font.PLAIN, new File( "./data/sys/font.ttf" ) );
			font = new TrueTypeFont( f, true );
		}
		catch( FontFormatException | IOException e ) {
			e.printStackTrace();
		}

		// font = new TrueTypeFont( new java.awt.Font( "Meiryo", java.awt.Font.PLAIN, 16 ), true );
		// java.awt.Font ff = new java.awt.Font( "Meiryo", java.awt.Font.PLAIN, 16 );

		// try {
		// UnicodeFont f = new UnicodeFont( "./data/sys/font.ttf", 16, false, false );
		// f.addAsciiGlyphs();
		// f.addGlyphs( 0x3000, 0x30ff );
		// f.addGlyphs( 0x4e00, 0x9fc0 );
		// font = f;
		// }
		// catch( SlickException e ) {
		// e.printStackTrace();
		// }
	}

	public static org.newdawn.slick.Font getFont() {
		return i.font;
	}
}
