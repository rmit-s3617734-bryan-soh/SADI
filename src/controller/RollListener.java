package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.AppFrame;

public class RollListener implements ActionListener {

	private AppFrame appFrame;
	private GameEngine ge;
	private Player player;

	public RollListener(AppFrame appFrame, GameEngine ge) {
		this.appFrame = appFrame;
		this.ge = ge;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player = appFrame.getSelectedPlayer(ge);
		// check if all players have rolled
		// new thread to roll player after player placed bet
		if (player.getBet() == 0) {
			JOptionPane.showMessageDialog(appFrame, "Please place bet first.");
		} else {
			new Thread() {
				@Override
				public void run() {
					ge.rollPlayer(player, 1, 1000, 200);
					// reset house result after roll
					appFrame.resetHouse();
				}
			}.start();
		}

	}

}
