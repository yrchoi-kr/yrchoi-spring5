package kr.or.test;

class MemberVO{
	//이 클래스는 회원 정보를 저장하는 자료 클래스 입니다.
	private String name;
	private int age;
	private String PhoneNum;
	//위 프라이빗 멤버변수를 입출력 구현 메서드를 만듭니다.
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNum() {
		return PhoneNum;
	}
	public void setPhoneNum(String PhoneNum) {
		this.PhoneNum = PhoneNum;
	}
	
}
public class Step2 {
	/**
	 * 
	 * @author 최영락
	 */
	public static void main(String[] args) {
		// MemberVO클래스 자료형(회원정보) 객체를 생성 합니다(아래)
		MemberVO memberVO = new MemberVO();
		memberVO.setName("홍길동");
		memberVO.setAge(10);
		memberVO.setPhoneNum("000-0000-0000");
		MemberVO memberVO2 = new MemberVO();
		memberVO2.setName("성춘향");
		memberVO2.setAge(18);
		memberVO2.setPhoneNum("111-1111-1111");
		MemberVO memberVO3 = new MemberVO();
		memberVO3.setName("각시탈");
		memberVO3.setAge(28);
		memberVO3.setPhoneNum("222-2222-2222");
		//MemberVO 클래스를 배열 객체 (String[]처럼)로 생성했음(아래)
		MemberVO[] members = new MemberVO[3];
		members[0] = memberVO;
		members[1] = memberVO2;
		members[2] = memberVO3;
		//출력도 메서드를 바로 호출하지 않고, 외부 클래스에서 객체로 만들어서 메서드를 호출합니다.
		MemberService memberService = new MemberService();
		memberService.printMember(members);
		memberService = null;
	}

}
class MemberService {

	public void printMember(MemberVO[] members) {
		// 멤버서비스클래스에서 프블릿 접근 제어로 회원 정보를 출력하는 메서드 생성
		// 향상된 for문을 생성
		for(MemberVO member:members) {
			System.out.println("회원의 이름은"+member.getName()+"나이는"+member.getAge()+"폰번호는"+member.getPhoneNum());
		
	}
	//회원을 출력하는 메서드를 생성합니다.
	
	
}
}