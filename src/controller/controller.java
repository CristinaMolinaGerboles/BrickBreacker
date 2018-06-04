package controller;

import model.Game;

public class controller {
	
	private Game _game;

	public controller(Game game){
		_game = game;
	}
	
	public void run() {		
		_game.moveBall();
		
		
	}
}
