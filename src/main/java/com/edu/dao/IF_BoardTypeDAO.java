package com.edu.dao;

import java.util.List;

import com.edu.vo.BoardTypeVO;

/**
 * 이 인터페이스는 게시판 생성관리 쿼리를 접근하기 위한 명세서(영수증- 상품명, 가격) 파일입니다.
 * @author 라건국
 * 20210616
 *
 */
public interface IF_BoardTypeDAO {
	//CRUD 메서드 명세만 생성(아래5개)
	public void deleteBoardType(String board_type) throws Exception;
	public void updateBoardType(BoardTypeVO boardTypeVO) throws Exception;
	public BoardTypeVO readBoardType(String board_type) throws Exception;
	public void insertBoardType(BoardTypeVO boardTypeVO) throws Exception;
	//BoardTypeVO 1개의 레코드를 저장한 클래스를 List<제네릭 타입>배열형 다중레코드로 받습니다.
	public List<BoardTypeVO> selectBoardType() throws Exception;
}
