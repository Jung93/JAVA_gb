package myFileTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileTest {
	//throws 오류이름  :  오류를 이 메소드에 접근한 주소로 다시 돌려보냄
	//a() throws IOException{
//			bufferedWriter bufferedWriter1 = new BufferedWriter("test.txt")
//			bufferedWriter bufferedWriter2 = new BufferedWriter("test.txt")	
//		}
	// 이렇게 할 경우 바디 내에 오류가 나는게 아니라 객체.a() 이 부분에 오류가 생긴다.
	// 따라서 try catch문을 한번만 써도 전체 오류를 처리할 수 있다.  try{객체.a()}catch(IOException){;}
	public static void main(String[] args) throws IOException{
		
		//절대 경로 : 어디에서 작성해도 찾아갈 수 있는 경로 C:/a/b
		//상대 경로 : 현재 위치에 따라 변경되는 경로 ../a/b
//		try {                                                                             /*append if true, then bytes will be writtento the end of the file rather than the beginning*/
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt", true));
////			bufferedWriter.write("정재훈\n");
//			bufferedWriter.write("정재훈");
//			//\n과 newLine()의 차이. 녹화본
//			bufferedWriter.newLine();
//			bufferedWriter.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//파일 객체 생성. 생성자에겐 파일의 경로를 상대든 절대든 올바르게 넣어줘야 한다.
		//Writer와 달리 경로가 맞지 않으면 FileNotFoundException이 발생
		File file = new File("test.txt");
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = bufferedReader.readLine()) != null) {
				System.out.print(line);
			}
			//닫지 않으면 아래의 file.delete의 값이 false로 나옴
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("존재하지 않는 경로입니다.");
		}
		//존재하는지 안하는지부터 검사
		if(file.exists()) {
			//존재 안하면 애초에 delete 실행이 안됨
			//따라서 출력이 된다면 무조건 true가 리턴됨
			System.out.println(file.delete());
		}
	}
}
