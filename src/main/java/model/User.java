package main.java.model;

public class User {
	private String userId;
	private String userPw;
	private String userName;
	private int usrPoint;
	private boolean userCookie;
	
	
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
	public boolean isUserCookie() {
		return userCookie;
	}
	public void setUserCookie(boolean userCookie) {
		this.userCookie = userCookie;
	}
	
	
	
}
