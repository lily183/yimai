package Bean;

public class Easybuy_news {
	 // EN_ID          int primary key not null  auto_increment,--新闻ID
	  private int EN_ID;
	
	// EN_TITLE       VARCHAR(40) not null,--新闻标题
	  private String EN_TITLE;
	  
	 // EN_CONTENT     VARCHAR(1000) not null,--新闻内容
	  private String EN_CONTENT;
	  
	 // EN_CREATE_TIME DATEtime not null--新闻创建时间
	  private String EN_CREATE_TIME;
	  
	public int getEN_ID() {
		return EN_ID;
	}
	public void setEN_ID(int eNID) {
		EN_ID = eNID;
	}
	public String getEN_TITLE() {
		return EN_TITLE;
	}
	public void setEN_TITLE(String eNTITLE) {
		EN_TITLE = eNTITLE;
	}
	public String getEN_CONTENT() {
		return EN_CONTENT;
	}
	public void setEN_CONTENT(String eNCONTENT) {
		EN_CONTENT = eNCONTENT;
	}
	public String getEN_CREATE_TIME() {
		return EN_CREATE_TIME;
	}
	public void setEN_CREATE_TIME(String eNCREATETIME) {
		EN_CREATE_TIME = eNCREATETIME;
	}
}
