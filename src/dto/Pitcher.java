package dto;

/**
 * 투수 정보 dto
 */
public class Pitcher extends Player {
	/**
	 * 평균 자책
	 */
	private double era;	
	/**
	 * 이닝
	 */
	private int inning;
	/**
	 * 승
	 */
	private int wins;
	/**
	 * 패
	 */
	private int losses;	
	/**
	 * 세이브
	 */
	private int save;
	/**
	 * 홀드
	 */
	private int hold;
	
	/**
	 * 기본 생성자
	 */
	public Pitcher() {
	}

	/**
	 * 생성자
	 */
	
	
	public Pitcher(String id, String name, String team, int salary, double war, double era, int inning, int wins, int losses, int save, int hold) {
		super(id, name, team, salary, war);
		this.era = era;
		this.inning = inning;
		this.wins = wins;
		this.losses = losses;
		this.save = save;
		this.hold = hold;
	}

	public double getEra() {
		return era;
	}

	public void setEra(double era) {
		this.era = era;
	}

	public int getInning() {
		return inning;
	}

	public void setInning(int inning) {
		this.inning = inning;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public int getSave() {
		return save;
	}

	public void setSave(int save) {
		this.save = save;
	}

	public int getHold() {
		return hold;
	}

	public void setHold(int hold) {
		this.hold = hold;
	}

	@Override
	public String toString() {
		return super.toString() + " 평균자책:" + era + " 이닝:" + inning + " 승:" + wins 
				+ " 패:" + losses + " 세이브:" + save + " 홀드:" + hold;
	}
}
