package casting;

public class CastingTask {
//	넷플릭스
//	애니메이션, 영화, 드라마 클래스 선언
//	사용자가 선택한 영상이
//	애니메이션이라면 "자막지원"기능 사용
//	영화라면 "4D"기능 사용
//	드라마라면 "굿즈"기능 사용
	
	//전달받을 값을 모르니 공통된 타입인 Video로 설정
	//업캐스팅 됨 Video video = new ~~~;
	public void check(Video video) {
		//Animation이 업캐스팅된 경우
		if(video instanceof Animation) {
			//Animation에 정의된 printSubtitle()을 사용하기 위해
			//다운캐스팅함
			Animation ani = (Animation) video;
			ani.printSubtitle();
			//위와 동일
		}else if(video instanceof Film) {
			Film film = (Film) video;
			film.print4D();
			//위와 동일
		}else {
			Drama drama = (Drama) video;
			drama.sellGoods();
		}
	}
	
	public static void main(String[] args) {
		CastingTask ct = new CastingTask();
		//매개변수로 자식 생성자를 넘겨서 업캐스팅 시킴
		ct.check(new Animation());
		ct.check(new Film());
		ct.check(new Drama());
	}
}












