package model;

import model.interfaces.DicePair;
import model.interfaces.Player;

public class SimplePlayer implements Player {

	private String playerId;
	private String playerName;
	private int points;
	private int bet;
	private DicePair result;

	public SimplePlayer(String playerId, String playerName, int points) {

		this.playerId = playerId;
		this.setPlayerName(playerName);
		this.setPoints(points);
	}

	@Override
	public String getPlayerName() {

		return playerName;
	}

	@Override
	public void setPlayerName(String playerName) {

		this.playerName = playerName;

	}

	@Override
	public int getPoints() {

		return points;
	}

	@Override
	public void setPoints(int points) {

		this.points = points;
	}

	@Override
	public String getPlayerId() {

		return playerId;
	}

	@Override
	public boolean placeBet(int bet) {

		if (getPoints() >= bet) {
			this.bet = bet;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int getBet() {

		return bet;
	}

	@Override
	public DicePair getRollResult() {

		return result;
	}

	@Override
	public void setRollResult(DicePair rollResult) {

		result = rollResult;
	}

	@Override
	public String toString() {
		String s = String.format("Player: id=%s, name= %s, points=%d\n", getPlayerId(), getPlayerName(), getPoints());

		return s;

	};

}
