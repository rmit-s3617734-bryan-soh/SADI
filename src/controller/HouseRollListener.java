package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.AppFrame;

public class HouseRollListener implements ActionListener {

	private GameEngine ge;
	private AppFrame appFrame;

	public HouseRollListener(GameEngine ge, AppFrame appFrame) {
		this.ge = ge;
		this.appFrame = appFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean stop = false, halt = false, noBet = false;

		Collection<Player> plyr = ge.getAllPlayers();
		Iterator<Player> it = plyr.iterator();
		// make sure conditions met before roll house
		while (it.hasNext()) {
			Player test = it.next();
			// check if player have bet
			if (test.getBet() == 0) {
				noBet = true;
				break;
			}
			// check player have roll
			if (test.getRollResult() == null || test.getRollResult().getDice1() == 0) {
				stop = true;
				break;
			}
			// check if all players has enough points
			if (test.getPoints() == 0) {
				halt = true;
				break;
			}
		}
		// new thread to rollHouse if all conditions met
		Player player = appFrame.getSelectedPlayer(ge);
		if (stop == true) {
			JOptionPane.showMessageDialog(appFrame, "Please roll dice for all players first.");
		} else if (halt == true) {
			JOptionPane.showMessageDialog(appFrame, "Players have insufficient funds");
		} else if (noBet == true) {
			JOptionPane.showMessageDialog(appFrame, "Please bet for all players first.");
		} else if (player.getRollResult() != null) {
			new Thread() {
				@Override
				public void run() {
					ge.rollHouse(1, 1000, 200);
				}
			}.start();
		}
	}

}
