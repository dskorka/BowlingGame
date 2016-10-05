package pl.kata.bowlinggame.game;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;

public class GameRolls {

	@NotNull
	private Integer firstRoll;
	
	@NotNull
	private Integer secondRoll;
	
	@NotNull
	private Integer thirdRoll;
	
	@NotNull
	private Integer fourthRoll;
	
	@NotNull
	private Integer fifthRoll;
	
	@NotNull
	private Integer sixthRoll;
	
	@NotNull
	private Integer seventhRoll;
	
	@NotNull
	private Integer eighthRoll;
	
	@NotNull
	private Integer ninthRoll;
	@NotNull
	@NumberFormat
	private Integer tenthRoll;
	
	@NotNull
	private Integer eleventhRoll;
	
	@NotNull
	private Integer twelfthRoll;
	
	@NotNull
	private Integer thirteenthRoll;
	
	@NotNull
	private Integer fourteenthRoll;
	
	@NotNull
	private Integer fifteenthRoll;
	
	@NotNull
	private Integer sixteenthRoll;
	
	@NotNull
	private Integer seventeenthRoll;
	
	@NotNull
	private Integer eighteenthRoll;
	
	@NotNull
	private Integer nineteenthRoll;
	
	@NotNull
	private Integer twentythRoll;
	
	@NotNull
	private Integer twentyFirstRoll;

	public Integer getFirstRoll() {
		return firstRoll;
	}

	public void setFirstRoll(Integer firstRoll) {
		this.firstRoll = firstRoll;
	}

	public Integer getSecondRoll() {
		return secondRoll;
	}

	public void setSecondRoll(Integer secondRoll) {
		this.secondRoll = secondRoll;
	}

	public Integer getThirdRoll() {
		return thirdRoll;
	}

	public void setThirdRoll(Integer thirdRoll) {
		this.thirdRoll = thirdRoll;
	}

	public Integer getFourthRoll() {
		return fourthRoll;
	}

	public void setFourthRoll(Integer fourthRoll) {
		this.fourthRoll = fourthRoll;
	}

	public Integer getFifthRoll() {
		return fifthRoll;
	}

	public void setFifthRoll(Integer fifthRoll) {
		this.fifthRoll = fifthRoll;
	}

	public Integer getSixthRoll() {
		return sixthRoll;
	}

	public void setSixthRoll(Integer sixthRoll) {
		this.sixthRoll = sixthRoll;
	}

	public Integer getSeventhRoll() {
		return seventhRoll;
	}

	public void setSeventhRoll(Integer seventhRoll) {
		this.seventhRoll = seventhRoll;
	}

	public Integer getEighthRoll() {
		return eighthRoll;
	}

	public void setEighthRoll(Integer eighthRoll) {
		this.eighthRoll = eighthRoll;
	}

	public Integer getNinthRoll() {
		return ninthRoll;
	}

	public void setNinthRoll(Integer ninthRoll) {
		this.ninthRoll = ninthRoll;
	}

	public Integer getTenthRoll() {
		return tenthRoll;
	}

	public void setTenthRoll(Integer tenthRoll) {
		this.tenthRoll = tenthRoll;
	}

	public Integer getEleventhRoll() {
		return eleventhRoll;
	}

	public void setEleventhRoll(Integer eleventhRoll) {
		this.eleventhRoll = eleventhRoll;
	}

	public Integer getTwelfthRoll() {
		return twelfthRoll;
	}

	public void setTwelfthRoll(Integer twelfthRoll) {
		this.twelfthRoll = twelfthRoll;
	}

	public Integer getThirteenthRoll() {
		return thirteenthRoll;
	}

	public void setThirteenthRoll(Integer thirteenthRoll) {
		this.thirteenthRoll = thirteenthRoll;
	}

	public Integer getFourteenthRoll() {
		return fourteenthRoll;
	}

	public void setFourteenthRoll(Integer fourteenthRoll) {
		this.fourteenthRoll = fourteenthRoll;
	}

	public Integer getFifteenthRoll() {
		return fifteenthRoll;
	}

	public void setFifteenthRoll(Integer fifteenthRoll) {
		this.fifteenthRoll = fifteenthRoll;
	}

	public Integer getSixteenthRoll() {
		return sixteenthRoll;
	}

	public void setSixteenthRoll(Integer sixteenthRoll) {
		this.sixteenthRoll = sixteenthRoll;
	}

	public Integer getSeventeenthRoll() {
		return seventeenthRoll;
	}

	public void setSeventeenthRoll(Integer seventeenthRoll) {
		this.seventeenthRoll = seventeenthRoll;
	}

	public Integer getEighteenthRoll() {
		return eighteenthRoll;
	}

	public void setEighteenthRoll(Integer eighteenthRoll) {
		this.eighteenthRoll = eighteenthRoll;
	}

	public Integer getNineteenthRoll() {
		return nineteenthRoll;
	}

	public void setNineteenthRoll(Integer nineteenthRoll) {
		this.nineteenthRoll = nineteenthRoll;
	}

	public Integer getTwentythRoll() {
		return twentythRoll;
	}

	public void setTwentythRoll(Integer twentythRoll) {
		this.twentythRoll = twentythRoll;
	}

	public Integer getTwentyFirstRoll() {
		return twentyFirstRoll;
	}

	public void setTwentyFirstRoll(Integer twentyFirstRoll) {
		this.twentyFirstRoll = twentyFirstRoll;
	}
	public int[] getRolls(){
		int [] rolls = new int[21];
		rolls[0] = getFirstRoll();
		rolls[1] = getSecondRoll();
		rolls[2] = getThirdRoll();
		rolls[3] = getFourthRoll();
		rolls[4] = getFifthRoll();
		rolls[5] = getSixthRoll();
		rolls[6] = getSeventhRoll();
		rolls[7] = getEighthRoll();
		rolls[8] = getNinthRoll();
		rolls[9] = getTenthRoll();
		rolls[10] = getEleventhRoll();
		rolls[11] = getTwelfthRoll();
		rolls[12] = getThirteenthRoll();
		rolls[13] = getFourteenthRoll();
		rolls[14] = getFifteenthRoll();
		rolls[15] = getSixteenthRoll();
		rolls[16] = getSeventeenthRoll();
		rolls[17] = getEighteenthRoll();
		rolls[18] = getNineteenthRoll();
		rolls[19] = getTwentythRoll();
		rolls[20] = getTwentyFirstRoll();
		
		return rolls;
	}
}
