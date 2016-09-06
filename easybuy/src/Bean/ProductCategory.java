package Bean;

public class ProductCategory {
	private int pid;		// 商品ID
	private String pname;	// 商品名称
	private String pdesc;	// 商品描述
	private double pprice;	// 商品价格
	private int pstock;		// 商品库存
	private String pbrand;	// 品牌
	private int pcode;		// 条码号
	private int pcatId;		// 分类ID
	private String pfileName;	// 商品图片名称
	private int pspecPrice;		// 1-特价；2-不特价
	private int pspecBuy;		// 1-特卖；2-不特卖
	private int pcatName;		// 分类名称
	private int ppcatId;	// 父分类ID
	private int ppcatName;	// 父分类名称
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public double getPprice() {
		return pprice;
	}
	public void setPprice(double pprice) {
		this.pprice = pprice;
	}
	public int getPstock() {
		return pstock;
	}
	public void setPstock(int pstock) {
		this.pstock = pstock;
	}
	public String getPbrand() {
		return pbrand;
	}
	public void setPbrand(String pbrand) {
		this.pbrand = pbrand;
	}
	public int getPcode() {
		return pcode;
	}
	public void setPcode(int pcode) {
		this.pcode = pcode;
	}
	public int getPcatId() {
		return pcatId;
	}
	public void setPcatId(int pcatId) {
		this.pcatId = pcatId;
	}
	public String getPfileName() {
		return pfileName;
	}
	public void setPfileName(String pfileName) {
		this.pfileName = pfileName;
	}
	public int getPspecPrice() {
		return pspecPrice;
	}
	public void setPspecPrice(int pspecPrice) {
		this.pspecPrice = pspecPrice;
	}
	public int getPspecBuy() {
		return pspecBuy;
	}
	public void setPspecBuy(int pspecBuy) {
		this.pspecBuy = pspecBuy;
	}
	public int getPcatName() {
		return pcatName;
	}
	public void setPcatName(int pcatName) {
		this.pcatName = pcatName;
	}
	public int getPpcatId() {
		return ppcatId;
	}
	public void setPpcatId(int ppcatId) {
		this.ppcatId = ppcatId;
	}
	public int getPpcatName() {
		return ppcatName;
	}
	public void setPpcatName(int ppcatName) {
		this.ppcatName = ppcatName;
	}
}
