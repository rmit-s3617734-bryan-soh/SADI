package view;

import java.util.Collection;
import javax.swing.JOptionPane;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class DialogBox extends JOptionPane {
	// get player name and points
	public Player getPlayer(GameEngine gameEngine) {
		Collection<Player> plyr = gameEngine.getAllPlayers();
		// if game has no player
		if (plyr.isEmpty()) {
			String id = "1";
			String playerName = JOptionPane.showInputDialog(null, "Please enter your Player Name:");
			if (playerName != null) {
				String playerPoints = JOptionPane.showInputDialog(null, "Please enter points available:");
				if (playerPoints != null) {
					try {
						int points = Integer.parseInt(playerPoints);
						Player player = new SimplePlayer(id, playerName, points);
						return player;
					} catch (NumberFormatException ie) {
						JOptionPane.showMessageDialog(null, "Input is not a number!");
					}
				}
			}
		} else {
			// if game has player
			int id = 0;
			id = plyr.size() + 1;
			String playerName = JOptionPane.showInputDialog(null, "Please enter your Player Name:");
			if (playerName != null) {
				String playerPoints = JOptionPane.showInputDialog(null, "Please enter points available:");
				if (playerPoints != null) {
					try {
						int points = Integer.parseInt(playerPoints);
						Player player = new SimplePlayer(Integer.toString(id), playerName, points);
						return player;
					}

					catch (NumberFormatException ie) {
						JOptionPane.showMessageDialog(null, "Input is not a number!");
					}
				}
			}

		}
		return null;

	}

	// get bet and place bet
	public void placeBet(GameEngine gameEngine, Player player) {
		boolean retry = true;
		while (retry == true) {
			String bet = JOptionPane.showInputDialog(null, "Please insert the amount you wish to bet:");
			int bets = 0;
			if (bet != null) {
				try {
					bets = Integer.parseInt(bet);
					if (gameEngine.placeBet(player, bets) == true) {
						retry = false;
					} else {
						JOptionPane.showMessageDialog(null, "Insuffiecient Points!");
					}
				} catch (NumberFormatException ie) {
					JOptionPane.showMessageDialog(null, "Input is not a number!");
					retry = true;
				}
			}
			retry = false;
		}

	}

}
