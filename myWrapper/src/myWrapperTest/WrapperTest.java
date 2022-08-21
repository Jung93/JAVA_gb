package myWrapperTest;

public class WrapperTest {
	public static void main(String[] args) {
		int data_i = 10;
		
		//boxing
//		Integer data_I = new Integer(data_i);
//		Integer data_I = Integer.valueOf(data_i);
		
//		auto boxing
		Integer data_I = data_i + 1;
		System.out.println(data_I);
		
		//unboxing
//		data_i = data_I.intValue();
		
//		auto unboxing
		data_i = data_I+1;
		
		System.out.println(data_i);
		//a
	}
}
