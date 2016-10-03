package pl.kata.bowlinggame.game;

import java.time.LocalTime;

public class GameBasicView {

	private int id;
	private LocalTime localTime;

	public int getId() {
		return id;
	}

	public LocalTime getLocalTime() {
		return localTime;
	}

	public GameBasicView(int id, LocalTime localTime) {
		this.id = id;
		this.localTime = localTime;
	}

	@Override
	public String toString() {
		return "GameBasicView [id=" + id + ", localTime=" + localTime + "]";
	}
}
