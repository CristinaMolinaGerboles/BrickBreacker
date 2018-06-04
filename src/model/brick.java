package model;

import java.awt.Rectangle;

public class brick {

	private Game _game;
	/*private int _x;
	private int _y;*/
	private int brickWidth;
	private int brickHeight;
	private int Height;
	private int Width;
	public int brickMap[][];
	public Rectangle rect[][];
	
	public brick(Game game, int row, int col) {
		_game = game;
		//_x = 30;
		//_y = 20;
		brickWidth = 50;
		brickHeight = 50;
		Height = 30;
		Width = 40;
		brickMap = new int[row][col];
		rect = new Rectangle[row][col];
		for(int i = 0; i < brickMap.length; i++) {
			for(int j = 0; j < brickMap[0].length; j++){
				brickMap[i][j] = 1;//No se ha roto
			}
		}
	}


	/*public int getX() {
		return _x;
	}
	public int getY() {
		return _y;
	}
	
	public void setX(int x) {
		_x = x;
	}
	public void setY(int y) {
		_y = y;
	}*/
	public int getWidth() {
		return Width;
	}
	public int getHeight() {
		return Height;
	}
	public int getbrickWidth() {
		return brickWidth ;
	}
	public int getbrickHeight() {
		return brickHeight;
	}
	public void setBarWidth(int x) {
		brickWidth -= x;
	}
	public Rectangle getRect(int i, int j) {
		return rect[i][j];
	}
	public void getBounds() {
		for(int i = 0; i < _game.getBrick().brickMap.length; i++) {		
			for(int j = 0; j < _game.getBrick().brickMap[0].length; j++) {
				rect[i][j] = new Rectangle(j*getbrickWidth() + 20, i*getbrickHeight() + 50, Width, Height);
			}
		}
		
	}
	
	public void destroyBrick(int i, int j) {
		brickMap[i][j] = 0;
		_game.setBricks(_game.getBricks() - 1);
	}
}
