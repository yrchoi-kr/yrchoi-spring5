package com.edu.service;

import java.util.List;

import com.edu.vo.MemberVO;

/**
 * 이 인터페이스는 회원관리에 관련된 Srvice의 명세를 모아놓은 파일.
 * {구현내용} 없음.
 * @author 최영락
 *
 */
public interface IF_MemberService {
	public List<MemberVO> selectMember() throws Exception;
}
