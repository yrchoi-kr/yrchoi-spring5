package com.edu.service;

import java.util.List;

import com.edu.vo.AttachVO;
import com.edu.vo.BoardVO;
import com.edu.vo.PageVO;

/**
 * 이 인터페이스는 DAO를 호출하는 서비스 입니다.
 * DAO클래스의 12개 메서드가 7개로 줄었습니다. 나머지 5개는 구현클래스에서 사용합니다.
 * @author 라건국
 *
 */
public interface IF_BoardService {
	//DAO클래스에 있는 CRUD 메서드 제외 -> 대신에 구현클래스에서 사용만 합니다.
	public List<AttachVO> readAttach(Integer bno) throws Exception;
	//게시물 상세보기시 조회수 올리는 메서드 메서드 제외 -> 대신 구현클래스에서 사용만합니다.
	//페이징 없는 검색된 (board_type포함된) 게시물 개수
	public int countBoard(PageVO pageVO) throws Exception;
	//기본 CRUD 아래
	public void deleteBoard(int bno) throws Exception;
	public void updateBoard(BoardVO boardVO) throws Exception;
	public BoardVO readBoard (int bno) throws Exception;
	public void insertBoard(BoardVO boardVO) throws Exception;
	public List<BoardVO> selectBoard(PageVO pageVO) throws Exception;
}
