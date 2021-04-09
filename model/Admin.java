package com.movieapp.model;

public class Admin {
private String loginId;
private String password;
@Override
public String toString() {
	return "Admin [loginId=" + loginId + ", password=" + password + "]";
}
public String getLoginId() {
	return loginId;
}
public void setLoginId(String loginId) {
	this.loginId = loginId;
}
public String getPassword() {
	return password;
}
public Admin()
{
	super();
}
public Admin(String loginId, String password) {
	super();
	this.loginId = loginId;
	this.password = password;
}
public void setPassword(String password) {
	this.password = password;
}
}
