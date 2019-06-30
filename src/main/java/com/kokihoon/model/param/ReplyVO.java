package main.java.com.kokihoon.model.param;

import java.util.Date;

public class ReplyVO {
	private Integer replyNo;
	private Integer articleNo;
	private String replyText;
	private String replyWriter;
	private Date regdate;
	private Date updateDate;

	
	
	public Integer getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(Integer replyNo) {
		this.replyNo = replyNo;
	}
	public Integer getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(Integer articleNo) {
		this.articleNo = articleNo;
	}
	public String getReplyText() {
		return replyText;
	}
	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}
	public String getReplyWriter() {
		return replyWriter;
	}
	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	@Override
	public String toString() {
		return "ReplyVO [replyNo=" + replyNo + ", articleNo=" + articleNo + ", replyText=" + replyText + ", replyWriter=" + replyWriter
				+ ", regdate=" + regdate + ", updateDate=" + updateDate + "]";
	}
}