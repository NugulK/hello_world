package com.yedam.inheritance;
/*
 * UnivFriend : Friend 상속.
 * 친구 2: 이름, 전화번호, 학교, 학과
 */
public class UnivFriend extends Friend { //상속받으려면 extends 부모클래스이름
	//필드.
	private String univName;
	private String major;
	//생성자.
	public UnivFriend() {
	}
	public UnivFriend(String name, String tel, String univName,String major) {
		super(name, tel); // super : 부모생성자를 가르킨다.
		this.univName = univName;
		this.major = major;
	}
	
	// 부모의 메소드를 -> 자식이 재정의. overriding.
	@Override // 언오테이션 특별한 기능부여 
	public String toString() {
		return super.toString() + ",학교는 " + univName + ", 학과는 " + major ;                         
	}
	
//	@Override 
//	public void  setName(String name {
//		// 부모클래스의 final 메소드는 overiding 안됨
//	}
	//getter setter
	public String getUnivName() {
		return univName;
	}
	public void setUnivName(String univName) {
		this.univName = univName;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
} // end of UnivFriend()
