package com.yedam.bookApp;

/*
 * Book : 도서제목, 저자, 출판사, 가격
 */
public class Book { //하나의 변수에다가 여러가지 정보를 담을수 있는 데이터 타입
	//필드.
	private String title; //제목을 담을수 있는 
	private String author; // 저자
	private String company ; // 출판사
	private int price; // 가격
	private int orderNo; // 1,2,3 
	
	

	//생성자 . 하는역활 = 필드의 초기값을 초기화 시킨다.
	public Book() {} //매개값이 없는 생성자 = 기본생성자
	
	public Book(String title, String author, String company, int price) {
		this.title = title;
		this.author = author;
		this.company = company;
		this.price = price;
	}
	
	public Book(String title, String author, String company, int price, int orderNo) {
//		this.title = title;
//		this.author = author;
//		this.company = company;
//		this.price = price;
		this(title, author, company, price); //this : 생성된 인스턴스를 가르킨다. ctrl + 클릭해보면 알려준다.
		this.orderNo = orderNo;
	}

	//메소드 만드는 순서
	//public void set(이름)(타입종류 이름){ set= 입력받을때 사용
	// this.이름 = 이름;
	//}
	
	// public 타입종류 get(이름)(){  // 입력받은것을 출력할때 사용
	// return (이름);
	// }
	
	//private 을 쓰면 직접 값을 담을수 없기때문에  메소드를 사용한다
	//메소드.
	public String ShowList(){
		String show = title  + " " +  author + " " + price ; 
		return show;
	}
	public String ShowListWithNo(){
		String show = orderNo + " " + title  + " " +  author + " " + price ; 
		return show;
	}
	public String ShowBookInfo() {
		String msg = " 제목은 " + title + " 저자는 " + author + " 출판사는 " + company + " 가격은 " + price;
		return msg;
	}
	public  String ShowCompanyInfo() {
		String cop =" 출판사: " + company + " 제목: " + title + " 저자: "  + author + " 가격: " + price;
		return cop;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthor() {
		return author;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCompany() {
		return company;
	}
	public void setPrice(String price) {
		this.price = Integer.parseInt(price);
	}
	public int getPrice() {
		return price;
	}
	public void setBookInfo(String title, String author ,String company,int price) {
		this.title = title;
		this.author = author;
		this.company = company;
		this.price = price;
	}
	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
}
