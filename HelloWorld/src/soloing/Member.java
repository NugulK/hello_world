package soloing;

public class Member {
	//필드 생성
		String name = "이름";
	    String id = "id";
	    String password = "패스워드";
	    int age = 0;
	
	public static void main(String[] args) {
		Member member = new Member();
		member.name = "최하얀";
		member.age = 23;
		System.out.println("이름은: " + member.name + " id : "+member.id + " 나이는:" + member.age); 
	}
}
