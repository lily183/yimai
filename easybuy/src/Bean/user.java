package Bean;

import java.io.Serializable;

public class user implements Serializable {
//	 EU_USER_ID       int primary key not null auto_increment,--用户ID
//	  EU_USER_NAME     VARCHAR(20) not null,--用户名
//	  EU_PASSWORD      VARCHAR(20) not null,--密码
//	  EU_SEX           VARCHAR(1) not null,--性别
//	  EU_BIRTHDAY      DATETIME,--生日
//	  EU_IDENTITY_CODE VARCHAR(60),--身份证号
//	  EU_EMAIL         VARCHAR(80),--email
//	  EU_MOBILE        VARCHAR(11),--电话
//	  EU_ADDRESS       VARCHAR(200),--地址
//	  EU_STATUS        int not null--用户权限状态，1普通用户  2管理员
//	
private	int id;
private	String usename;
private	String name;
private	String password;
private	String sex;
private	String birthday;
private	String identitycode;
private	String email;
private	String mobil;
private	String address;
private	int status;

public user() {
	super();
	// TODO Auto-generated constructor stub
}
public user(int id, String usename, String name, String password, String sex,
		String birthday, String identitycode, String email, String mobil,
		String address, int status) {
	super();
	this.id = id;
	this.usename = usename;
	this.name = name;
	this.password = password;
	this.sex = sex;
	this.birthday = birthday;
	this.identitycode = identitycode;
	this.email = email;
	this.mobil = mobil;
	this.address = address;
	this.status = status;
}

public String getUsename() {
	return usename;
}
public void setUsename(String usename) {
	this.usename = usename;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getBirthday() {
	return birthday;
}
public void setBirthday(String birthday) {
	this.birthday = birthday;
}
public String getIdentitycode() {
	return identitycode;
}
public void setIdentitycode(String identitycode) {
	this.identitycode = identitycode;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMobil() {
	return mobil;
}
public void setMobil(String mobil) {
	this.mobil = mobil;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}

	
}
