package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CharacterExe {
	public static void main(String[] args) {
		Scanner scn = null;
		try {
			scn = new Scanner(new FileInputStream("c:/temp/message.txt"));
			while(true) {
				String msg = scn.nextLine();
				String[] msgAry = msg.split(" "); // split 문자를 나눈다 () " " 공백을 기준으로  
				System.out.println("코드: " + msgAry[0] + " 상품명: " + msgAry[1] + " 가격: " + msgAry[2]);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(NoSuchElementException e) {
			
		}
		scn.close();
	System.out.println("end of frog.");
		
		
	} // end of main()
	static void read () {
		//입력스트림(문자)
		try {
			Reader reader = new FileReader("d:/Dev/git/hello_World/HelloWorld/src/com/yedam/io/StreamExe.java");
			while(true) {
				int data = reader.read();
				if(data == -1) { // 파일의 끝.
					break;
				}
				System.out.print((char) data);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // end of read ()
	static void write() {
		try {
			Writer writer = new FileWriter("c:/temp/data.txt");
			writer.write('a');
			writer.write('b');
			writer.write('c');
			
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // end of write()
	
	static void write2() {
		Scanner scn = new Scanner(System.in);
		// 입력값을 파일출력.
		try {
			Writer writer = new FileWriter("c:/temp/message.txt");
			while(true) {
				System.out.println("입력>> ");
				String msg = scn.nextLine();
				if(msg.equals("quit"))
					break;
				writer.write(msg + "\n"); // "공백"
				writer.flush();
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} // end of write2()
} // end ofCharacterExe()
