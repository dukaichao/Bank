package test_duy_Connection_jdbc.copy;

public class preson_Message {
	public String username;   //持卡人姓名
	public String IDCardNo;	  //身份证号
	public String iccid;	  //卡号
	public String password;	  //密码
	public String deposit;		  //余额
	public String telephone;	//电话
	public preson_Message(String username, String IDCardNo, String iccid, String password, String deposit, String telephone) {
		super();
		this.username = username;
		this.IDCardNo = IDCardNo;
		this.iccid = iccid;
		this.password = password;
		this.deposit = deposit;
		this.telephone = telephone;
	}
	@Override
	public String toString() {
		return "[username=" + username + ", IDCardNo=" + IDCardNo + ", iccid=" + iccid + ", password="
				+ password + ", deposit=" + deposit + "telephone = "+telephone+"]";
	}
	
}
