package advengine.sequence;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Splash implements Sequence {

	@Override
	public void init( GameContainer gc ) throws SlickException {
	}

	@Override
	public Sequence next() throws SlickException {
		return new Title();
	}

	@Override
	public boolean update( GameContainer gc, int delta ) throws SlickException {
		Input i = gc.getInput();
		if( i.isMousePressed( Input.MOUSE_LEFT_BUTTON ) )
			return false;
		return true;
	}

	@Override
	public void render( GameContainer gc, Graphics g ) throws SlickException {
		g.setColor( Color.white );

		g.setColor( Color.black );
		g.drawRect( 120, 120, 100, 100 );
		g.drawString( "Sequence::Splash", 10, 30 );
	}
}
