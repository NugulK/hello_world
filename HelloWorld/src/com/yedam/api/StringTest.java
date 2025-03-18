package com.yedam.api;

public class StringTest {
	public static void main(String[] args) {
		String[] ssn = {"0106241134156"
				,"9906032345678"
				,"030502-3456789"
				,"050311-4123456"};
		for (int i = 0;  i <ssn.length; i++) {
			String gender = StringUtil.getGender(ssn[i]);
			System.out.println(gender);
		}
	// 파일 정보를 반환(파일이름 /  파일확장자)
		String[] files = {"c:/temp/orange.jpg"//
				,"d:/storage/test/grape.jpeg"//
				,"d:/img/melon.png"//
		};
		for (int i = 0; i < files.length; i++) {
			System.out.println("파일이름은 " + StringUtil.getFileName(files[i]));
			System.out.println("파일의 확장자는" + StringUtil.getExtName(files[i]));
		}
			
	}//end of main.
}
