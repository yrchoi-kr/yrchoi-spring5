package com.edu.util;


import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.service.IF_MemberService;
import com.edu.vo.MemberVO;

/**
 * 이 클래스는 프로젝트에서 공통으로 사용하는 유틸리티기능을 모아놓은 클래스. 
 * @author 최영락
 * 콤포넌트@Component는 MVC가 아닌 기능들을 모아놓은 스프링빈 명시, 유틸 메서드 포함
 */
@Controller
public class CommonUtil {
	//멤버변수생성(아래)
	private Logger logger = LoggerFactory.getLogger(CommonUtil.class);
	@Inject
	private IF_MemberService memberService; //스프링빈을 주입받아서(DI) 객체준비
	//RestAPI 서버 맛보기 ID중복체크( @RestController 사용)
	@RequestMapping(value="/id_check", method=RequestMethod.GET)
	@ResponseBody //반환받는 값의 헤더값을 제외하고, 내용(body)만 반환하겠다는 명시
	public String id_check(@RequestParam("user_id")String user_id) throws Exception{
		//중복아이디를 체크로
		String memberCnt = "0";//중복id가 없을떄 기본값 0
		MemberVO memberVO = memberService.readMember(user_id);	
		logger.info("디버그: " + memberVO);//user_id를 공백을 전송해도 null이기 때문에 조건이 1개 필요
		if(memberVO != null) { //중복아이디가 존재하면 아래 {}실행
			memberCnt = "1";
		}
		if(user_id == "") {
			memberCnt = "2";
		}
		return memberCnt;//0.jsp 이렇게 작동하지 않습니다. 이유는 @ResponseBody때문		
	}
}
