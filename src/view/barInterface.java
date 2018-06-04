package view;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import model.Game;
import model.Game.GameObserver;
import model.ball;
import model.bar;
import model.brick;

public class barInterface extends JComponent implements GameObserver{

	private Game _game;
	private bar _bar;
	
	
	
	public barInterface(Game game) {
		_bar = new bar(_game);
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
		_bar = Bar;
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
