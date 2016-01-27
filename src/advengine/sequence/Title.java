package advengine.sequence;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import advengine.meta.App;

public class Title implements Sequence {

	@Override
	public void init( GameContainer gc ) throws SlickException {
	}

	@Override
	public Sequence next() throws SlickException {
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
		g.setColor( Color.white );
		g.fillRect( 0, 0, App.width, App.height );

		g.setColor( Color.black );
		g.drawString( "Sequence::Title", 10, 30 );
	}

}
