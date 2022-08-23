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
	
	@Override
	public String toString() {

//		String str = ranking + "\t" + name + "\t" + releaseDate + "\t" + income + "\t" + guestCount + "\t" + screenCount;
		
		//값이 여러 개라 배열로 저장
		String[] datas = {String.valueOf(income), String.valueOf(guestCount), String.valueOf(screenCount)};
		//뒤에서부터 가져와서 3칸마다 , 찍은 문자열 저장할 배열
		String[] temp = new String[3];
		//temp를 다시 거꾸로 가져와서 저장할 배열
		String[] result = new String[3];
		//총 세 번 반복
		for (int i = 0; i < datas.length; i++) {
			//연결을 위해 null이 아닌 빈 문자열로 초기화
			temp[i] = "";
			result[i] = "";
			for (int j = 0; j < datas[i].length(); j++) {
				//3으로 나눈 나머지가 2라는 것은 인덱스상으로는 j가 3번째라는 뜻
				//그 인덱스 다음에 , 을 찍음. 이거만 하면 마지막 숫자 뒤에도 ,을 찍을 수 있음
				//그래서 j가 마지막 인덱스면 false가 나오게 조건을 둠
				if(j%3==2 && j != datas[i].length()-1) {
					//temp의 i번째 인덱스에 dats의 i번째 인덱스에 있는 문자열을
					//문자로 쪼개고 붙임
					temp[i] += datas[i].charAt(datas[i].length()-1-j) +",";
				
				}else {
					//, 안찍고 그냥 붙임
					temp[i] += datas[i].charAt(datas[i].length()-1-j);
				}
			}
			for (int j = 0; j < temp[i].length(); j++) {
				//temp[i] 번째를 다시 거꾸로 가져옴
				result[i] += temp[i].charAt(temp[i].length()-1-j);
			}
		}
		//result의 각 방에 income, guestCount, screenCount이 들어있음
		String str = ranking + "\t" + name + "\t" + releaseDate + "\t" + result[0] + "\t" + result[1] + "\t" + result[2];
		
		return str;
	}
}
