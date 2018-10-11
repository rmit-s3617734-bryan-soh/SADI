package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.AppFrame;

public class SelectPlayerListener implements ActionListener {
	private AppFrame appFrame;
	private GameEngine ge;

	public SelectPlayerListener(AppFrame appFrame, GameEngine ge) {
		this.appFrame = appFrame;
		this.ge = ge;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Player player = appFrame.getSelectedPlayer(ge);
		//update status bar and dice panel of selected combobox player
		appFrame.setStatus1(ge);
		appFrame.updatePanel(player, player.getRollResult());

	}

}
