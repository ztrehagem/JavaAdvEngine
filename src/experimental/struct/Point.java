package experimental.struct;

public class Point {

	private int x, y;

	public Point() {
	}

	public Point( int x, int y ) {
		this.set( x, y );
	}

	public void set( int x, int y ) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX( int x ) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY( int y ) {
		this.y = y;
	}

	public boolean horizontal( Point to ) {
		return this.y == to.y;
	}

	public boolean above( Point to ) {
		return this.y < to.y;
	}

	public boolean below( Point to ) {
		return this.y > to.y;
	}

	public boolean vertical( Point to ) {
		return this.x == to.x;
	}

	public boolean left( Point to ) {
		return this.x < to.x;
	}

	public boolean right( Point to ) {
		return this.x > to.x;
	}
}
