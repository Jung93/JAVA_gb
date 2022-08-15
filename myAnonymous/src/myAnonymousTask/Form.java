package myAnonymousTask;

//틀이기 때문에 외부에서 변경 불가
public interface Form {
	//구현되지 않은 추상 메소드들
	public String[] getMenu();
	public void sell(String order);
}
