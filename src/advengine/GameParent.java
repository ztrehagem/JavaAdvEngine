package advengine;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import advengine.sequence.Sequence;
import advengine.sequence.Splash;

public class GameParent extends BasicGame {

	Sequence seq;

	public GameParent( String title ) {
		super( title );
	}

	@Override
	public void init( GameContainer gc ) throws SlickException {
		seq = new Splash();
	}

	@Override
	public void update( GameContainer gc, int delta ) throws SlickException {
		if( !seq.update( gc, delta ) ) {
			Class<? extends Sequence> next = seq.next( gc );

			if( next == null ) {
				gc.exit();
				return;
			}

			try {
				seq = next.newInstance();
			}
			catch( InstantiationException | IllegalAccessException e ) {
				e.printStackTrace();
				gc.exit();
				return;
			}
		}
	}

	@Override
	public void render( GameContainer gc, Graphics g ) throws SlickException {
		seq.render( gc, g );
	}
}
