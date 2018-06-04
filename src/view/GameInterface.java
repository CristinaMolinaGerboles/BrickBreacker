package view;

import java.awt.Graphics;

import java.awt.Graphics2D;
import java.util.List;

import view.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Game;
import model.Game.GameObserver;
import model.ball;
import model.bar;
import model.brick;

public class GameInterface extends JPanel implements GameObserver{

	private Game _game;
	private ballInterface _ball;
	private brickInterface _brick;
	private ball _Ball;
	private bar _Bar;
	private barInterface _bar;
	private mainWindow main;
	private brick _Brick;

	

	
	public GameInterface(Game game) {
		_game = game;
		_ball = new ballInterface(_game);
		_bar = new barInterface(_game);
		_brick = new brickInterface(_game);

		
		//_g =_; 
		//paint(_g);
		//main = mainWindow(_game, null);
			
		
		
		_game.addObserver(this);
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		//g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		_ball.paintComponent(g2d);
		_bar.paint(g2d);
		_brick.paint(g2d);
		
		
		if(_game.gameOver()) {
			gameOver();
		}
		if(_game.win()) {
			win();
			
		}
	}
	private void gameOver() {
		 JOptionPane.showMessageDialog(this, "GAME OVER"
				,"GAME OVER", JOptionPane.YES_NO_OPTION);
		
			System.exit(ABORT);
	
	}
	private void win() {
		//JOptionPane.showM
		
		 JOptionPane.showMessageDialog(this, "You won"
				,"You won", JOptionPane.INFORMATION_MESSAGE);
		
			System.exit(0);
	
	}
	
	@Override
	public void move(bar Bar, ball Ball, brick Brick) {
		// TODO Auto-generated method stub
		_Ball = Ball;
		_Bar = Bar;
		_Brick = Brick;
		repaint();
	}

	@Override
	public void reset(bar Bar, ball Ball, brick Brick) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyScore() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removedbrick(bar Bar, ball Ball, brick Brick) {
		// TODO Auto-generated method stub
		
	}




	

}
