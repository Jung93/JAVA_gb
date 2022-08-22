package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import vo.BoxOfficeVO;

public class BoxOfficeDAO {

	//추가와 삽입
	//한번에 하는 메소드
	//순의를 구분점으로 둬서 순위가 없다면 boxOfficeVO의 getRanking이 초기값인 0이므로
	//삼항의 결과가 true -> append()가 실행, 있다면 getRanking이 0이 아닌 값이 들어있으므로
	//삼항의 결과가 false -> insert()가 실행
	public boolean add(BoxOfficeVO boxOfficeVO) throws IOException{
		return boxOfficeVO.getRanking() == 0 ? append(boxOfficeVO) : insert(boxOfficeVO);
	}
	
	//CRUD
	//추가 C
	private boolean append(BoxOfficeVO boxOfficeVO) throws IOException{
		
		BufferedWriter bufferedWriter = DBConnecter.getAppend();
		BufferedReader bufferedReader = DBConnecter.getReader();
		String line = null, content = null, newLine = null;
		int lastRanking = 0;
		boolean check = true;
		
		while((line = bufferedReader.readLine()) !=null) {
			String excludedRankingOrigin = line.substring(line.indexOf("\t"));
			String excludedRankingNew = boxOfficeVO.toString().substring(boxOfficeVO.toString().indexOf("\t"));
			
			if(excludedRankingOrigin.equals(excludedRankingNew)) {
				check = false;
			}
			lastRanking++;
		}
		
		bufferedReader.close();
		
		boxOfficeVO.setRanking(lastRanking+1);
		
		content = new String(Files.readAllBytes(Paths.get(DBConnecter.PATH)));
		
		newLine = content.charAt(content.length()-1) == '\n' ? "" : "\n";
		
		bufferedWriter.write(boxOfficeVO.toString());
		bufferedWriter.close();
		
		return check;
	}
	
	//삽입 C
		private boolean insert(BoxOfficeVO boxOfficeVO) throws IOException{
			BufferedReader bufferedReader = DBConnecter.getReader();
			BufferedWriter bufferedWriter = null;
			String line = null, temp = "";
			int newRanking = boxOfficeVO.getRanking();
			boolean check = false;
			
			while((line = bufferedReader.readLine())!=null) {
				if(Integer.valueOf(line.split("\t")[0]) == boxOfficeVO.getRanking()) {
					temp += boxOfficeVO;
					check = true;
				}
				if(check) {
					temp += check ? ++newRanking + line.substring(line.indexOf("\t")) : line;
				}else {
					temp += line + "\n";
				}
			}
			bufferedReader.close();
			
			bufferedWriter = DBConnecter.getWriter();
			bufferedWriter.write(temp);
			bufferedWriter.close();
			
			return check;
		}
	
	//수정 U
		
		public boolean update(BoxOfficeVO boxOfficeVO) throws IOException{
			BufferedReader bufferedReader = DBConnecter.getReader();
			BufferedWriter bufferedWriter = DBConnecter.getWriter();
			String line = null, temp = "";
			boolean check = false;
			
			while((line = bufferedReader.readLine()) != null) {
				if(Integer.valueOf(line.split("\t")[0]) == boxOfficeVO.getRanking()) {
					temp += boxOfficeVO + "\n";
					check = true;
					continue;
				}
				temp += line + "\n";
			}
			bufferedReader.close();
			bufferedWriter.write(temp);
			bufferedWriter.close();
			
			return check;
		}
		
		
	//삭제 D
		public boolean delete(int ranking) throws IOException{
			BufferedReader bufferedReader = DBConnecter.getReader();
			BufferedWriter bufferedWriter = DBConnecter.getWriter();
			String line = null, temp = "";
			int deletedRanking = ranking;
			boolean check = false;
			
			while((line = bufferedReader.readLine()) != null) {
				if(Integer.valueOf(line.split("\t")[0]) == ranking) {
					check = true;
					continue;
				}
				temp += check ? deletedRanking-- +line.substring(line.indexOf("\t")) : line;
				temp += "\n";
			}
			bufferedReader.close();
			bufferedWriter.write(temp);
			bufferedWriter.close();
			
			return check;
		}
	//조회 R
		public ArrayList<BoxOfficeVO>select(String name) throws IOException{
			BufferedReader bufferedReader = DBConnecter.getReader();
			ArrayList<BoxOfficeVO> boxOfficeVOs = new ArrayList<BoxOfficeVO>();
			
			String line = null;
			int i = 0;
			
			while((line = bufferedReader.readLine())!=null) {
				String[] datas = line.split("\t");
				if(line.split("\t")[1].contains(name)) {
					BoxOfficeVO boxOfficeVO = new BoxOfficeVO();
					boxOfficeVO.setRanking(Integer.valueOf(datas[i++]));
					boxOfficeVO.setName(datas[i++]);
					boxOfficeVO.setReleaseDate(datas[i++]);
					boxOfficeVO.setIncome(Integer.valueOf(removeComma(datas[i++].equals("") ? "0" : datas[i++])));
					boxOfficeVO.setGuestCount(Integer.valueOf(removeComma(removeS(datas[i++]))));
					boxOfficeVO.setScreenCount(Integer.valueOf(removeComma(removeS(datas[i++]))));
					i = 0;
				}
			}
			return boxOfficeVOs;
		}
		
		
	//목록 R
	
	public String removeComma(String data) {
		return data.replaceAll(",", "");
	}
		
	public String removeS(String data) {
		return data.replaceAll("S", "");
	}
	
	
}
