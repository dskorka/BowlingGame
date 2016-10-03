package pl.kata.bowlinggame.game;

import java.time.LocalDate;

public class GameViewModel {

	private int id;
	private int score;
	private LocalDate dateGame;

	public int getId() {
		return id;
	}

	public int getScore() {
		return score;
	}

	public LocalDate getDateGame() {
		return dateGame;
	}

	public GameViewModel(int id, int score, LocalDate insert_date) {
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
