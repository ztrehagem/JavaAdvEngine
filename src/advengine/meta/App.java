package advengine.meta;

import java.io.IOException;

public class App {

	public static String	title;
	public static short		width, height;

	private App() {
	}

	public static void load() {
		try( MetaFileReader r = new MetaFileReader( "app" ) ) {
			String l;
			while( (l = r.readLine()) != null ) {
				if( l.equals( "" ) ) {
					continue;
				}
				if( l.equals( "title" ) ) {
					title = r.readLine();
				}
				else if( l.equals( "width" ) ) {
					width = Short.parseShort( r.readLine() );
				}
				else if( l.equals( "height" ) ) {
					height = Short.parseShort( r.readLine() );
				}
			}
		}
		catch( IOException e ) {
			throw new RuntimeException();
		}
	}
}
