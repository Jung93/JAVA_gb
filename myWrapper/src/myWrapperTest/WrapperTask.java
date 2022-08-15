package myWrapperTest;

import java.util.Iterator;

public class WrapperTask {
	public static void main(String[] args) {
		
		//1, 12.5, 86.6F, 'Z', "Hi",false
		//위 6개의 값을 6칸 배열에 담기
		
		int data_i = 1;
		double data_d = 12.5;
		float data_f = 86.6F;
		char data_c = 'Z';
		String data_s = "Hi";
		boolean data_b = false;
		
//		Integer data_I = data_i;
//		Double data_D = data_d;
//		Float data_F = data_f;
//		Character data_C = data_c;
//		Boolean data_B = data_b;

//		Object data_I = data_i;
//		Object data_D = data_d;
//		Object data_F = data_f;
//		Object data_C = data_c;
//		Object data_B = data_b;
//		
//		Object[] arObj = {data_I,data_D,data_F,data_C,data_s,data_B};
//		for (int i = 0; i < arObj.length; i++) {
//			System.out.println(arObj[i]);
//		}
		
		Object[] datas = {1, 12.5, 86.6F, 'Z', "Hi",false};
		for (int i = 0; i < datas.length; i++) {
			System.out.println(datas[i]);
		}
	}
}
