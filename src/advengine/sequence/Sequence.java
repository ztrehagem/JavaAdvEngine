package advengine.sequence;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public interface Sequence {

	public void init( GameContainer gc ) throws SlickException;

	/**
	 * @return このシーケンスの次に実行するシーケンスのクラスを返します。nullでゲームを終了します。
	 * @throws SlickException
	 */
	public Class<? extends Sequence> next() throws SlickException;

	/**
	 * @return 現在のシーケンスを続ける場合はtrueを返します。falseでシーケンスを終了し、次のシーケンスに移行します
	 * @throws SlickException
	 */
	public boolean update( GameContainer gc, int delta ) throws SlickException;

	public void render( GameContainer gc, Graphics g ) throws SlickException;
}
