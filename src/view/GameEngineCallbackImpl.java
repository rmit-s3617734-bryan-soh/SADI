package view;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

public class GameEngineCallbackImpl implements GameEngineCallback {
	private Logger logger = Logger.getLogger("assignment1");

	public GameEngineCallbackImpl() {
		// FINE shows rolling output, INFO only shows result
		logger.setLevel(Level.FINE);
		Logger.getGlobal().getParent().getHandlers()[0].setLevel(Level.FINE);

	}

	@Override
	public void intermediateResult(Player player, DicePair dicePair, GameEngine gameEngine) {
		String intermediate = String.format("%s: ROLLING %s",
				gameEngine.getPlayer(player.getPlayerId()).getPlayerName(), dicePair.toString());
		// intermediate results logged at Level.FINE
		logger.log(Level.FINE, intermediate);

	}

	@Override
	public void result(Player player, DicePair result, GameEngine gameEngine) {
		String end = String.format("%s: *RESULT* %s", gameEngine.getPlayer(player.getPlayerId()).getPlayerName(),
				result.toString());
		// final results logged at Level.INFO
		logger.log(Level.INFO, end);

	}

	@Override
	public void intermediateHouseResult(DicePair dicePair, GameEngine gameEngine) {
		// intermediate house results logged at Level.FINE
		String intermediateHouse = String.format("House: ROLLING %s", dicePair.toString());
		logger.log(Level.FINE, intermediateHouse);
	}

	@Override
	public void houseResult(DicePair result, GameEngine gameEngine) {
		// final house results logged at Level.INFO
		String endHouse = String.format("House: *RESULT* %s", result.toString());
		// final results logged at Level.INFO
		logger.log(Level.INFO, endHouse);
		// display players method
		displayResult(gameEngine);
	}

	// private method to display players' points
	private void displayResult(GameEngine gameEngine) {
		Iterator<Player> it = gameEngine.getAllPlayers().iterator();
		while (it.hasNext()) {
			logger.log(Level.INFO, it.next().toString());

		}

	}

}
