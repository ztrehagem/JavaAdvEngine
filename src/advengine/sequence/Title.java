package advengine.sequence;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import advengine.meta.App;
import advengine.struct.Point;
import advengine.struct.Rect;
import advengine.system.Font;
import javafx.util.Pair;

public class Title implements Sequence {

	private static final int MENU_NUM = 2;
	private static final int MENU_WIDTH = 300;
	private static final int MENU_HEIGHT = 50;

	private Menu[] menus;

	@Override
	public void init( GameContainer gc ) throws SlickException {
		menus = new Menu[2];
		menus[0] = new Menu( "スタート", new Rect( (App.width - MENU_WIDTH) / 2, App.height - 4 * MENU_HEIGHT, MENU_WIDTH, MENU_HEIGHT ) );
		menus[1] = new Menu( "おわる", new Rect( (App.width - MENU_WIDTH) / 2, App.height - 2 * MENU_HEIGHT, MENU_WIDTH, MENU_HEIGHT ) );
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
		Point center;
		String name;
		Point nameDrawPoint;
		boolean onMouse;

		Menu( String name, Rect area ) {
			this.area = area;
			points = area.get();
			center = new Point( (points.getKey().getX() + points.getValue().getX()) / 2, (points.getKey().getY() + points.getValue().getY()) / 2 );
			this.nameDrawPoint = new Point();
			this.setName( name );
		}

		boolean isOnMouse() {
			return onMouse;
		}

		void setOnMouse( boolean onMouse ) {
			this.onMouse = onMouse;
		}

		String getName() {
			return name;
		}

		void setName( String name ) {
			this.name = name;
			this.nameDrawPoint.set( center.getX() - Font.getFont().getWidth( name ) / 2, center.getY() - Font.getFont().getHeight( name ) / 2 );
		}

		void draw( Graphics g ) {
			Color c = g.getColor();
			g.fillRect( points.getKey().getX(), points.getKey().getY(), points.getValue().getX() - points.getKey().getX(), points.getValue().getY() - points.getKey().getY() );
			g.setColor( Color.white );
			g.drawString( this.name, nameDrawPoint.getX(), nameDrawPoint.getY() );
			g.setColor( c );
		}

	}
}
