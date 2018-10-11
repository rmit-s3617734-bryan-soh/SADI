package view;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

public class GameEngineCallbackGUI implements GameEngineCallback {

	private AppFrame frame;

	public GameEngineCallbackGUI(AppFrame frame) {
		this.frame = frame;
	}

	@Override
	public void intermediateResult(final Player player, final DicePair dicePair, GameEngine gameEngine) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				frame.updatePanel(player, dicePair);
			}
		});

	}

	@Override
	public void result(final Player player, final DicePair result, GameEngine gameEngine) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				frame.updatePanel(player, result);
			}
		});
	}

	@Override
	public void intermediateHouseResult(final DicePair dicePair, GameEngine gameEngine) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				frame.updateHouse(dicePair, frame);
			}
		});

	}

	@Override
	public void houseResult(final DicePair result, GameEngine gameEngine) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				frame.updateHouse(result, frame);
				// update new points of player in combobox
				frame.updateComboBox();
				frame.resetBet();
				JOptionPane.showMessageDialog(null, "All bets reset. Place Bet and Roll again");
			}
		});
	}

}
