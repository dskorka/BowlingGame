package pl.kata.bowlinggame.finder;

import java.time.LocalDateTime;

public class GameViewModel {

	private final int id;
	private final int score;
	private final LocalDateTime timeGame;

	public int getId() {
		return id;
	}

	public int getScore() {
		return score;
	}

	public LocalDateTime getTimeGame() {
		return timeGame;
	}

	public GameViewModel(int id, int score, LocalDateTime dateGame) {
		super();
		this.id = id;
		this.score = score;
		this.timeGame = dateGame;
	}

	@Override
	public String toString() {
		return "GameBasicView [id=" + id + ", score=" + score + ", localTime=" + timeGame + "]";
	}
}
