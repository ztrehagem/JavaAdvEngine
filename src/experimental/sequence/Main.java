package experimental.sequence;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Main {

	public Main() {
		try {
			AppGameContainer app = new AppGameContainer( new App( "AdvEngine" ), 800, 450, false );
			app.setVSync( true );
			app.start();
		}
		catch( SlickException e ) {

		}
	}

	class App extends BasicGame {

		Sequence sequence;

		public App( String title ) {
			super( title );
		}

		@Override
		public void init( GameContainer gc ) throws SlickException {
			sequence = new Splash();
		}

		@Override
		public void update( GameContainer gc, int delta ) throws SlickException {
			//			synchronized( sequence ) {
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
			}
			//			}
		}

		@Override
		public void render( GameContainer gc, Graphics g ) throws SlickException {
			//			synchronized( sequence ) {
			sequence.render( gc, g );
			//			}
		}
	}
}
