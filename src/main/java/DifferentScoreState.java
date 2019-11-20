
public class DifferentScoreState implements State {

	TennisGame1Refactored tennisGame;

	private int player1Score;
	private int player2Score;

	public DifferentScoreState(TennisGame1Refactored tennisGame) {
		this.tennisGame = tennisGame;
	}

	public void playerScored() {
		player1Score = tennisGame.getPlayer1().getScore();
		player2Score = tennisGame.getPlayer2().getScore();
		int resultDifference = player1Score - player2Score;

		boolean sameScore = player1Score == player2Score;
		boolean thresholdPassed = player1Score >= TennisGame1Refactored.MAX_SCORE_THRESHOLD
				|| player2Score >= TennisGame1Refactored.MAX_SCORE_THRESHOLD;

		boolean player1Win = (player1Score >= TennisGame1Refactored.MAX_SCORE_THRESHOLD)
				&& (Math.abs(resultDifference) >= TennisGame1Refactored.WIN_THRESHOLD);
		boolean player2Win = (player2Score >= TennisGame1Refactored.MAX_SCORE_THRESHOLD)
				&& (Math.abs(resultDifference) >= TennisGame1Refactored.WIN_THRESHOLD);
		boolean win = player1Win || player2Win;

		State newState; 
		
		if (win)
			newState = tennisGame.getWinState();
		else if (sameScore)
			newState = tennisGame.getSameScoreState();
		else if (thresholdPassed)
			newState = tennisGame.getOverThresholdState();
		else
			newState = tennisGame.getDifferentScoreState();
		
		tennisGame.setCurrentState(newState);
	}

	public String getScore() {

		player1Score = tennisGame.getPlayer1().getScore();
		player2Score = tennisGame.getPlayer2().getScore();

		String player1ScoreStr = tennisGame.scoreMap.get(Integer.valueOf(player1Score));
		String player2ScoreStr = tennisGame.scoreMap.get(Integer.valueOf(player2Score));

		String score = TennisGame1Refactored.concatenate(player1ScoreStr, player2ScoreStr);
		return score;
	}
}
