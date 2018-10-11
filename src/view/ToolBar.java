package view;

import java.awt.FlowLayout;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToolBar;

import controller.HouseRollListener;
import controller.PlaceBetListener;
import controller.RollListener;
import controller.SelectPlayerListener;
import model.interfaces.GameEngine;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class ToolBar extends JToolBar {

	private JButton btnPlaceBet = new JButton("Place Bet");
	private JButton btnRoll = new JButton("Roll Dice");
	private JButton btnRollHouse = new JButton("Roll House");
	private JComboBox<String> comboBox = new JComboBox<String>();
	SelectPlayerListener selectPlayerListener;

	public ToolBar(GameEngine ge, AppFrame frame) {
		add(btnPlaceBet);
		add(btnRoll);
		add(comboBox);
		add(btnRollHouse);

		setLayout(new FlowLayout(FlowLayout.LEFT));
		// listeners
		selectPlayerListener = new SelectPlayerListener(frame, ge);
		comboBox.addActionListener(selectPlayerListener);

		PlaceBetListener placeBetListener = new PlaceBetListener(frame, ge);
		btnPlaceBet.addActionListener(placeBetListener);

		RollListener rollListener = new RollListener(frame, ge);
		btnRoll.addActionListener(rollListener);

		HouseRollListener houseRollListener = new HouseRollListener(ge, frame);
		btnRollHouse.addActionListener(houseRollListener);

	}

	// update combobox
	public void updateCombo(GameEngine ge) {
		comboBox.removeActionListener(selectPlayerListener);
		comboBox.removeAllItems();
		Collection<Player> plyr = ge.getAllPlayers();
		Player player;
		Iterator<Player> it = plyr.iterator();
		while (it.hasNext()) {
			player = it.next();
			comboBox.addItem(player.toString());
		}

		comboBox.addActionListener(selectPlayerListener);
	}

	// get selected player in combobox
	public Player getPlayer(GameEngine ge) {
		String player = (String) comboBox.getSelectedItem();
		Player gamer;
		player.toString();
		Collection<Player> plyr = ge.getAllPlayers();
		Iterator<Player> it = plyr.iterator();
		while (it.hasNext()) {
			Player test = it.next();
			if (test.toString().equals(player)) {
				gamer = test;
				return gamer;
			}
		}
		return null;
	}

}
