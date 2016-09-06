package Bean;

public class order {
private int EO_ID;//订单ID
private int EO_USER_ID;//用户ID
private String EO_USER_NAME;//用户名字
private String EO_USER_ADDRESS;//用户地址
private String EO_CREATE_TIME;//订单产生时间
private double EO_COST;//总价格
private int EO_STATUS;//订单状态
private int EO_TYPE;//付款类型
public int getEO_TYPE() {
	return EO_TYPE;
}
public void setEO_TYPE(int eOTYPE) {
	EO_TYPE = eOTYPE;
}
public int getEO_ID() {
	return EO_ID;
}
public void setEO_ID(int eOID) {
	EO_ID = eOID;
}
public int getEO_USER_ID() {
	return EO_USER_ID;
}
public void setEO_USER_ID(int eOUSERID) {
	EO_USER_ID = eOUSERID;
}
public String getEO_USER_NAME() {
	return EO_USER_NAME;
}
public void setEO_USER_NAME(String eOUSERNAME) {
	EO_USER_NAME = eOUSERNAME;
}
public String getEO_USER_ADDRESS() {
	return EO_USER_ADDRESS;
}
public void setEO_USER_ADDRESS(String eOUSERADDRESS) {
	EO_USER_ADDRESS = eOUSERADDRESS;
}
public String getEO_CREATE_TIME() {
	return EO_CREATE_TIME;
}
public void setEO_CREATE_TIME(String eOCREATETIME) {
	EO_CREATE_TIME = eOCREATETIME;
}
public double getEO_COST() {
	return EO_COST;
}
public void setEO_COST(double eOCOST) {
	EO_COST = eOCOST;
}
public int getEO_STATUS() {
	return EO_STATUS;
}
public void setEO_STATUS(int eOSTATUS) {
	EO_STATUS = eOSTATUS;
}


}
