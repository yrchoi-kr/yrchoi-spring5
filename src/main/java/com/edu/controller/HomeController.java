package com.edu.controller;


//외부 라이브러리(모듈)
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.slf4j.LoggerFactory;
/**
 * 이 클래스는 MVC웹프로젝트를 최초로 생성시 자동으로 생성되는 클래스
 * 웹브라우저의 요청사항을 view단(jsp)에 연결시켜주는 클래스 @Controller.
 * 스프링에서 관리하는 클래스를 스프링빈(콩) = 스프링 빈을 명시 하는 것이 @Controller 
 * Beans(콩들) 그래프로 이 프로젝트의 규모를 확인 가능.
 * 스프링이 관리하는 클래스는 파일아이콘에 S가 붙습니다.
 */
@Controller
public class HomeController {
	//스프링빈(클래스) 에서는 로거로 디버그를 합니다. .=로거객체를 만듭니다.
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * 사용자요청(웹브라우저)를 받아서=@RequestMapping인터페이스를 사용해서 메서드명을 스프링이 구현합니다.
	 * , router(루트)
	 * return 값으로 view(jsp)를 선택해서 작업한 결과를 변수에 담아서 화면에 전송 후 결과를 표시(렌더링) 합니다.
	 * 폼전송시 post(자료숨김), get(자료 노출-URL쿼리스트링?자료 전송시)
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homepage(Model model) {
		String jspVar = "@서비스(DB)에서 처리한 결과";
		model.addAttribute("jspObVar", jspVar);//home.jsp파일로 자료를 전송하는 기능model
		logger.info("디버그 스프링로고사용: "+ jspVar);//System.out 대신 logger 객체를 사용
		return "home/index";//확장자가 생략. jsp가 생략되어있음.
	}
}
