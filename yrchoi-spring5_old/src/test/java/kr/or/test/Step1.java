package kr.or.test;
/**
 * 내부변수와 배열 사용에 대해서 실습 클래스
 * @author 최영락
 *
 */
public class Step1 {
	//전역변수(멤버변수)는 클래스 전체에 영향을 미치는 변수=클래스안에서 사용하는 변수
	//내부변수(필드변수)는 메서드내에서만, 영향을 미치는 변수=메서드(함수)안에서만 사용하는 변수
	//private String name; 전역변수 사용예, Step2클래스에서 사용예정.
	public static void main(String[] args) {
		// name, age, phoneNum 필드변수 사용
		String name; //문자열 이름 입력받는 변
		int age; //정수형 나이 입력받는 변수
		String phoneNum; //문자열 폰번호 입력 받는 변수
		//변수에 값을 입력(아래)
		name = "홍길동";
		age = 10; //자바스크립트 보다는 자료형 사용에 엄격합니다.
		phoneNum = "000-0000-0000"; //1문자 끝을 명시.
		pirntMember(name, age, phoneNum); //프린트멤버 함수 호출
		name = "성춘향";
		age = 18; //자바스크립트 보다는 자료형 사용에 엄격합니다.
		phoneNum = "111-1111-1111"; //1문자 끝을 명시.
		pirntMember(name, age, phoneNum); //프린트멤버 함수 호출
		name = "각시탈";
		age = 28; //자바스크립트 보다는 자료형 사용에 엄격합니다.
		phoneNum = "222-2222-2222"; //1문자 끝을 명시.
		pirntMember(name, age, phoneNum); //프린트멤버 함수 호출
		//배열을 이용해서 입력을 좀더 편리하게 변경합니다.
		String[] names = {"홍길동","성춘향","각시탈"};
		int[] ages = {10,18,28};
		String[] phoneNums = {"000-0000-0000","111-1111-1111","222-2222-2222"};
		printMember(names, ages, phoneNums);
		//메서드명이 같습니다. 단 로드된 파라미터가 다른 메서드를 호출 = 오버로드
		
	}

	private static void printMember(String[] names, int[] ages, String[] phoneNums) {
		// for 반복문으로 3개를 한번에 출력
		int dataLength = names.length;
		for(int i=0;i<dataLength;i++) {
			System.out.println("입력하신 회원의 이름은"+names[i]+"님, 나이는 "+ages[i]+", 폰번호는 "+phoneNums[i]);
		}
	}

	private static void pirntMember(String name, int age, String phoneNum) {
		//println 함수는 출력 후 줄바꿈 명령 실행 =print + new + line
		System.out.println("입력하신 회원의 이름은"+name+"님, 나이는 "+age+", 폰번호는 "+phoneNum);
		//println 함수는 출력 후 줄바꿈 명령 실행 =print + new + line
	}


		
	}


