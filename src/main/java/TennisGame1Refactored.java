import java.util.HashMap;
import java.util.Map;

public class TennisGame1Refactored implements TennisGame {

	private Player player1;
	private Player player2;

	State sameScoreState;
	State differentScoreState;
	State overThresholdState;
	State winState;
	State currentState;

	static final int WIN_THRESHOLD = 2;
	static final int DEUCE_THRESHOLD = 3;
	static final int MAX_SCORE_THRESHOLD = 4;

	public State getWinState() {
		return winState;
	}

	public void setWinState(State winState) {
		this.winState = winState;
	}

	public State getSameScoreState() {
		return sameScoreState;
	}

	public void setSameScoreState(State sameScoreState) {
		this.sameScoreState = sameScoreState;
	}

	public State getDifferentScoreState() {
		return differentScoreState;
	}

	public void setDifferentScoreState(State differentScoreState) {
		this.differentScoreState = differentScoreState;
	}

	public State getOverThresholdState() {
		return overThresholdState;
	}

	public void setOverThresholdState(State overThresholdState) {
		this.overThresholdState = overThresholdState;
	}

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	Map<Integer, String> scoreMap = new HashMap<Integer, String>() {
		{
			put(0, "Love");
			put(1, "Fifteen");
			put(2, "Thirty");
			put(3, "Forty");
		}
	};

	public TennisGame1Refactored(String player1Name, String player2Name) {
		this.player1 = new Player(player1Name);
		this.player2 = new Player(player2Name);
		this.sameScoreState = new SameScoreState(this);
		this.differentScoreState = new DifferentScoreState(this);
		this.overThresholdState = new OverThresholdState(this);
		this.winState = new WinState(this);
		this.currentState = sameScoreState;
	}

	public void wonPoint(String playerName) {
		if (playerName.equals(player1.getName()))
			player1.incrementScore();
		else
			player2.incrementScore();
		currentState.playerScored();
	}

	public String getScore() {

		return currentState.getScore();
	}

	public static String concatenate(String s1, String s2) {
		String ret = s1 + "-" + s2;
		return ret;
	}
}
