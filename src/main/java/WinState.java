
public class WinState implements State {
	TennisGame1Refactored tennisGame;

	private int player1Score;
	private int player2Score;

	public WinState(TennisGame1Refactored tennisGame) {
		this.tennisGame = tennisGame;
	}

	public void playerScored() {
	}

	public String getScore() {

		player1Score = tennisGame.getPlayer1().getScore();
		player2Score = tennisGame.getPlayer2().getScore();

		String score;
		if (player1Score > player2Score)
			score = "Win for " + tennisGame.getPlayer1().getName();
		else
			score = "Win for " + tennisGame.getPlayer2().getName();
		return score;
	}

}
