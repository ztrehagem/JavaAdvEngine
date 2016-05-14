package experimental;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class SimpleSlickGame extends BasicGame {

	float x = 304;
	float y = 184;
	static final float SPEED = 0.1f;

	public SimpleSlickGame( String title ) {
		super( title );
	}

	@Override
	public void init( GameContainer gc ) throws SlickException {
	}

	@Override
	public void update( GameContainer gc, int delta ) throws SlickException {
		float move = SPEED * delta;
		Input input = gc.getInput();
		if( input.isKeyDown( Input.KEY_LEFT ) ) {
			x -= move;
		}
		else if( input.isKeyDown( Input.KEY_RIGHT ) ) {
			x += move;
		}
		if( input.isKeyDown( Input.KEY_UP ) ) {
			y -= move;
		}
		else if( input.isKeyDown( Input.KEY_DOWN ) ) {
			y += move;
		}
	}

	@Override
	public void render( GameContainer gc, Graphics g ) throws SlickException {
		g.drawRect( x, y, 32, 32 );
	}

}
