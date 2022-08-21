package fighting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

public class WeCanDoIt {

	public static int solution(String s) {
		//1,0으로 이루어진 문자열
		//1이 최대 몇번 연속되었는지
		
		//0을 기준으로 잘라서 문자열로 리턴된 값들이 담긴 배열을 datas에 저장
	      ArrayList<String> datas = new ArrayList<String>(Arrays.asList(s.split("0")));
	      //1로 이루어진 각 문자열의 길이를 담을 lengths
	      ArrayList<Integer> lengths = new ArrayList<Integer>();
	      List<Integer> result = null;
	      //datas에 들어있는 각 문자열의 길이(정수)를 lengths에 추가
	      datas.stream().map(data -> data.length()).forEach(lengths::add);
	      //lengths에 추가된 값들을 오름차순 정렬 후 내림차순 후 List 타입으로 리턴
	      result = lengths.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
	      //result의 인덱스가 0이 최대값이므로 1의 최대 연속횟수를 리턴하게 됨
	      return result.size() == 0 ? 0 : result.get(0);
	   }
	   
	   public static void main(String[] args) {
	      System.out.println(solution("1101110"));
	   }

	
}
