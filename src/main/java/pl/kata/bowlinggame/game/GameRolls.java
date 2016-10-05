package pl.kata.bowlinggame.game;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

public class GameRolls {

	@NotNull
	@Size(min = 0, max = 10)
	private Integer firstRoll;
	@NotNull
	@NumberFormat
	@Max(10)
	private Integer secondRoll;
	@NotNull
	@NumberFormat
	private Integer thirdRoll;
	@NotNull
	@NumberFormat
	@Max(10)
	private Integer fourthRoll;
	@NotNull
	@NumberFormat
	@Max(10)
	private Integer fifthRoll;
	@NotNull
	@NumberFormat
	@Max(10)
	private Integer sixthRoll;
	@NotNull
	@NumberFormat
	@Max(10)
	private Integer seventhRoll;
	@NotNull
	@NumberFormat
	@Max(10)
	private Integer eighthRoll;
	@NotNull
	@NumberFormat
	@Max(10)
	private Integer ninthRoll;
	@NotNull
	@NumberFormat
	@Max(10)
	private Integer tenthRoll;
	@NotNull
	@NumberFormat
	@Max(10)
	private Integer eleventhRoll;
	@NotNull
	@NumberFormat
	@Max(10)
	private Integer twelfthRoll;
	@NotNull
	@NumberFormat
	@Max(10)
	private Integer thirteenthRoll;
	@NotNull
	@NumberFormat
	@Max(10)
	private Integer fourteenthRoll;
	@NotNull
	@NumberFormat
	@Max(10)
	private Integer fifteenthRoll;
	@NotNull
	@NumberFormat
	@Max(10)private Integer sixteenthRoll;
	@NotNull
	@NumberFormat
	private Integer seventeenthRoll;
	@NotNull
	@NumberFormat
	private Integer eighteenthRoll;
	@NotNull
	@NumberFormat
	private Integer nineteenthRoll;
	@NotNull
	@NumberFormat
	private Integer twentythRoll;
	@NotNull
	@NumberFormat
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

}
