package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.AppFrame;

public class PlaceBetListener implements ActionListener {

	private AppFrame appFrame;
	private GameEngine gameEngine;

	public PlaceBetListener(AppFrame appFrame, GameEngine gameEngine) {
		this.appFrame = appFrame;
		this.gameEngine = gameEngine;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//place bet for selected combobox player and update status bar
		Player player = appFrame.getSelectedPlayer(gameEngine);
		appFrame.placeBet(gameEngine, player);
		appFrame.setStatus1(gameEngine);
	}

}
