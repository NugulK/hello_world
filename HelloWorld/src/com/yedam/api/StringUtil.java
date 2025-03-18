package com.yedam.api;

public class StringUtil {
	//1.성별
	static String getGender(String ssn) {
		int pos = -1;
		if (ssn.length() == 13) {
			pos = 6;
		}else if (ssn.length() == 14) {
			pos = 7;
		}
		char sex = ssn.charAt(pos);
		switch(sex){
			case '1':
			case '3':
				return"남자입니다.";
			case '2':
			case '4':
				return"여자입니다.";
			default:
				return "알수없음";
		}
	}
	//2.파일명
	static String getFileName(String files) {
		int num = 0;
		String fileName = "";
		while (true) {
			int idx = files.indexOf("/",num); // 찾을값 , 찾을 위치의 시작값.
			if(idx == -1) {
				fileName = files.substring(num, files.indexOf("."));
				break;
			}
			num = idx +1;
		}
		return fileName;
		
		//lastIndexOF 를 활용한 방법
//		static String getFileName2(String files) {
//			String fileName = "";
//			fileName = files.substring(files.lastIndexOf("/") +1,files.indexOf("."));
//			return filename;
//		}
		
//      내가 한것과 비교 해서 보기
//		for(int i = 0; i < files.length(); i++) {
//			num = files.indexOf(".");
//			if(files.indexOf(".") != -1) {
//				num = files.indexOf(".");
//			}
//		}
//		return files.substring(0,num);
	}
	//3.파일확장자
	static String getExtName(String files) {
		String Extname = "";
		Extname = files.substring(files.indexOf(".")+1);
		return Extname;
		
		// 내가 한것과 비교하기
//		int num = 0;
//		for(int i = 0; i < files.length(); i++) {
//			num = files.indexOf(".");
//			if(files.indexOf(".") != -1) {
//				num = files.indexOf(".");
//			}
//		}
//		return files.substring(num);
	}
}
