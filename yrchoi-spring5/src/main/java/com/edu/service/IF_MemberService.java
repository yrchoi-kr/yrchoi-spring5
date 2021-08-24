package com.edu.service;

import java.util.List;

import com.edu.vo.MemberVO;
import com.edu.vo.PageVO;

/**
 * 이 인터페이스는 DAO클래스를 접근하는 서비스 입니다.
 * 그러면, DAO와 똑같으나, 나중에 DAO 10개일때 -> 서비스는 5개로 처리가 가능하게 되는 경우가 있어서...
 * 스프링부트는 위 과정이 1개로 합쳐져 있어서 상대적으로 간단한 프로젝트에 부트를 사용. 
 *
 * @author 김일국
 *
 */
public interface IF_MemberService {
	public List<MemberVO> selectMember(PageVO pageVO) throws Exception;
	//이곳에 CRUD 메서드가 계속 추가됩니다.
	public int countMember(PageVO pageVO) throws Exception;
	public void insertMember(MemberVO memberVO) throws Exception;
	public void deleteMember(String user_id) throws Exception;
	public MemberVO readMember(String user_id) throws Exception;
	public void updateMember(MemberVO memberOne) throws Exception;
}
