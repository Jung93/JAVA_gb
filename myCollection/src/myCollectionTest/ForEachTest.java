package myCollectionTest;

public class ForEachTest {
	public static void main(String[] args) {
		int[][] arrData = {{10, 30, 80}, {20, 40, 10}};
		//각 학생의 총점과 평균 출력
		
		
			
		
//		arrData[0][0], [1], [2]  10 30 80
//		arrData[1][0], [1], [2] 20 40 10
//		String format
		
//			for (int i = 0; i < arrData.length; i++) {
//				int sum = 0; 
//				double avg = 0.0;
//				for (int j = 0; j < arrData[i].length; j++) {
//					sum += arrData[i][j];
//				}
//				avg = sum/3.0;
//				System.out.println(sum);
//				System.out.println(avg);
//			}
		
		int sum = 0;
		double avg = 0.0;
			//행.  0행  1행
			for (int[] is : arrData) {
				sum = 0;
				//0행의 열  1행의 열
				for (int is2 : is) {
//					sum+=is2;
//					System.out.println(sum);
					sum+=is2;
				}
				avg = sum/(double)is.length;
				avg = Double.parseDouble(String.format("%.2f", avg));
				System.out.println(sum);
				System.out.println(avg);
			}
		
	}
}
