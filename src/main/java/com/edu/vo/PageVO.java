package com.edu.vo;
/**
 * 이 클래스는 공통(회원관리, 게시물관리)으로 사용하는 페이징처리 +검색기능의 클래스.
 * @author 최영락
 *
 */

public class PageVO {
	private int queryPerPageNum; //쿼리전용
	private Integer page; //jsp에서 발생 자바전용
	private int totalCount;
	private int startPage;
	private int perPageNum;//UI 하단에 보여줄 페이징 개수 계산
	private int endPage;//dnl perPageNum으로 구하는 UI 하단 페이지 번호
	private boolean prev;//UI하단 이전 페이지로 이동이 가능한지 판별하는 변수
	private boolean next;//UI하단 다음 페이지로 이동이 가능한지 판별하는 변수
	private String search_keyword;//jsp에서 받은 검색어 쿼리전용 변수
	private String search_type;//검색조건에 해당하는 쿼리 전용변수
	private int queryStartNo; //쿼리전용 변수
	
	
	
	@Override
	public String toString() {
		return "PageVO [queryPerPageNum=" + queryPerPageNum + ", page=" + page + ", totalCount=" + totalCount
				+ ", startPage=" + startPage + ", perPageNum=" + perPageNum + ", endPage=" + endPage + ", prev=" + prev
				+ ", next=" + next + ", search_keyword=" + search_keyword + ", search_type=" + search_type
				+ ", queryStartNo=" + queryStartNo + "]";
	}
	public int getQuerySrartNo() {
		//this.page-1하는 이유는 jsp에서 1,2,3...받지만,
		//쿼리에서는 0,1,2...으로 사용되기 때문
		queryStartNo = (this.page-1)*queryPerPageNum;
		return queryStartNo;
	}
	public void setQuerySrartNo(int querySrartNo) {
		this.queryStartNo = querySrartNo;
	}
	public int getQueryPerPageNum() {
		return queryPerPageNum;
	}
	public void setQueryPerPageNum(int quertPerPageNum) {
		this.queryPerPageNum = quertPerPageNum;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		//전체개수 값을 지정한 이후 계산식 실행
		calcPage();
	}
	private void calcPage() {
		// 이 메서드는 totalCount변수값을 기반으로 prev,next,startPage,endPage 등등을 구현하게 됩니다.
		int tempEnd = (int) Math.ceil(page/(double)this.perPageNum)*this.perPageNum;
		this.startPage = (tempEnd - this.perPageNum) + 1;
		if(tempEnd*this.queryPerPageNum > this.totalCount) {
			this.endPage = (int)Math.ceil((this.totalCount/(double)this.queryPerPageNum));
		} else {
			this.endPage = tempEnd;
		}
		
		this.prev = (this.startPage > 1);
		this.next = (this.endPage*this.queryPerPageNum) < this.totalCount;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public String getSearch_keyword() {
		return search_keyword;
	}
	public void setSearch_keyword(String search_keyword) {
		this.search_keyword = search_keyword;
	}
	public String getSearch_type() {
		return search_type;
	}
	public void setSearch_type(String search_type) {
		this.search_type = search_type;
	}
	
	
}
