package Bean;

public class comment {
	  //EC_ID          int primary key not null auto_increment,--留言ID
	   private int EC_ID;
	 // EC_TITLE       VARCHAR(200) not null,--留言标题
	   private String EC_TITLE;
	 // EC_CONTENT     VARCHAR(200) not null,--留言内容
	   private String EC_CONTENT;
	 // EC_CREATE_TIME DATETIME not null,--留言创建时间
	   private String EC_CREATE_TIME;
	//  EC_REPLY       VARCHAR(200),--回复内容
	   private String EC_REPLY;
	//  EC_REPLY_TIME  DATETIME,--回复时间
	   private String EC_REPLY_TIME;
	//  EC_NICK_NAME   VARCHAR(10) not null--留言人昵称
	   private String EC_NICK_NAME;
	   
	   
	 public int getEC_ID() {
		return EC_ID;
	}
	public void setEC_ID(int eCID) {
		EC_ID = eCID;
	}
	public String getEC_TITLE() {
		return EC_TITLE;
	}
	public void setEC_TITLE(String eCTITLE) {
		EC_TITLE = eCTITLE;
	}
	public String getEC_CONTENT() {
		return EC_CONTENT;
	}
	public void setEC_CONTENT(String eCCONTENT) {
		EC_CONTENT = eCCONTENT;
	}
	public String getEC_CREATE_TIME() {
		return EC_CREATE_TIME;
	}
	public void setEC_CREATE_TIME(String eCCREATETIME) {
		EC_CREATE_TIME = eCCREATETIME;
	}
	public String getEC_REPLY() {
		return EC_REPLY;
	}
	public void setEC_REPLY(String eCREPLY) {
		EC_REPLY = eCREPLY;
	}
	public String getEC_REPLY_TIME() {
		return EC_REPLY_TIME;
	}
	public void setEC_REPLY_TIME(String eCREPLYTIME) {
		EC_REPLY_TIME = eCREPLYTIME;
	}
	public String getEC_NICK_NAME() {
		return EC_NICK_NAME;
	}
	public void setEC_NICK_NAME(String eCNICKNAME) {
		EC_NICK_NAME = eCNICKNAME;
	}
	
}
