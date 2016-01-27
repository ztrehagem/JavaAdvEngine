package advengine;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import advengine.module.effect.Fade;
import advengine.sequence.Sequence;
import advengine.sequence.Splash;

public class GameParent extends BasicGame {

	Sequence	seq;
	Fade		fade;

	public GameParent( String title ) {
		super( title );
	}

	@Override
	public void init( GameContainer gc ) throws SlickException {
		seq = new Splash();
		fade = new Fade();
		fade.in();
	}

	@Override
	public void update( GameContainer gc, int delta ) throws SlickException {

		if( !fade.isFinished() ) {
			fade.update( gc, delta );

			if( fade.isFinished() ) {
				if( fade.getPrev() == Fade.State.fadeout ) {
					if( !switchSeaquence() ) {
						gc.exit();
						return;
					}
					fade.in();
				}
			}
		}
		else {
			if( !seq.update( gc, delta ) ) {
				fade.out();
			}
		}
	}

	@Override
	public void render( GameContainer gc, Graphics g ) throws SlickException {
		seq.render( gc, g );
		if( !fade.isFinished() )
			fade.render( gc, g );
	}

	private boolean switchSeaquence() throws SlickException {
		Class<? extends Sequence> next = seq.next();

		if( next == null )
			return false;

		try {
			seq = next.newInstance();
		}
		catch( InstantiationException | IllegalAccessException e ) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
}
