package vo;

public class BoxOfficeVO {
	private int ranking;
	private String name;
	private String releaseDate;
	private long income;
	private int guestCount;
	private int screenCount;
	
	public BoxOfficeVO() {;}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public long getIncome() {
		return income;
	}

	public void setIncome(long income) {
		this.income = income;
	}

	public int getGuestCount() {
		return guestCount;
	}

	public void setGuestCount(int guestCount) {
		this.guestCount = guestCount;
	}

	public int getScreenCount() {
		return screenCount;
	}

	public void setScreenCount(int screenCount) {
		this.screenCount = screenCount;
	}
	
//	숫자타입은 3자리마다 , 삽입	
	@Override
	public String toString() {
		String str = ranking + "\t" + name + "\t" + releaseDate + "\t" + income + "\t" + guestCount + "\t" + screenCount;
		return str;
	}
}
























