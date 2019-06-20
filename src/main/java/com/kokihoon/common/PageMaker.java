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
		
		//��: ���� �������� 13�̸� 13/10 = 1.3 �ø�-> 2 ���������� 2*10=20
		this.endPage = (int)(Math.ceil(page/(double)displayPageCnt)*displayPageCnt);
		
        //��: ���� �������� 13�̸� 20-10 +1 = 11 
		this.startPage = (this.endPage-displayPageCnt) + 1;
		
        //������ ���Ǵ� �������� ��
        //��: ��ü �Խù� ���� 88���̸� 88/10=8.8 �ø�-> 9
		int tempEndPage = (int)(Math.ceil(totalCount / (double) perPageNum));
		
		//���� ���� �� ������ ��ȣ���� ���� ���Ǵ� ������ ���� �� ������ ���� ���� ������ ��ȣ�� ������
		if(this.endPage > tempEndPage) {
			this.endPage = tempEndPage;
		}
		
		this.prev = (startPage != 1); // startPage 1�� �ƴϸ� false
		this.next = (endPage * perPageNum < totalCount); //���� �� ������ �������� ������ true 
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