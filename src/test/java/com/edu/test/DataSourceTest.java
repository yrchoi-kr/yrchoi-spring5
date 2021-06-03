package com.edu.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 이클래스는 오라클과 연동해서 CRUD를 테스트하는 클래스 입니다.
 * 과장(이사,팀장) JUnit CURD까지 만들어서 일반사원에게 공개 + 회원관리
 * @author hcopp
 *
 */
//RunWith인터페이스 현재클래스가 Junit실행클래스라고 명시
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class DataSourceTest {
	//디버그용 로그 객체변수 생성
	private Logger logger = Logger.getLogger(DataSourceTest.class);
	//dataSource 객체는 데이터베이스 객체를 pool로 저장해서 사용할떄 DataSource 클래스를 사용(아래)
	//@Inject 는 스프링에서 객체를 만드는 방법, 이전 자바에서는new 키워드로 객체 만들었지만, inject로 객체를 만들면 메모리 관리를 스프링이 대신 해줌.
	//Inject 자바8부터 지원, 그럼, 이전 자바7에서 @Autowired 로 객체를 만들었음
	@Inject
	DataSource dataSource;
	
	@Test
	public void oldQueryTest() throws Exception {
		//스프링빈을 사용하지 않을때 예전 방식: 코딩테스트에서는 스프링 설정을 안쓰고, 직접 DB id/ pw입력
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","XE","apmsetup");
		
		logger.debug("데이터베이스 직접 접속이 성공 하였습니다. DB종류는"+ connection.getMetaData().getDatabaseProductName());
		
		connection = null; //메모리 초기화
	}
	@Test
	public void dbConnectionTest() {
		//데이터베이스 커넥션 테스트: 설정은 root-context의 빈(스프링클래스)을 이용
		try {
			Connection connection = dataSource.getConnection();
			logger.debug("데이터베이스 접속이 성공 하였습니다.DB종류는"+ connection.getMetaData().getDatabaseProductName());
		} catch (SQLException e) {
			logger.debug("데이터베이스 접속이 실패 하였습니다.");
			//e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void JunitTest() {
		logger.debug("Junit테스트 시작 입니다.");
	}
}
