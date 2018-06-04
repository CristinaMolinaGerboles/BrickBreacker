package view;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import controller.controller;
import model.Game;

public class buttons extends JPanel{
	//modelo
	private Game _game;
	private controller _control;
	
	public buttons(Game game, controller control) {
		_game = game;
		_control = control;
		initGUI();
	}
	void initGUI() {
		JPanel buttonsPanel = new JPanel();
		
				
		ImageIcon restart1 = new ImageIcon(loadImage("icons/restart.png"));
		Image restart2 = restart1.getImage();
		Image restart3 = restart2.getScaledInstance(50,  50,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon restart4 = new ImageIcon(restart3);
		JButton restart = new JButton(restart4);
		
		restart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
								
			}			
			
		});
		buttonsPanel.add(restart);
		
		//Añadir lo de los niveles
		
		ImageIcon pause1 = new ImageIcon(loadImage("icons/pause.png"));
		Image pause2 = pause1.getImage();
		Image pause3 = pause2.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		ImageIcon pause4 = new ImageIcon(pause3);
		JButton pause = new JButton(pause4);
		
		pause.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				_game.getBall().setpuased(true);
				
			}
		});
		
		buttonsPanel.add(pause);
		
		this.add(buttonsPanel);
		
	}
	private static Image loadImage(String path) {
		return Toolkit.getDefaultToolkit().createImage(path);
	}
}
