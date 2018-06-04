package view;

import java.awt.BorderLayout;
import java.awt.Dimension;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;


import controller.controller;
import model.Game;
import model.Game.GameObserver;
import model.ball;
import model.bar;
import model.brick;

public class mainWindow extends JFrame implements GameObserver{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Game _game;
	private int direction;
	private BallsWorker _ballsworker;
	private int _Score;
	private JLabel ScoreLabel;

	
	public mainWindow(Game game, controller control){
	
		_game = game;
		_Score = 0;
		
		initGUI();
		_game.addObserver(this);
	
		
	}
	
	public void initGUI() {
		
		//Crear los paneles
		JPanel mainPanel = new JPanel(new BorderLayout());
		this.setContentPane(mainPanel);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout( new BoxLayout(centerPanel, BoxLayout.Y_AXIS));		
		mainPanel.add( centerPanel, BorderLayout.CENTER);
		
		JPanel upperPanel = new JPanel();
		upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.X_AXIS));
		centerPanel.add(upperPanel);
		
		
		GameInterface _b = new GameInterface(_game);
		centerPanel.add(_b);
		
		JLabel Score = new JLabel("Score");
		upperPanel.add(Score);
		
		ScoreLabel = new JLabel();
		ScoreLabel.setText(" " + _Score);
		upperPanel.add(ScoreLabel);
		
		int height = (int) (500);
		int width = (int) (400);
		setPreferredSize(new Dimension(width, height));
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		
		_ballsworker = new BallsWorker();
		_ballsworker.execute();
		
		this.addKeyListener(new KeyListener(){
			@Override
		
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			direction = e.getKeyCode();
			//System.out.println(e.getKeyCode());
	
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			direction = e.getKeyCode();
		}
		});
	}

	@Override
	public void move(bar Bar, ball Ball, brick Brick) {
		// TODO Auto-generated method stub
		_game.setBar(Bar);
		_game.setBall(Ball);
		repaint();
	}

	@Override
	public void reset(bar Bar, ball Ball, brick Brick) {
		// TODO Auto-generated method stub
	
		
	}
	

	private class BallsWorker extends SwingWorker<Void, Void>{
		
	@Override
	protected  Void doInBackground() throws Exception{
		while(!isCancelled() &&  !_game.gameOver() && !_game.win()) {
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub 
					_game.moveBall();
					if(direction == KeyEvent.VK_LEFT)
						_game.moveBar(-1);
					else if(direction == KeyEvent.VK_RIGHT)
						_game.moveBar(+1);
					//direction = KeyEvent.VK_2; Para que la barra no salga disparada
				
				}
				
		
			});
			try {
				Thread.sleep(3);
				
			}catch(InterruptedException e) {
				
			}
		
		}
		return null;
	}
	}


	@Override
	public void notifyScore() {
		// TODO Auto-generated method stub
		_Score+= 5;
		ScoreLabel.setText(" " + _Score);
		if(_Score == 40) {
			_game.setSpeed(2);
		}
		else if(_Score == 80) {
			_game.setSpeed(3);		
		}
		else if(_Score == 100) {
			_game.setSpeed(4);
			_game.getBar().setBarWidth(50);
		}
	}

	@Override
	public void removedbrick(bar Bar, ball Ball, brick Brick) {
		// TODO Auto-generated method stub
		
	}




	
	
}
