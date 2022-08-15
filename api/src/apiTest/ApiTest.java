package apiTest;

public class ApiTest {
	public static void main(String[] args) {
		//강사님이 보내준 calc.jar를
		//프로젝트 우클릭->buildPath->Configure Build Path
		//->Libaries->classpath0>add external files에서 선택
		//->order and export->select all
		Calc c = new Calc();
		//해당 api안에 있는 메소드 사용
		c.divide(10, 3);
	}
}
