package com.yedam.classes;

public class MethodMain {
	public static void main(String[] args) {
		
		MethodExe3 m3 = new MethodExe3();
		System.out.println(m3.gugudan(6, 10));
		m3.printStar(5,"★");
		m3.printCard();
	} //end of main()
	
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
	}
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
		Product[] list = m2.productList(search);
		for(int i = 0 ; i < list.length; i ++) {
			if (list[i] != null) {
				System.out.println(list[i].showList());
			}
		}
	}
} // end of MethodMain
