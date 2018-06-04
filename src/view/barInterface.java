package view;

import java.awt.Graphics2D;


import javax.swing.*;

import model.Game;
import model.Game.GameObserver;
import model.ball;
import model.bar;
import model.brick;

@SuppressWarnings("serial")
public class barInterface extends JComponent implements GameObserver{

	private Game _game;

	
	
	
	public barInterface(Game game) {
		
		_game = game;
		
		//Listener for the keyBoard
	
	
		
		_game.addObserver(this);
		
	}
	
	public void paint(Graphics2D g) {
		g.fillRect(_game.getBar().getX(), _game.getBar().getY() , _game.getBar().getbarWidth(), 10);		
	}

	@Override
	public void move(bar Bar, ball Ball, brick Brick) {
		// TODO Auto-generated method stub
		_game.setBar(Bar);
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
