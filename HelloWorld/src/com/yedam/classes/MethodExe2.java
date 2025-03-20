package com.yedam.classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MethodExe2 {
	
	
	private List<Product> store; // 필드.
	
	//생성자
	MethodExe2(){ 
		init(); //초기화한다는 의미
		
	}
	
	void init1() {
		store = new ArrayList<Product>();  //new Product[10];
		try {
			Scanner scn = new Scanner(new FileInputStream("c:/temp/message.txt"));
			while(true) {
				String msg = scn.nextLine();
				String[] msgAry = msg.split(" ");
				store.add(new Product(msgAry[0], msgAry[1],Integer.parseInt(msgAry[2])));
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(NoSuchElementException e) {	
		}
		//초기화 작업의 끝.
	} // end of init1 ()
	
	void init() {
		try {
			FileInputStream fis = new FileInputStream("c:/temp/object.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
		    store = (List<Product>) ois.readObject(); //읽어드린 메소드를 객체로 변경시키는게 readObject()
		} catch (Exception e) {
//			e.printStackTrace();
		}
	} //end of init()
	
	void save() {
		try {
			FileOutputStream fos = new FileOutputStream("c:/temp/object.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(store); // ArrayList<Product>()
			oos.flush();
			oos.close();fos.close();
					
		} catch (IOException e) {
		e.printStackTrace();
		}
		
	} //end of save
	
	//종료시점에 store 컬렉션 갯수만큼 반복하고  정보를 message.txt에 저장.
	void save1() {
		try {
			Writer writer = new FileWriter("c:/temp/message.txt");
			for(Product prod : store) {
				String msg = prod.getProductCode() + " " + prod.getProductName() + " " + prod.getPrice();
				writer.write(msg + "\n"); // "공백"
				writer.flush();
//				writer.write(prod.getProductCode() + " ");
//				writer.write(prod.getProductName() + " ");
//				writer.write(prod.getPrice() + "\n");
//				writer.flush();
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // end of save()
	
	//메소드. (기능)
	boolean add(Product prd) { //staitc 이 되면 클래스이름.add로 실행가능하다.
		boolean result = store.add(prd);
		return result;
	} // end of add()
	
	// 상품이름, ALL 정의부분
	List<Product> productList (Product prd) {
    	List<Product> list = new ArrayList<Product>(); //	Product[] list = new Product[10];
    	for(int i = 0 ;  i < store.size(); i ++) {
    			if(prd.getProductName().equals("ALL") // 
    					|| store.get(i).getProductName().equals(prd.getProductName())) {
    				// 상품가격이 조건으로 추가됨.
    				if(prd.getPrice() >= 0 // 
    						&& store.get(i).getPrice() >= prd.getPrice()) {
    					list.add(store.get(i));    					    					
    				}    					    			
    			}
    	}
    	return list;
	} // end of productList()
    
    // 삭제 
    // 상품 코드로 
    boolean remove (String code) {
    	for(int i = 0 ; i < store.size() ; i ++) {
    		if(store.get(i).getProductCode().equals(code) == true) {
    			store.remove(i);
    			return true;
    		}
    	}
		return false;
    } // end of remove()
    
    //수정 
    boolean modify(Product prod) {
    	for(int i = 0; i < store.size();  i++) {
    		if(store.get(i).getProductCode().equals(prod.getProductCode()) == true) { // 배열에서 가지고 있는 상품코드 와 prod.가 가지고있는 상품코드를비교 
				//상품명수정.
    			if(prod.getProductName() != null) {
    				store.get(i).setProductName(prod.getProductName());
    			}
    			//상품가격수정
    			if(prod.getPrice() != 0) {
    				store.get(i).setPrice(prod.getPrice());
    			}
    			return true;
    		}
    	} 
    	return false;    
    }// end of modify()
}// end of MetohdExe2()
