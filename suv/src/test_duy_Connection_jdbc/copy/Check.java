package test_duy_Connection_jdbc.copy;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
   	1. 在登录时， 验证账号密码是否正确 
	2. 在注册时 验证账号是否存在 
	3. 在挂失是 找回密码需要验证， 姓名，身份证号，和账户是否与注册时保持一致 
	4. 各种输入金额页面，判断金额是否合法 
	5. 登录时验证用户名和密码是否为中文 
	6. 注册时验证姓名是否为中文
*/
public class Check {
	// 在登录时， 验证账号密码是否正确
	 
    public boolean  check1(String iccid,String pwd){
    	//获取数据库信息
    	List<preson_Message> list = UserMessage.getMessage();
    	/*System.out.println(list.toString());*/
    	//遍历
    	for(int i = 0;i<list.size();i++) {
    		if(list.get(i).iccid.equals(iccid)&&list.get(i).password.equals(pwd)) {
    			return true;
    		}
    	}
    	return false;

    }
    
  //在注册时 验证账号是否存在
    public boolean  check2(String iccid){
    	//获取数据库信息
    	List<preson_Message> list = UserMessage.getMessage();
    	//遍历
    	for(int i = 0;i<list.size();i++) {
    		if(list.get(i).iccid.equals(iccid)) {
    			return true;
    		}
    	}
        
        return false;
    }
    
  //在挂失时 找回密码需要验证， 姓名，身份证号，和账户是否与注册时保持一致
    public String  check3(String username, String userid,String iccid){
    	//获取数据库信息
    	List<preson_Message> list = UserMessage.getMessage();
    	//遍历
    	for(int i = 0;i<list.size();i++) {
    		if(list.get(i).username.equals(username)&&list.get(i).IDCardNo.equals(userid)&&list.get(i).iccid.equals(iccid)) {
    			return list.get(i).password;
    		}
    	}
        return null;
    }
    
  //判断金额是否合法
    public boolean checkmoney(String money)
        {
            for(int i=0; i<money.length(); i++)
            {
                if (money.charAt(i)<'0'||money.charAt(i)>'9')
                    return false;
            }  
            return true;
        }
    //验证用户名和密码是否为中文
    public boolean checkcountname(String countname) 
    { 
	    Pattern p = Pattern.compile("[\u4e00-\u9fa5]"); 
	    Matcher m = p.matcher(countname); 
	    if (m.find()) { 
	    	return true; 
	    } 
	    	return false; 
	}
    
  //验证姓名是否为中文
    public boolean checkname(String name)
    {
        int n = 0;
        for(int i = 0; i < name.length(); i++) {
            n = (int)name.charAt(i);
            if(!(19968 <= n && n <40869)) {
                return false;
            }
        }
        return true;
    }
    
  //验证手机号是否合法
  	public boolean check_Phone(String str) {
  		return str.matches("1[345678]\\d{9}");
  	}


  	//验证身份证
  	public boolean check_IDcard(String str) {
  		return str.matches("[1-9]\\d{5}(19\\d{2}|20\\d{2})((0[1-9])|(10|11|12))(([0-2][1-9])|10|30|31)\\d{3}[0-9Xx]{1}");
  	} 
   
}
