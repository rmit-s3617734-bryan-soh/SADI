package view;

import java.awt.BorderLayout;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JFrame;

import model.GameEngineImpl;
import model.SimplePlayer;
import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class AppFrame extends JFrame {

	private GameEngine gameEngine = new GameEngineImpl();
	private GameEngineCallback gecI = new GameEngineCallbackImpl();
	private GameEngineCallback gecGUI = new GameEngineCallbackGUI(this);
	private PullDownMenu menu = new PullDownMenu(this.gameEngine, this);
	private ToolBar toolBar = new ToolBar(this.gameEngine, this);
	private DicePanel dicePanel = new DicePanel(this.gameEngine, this);
	private StatusBar statusBar = new StatusBar(this.gameEngine, this);
	private DialogBox dialogBox = new DialogBox();

	public AppFrame() {
		super("Dice Game");
		setBounds(100, 100, 640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setJMenuBar(menu);
		setVisible(true);
	}

	public void populate() {
		add(toolBar, BorderLayout.NORTH);
		add(dicePanel, BorderLayout.CENTER);
		add(statusBar, BorderLayout.SOUTH);
		setJMenuBar(menu);
	}

	public void loadPlayer() {
		// load 1 player to game
		Player player = new SimplePlayer("1", "The Roller", 1000);
		this.gameEngine.addPlayer(player);

		updateComboBox();
	}

	public void addCallBacks() {
		// add callbacks to game engine,GUI & Console
		gameEngine.addGameEngineCallback(this.gecI);
		gameEngine.addGameEngineCallback(this.gecGUI);
	}

	public Player createPlayer(GameEngine gameEngine) {
		Player player = dialogBox.getPlayer(gameEngine);
		return player;
	}

	// get selected combobox player
	public Player getSelectedPlayer(GameEngine gameEngine) {
		Player player = toolBar.getPlayer(gameEngine);
		return player;
	}

	public void placeBet(GameEngine gameEngine, Player player) {
		dialogBox.placeBet(gameEngine, player);
	}

	public void updateComboBox() {
		toolBar.updateCombo(this.gameEngine);
	}

	// set status bar
	public void setStatus1(GameEngine ge) {
		Player player = getSelectedPlayer(ge);
		statusBar.setStatus1(player);
	}
	//update dice panel
	public void updatePanel(Player player, DicePair dp) {

		dicePanel.updatePanel(player, dp);
	}
	
	//update house dices
	public void updateHouse(DicePair dp, AppFrame frame) {

		dicePanel.updateHouse(dp);
	}

	// update result of rolls
	public void updateResult() {
		dicePanel.updateResult();

	}

	// reset house dice
	public void resetHouse() {
		dicePanel.resetHouse();
	}

	// reset all players roll results
	public void resetBet() {
		Collection<Player> plyr = this.gameEngine.getAllPlayers();
		Iterator<Player> it = plyr.iterator();

		while (it.hasNext()) {
			Player test = it.next();
			test.placeBet(0);
		}
	}

}
