package soloing;
/*
 * class 
 * Student 클래스는 라이브러리 클래스이다.
 * Student 클래스에 main()메소드를 작성하여 라이브러리인 동시 실행클래스로 만들수도 있다.
 */
public class Student {
	//라이브러리로서의 코드 (필드, 생성자, 메소드)
	
	//실행하기 위한 코드
	public static void main(String[] args) {
		Student s1 = new Student();
		System.out.println("s1 변수가 Studnt 객체를 참조합니다.");
		
		Student s2 = new Student();
		System.out.println("s2 변수가 또 다른 Studnt 객체를 참조합니다.");
	}
	//클래스의 구성 멤버
	// 필드(filed) - 객체의 데이터가 저장되는곳
	// 생성자(Constructor) - 객체 생성시 초기화 역활 담당
	// 메소드(Method)객체의 동작에 해당하는 실행블록
}
