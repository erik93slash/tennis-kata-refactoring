
public class OverThresholdState implements State {

	TennisGame1Refactored tennisGame;

	private int player1Score;
	private int player2Score;

	public OverThresholdState(TennisGame1Refactored tennisGame) {
		this.tennisGame = tennisGame;
	}

	public void playerScored() {

		player1Score = tennisGame.getPlayer1().getScore();
		player2Score = tennisGame.getPlayer2().getScore();

		boolean sameScore = player1Score == player2Score;

		int resultDifference = player1Score - player2Score;

		if (Math.abs(resultDifference) >= 2)
			tennisGame.setCurrentState(tennisGame.getWinState());
		else if (sameScore)
			tennisGame.setCurrentState(tennisGame.getSameScoreState());
	}

	public String getScore() {

		player1Score = tennisGame.getPlayer1().getScore();
		player2Score = tennisGame.getPlayer2().getScore();

		String score;
		if (player1Score > player2Score)
			score = "Advantage " + tennisGame.getPlayer1().getName();
		else
			score = "Advantage " + tennisGame.getPlayer2().getName();

		return score;
	}
}
