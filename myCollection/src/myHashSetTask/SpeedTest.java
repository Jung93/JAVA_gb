package myHashSetTask;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class SpeedTest {

	public static void main(String[] args) {
		
		final int SIZE = 10_000_000;
		final List<Integer> arrayList = new ArrayList<Integer>(SIZE);
		final Set<Integer> hashSet = new HashSet<Integer>(SIZE);
		final int DATA = 7_133_401;
		//정렬 집계 연산이었나. 녹화본
		IntStream.range(0, SIZE).forEach(value ->{
			arrayList.add(value);
			hashSet.add(value);
		});
		//시작시간
		Instant start = Instant.now();
		arrayList.contains(DATA);
		//끝시간
		Instant end = Instant.now();
		//시간은 long 타입에 저장
		long elapsedTime = Duration.between(start, end).toMillis();
		System.out.println("arrayList : " + elapsedTime*0.001 + "초");
		
		//데이터가 수억, 수십억개 이상이 되면 차이가 확연하게 벌어지기 때문에
		//검사는 Set으로 하자.
		start = Instant.now();
		hashSet.contains(DATA);
		end = Instant.now();
		elapsedTime = Duration.between(start, end).toMillis();
		System.out.println("hashSet : " + elapsedTime*0.001 + "초");
	}
}
