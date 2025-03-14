package com.yedam.inheritance;
/*
 * CompanyFriend : Friend 상속
 * 친구3: 이름, 연락처, 회사, 부서
 */
public class CompanyFriend  extends Friend {
	//필드.
	private String company;
	private String dept;
	
	//생성자.
	public CompanyFriend () {
	}
	public CompanyFriend (String name, String tel, String company, String dept) { // source > 밑에서 3번째 누르면 생성가능
		super(name,tel);
		this.company = company;
		this.dept = dept;
	}
	// 부모의 메소드를 -> 자식이 재정의. overriding.
	@Override
	public String toString() {
		return super.toString() + ",회사는  " + company +", 부서는 " + dept ;
	}
	//getter , setter
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
}// end ofCompanyFriend()
