package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.NewPlayerListener;
import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class PullDownMenu extends JMenuBar {

	private JMenu fileMenu = new JMenu("File");
	private JMenuItem addPlayer = new JMenuItem("Add Player");
	private JMenuItem exitItem = new JMenuItem("Exit");

	public PullDownMenu(GameEngine ge, AppFrame appFrame) {
		add(fileMenu);
		fileMenu.add(addPlayer);
		fileMenu.add(exitItem);
		//listener for adding player
		NewPlayerListener newPlayerListener = new NewPlayerListener(ge, appFrame);
		addPlayer.addActionListener(newPlayerListener);
		//listener to exit game
		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

}
