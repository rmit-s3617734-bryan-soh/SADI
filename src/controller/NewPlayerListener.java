package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.AppFrame;

public class NewPlayerListener implements ActionListener {

	private AppFrame appFrame;
	private GameEngine ge;

	public NewPlayerListener(GameEngine ge, AppFrame appFrame) {
		this.appFrame = appFrame;
		this.ge = ge;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// add player and update combobox with new player
		Player player = appFrame.createPlayer(ge);
		if (player != null) {
			ge.addPlayer(player);
			appFrame.updateComboBox();
		}
	}

}
