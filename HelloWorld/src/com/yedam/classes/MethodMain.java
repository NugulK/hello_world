package com.yedam.classes;

import java.util.List;
import java.util.Scanner;

public class MethodMain {
	
	public static void main(String[] args) {
		Scanner scn;
		officeApp();
		
		
	} //end of main()
	
	static void officeApp() {
		
		MethodExe2 m2 = new MethodExe2(); // 기능정의.
//		System.out.println(m2);
		Scanner scn = new Scanner(System.in);
		String pc = "";
		String pn = "";
		int price = 0;
		Product product = new Product();
		Product search = new Product();

		// 목록,추가,수정,삭제.....
		boolean run = true;
		while(run) {
			// 사용자입력 받아서 1.목록,2.추가,3.수정,4.삭제 9.종료 구현.
			// 입력메세지 정의 구현.
			System.out.println("1.목록 2.추가 3.수정 4.삭제 9.종료");
			System.out.println("선택>>");
			int menu = Integer.parseInt(scn.nextLine());
			switch(menu) {
			case 1: //목록.
				System.out.println("목록 입니다.");
				System.out.println("상품명 입력>>");
				pn = scn.nextLine();
				search.setProductName(pn);
				List<Product> list = m2.productList(search);
				for(int i = 0 ; i < list.size(); i ++) {
						System.out.println(list.get(i).showList());
				}
				break;
			case 2: //추가.
				System.out.println("추가할 품목의 상품코드,상품명 ,가격을 입력해주세요 ");
				System.out.println("상품코드입력>>");
				pc = scn.nextLine();
				System.out.println("상품명입력>>");
				pn = scn.nextLine();
				System.out.println("가격입력>>");
				price = Integer.parseInt(scn.nextLine());
				product = new Product(pc, pn ,price);
				
				if(m2.add(product)) {
					System.out.println("등록완료");
				}
				break;
			case 3: //수정.
				System.out.println("수정할 품목의 상품코드, 상품명, 가격을 입력해주세요 ");
				System.out.println("상품코드입력>>");
				pc = scn.nextLine();
				System.out.println("상품명입력>>");
				pn = scn.nextLine();
				System.out.println("가격입력>>");
				price = Integer.parseInt(scn.nextLine());
				product = new Product(pc, pn ,price);
				
				if(m2.modify(product)) {
					System.out.println("수정성공");
				}else
				break;
			case 4: //삭제.
				System.out.println("삭제할 품목의 상품코드, 상품명, 가격을 입력해주세요 ");
				System.out.println("상품코드입력>>");
				pc = scn.nextLine();
				
				if(m2.remove(pc)) {
					System.out.println("삭제완료");
				}
				break;
			case 9: //종료.
				run = false;
				break;
			default:
				System.out.println("메뉴를 다시 선택해주세요.");
				break;
			} // end of switch()			
		} // end of while()
		System.out.println("end of prog.");
	} // end of main()
	
	void method1() {
		MethodExe1 m1 = new MethodExe1(); //printString을 사용하기위해서 MetohdExe1을 호출한다.
		System.out.println(m1);
		// 메소드 호출. 하는부분에는 실제 값이 들어가야함 
		int n = 5;
		m1.printString(n , "★");
		
		double result = m1.sum(n,10.5);
		System.out.println(result);
		
		int sum = m1.sum(new int[] {10,20,30});
		System.out.println(sum);
		
		result = m1.sum(new double[]{10.5, 22.1, 34.5, 36.8});
		System.out.println(result);
	} // end of method1()
	
	void method2() {
		// 상품코드 : M001, 상품명: 만년필, 가격: 10000
		MethodExe2 m2 = new MethodExe2();
//		System.out.println(m2);
		
		// 등록하는 기능
		if(m2.add(new Product("M001", "만년필" , 10000))) {
			System.out.println("등록완료");
		}
		// 상품코드(중복값X 프라이머리키 역활), 상품명, 가격. modify(Product prod)
		// modify (String code, String name, int price )
		// 수정하는 기능
		Product prod = new Product("B001" , "변경값", 500);
		if(m2.modify(prod)) {
			System.out.println("수정성공");
		}
		// 삭제하는 기능
		if(m2.remove("B001")) {
			System.out.println("삭제완료");
		}
		
		// 목록보는 기능
		// 매개값의 따라 목록을 보여주는게 다른 기능으로 바꾸기
		Product search = new Product();
		search.setProductName("ALL"); // 상품코드 상품명 가격
		search.setPrice(400);
		
		//실행하는 메소드 
		List<Product> list = m2.productList(search);
		for(int i = 0 ; i < list.size(); i ++) {
				System.out.println(list.get(i).showList());
		}
	} // end of method2()
	
		void method3(){
		MethodExe3 m3 = new MethodExe3();  // 인스턴스
		System.out.println(MethodExe3.gugudan(6, 10)); //static 으로 선언을 해주면 인스턴스를 생성해주지않고 클래스이름.메소드를 사용한다.
		MethodExe3.printStar(5,"★"); //void 일때는 System.out.println이 먹지않기 떄문에 .print= 해서 사용한다.
//		m3.printCard();
	} // end of method3()
		
		void method4() {
//			MethodExe4 m4 = new MethodExe4();
			MethodExe4.main();		
		
	}// end of method4()
		
} // end of MethodMain
