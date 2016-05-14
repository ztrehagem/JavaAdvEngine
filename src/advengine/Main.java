package advengine;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;
import advengine.meta.App;
import advengine.meta.Config;

public class Main {

	private static AppGameContainer game;

	public static void start() {

		if( game != null ) {
			return;
		}

		App.load();
		Config.load();

		try {
			game = new AppGameContainer( new GameParent( App.title ) );
			game.setDisplayMode( App.width, App.height, false );
			game.setVSync( true );
			game.start();
		}
		catch( SlickException e ) {

		}
	}

	private Main() {
	}
}
