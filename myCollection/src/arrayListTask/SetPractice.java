package arrayListTask;

import java.util.HashSet;
import java.util.Set;

public class SetPractice {

		public static Set<String> setPractice = new HashSet<String>();
		public static Set<String> setPractice1 = new HashSet<String>();
		
		public static void main(String[] args) {
			System.out.println(setPractice.add("Hello world!"));
			System.out.println(setPractice.add("Hello world!"));
			setPractice.add("Hello world!");
			setPractice.add("Hello world!");
			setPractice.add("Seeyou later world!");
			setPractice.add("Longtime no see world!");
			setPractice.add("Longtime no see world!");
			setPractice.add("A");
			setPractice.add("B");
			setPractice.add("34");
			setPractice.add("C");
			setPractice.add("D");
			setPractice.add("0");
			setPractice.add("-123");
			
			for (String str : setPractice) {
				System.out.println(str);
			}
			
			
			System.out.println(setPractice.toString());
			System.out.println(setPractice.hashCode());
			System.out.println(setPractice.size());
			
			setPractice1.add("Hello world!");
			setPractice1.add("Hello world!");
			setPractice1.add("Hello world!");
			setPractice1.add("Seeyou later world!");
			setPractice1.add("Longtime no see world!");
			setPractice1.add("Longtime no see world!");
			setPractice1.add("A");
			setPractice1.add("B");
			setPractice1.add("34");
			setPractice1.add("C");
			setPractice1.add("D");
			setPractice1.add("0");
			setPractice1.add("-123");
			
			System.out.println(setPractice1);
			System.out.println(setPractice1.size());
			
			
			
			
			
			
		}
}
