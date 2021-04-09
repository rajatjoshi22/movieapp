package com.movieapp.model;
public class User{
private String loginId;
private String password;
private String  mobileNo;
public String getLoginId() {
	return loginId;
}
public void setLoginId(String loginId) {
	this.loginId = loginId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getMobileNo() {
	return mobileNo;
}
public void setMobileNo(String mobileNo) {
	this.mobileNo = mobileNo;
}
@Override
public String toString() {
	return "User [loginId=" + loginId + ", password=" + password + ", mobileNo=" + mobileNo + "]";
}
public User() {
	super();
}
public User(String loginId, String password, String mobileNo) {
	super();
	this.loginId = loginId;
	this.password = password;
	this.mobileNo = mobileNo;
}

}
