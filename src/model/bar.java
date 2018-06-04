package model;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class bar {
	
	private int _x;
	private int _y;
	private int _xa = 0;
	private int barWidth;
	private Game _game;
	
	public bar(Game game){
		_game = game;
		_y = 442;
		_x = 0;
		barWidth = 150;
		//_y = _game.getWidth();
	}
	public void move(int xa) {
		_xa = xa;
		//Si está dentro de los limites y se puede mover lo hace
		if(_x + _xa >= 0 && _x + _xa <= _game.getWidth() - getbarWidth()) {
			_x += _xa;
		}
	}
	public int getX() {
		return _x;
	}
	public int getY() {

		return _y;

	}
	public void setBarWidth(int x) {
		barWidth -= x;
	}
	public int getbarWidth() {
		return barWidth;
	}
	public int getbarHeight() {
		return 10;
	}	
	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), getbarWidth(), getbarHeight());
	}


}
