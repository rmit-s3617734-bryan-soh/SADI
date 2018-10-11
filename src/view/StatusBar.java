package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.interfaces.GameEngine;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class StatusBar extends JPanel {

	private JLabel statusLabel1 = new JLabel("", JLabel.LEFT);
	private JLabel statusLabel2 = new JLabel("", JLabel.CENTER);

	public StatusBar(GameEngine ge, AppFrame frame) {
		setLayout(new GridLayout(1, 2));

		statusLabel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		statusLabel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		add(statusLabel1);
		add(statusLabel2);

	}
	//update status bar
	public void setStatus1(Player player) {
		statusLabel2.setText("Bet: " + Integer.toString(player.getBet()));
		statusLabel1.setText(player.toString());
	}
	

}
