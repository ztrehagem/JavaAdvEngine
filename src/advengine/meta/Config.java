package advengine.meta;

import java.io.IOException;
import advengine.container.Vector2;

public class Config {

	public static Vector2<Short>	windowPos	= new Vector2<>();
	public static byte				fontSize;
	public static Vector2<Short>	namePos		= new Vector2<>();
	public static Vector2<Short>	facePos		= new Vector2<>();
	public static Vector2<Short>	textPos		= new Vector2<>();
	public static short				textWidth;
	public static byte				textRowSize;
	public static short				lineHeight;

	private Config() {
	}

	public static void load() {
		try( MetaFileReader r = new MetaFileReader( "config" ) ) {
			String l;
			String[] sp;
			while( (l = r.readLine()) != null ) {
				if( l.equals( "" ) ) {
					continue;
				}
				if( l.equals( "window_pos" ) ) {
					sp = r.splitReadLine();
					windowPos.set( Short.valueOf( sp[0] ), Short.valueOf( sp[1] ) );
				}
				else if( l.equals( "font_size" ) ) {
					fontSize = Byte.valueOf( r.readLine() );
				}
				else if( l.equals( "name_pos" ) ) {
					sp = r.splitReadLine();
					namePos.set( Short.valueOf( sp[0] ), Short.valueOf( sp[1] ) );
				}
				else if( l.equals( "face_pos" ) ) {
					sp = r.splitReadLine();
					facePos.set( Short.valueOf( sp[0] ), Short.valueOf( sp[1] ) );
				}
				else if( l.equals( "text_pos" ) ) {
					sp = r.splitReadLine();
					textPos.set( Short.valueOf( sp[0] ), Short.valueOf( sp[1] ) );
				}
				else if( l.equals( "text_width" ) ) {
					textWidth = Short.valueOf( r.readLine() );
				}
				else if( l.equals( "text_rowsize" ) ) {
					textRowSize = Byte.valueOf( r.readLine() );
				}
				else if( l.equals( "line_height" ) ) {
					lineHeight = Short.valueOf( r.readLine() );
				}
			}
		}
		catch( IOException | ArrayIndexOutOfBoundsException e ) {
			throw new RuntimeException();
		}
	}

}
