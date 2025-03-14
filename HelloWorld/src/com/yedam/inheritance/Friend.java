package com.yedam.inheritance;
/*
 * 친구1: 이름, 연락처.
 */
public class Friend extends Object{
	// 필드.
	private String name; //이름을 담을수있는 필드 
	private String tel; // 전화번호를 담을수있는 필드
	//생성자.
	public Friend() {}
	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	
	// tos 치고 ctrl + spacebar enter
	@Override
	public String toString() {
		return "이름은" + getName() + ", 연락처는 " + getTel();
	}
	
	//getter , setter.
	public String getName() {
		return name;
	}
	public final void setName(String name) { //final 이 붙으면 자식클래스에서 overiding 할수없다라는 뜻이다.
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
} //  end of Friend()
