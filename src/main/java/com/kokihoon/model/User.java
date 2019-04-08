package main.java.com.kokihoon.model;

import java.util.Date;

public class User {
	private String userId;
	private String userPw;
	private String userName;
	private String userEmail;
	private Date userJoinDate;
	private Date userLoginDate;
	private String userSignature;
	private String userImg;
	private int usrPoint;

	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUsrPoint() {
		return usrPoint;
	}
	public void setUsrPoint(int usrPoint) {
		this.usrPoint = usrPoint;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Date getUserJoinDate() {
		return userJoinDate;
	}
	public void setUserJoinDate(Date userJoinDate) {
		this.userJoinDate = userJoinDate;
	}
	public Date getUserLoginDate() {
		return userLoginDate;
	}
	public void setUserLoginDate(Date userLoginDate) {
		this.userLoginDate = userLoginDate;
	}
	public String getUserSignature() {
		return userSignature;
	}
	public void setUserSignature(String userSignature) {
		this.userSignature = userSignature;
	}
	public String getUserImg() {
		return userImg;
	}
	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	
}
