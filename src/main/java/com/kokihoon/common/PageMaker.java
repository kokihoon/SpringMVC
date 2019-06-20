package main.java.com.kokihoon.common;

public class PageMaker {
    
    private Criteria cri;
    
    private int startPage;
    private int endPage;
    private boolean prev;
    private boolean next;
    
    private int displayPageCnt = 10;
    private int totalCount;
    
    public PageMaker(Criteria cri) {
    	this.cri = cri;
    }
    
    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        calcData();
    }
    
    private void calcData() {
    	int page = this.cri.getPage();
		int perPageNum = this.cri.getPerPageNum();
		
		//예: 현재 페이지가 13이면 13/10 = 1.3 올림-> 2 끝페이지는 2*10=20
		this.endPage = (int)(Math.ceil(page/(double)displayPageCnt)*displayPageCnt);
		
        //예: 현재 페이지가 13이면 20-10 +1 = 11 
		this.startPage = (this.endPage-displayPageCnt) + 1;
		
        //실제로 사용되는 페이지의 수
        //예: 전체 게시물 수가 88개이면 88/10=8.8 올림-> 9
		int tempEndPage = (int)(Math.ceil(totalCount / (double) perPageNum));
		
		//만약 계산된 끝 페이지 번호보다 실제 사용되는 페이지 수가 더 작으면 실제 사용될 페이지 번호만 보여줌
		if(this.endPage > tempEndPage) {
			this.endPage = tempEndPage;
		}
		
		this.prev = (startPage != 1); // startPage 1이 아니면 false
		this.next = (endPage * perPageNum < totalCount); //아직 더 보여질 페이지가 있으면 true 
    }
    
    public Criteria getCri() {
        return cri;
    }
    public void setCri(Criteria cri) {
        this.cri = cri;
    }
    
    public int getStartPage() {
        return startPage;
    }
    public void setStartPage(int startPage) {
        this.startPage = startPage;
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
    public int getDisplayPageCnt() {
        return displayPageCnt;
    }
    public void setDisplayPageCnt(int displayPageCnt) {
        this.displayPageCnt = displayPageCnt;
    }
 
}