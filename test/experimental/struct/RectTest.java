package experimental.struct;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import javafx.util.Pair;

public class RectTest {

	@Test
	public void testAdjust() {
		checkAdjust( new Rect( 1, 1, 2, 2 ).get() );
		checkAdjust( new Rect( 2, 1, 1, 2 ).get() );
		checkAdjust( new Rect( 2, 2, 1, 1 ).get() );
		checkAdjust( new Rect( 1, 2, 2, 1 ).get() );
		checkAdjust( new Rect( 1, 1, 1, 1 ).get() );
		checkAdjust( new Rect( 1, 1, 1, 2 ).get() );
		checkAdjust( new Rect( 1, 1, 2, 1 ).get() );
	}

	private void checkAdjust( Pair<Point, Point> pair ) {
		assertEquals( true, !pair.getKey().below( pair.getValue() ) && !pair.getKey().right( pair.getValue() ) );
	}

	@Test
	public void testContains() {
		Rect rect = new Rect( 1, 1, 3, 3 );
		assertEquals( true, rect.contains( new Point( 2, 2 ) ) );
		assertEquals( true, rect.contains( new Point( 1, 1 ) ) );
		assertEquals( true, rect.contains( new Point( 1, 2 ) ) );
		assertEquals( true, rect.contains( new Point( 2, 1 ) ) );
		assertEquals( true, rect.contains( new Point( 2, 3 ) ) );
		assertEquals( true, rect.contains( new Point( 3, 2 ) ) );
		assertEquals( false, rect.contains( new Point( 0, 0 ) ) );
	}

}
