package model;


import java.util.ArrayList;
import java.util.List;

import model.Game.GameObserver;

@SuppressWarnings("serial")
public class Game {

	private static final int MINWIDTH = 380;
	private static final int MINHEIGHT =  452;
	
	private int _width;
	private int _height;
	
	private ball _ball;
	private bar _bar;
	private brick _brick;
	
	private boolean gameOver;
	//private boolean win;
	private boolean Collision;
	private int _gameSpeed;
	private boolean brickCollision;
	private int totalBricks = 21;
	private int colPosi;
	private int colPosj;
	
	
	private List<GameObserver> _obs;

	
	public Game() {
		_ball = new ball(this);
		_bar = new bar(this);
		_brick = new brick(this, 3, 7);
		_obs = new ArrayList<>();
		_width = MINWIDTH;
		_height = MINHEIGHT ;
		_gameSpeed = 1;
		gameOver = false;
		Collision = false;
		brickCollision = false;
		}
	
	 public interface GameObserver {
		void move(bar Bar, ball Ball, brick Brick);
		void reset(bar Bar, ball Ball,brick Brick);
		void notifyScore();
		void removedbrick(bar Bar, ball Ball,brick Brick);
	
	}
	 
	 public void moveBar(int xa) {		 
		 _bar.move(xa);
		 for(GameObserver o: _obs) {
			 o.move(_bar, _ball, _brick);
		 }
		 
	 }
	public void moveBall() {	
		_ball.move();
		 for(GameObserver o: _obs) {
			 o.move(_bar, _ball, _brick);
		 }
	/*	/*if(getCollision()){
				 for(GameObserver o: _obs)
				 o.notifyScore();
			 }
		setCollision(false);*/
		if(getbrickCollision()) {			
			 for(GameObserver o: _obs)
				 o.notifyScore();
		}
		setbrickCollision(false);
		
			 
	} 
	public void iniList(){
		for(int i = 0; i < _width; i++) {
		
		}
	}
	
	public boolean getCollision() {
		return Collision;
	}
	public void  setCollision(boolean _collision) {
		Collision = _collision;
	}
	public boolean getbrickCollision() {
		return brickCollision;
	}
	public void setbrickCollision(boolean _brickCollision) {
		brickCollision = _brickCollision;
	}
	public bar getBar() {
		return _bar;
	}
	public ball getBall() {
		return _ball;
	}
	public brick getBrick() {
		return _brick;
	}
	public void setBar(bar Bar) {
		_bar = Bar;
	}
	public void setBall(ball Ball) {
		_ball = Ball;
	}
	public int getWidth() {
		return _width;
	}
	public boolean gameOver() {
		return gameOver;
	}
	public boolean win() {
		return (totalBricks == 0);
	}
	public void setgameOver(boolean _gameOver) {
		gameOver = _gameOver;
		//_gameOver = true;
	}
	
	public int getHeight() {
		return _height;
	}
	public boolean collision() {
		return getBar().getBounds().intersects(getBall().getBounds());
		
	}
	public boolean brickCollision() {
		getBrick().getBounds();
		for(int i = 0; i < getBrick().brickMap.length; i++) {		
			for(int j = 0; j < getBrick().brickMap[0].length; j++) {
				if(getBall().getBounds().intersects(getBrick().getRect(i, j)) && getBrick().brickMap[i][j] > 0) {
					setYX(i, j);
					return true;
				}
			}
			}
			
		/*System.out.println(getBrick().getBounds());
		return getBrick().getBounds().intersects(getBall().getBounds());*/
		return false;
	}
	public void setYX(int i, int j) {
		colPosi = i;
		colPosj = j;
	}
	public int getBricks() {
		return totalBricks;
	}
	public void setBricks(int bricks) {
		totalBricks = bricks;
	}
	public int getI() {
		return colPosi;
	}
	public int gerJ() {
		return colPosj;
	}
	public int getSpeed() {
		return _gameSpeed;
	}
	public void setSpeed(int speed) {
		_gameSpeed = speed;
	}
	
	/**
	 * Add an observer
	 * @param o
	 */
	public void addObserver(GameObserver o) {
		_obs.add(o);
	}
	/**
	 * Remove an observer
	 * @param o
	 */
	public void RemoveObserver(GameObserver o) {
		_obs.remove(o);
	}

}
