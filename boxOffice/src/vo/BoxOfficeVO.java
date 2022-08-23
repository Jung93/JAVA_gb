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

//		String str = ranking + "\t" + name + "\t" + releaseDate + "\t" + income + "\t" + guestCount + "\t" + screenCount;
		
		//datas[0]  123456
		String[] datas = {String.valueOf(getIncome()), String.valueOf(getGuestCount()), String.valueOf(getScreenCount())};
		String[] temp = new String[3];
		String[] result = new String[3];
		
		for (int i = 0; i < datas.length; i++) {
			//datas[0].length  6
			temp[i] = "";
			result[i] = "";
			for (int j = 0; j < datas[i].length(); j++) {
				if(j%3==2 && j != datas[i].length()-1) {
					temp[i] += datas[i].charAt(datas[i].length()-1-j) +",";
				
				}else {
					temp[i] += datas[i].charAt(datas[i].length()-1-j);
				}
			}
			for (int j = 0; j < temp[i].length(); j++) {
				result[i] += temp[i].charAt(temp[i].length()-1-j);
			}
		}

		String str = ranking + "\t" + name + "\t" + releaseDate + "\t" + result[0] + "\t" + result[1] + "\t" + result[2];
		
		return str;
	}
	
	
//	int data = 1019231;
//	String temp = "";
//	String result = "";
//	String str = String.valueOf(data);
//	System.out.println(data);
//	
//	for (int i = 0; i < str.length(); i++) {
//		if(i%3==2 && i != str.length()-1) {
//		temp += str.charAt(str.length()-1-i) +",";
//		}else {
//			temp += str.charAt(str.length()-1-i);
//		}
//	}
//	
//	for (int i = 0; i < temp.length(); i++) {
//		result += temp.charAt(temp.length()-1-i);
//	}
//	System.out.println(result);
	
	
//	String data = str.split("\t")[3];
//	
//	String temp = "";
//	String result = "";
//	
//	for (int i = 0; i < data.length(); i++) {
//		if(i%3==2 && i != data.length()-1) {
//		temp += str.charAt(data.length()-1-i) +",";
//		}else {
//			temp += str.charAt(data.length()-1-i);
//		}
//	}
//	for (int i = 0; i < temp.length(); i++) {
//	result += temp.charAt(temp.length()-1-i);
//	}
	
	
	
	
	
	
}
























