package pl.kata.bowlinggame.game;

public class Game {

	private final static int COUNT_FRAME = 10;
	private final BowlingFrame[] bowlingFrame = new BowlingFrame[COUNT_FRAME - 1];
	private final TenthBowlingFrame tenthBowlingFrame = new TenthBowlingFrame();
	private int id;
	private Integer firstRoll = null;
	private Integer secondRoll = null;
	private Integer extraRoll = null;
	private int numberLoop = 0;

	public Game() {
		initializeFrame();
		initializeLinkToTheNextFrame();
	}

	public Game(int id) {
		this.id = id;
		initializeFrame();
		initializeLinkToTheNextFrame();
	}

	public Game(int id, int[] rollResult) {
		this.id = id;
		initializeFrame();
		initializeLinkToTheNextFrame();
		initializeFrameByRollResult(rollResult);
	}

	public int getId() {
		return id;
	}

	private void initializeFrame() {
		for (int i = 0; i < bowlingFrame.length; i++) {
			bowlingFrame[i] = new BowlingFrame();
		}
	}

	private void initializeLinkToTheNextFrame() {
		for (int i = 0; i < bowlingFrame.length - 1; i++) {
			bowlingFrame[i].setNextBowlingFrame(bowlingFrame[i + 1]);
		}
	}

	private void initializeFrameByRollResult(int[] rollGameNumber) {
		int rollTableNumber = 0;
		for (int i = 0; i < 9; i++) {
			bowlingFrame[i].setFirstRolle(rollGameNumber[rollTableNumber]);
			bowlingFrame[i].setSecondRolle(rollGameNumber[rollTableNumber + 1]);
			rollTableNumber += 2;
		}
		tenthBowlingFrame.setFirstRolle(rollGameNumber[rollTableNumber]);
		tenthBowlingFrame.setSecondRolle(rollGameNumber[rollTableNumber + 1]);
		tenthBowlingFrame.setExtraRoll(rollGameNumber[rollTableNumber + 2]);
	}

	public int[] getRolls() {
		int[] numbersRollTable = new int[21];
		int i = 0;
		for (BowlingFrame bowlingScrolle : bowlingFrame) {
			if (nextFrameHaveValue(bowlingScrolle)) {
				numbersRollTable[i] = bowlingScrolle.getFirstRolle();
				numbersRollTable[i + 1] = bowlingScrolle.getSecondRolle();
				i += 2;
			} else {
				break;
			}
		}
		if (tenthFrameHaveValue()) {
			numbersRollTable[i] = tenthBowlingFrame.getFirstRolle();
			numbersRollTable[i + 1] = tenthBowlingFrame.getSecondRolle();
			numbersRollTable[i + 2] = tenthBowlingFrame.getExtraRoll();
		}
		return numbersRollTable;
	}

	private boolean nextFrameHaveValue(BowlingFrame bowlingScrolle) {
		if (bowlingScrolle.getNextBowlingFrame() != null) {
			if (bowlingScrolle.getNextBowlingFrame().getFirstRolle() == null) {
				return false;
			}
		}
		return true;
	}

	private boolean tenthFrameHaveValue() {
		return tenthBowlingFrame.getSecondRolle() != null;
	}

	public void roll(int value) {
		packFrame(value);
	}

	private void packFrame(int addValue) {
		if (numberLoop == 9) {
			addResultToTenthFrame(addValue);
		} else {
			addResultToBowlingFrame(addValue);
		}
	}

	private void addResultToBowlingFrame(int addValue) {
		if (isSpare(addValue)) {
			addSpareResult();
			clearTempRoll();
			numberLoop++;
		} else if (firstRoll == null) {
			firstRoll = addValue;
			bowlingFrame[numberLoop].setFirstRolle(firstRoll);
		} else {
			secondRoll = addValue;
			bowlingFrame[numberLoop].setSecondRolle(secondRoll);
			if (rollsIsNotEmpty()) {
				clearTempRoll();
				numberLoop++;
			}
		}
	}

	private boolean rollsIsNotEmpty() {
		return firstRoll != null && secondRoll != null;
	}

	private void addResultToTenthFrame(int addValue) {
		if (firstRoll == null) {
			firstRoll = addValue;
			tenthBowlingFrame.setFirstRolle(firstRoll);
		} else if (secondRoll == null) {
			secondRoll = addValue;
			tenthBowlingFrame.setSecondRolle(secondRoll);
		} else {
			extraRoll = addValue;
			tenthBowlingFrame.setExtraRoll(extraRoll);
		}
	}

	private void addSpareResult() {
		firstRoll = 10;
		secondRoll = 0;
		bowlingFrame[numberLoop].setFirstRolle(firstRoll);
		bowlingFrame[numberLoop].setSecondRolle(secondRoll);
	}

	public int score() {
		int resultGame = 0;
		for (BowlingFrame bowlingTemp : bowlingFrame) {
			if(bowlingTemp.getFirstRolle() == null){
				return resultGame;
			}
			resultGame += bowlingTemp.getScore();
			resultGame += bowlingTemp.getBonus();
		}
		resultGame += tenthBowlingFrame.getScore();
		// resultGame += tenthBowlingFrame.getBonus();
		return resultGame;
	}

	private void clearTempRoll() {
		firstRoll = null;
		secondRoll = null;
	}

	private boolean isSpare(int value) {
		return value == 10;
	}
}
