package com.yedam.bookApp;

import java.util.Scanner;

import com.yedam.variable.Member;

//BookMain :  main 메소드. 
/*
 * 등록 , 수정, 삭제 , 목록
 */
public class BookMain {
	// 싱글톤 방식
	// 2. 정적 필드선언. 값을 하나 할당.
	private static BookMain instance = new BookMain();	
	// 1. 생성자 private 선언
	private BookMain() {
	}
	// 3. getInstance() 제공.
	public static BookMain getInstance() {
		return instance;
	}
	// BookMain에 User[]을 선언해서 회원을 3명 등록하기.

	
	User[] userdata = new User[10];
	public  void ud () {
		userdata[0] = new User("aaa","aaa","aaa"); 
		userdata[1] = new User("bbb","bbb","bbb"); 
		userdata[2] = new User("ccc","ccc","ccc"); 
	}
	// BookMain에 login메소드를 선언하고 매개값으로 아이디와 비밀번호를 입력받도록 한다.
//	public static void login(String userId, String password) {
//		this.userId = userId;
//		
//	}
//	
	
	
	
	
	// 저장공간.
	 Book[] bookStore =  new Book[100];
	 Scanner scn = new Scanner(System.in); //사용자가 입력한 값을 읽어 들이기위해 스캐너 사용
	
	// 순번생성.(메소드)
	public  int getSequnceNo() {
		int max = 0; 
		for (int i = 0 ; i < bookStore.length; i++) {
			if(bookStore[i] != null && max < bookStore[i].getOrderNo()) {
				max = bookStore[i].getOrderNo();
				}
		}
		return max + 1; //현재 마지막 번호 +1
	}
	
	
 	//등록.
	// 1. 이미 존재하는 도서제목은 입력불가.
	
	public  void add() { // main 메소드가  static 메소드이기 때문에 사용하는 메소드들도 전부 static 메소드여야 한다.
		
		System.out.print("도서명입력>> ");
		String title = scn.nextLine();
		System.out.println("저자입력>>");
		String author = scn.nextLine();
		System.out.println("출판사입력>>");
		String company = scn.nextLine();
		System.out.println("금액입력>>");
		String price = scn.nextLine();
		Book book = new Book(title, author, company , Integer.parseInt(price) ,getSequnceNo());
//		System.out.println(book. ShowBookInfo());
		for (int i = 0; i < bookStore.length; i ++) {
			if(bookStore[i] == null) { // 스토리지가 비여잇는곳을 찾기위해
				bookStore[i] = book; //비어있으면 멤버값을 넣는다.
				System.out.println("등록되었습니다."); //등록되었을때 출력
				break; //for 반복문 종료
			}
			if(bookStore[i] != null && bookStore[i].getTitle().equals(title) != false) {
				System.out.println("이미 등록된 도서명입니다.");
				break;
			}
		}
	}// end of add().
	
	//수정 
	public  void edit() {
		boolean isExit = true;
		Book book = new Book();
		System.out.println("도서명을 입력>>");
		String title = scn.nextLine();
		if(title.isBlank()) {
		System.out.println("도서명을 반드시 입력.");
			return;
		}
		for(int i = 0; i < bookStore.length; i++) {
			if(bookStore[i] != null && bookStore[i].getTitle().equals(title)){
				System.out.println("수정할 값을 입력해주세요.");
				String price = scn.nextLine();
				book.setPrice(price);
				bookStore[i].setPrice(price);
				System.out.println("수정되었습니다.");	
				isExit =true;
			}else if(bookStore[i] != null && bookStore[i].getTitle().equals(title) == false) {
				isExit =false;
			}
		}
		if(isExit == false){
			System.out.println("이름이 목록에 존재하지 않습니다.");
		}
	} //end of edit()
	
	//삭제
	 public  void del() {
				System.out.print("삭제할 도서명을 입력>>");
				String title = scn.nextLine();
				boolean isExit = true;
				
				for(int i = 0; i < bookStore.length; i++) {
					if(bookStore[i] != null && bookStore[i].getTitle().equals(title)) {
						bookStore[i] = null;
						System.out.println("삭제되었습니다.");
						isExit = true;
						break;
					}else if (bookStore[i] != null && bookStore[i].getTitle().equals(title) != true) {
						 isExit = false;
					}
				}
				if(isExit == false){
					System.out.println("삭제하려는 이름이 목록에 존재하지 않습니다.");
				}
	 }// end of del()
	
