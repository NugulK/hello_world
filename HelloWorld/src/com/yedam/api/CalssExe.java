package com.yedam.api;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class CalssExe {
	public static void main(String[] args) {

		try {
			//클래스의 메서드 반환.
			Class cls = Class.forName("com.yedam.bookApp.Book"); //ClassNotFoundException
			
			
			
			Method[] methods = cls.getDeclaredMethods();
			for(int i= 0; i<methods.length; i++) {
//				System.out.println(methods[i].getName());				
			}
			
			Field[] fary = cls.getDeclaredFields();
			// 클래스의 필드 반환
			for(int i= 0; i<fary.length; i++) {
				System.out.println("i=" + i + "," + fary[i].getName());				
			}	
			
//			Constructor[] fcon = cls.getDeclaredConstructors();
//			// 클래스의 생성자 반환.
//			for(int i= 0; i<fcon.length; i++) {
//				System.out.println(fcon[i].getName());				
//			}
//			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
	}
}
