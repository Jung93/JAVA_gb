package arrayTest;

public class ArTest1 {
	public static void main(String[] args) {
		int[] arData = /*new 생략*/{2, 4, 5, 6, 8};
		int result = 0;
//		double[] arDataTwo = {3.0, 3.14, 2.5942};
//		char[] arDataThree = {'a','b','3'};
//		String[] arDataFour = {"abc", "cda"};
//		float[] arData5 = {3.4F, 6.33F, 2.1112F};
//		long[] arDataLong = {2,4,5,1,9,2};
		
//		System.out.println(arDataTwo);
//		System.out.println(arDataThree);
//		System.out.println(arDataFour);
//		System.out.println(arData5);
//		System.out.println(arDataLong);
//		System.out.println(arDataThree[2]);
		System.out.println(arData);
		System.out.println(arData.length);

		for (int i = 0; i < arData.length; i++) {
			System.out.println(arData[i]);
		}
//		System.out.println(arData[0] + 7);
//		System.out.println(arData[1]);
//		System.out.println(arData[2]);
//		System.out.println(arData[3]);
//		System.out.println(arData[4]);
	
	//5,4,3,2,1을 넣고 출력
		System.out.println("-----------------");
		
		for (int i = 0; i < arData.length; i++) {
			arData[i] = 5-i;
			
		}		
		for (int i = 0; i < arData.length; i++) {
			System.out.println(arData[i]);
		}
	}
}