	//목록  
	public  void list() {
		// 순번정렬.
		// 순번 > 순번2, 순번2(null)경우는 제외  순번1(null)인경우,
		Book temp = null;
		for (int j = 0;  j < bookStore.length - 1 ; j++) {
			for(int i = 0 ; i<bookStore.length -1 ; i++) {
				if(bookStore[i+1] == null) {
					continue;
				}
				if(bookStore[i] == null || bookStore[i].getOrderNo() > bookStore[i+1].getOrderNo()){
					temp  = bookStore[i];
					bookStore[i] = bookStore[i+1];
					bookStore[i + 1] =temp ;
				}
			}
		}
		//출력.
		int seqNo = 1;
		System.out.println("순번 제목      저자     가격");
		System.out.println("====================");
		Book[] list = searchList(null);
		for(Book bok : list) {
			if(bok != null) {  // null 값을 굳이 볼필요가없기때문에 if문을 사용해서 null값이 아닌것만 본다.
			System.out.println(seqNo++ +" " +bok.ShowList());
			}
		}
	} // end of list()
	public  Book[] searchList(String keyword) {
		Book[] list = new Book[100];
		int idx =0;
		for (int i = 0; i < bookStore.length; i++) {
			if (bookStore[i] != null) {
				if(keyword == null // 
				||bookStore[i].getCompany().equals(keyword)) {
					list[idx++] = bookStore[i];
				}				
			}
		}
		return list;
	}
	// 목록조회
	public  void listCompany() {
		System.out.println("조회할 출판사 정보>>");
		String company = scn.nextLine();
		int seqNo = 1;
		System.out.println("순번 제목      저자     가격");
		System.out.println("====================");
		for(int i = 0 ;  i < bookStore.length; i++) {
			if(bookStore[i] != null) {  // null 값을 굳이 볼필요가없기때문에 if문을 사용해서 null값이 아닌것만 본다.
				if(bookStore[i].getCompany().equals(company)) {
					System.out.println(seqNo++ +" " +bookStore[i].ShowList());					
				}
			}
	} // end of listCompany
		
//	System.out.println("저자입력>>");
//	author = scn.nextLine();
//	System.out.println("출판사입력>>");
//	company = scn.nextLine();
//	System.out.println("금액입력>>");
//	price = Integer.parseInt(scn.nextLine());
//	
	//조회 및 수정
//	boolean(isExist) = false;
//	for(int i = 0; i < bookStore.length; i++) {
//		if(bookStore[i] != null && bookStore[i].getTitle().equals(title)) {
//			//항목수정
//			if(!author.isBlank()) {
//				bookStore[i].setAuthor(author);
//			}
//			if(!company.isBlank()) {
//				bookStore[i].setAuthor(company);
//			}
//			if(!price.isBlank()) {
//				bookStore[i].setPirce(Integer.parseInt(price));
//			}
//		}	
//	}
	} // end of edit()
	// 상세 조회.
	public  void inquiry() {
		
		boolean isExit = false;
		System.out.println("도서제목을 입력해주세요");
		String title = scn.nextLine();
		for(int i = 0; i < bookStore.length; i++) {
			if(bookStore[i] != null && bookStore[i].getTitle().equals(title)) {
				System.out.println(bookStore[i].ShowBookInfo());
				isExit = true;
				break;
			}
		}
		if(isExit == false){
			System.out.println("없는 도서제목입니다.");
		}
	} // end of inquiry
	// 6.목록조회
//	public static void detailed() {
//		boolean isExit = false;
//		System.out.println("출판사 이름을 입력>>");
//		String company = scn.nextLine();
//		int seqNo = 1;
//		for(int i = 0; i < bookStore.length; i++) {
//			if(bookStore[i] != null && bookStore[i].getCompany().equals(company)) {
//				System.out.println(seqNo++ +" " + bookStore[i].ShowCompanyInfo());
//				isExit = true;
//			}
//		}if(isExit == false){
//			System.out.println("없는 출판사입니다.");
//		}
//	}
	
	public  void main(String[] args) {
		//저장공간.
		init();
		boolean run = true;
		while(run) {
			System.out.println("1.도서등록 2.수정 3.삭제 4.목록 5.상세조회 6.목록조회 9.종료");
			System.out.println("선택>>");
	
			int menu = Integer.parseInt(scn.nextLine());
			switch(menu) {
			case 1: //등록.
				add();
				break;
			case 2: //수정. 입력하는 값이 있으면 그 값만 바꾸도록 
				edit();
				break;
			case 3: //삭제. 도서명으로 검색 후 삭제.
				del();
				break;
			case 4: //목록.
				list();
				break;
			case 5: //상세조회
				inquiry();
				break;
			case 6: //목록조회 : 출판사이름을 넣으면 해당출판사 책들을 모두 출력
//				detailed();
				listCompany();
				break;
			case 9: //종료.
				run = false ;
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요");
				break;
			}
		}
		System.out.println("end of prog.");
 } // end of main()
	public  void init () { // main 에서 사용하기 위해서는 static 이여야 한다. 없으면 에러가 발생한다.
		bookStore[0] = new Book("혼자공부하는자바","신용권","한빛미디어" ,28000 ,1 ); 
		bookStore[1] = new Book("어린왕자","생택쥐베리","솔" ,15000 , 2); 
		bookStore[2] = new Book("인어공주","디즈니","디즈니" ,10000, 3); 
		bookStore[3] = new Book("백설공주","디즈니","디즈니" ,17000, 4); 
		bookStore[4] = new Book("라푼젤","디즈니","디즈니" ,14500, 5); 
		bookStore[5] = new Book("모아나","디즈니","디즈니" ,17700, 6); 
	}
	
} // end of BookMian()
