package advengine.module.effect;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import advengine.meta.App;

public class Fade {

	private State	state	= State.standby;
	private State	prev	= State.standby;
	private float	speed	= 0.002f;
	private float	alpha	= 0.0f;

	public Fade() {
	}

	public void setSpeed( float speed ) {
		this.speed = speed;
	}

	public void in() {
		prev = state = State.fadein;
		alpha = 1.0f;
	}

	public void out() {
		prev = state = State.fadeout;
		alpha = 0.0f;
	}

	public boolean isFinished() {
		return state == State.standby;
	}

	public State getPrev() {
		return prev;
	}

	public void update( GameContainer gc, int delta ) {
		switch( state ) {
		case fadein:
			if( (alpha -= delta * speed) <= 0.0f )
				state = State.standby;
			break;
		case fadeout:
			if( (alpha += delta * speed) >= 1.0f )
				state = State.standby;
			break;
		default:
			break;
		}
	}

	public void render( GameContainer gc, Graphics g ) {
		g.setDrawMode( Graphics.MODE_ALPHA_MAP );
		g.clearAlphaMap();

		g.setColor( new Color( 255, 255, 255, this.alpha ) );
		g.fillRect( 0, 0, App.width, App.height );

		g.setDrawMode( Graphics.MODE_ALPHA_BLEND );

		g.setColor( Color.black );
		g.fillRect( 0, 0, App.width, App.height );

		g.setDrawMode( Graphics.MODE_NORMAL );
	}

	public enum State {
		standby, fadein, fadeout
	}
}
