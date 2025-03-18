package com.yedam.variable;
//public <-> private : 퍼블릭의 반대
public class Member { //public 은 다른클래스에서 접근이 가능하게 하겠습니다.
	// 클래스 : 필드(값을 저장)
private String name;
private	int  score;
	// 클래스 : 생성자(실체생성) 
	// 따로 정의하지 않으면 컴파일러가 기본생성자를 생성. 
	// 생성자 재정의(overloading).
	public Member() {
		
	}
	// setMember = Member()라는 기본생성자를 먼저 만들고 
	// setMember ()안에 값을 넣어주고 this.로 지정하고 채워주는방법.
	
	// 두개의 매개값을 가지는 Member 생성자
	// 생성하는 시점에 두개의 필드값을 채워주는 방법
	public Member(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	// Set 컬렉션의 중복된 값으로 지정.
	// name , score => hashCode + equals => 동일한값.
	@Override
	public int hashCode() {
		return score;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {			
			Member target = (Member) obj;
			return this.name.equals(target.name);
		
		}
		return false;
	}
	
	// 클래스 : 메소드(기능) = 반환값 메소드명 (매개값)
	public void showInfo() {   //void : 메소드를 실행한 경우에 반환댄 값이 없습니다.
		System.out.println("이름은 " + name + ", 점수는 " + score);
	}
	// 매개값을 가지는 메소드
	public void setMember(String name, int score) {
		this.name = name; //필드값을 가르칠때는this.를 붙여준다. name(매개값) 이라고하는 값을 채워주겠습니다.
		this.score = score;
	}
	//name
	public String getName(){ //name 이 반환대는 메소드 생성 
		return name; // 반환한다 : return 
	}
	public int getScore() {
		return score;
	}
	//score 필드의 값을 지정
	public void setScore(int score) { //어떤 타입으로 할지 해서 (int score)
		if(score < 0 || score > 100) {          //메소드 안에서 리턴문은 메소드가 종료된다. 반복문에 break;와 같은 역활
			System.out.println("적정값을 입력하세요.");
			return;
		}
		this.score  = score;
	}
	//name 필드의 값을 지정
	public void setName(String name) {
		this.name = name;
	}
	// toString 재정의.
	public String toString() {
		return "이름: " + name + ", 점수: " + score;
	}
}
