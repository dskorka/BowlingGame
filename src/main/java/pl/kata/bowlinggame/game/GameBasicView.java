package pl.kata.bowlinggame.game;

public class GameBasicView {

	private int id;
	private int score;
	private String dateGame;

	public int getId() {
		return id;
	}

	public int getScore() {
		return score;
	}

	public String getDateGame() {
		return dateGame;
	}

	public GameBasicView(int id, int score, String insert_date) {
		super();
		this.id = id;
		this.score = score;
		this.dateGame = insert_date;
	}

	@Override
	public String toString() {
		return "GameBasicView [id=" + id + ", score=" + score + ", localTime=" + dateGame + "]";
	}

}
