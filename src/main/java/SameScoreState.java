
public class SameScoreState implements State {

	TennisGame1Refactored tennisGame;

	private int player1Score;
	private int player2Score;

	public SameScoreState(TennisGame1Refactored tennisGame) {
		this.tennisGame = tennisGame;
	}

	public void playerScored() {
		player1Score = tennisGame.getPlayer1().getScore();
		player2Score = tennisGame.getPlayer2().getScore();

		boolean thresholdPassed = player1Score >= TennisGame1Refactored.MAX_SCORE_THRESHOLD
				|| player2Score >= TennisGame1Refactored.MAX_SCORE_THRESHOLD;

		if (thresholdPassed)
			tennisGame.setCurrentState(tennisGame.getOverThresholdState());
		else
			tennisGame.setCurrentState(tennisGame.getDifferentScoreState());
	}

	public String getScore() {

		player1Score = tennisGame.getPlayer1().getScore();
		player2Score = tennisGame.getPlayer2().getScore();

		int intScore = player1Score;
		String score = tennisGame.scoreMap.get(Integer.valueOf(intScore));

		if (intScore < TennisGame1Refactored.DEUCE_THRESHOLD)
			score = TennisGame1Refactored.concatenate(score, "All");
		else
			score = "Deuce";

		return score;
	}

}
