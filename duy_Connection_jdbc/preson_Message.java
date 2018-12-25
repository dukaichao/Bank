package duy_Connection_jdbc;

public class preson_Message {
	public String username;   //持卡人姓名
	public String IDCardNo;	  //身份证号
	public String iccid;	  //卡号
	public String password;	  //密码
	public String deposit;		  //余额
	public preson_Message(String username,String iDCardNo, String iccid,String password, String deposit) {
		super();
		this.username = username;
		this.IDCardNo = iDCardNo;
		this.iccid = iccid;
		this.password = password;
		this.deposit = deposit;
	}
	@Override
	public String toString() {
		return "[username=" + username + ", password=" + password + ", iccid=" + iccid + ", IDCardNo="
				+ IDCardNo + ", deposit=" + deposit + "]";
	}
	
}
