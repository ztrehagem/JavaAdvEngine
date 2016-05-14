package advengine.sequence;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import advengine.meta.App;
import advengine.struct.Point;
import advengine.struct.Rect;
import javafx.util.Pair;

public class Title implements Sequence {

	private static final int MENU_NUM = 2;
	private static final int MENU_WIDTH = 300;
	private static final int MENU_HEIGHT = 50;

	private Menu[] menus;

	@Override
	public void init( GameContainer gc ) throws SlickException {
		menus = new Menu[2];
		menus[0] = new Menu( new Rect( (App.width - MENU_WIDTH) / 2, App.height - 4 * MENU_HEIGHT, MENU_WIDTH, MENU_HEIGHT ) );
		menus[1] = new Menu( new Rect( (App.width - MENU_WIDTH) / 2, App.height - 2 * MENU_HEIGHT, MENU_WIDTH, MENU_HEIGHT ) );
	}

	@Override
	public Sequence next() throws SlickException {
		return null;
	}

	@Override
	public boolean update( GameContainer gc, int delta ) throws SlickException {
		final Input input = gc.getInput();
		final Point mouse = new Point( input.getMouseX(), input.getMouseY() );

		if( input.isMousePressed( Input.MOUSE_RIGHT_BUTTON ) )
			return false;

		for( Menu menu : menus ) {
			menu.setOnMouse( menu.area.contains( mouse ) );
		}

		return true;
	}

	@Override
	public void render( GameContainer gc, Graphics g ) throws SlickException {
		g.setColor( Color.black );

		for( Menu menu : menus ) {
			if( menu.isOnMouse() ) {
				g.setColor( Color.orange );
			}
			else {
				g.setColor( Color.gray );
			}
			menu.draw( g );
		}

		g.setColor( Color.black );
		g.drawString( "Sequence::Title", 10, 30 );
	}

	private class Menu {

		Rect area;
		Pair<Point, Point> points;
		boolean onMouse;

		Menu( Rect area ) {
			this.area = area;
			points = area.get();
		}

		boolean isOnMouse() {
			return onMouse;
		}

		void setOnMouse( boolean onMouse ) {
			this.onMouse = onMouse;
		}

		void draw( Graphics g ) {
			g.fillRect( points.getKey().getX(), points.getKey().getY(), points.getValue().getX() - points.getKey().getX(), points.getValue().getY() - points.getKey().getY() );
		}

	}
}
