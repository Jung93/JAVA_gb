package myFileTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTask {
	public static void main(String[] args) throws IOException{
		//고등어, 갈치, 꽁치, 전어
		//배열로 출력하고 전체 내용  가져와서 콘솔에 출력
		String[] fishs = {"고등어", "갈치", "꽁치", "전어"};
		
//		try {
//			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("fish.txt"));
//		
//			for (String fish : fishs) {
//				bufferedWriter.write(fish); +"\n"을 쓰든 <- 강사님 픽
//				bufferedWriter.newLine(); 뉴라인을 쓰든 맘대로
//			}
//			bufferedWriter.close();
//		} catch (IOException e) { //main 메소드에 throws를 걸어주었기 때문에 catch 불필요
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			BufferedReader bufferedReader = new BufferedReader(new FileReader("fish.txt"));
//			String line = null;
//			while((line = bufferedReader.readLine())!=null) {
//				//입력할 때 파일 안에 있는 줄바꿈 문자는 읽어오지 않음
//				//파일처럼 줄바꿈이 되는 이유는 여기서 println으로 콘솔 창에 
//				//출력하기 때문이다. println의 api문서를 보면 newLine()이 사용되고
//				//있는 것을 알 수 있다.
//				System.out.println(line);
//			}
//			//닫는 거 잊지 말고.
//			bufferedReader.close();
//		
//		} catch (FileNotFoundException e) {//main에 throws를 걸어주었지만 FileNotFoundException도 대비해야 하기 때문에 try catch 필요
//			// TODO Auto-generated catch block
//			System.out.println("존재하지 않는 경로");
		
		//수정 갈치-> 연어
//		try {
//			BufferedReader bufferedReader = new BufferedReader(new FileReader("fish.txt"));
//			 String line = null, temp = "";
//		
//			 while((line = bufferedReader.readLine()) != null) {
//				    //너 갈치니?  
//				 if(line.equals("갈치")) {
//					//응!   너 이제 연어
//					 temp += "연어\n";
//					 continue;
//				 }
//				 temp += line + "\n";
//			 }
//			 bufferedReader.close();
//			 
//			 BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("fish.txt"));
//		
//			 bufferedWriter.write(temp);
//			 bufferedWriter.close();
//			 
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println("없는 경로");
//		}
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("fish.txt"));
			 String line = null, temp = "";
		
			 while((line = bufferedReader.readLine()) != null) {
				 if(line.equals("고등어")) {
					 //암것도 안하고 그냥 건너뜀
					 continue;
				 }
				 temp += line + "\n";
			 }
			 bufferedReader.close();
			 
			 BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("fish.txt"));
		
			 bufferedWriter.write(temp);
			 bufferedWriter.close();
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("없는 경로");
		}
	}
}
