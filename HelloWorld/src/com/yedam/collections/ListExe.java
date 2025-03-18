package com.yedam.collections;

import java.util.ArrayList;
import java.util.List;

import com.yedam.bookApp.Book;

public class ListExe {
	public static void main(String[] args) {
		// 배열을 활용해서 값을 추가할 경우 배열의 크기가 정해져있을경우 
		// 새로운배열을 추가해서 기존에값을 복사한 후 추가. 
		int[] intAry = {10,20};
		int[] intAry2 = new int [5];
		for(int i =0; i<intAry.length; i++) {
			intAry2[i] = intAry[i];
		}
//		intAry[2] = 30 ;
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(10); // 추가.
		list.add(14);
		list.add(17);
		list.add(20);
		
		Integer it1 = list.get(0); // 조회. index 값 기준
		
		list.remove(0); // 삭제 .index 값을 기준
		
		list.set(0, 30); //수정.
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// List - ArrayList
		List<String>list2 = new ArrayList<String>();
		list2.add("Hello");
//		list2.add(200);
//		list2.add(new Book());
		
		List<Book> list3 = new ArrayList<Book>();
		list3.add(new Book());
		
		
		for(int i=0; i < list2.size(); i++) {
			String result = (String) list2.get(i); //Object - > 캐스팅 Casting String, Integer, 
		}
		
		
	}
}
