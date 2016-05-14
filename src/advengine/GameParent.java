package advengine;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import advengine.module.effect.Fade;
import advengine.sequence.Sequence;
import advengine.sequence.Splash;

public class GameParent extends BasicGame {

	Sequence seq;
	Fade fade;

	public GameParent( String title ) {
		super( title );
	}

	@Override
	public void init( GameContainer gc ) throws SlickException {
		seq = new Splash();
		seq.init( gc );
		fade = new Fade();
		fade.in();
	}

	@Override
	public void update( GameContainer gc, int delta ) throws SlickException {

		if( !fade.isFinished() ) {
			fade.update( gc, delta );

			if( fade.isFinished() && fade.getPrev() == Fade.State.fadeout ) {
				if( (seq = seq.next()) == null ) {
					gc.exit();
					return;
				}
				seq.init( gc );
				fade.in();
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
		if( seq != null )
			seq.render( gc, g );
		if( !fade.isFinished() )
			fade.render( gc, g );
	}
}
