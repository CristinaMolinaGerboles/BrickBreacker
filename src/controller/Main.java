package controller;
import javax.swing.SwingUtilities;


import model.Game;
import view.mainWindow;

public class Main {
	private static Game _game;
	private static controller _control; 

	public static void main(String[] args) {
		_game =  new Game();
		_control =  new controller(_game);
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {				
				new mainWindow(_game, _control);			
			}
		});
	
	}
	
}
