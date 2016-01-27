package advengine.sequence;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Title implements Sequence {

	@Override
	public void init( GameContainer gc ) throws SlickException {
	}

	@Override
	public Class<? extends Sequence> next( GameContainer gc ) throws SlickException {
		return null;
	}

	@Override
	public boolean update( GameContainer gc, int delta ) throws SlickException {
		if( gc.getInput().isMousePressed( Input.MOUSE_LEFT_BUTTON ) )
			return false;
		return true;
	}

	@Override
	public void render( GameContainer gc, Graphics g ) throws SlickException {
		g.drawString( "Sequence::Title", 10, 30 );
	}

}
