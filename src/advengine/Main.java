package advengine;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;
import advengine.meta.App;
import advengine.meta.Config;

public class Main {

	public Main() {
		App.load();
		Config.load();

		try {
			AppGameContainer app = new AppGameContainer( new GameParent( App.title ) );
			app.setDisplayMode( App.width, App.height, false );
			app.setVSync( true );
			app.start();
		}
		catch( SlickException e ) {

		}
	}
}
