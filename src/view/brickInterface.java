package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JComponent;

import model.Game;
import model.Game.GameObserver;
import model.ball;
import model.bar;
import model.brick;


public class brickInterface  implements GameObserver {
	
	private Game _game;
	private brick _brick;

	public brickInterface(Game game) {
		_game = game;
		
	}
	
	public void paint(Graphics2D g) {
	
		for(int i = 0; i < _game.getBrick().brickMap.length; i++) {		
			for(int j = 0; j < _game.getBrick().brickMap[0].length; j++) {
				if(_game.getBrick().brickMap[i][j] > 0) {
					g.setColor(Color.BLUE);
					g.fillRect(j*_game.getBrick().getbrickWidth() + 20, 
							  i*_game.getBrick().getbrickHeight() + 50,
							_game.getBrick().getWidth(), 
							_game.getBrick().getHeight());
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.BLACK);
					g.drawRect(j*_game.getBrick().getbrickWidth() + 20, 
							  i*_game.getBrick().getbrickHeight() + 50,
							_game.getBrick().getWidth(), 
							_game.getBrick().getHeight());
				}
				
			
			}

		}
	}
	
	@Override
	public void move(bar Bar, ball Ball, brick Brick) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reset(bar Bar, ball Ball,brick Brick) {
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
