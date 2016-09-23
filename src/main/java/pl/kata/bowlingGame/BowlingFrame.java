package pl.kata.bowlingGame;

	class BowlingFrame {
		
	private Integer firstRoll;
	private Integer secondRoll;
	private BowlingFrame nextBowlingFrame;
	

	public Integer getFirstRolle() {
		return firstRoll;
	}

	public void setFirstRolle(Integer firstRolle) {
		this.firstRoll = firstRolle;
	}

	public Integer getSecondRolle() {
		return secondRoll;
	}

	public void setSecondRolle(Integer secondRolle) {
		this.secondRoll = secondRolle;
	}

	public BowlingFrame getNextBowlingFrame() {
		return nextBowlingFrame;
	}

	protected void setNextBowlingFrame(BowlingFrame nextBowlingFrame) {
		this.nextBowlingFrame = nextBowlingFrame;
	}
	
	@Override
	public String toString() {
		return "BowlingFrame [firstRoll=" + firstRoll + ", secondRoll=" + secondRoll +  "]";
	}

	public int getBonus() {
		/*int result = 0;
		//if (nextBowlingFrame.nextBowlingFrame.firstRoll != null) {
			if (firstRoll == 10) {
				// bonus dla strike dwa rzuty
				if (nextBowlingFrame.firstRoll == 10) {
					// jezeli kolejny tez strike to licz pierwszy z i+1 i i+2
					result += nextBowlingFrame.firstRoll + nextBowlingFrame.nextBowlingFrame.firstRoll;
				} else {
					result += nextBowlingFrame.getScore();
				}
				// bonus w postaci jednego rzutu
			} else if (getScore() == 10) {
				result += nextBowlingFrame.getFirstThrow();
		//	}
		}
		
		
	/*	if (nextBowlingFrame != null) {
			if (nextBowlingFrame.firstRoll == 10) {
				if (nextBowlingFrame.nextBowlingFrame.firstRoll == 10) {
					
					result = nextBowlingFrame.getFirstThrow() + nextBowlingFrame.nextBowlingFrame.getFirstThrow();
				} else {
					result = nextBowlingFrame.getScore();
				}
			} else if (nextBowlingFrame.getScore() == 10) {
				result = nextBowlingFrame.getFirstThrow();
			}
		}*/
		return 0;
	}

	public int getScore(){
		return firstRoll + secondRoll;
	}
	
}
