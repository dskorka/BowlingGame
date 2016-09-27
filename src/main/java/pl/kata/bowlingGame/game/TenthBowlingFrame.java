package pl.kata.bowlinggame.game;

class TenthBowlingFrame extends BowlingFrame {

	private int extraRoll;
	

	public TenthBowlingFrame() {

	}

	public int getExtraRoll() {
		return extraRoll;
	}

	protected void setExtraRoll(int extraRoll) {
		this.extraRoll = extraRoll;
	}

	@Override
	public int getScore() {
		return super.getScore() + extraRoll;
	}

	@Override
	public int getBonus() {
		return super.getBonus();
	}
}
