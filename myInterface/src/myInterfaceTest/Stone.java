package myInterfaceTest;

public class Stone extends PetAdapter{
//강제성을 없애주는 Adapter 덕분에 필요한 메소드만 재정의할 수 있다. 
	
	@Override
	public void sitDown() {
		System.out.println("이미 앉아있다.");
	}

	@Override
	public void waitNow() {
		System.out.println("계속 기다린다");
	}
}
