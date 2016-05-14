package experimental;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import experimental.sequence.Sequence;
import experimental.sequence.Splash;

public class App extends BasicGame {

	private static AppGameContainer app;

	public static void start() {
		if( app != null ) {
			return;
		}
		try {
			app = new AppGameContainer( new App( "AdvEngine" ), C.WINDOW_WIDTH, C.WINDOW_HEIGHT, false );
			app.setVSync( true );
			app.start();
		}
		catch( SlickException e ) {

		}
	}

	Sequence sequence;

	private App( String title ) {
		super( title );
	}

	@Override
	public void init( GameContainer gc ) throws SlickException {
		sequence = new Splash();
	}

	@Override
	public void update( GameContainer gc, int delta ) throws SlickException {
		if( !sequence.update( gc, delta ) ) {
			Class<? extends Sequence> next = sequence.next( gc );
			if( next == null ) {
				gc.exit();
				return;
			}
			try {
				sequence = next.newInstance();
			}
			catch( InstantiationException | IllegalAccessException e ) {
				e.printStackTrace();
				gc.exit();
				return;
			}
			sequence.init( gc );
		}
	}

	@Override
	public void render( GameContainer gc, Graphics g ) throws SlickException {
		sequence.render( gc, g );
	}
}
