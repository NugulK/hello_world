package com.yedam.inheritance;
/*
 * 상속.
 * 친구1: 이름, 연락처
 * 친구2: 이름, 연락처, 학교, 학과
 * 친구3: 이름, 연락처, 회사, 부서
 */
public class FriendExe {
	public static void main (String [] args) {
		Friend[] friends = new Friend[10]; //배열선언.
		
		//instance.
		Friend f1 = new Friend();
		f1.setName("홍길동");
		f1.setTel("010-1111-2222");
		System.out.println(f1.toString());
		
		
		UnivFriend f2 = new UnivFriend();
		f2.setName("김자식");
		f2.setTel("010-1111-1111");
		f2.setUnivName("우리학교");
		f2.setMajor("역사학과");
		System.out.println(f2.toString());
		
		CompanyFriend f3= new CompanyFriend("김영식" , "010-2323-2323", "아마존", "개발팀");
		System.out.println(f3.toString());
		
		// Friend[] => toString()
		friends[0] = f1;
		friends[1] = f2;
		friends[2] = f3;
		
		for(int i=0; i < friends.length; i++) {
			if(friends[i] != null) {
				System.out.println(friends[i].toString());
			}
		}
		
		// 부모 클래스의 변수에 자식인스턴스 대입
//		friends[0] = new UnivFriend(); //상속관계이면 담을수있다.
//		friends[1] = new CompanyFriend(); //상속관계이면 담을수있다.
		
		
		//형변환.
		int num = 20;
		double num2 = num; // 자동형변환 promotion
		num =(int)num2; // 강제 형변환 . casting
		
		Friend f4 = new CompanyFriend("김무열", "010-1111-1111" ,"자회사","인사팀"); //이미 자동형변환이 되었다. promotion
		CompanyFriend cf = (CompanyFriend)f4; //부모클래스의 변수를 자식클래스에 대입 강제형변환 : casting
		Friend f5 = new Friend("박성길","010-1111-2222");
		if(f5 instanceof CompanyFriend) { // 형변환 예외가 발생해서 오류가발생한다. 그것을 막기위해 조건문사용
			cf = (CompanyFriend)f5;
			System.out.println(cf.getCompany());
		} else {
			System.out.println("Casting 할 수 없습니다.");
		}
		
	} // end of main()
} // end of FriendExe()
