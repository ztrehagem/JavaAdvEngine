package advengine.container;

public class Vector2<T> {

	public T x, y;

	public Vector2() {
	}

	public Vector2( T x, T y ) {
		this.set( x, y );
	}

	public void set( T x, T y ) {
		this.x = x;
		this.y = y;
	}
}
