package myHashSetTest;

import java.util.HashSet;

public class School {
	public static void main(String[] args) {
		
		HashSet<Student> stds = new HashSet<Student>();
		//hashCode를 재정의하지 않으면
		//생성자가 두 개이기 때문에 주소가 달라서 hashCode도 달라지게 됨
		stds.add(new Student(1, "한동석"));
		stds.add(new Student(1, "한동석"));
		//그래서 stds 안에 각각 들어가서 size()하면 2가 리턴됨
		//따라서 hasCode를 재정의해야 한다.
		System.out.println(stds.size());
		//Student 타입의 han에 새로운 주소 부여.
		Student han = new Student(1, "한동석");
		System.out.println(han.equals(new Student(1, "한동석")));
		
	}
}
