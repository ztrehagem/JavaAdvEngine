package experimental.struct;

import javafx.util.Pair;

public class Rect {

	private Point a, b;

	public Rect() {
	}

	public Rect( Point a, Point b ) {
		this.set( a, b );
	}

	public Rect( int x, int y, int width, int height ) {
		this.set( x, y, width, height );
	}

	public void set( Point a, Point b ) {
		this.a = a;
		this.b = b;
		adjust();
	}

	public void set( int x, int y, int width, int height ) {
		a = new Point( x, y );
		b = new Point( x + width, y + height );
		adjust();
	}

	public boolean contains( Point at ) {
		return !a.right( at ) && !a.below( at ) && !b.left( at ) && !b.above( at );
	}

	public boolean contains( int x, int y ) {
		return contains( new Point( x, y ) );
	}

	//	public void draw( Graphics g ) {
	//		g.fillRect( a.getX(), a.getY(), b.getX() - a.getX() + 1, b.getY() - a.getY() + 1 );
	//	}

	public Pair<Point, Point> get() {
		return new Pair<Point, Point>( a, b );
	}

	private void adjust() {
		if( a.below( b ) ) {
			Point t;
			t = a;
			a = b;
			b = t;
		}

		if( a.right( b ) ) {
			int t;
			t = a.getX();
			a.setX( b.getX() );
			b.setX( t );
		}
	}

}
