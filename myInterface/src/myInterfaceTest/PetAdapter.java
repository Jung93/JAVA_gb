package myInterfaceTest;

//필요한 것만 구현하기 위한 추상 클래스
//인터페이스를 부모로 두고 필요한 것만 구현할 클래스가
//이 클래스를 부모로 둠
//인터페이스명Adapter 라는 이름은 개발자들 사이의 약속
//강제성을 중간에서 없애주는 친구
public abstract class PetAdapter implements Pet {

	@Override
	public void bang() {;}

	@Override
	public void giveYourHand() {;}

	@Override
	public void bite() {;}

	@Override
	public void sitDown() {;}

	@Override
	public void waitNow() {;}

	@Override
	public void getNose() {;}

}
