package duy_Connection_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserMessage {
	//获取数据库的成员信息
	public static List<preson_Message> getMessage(){
		List<preson_Message> list =  new ArrayList<preson_Message>();;
		//3.ResultSet类，用来存放获取的结果集！！
		try {
			Connection con = Test.getConnection();
			Statement stat = con.createStatement();
			//要执行的SQL语句
			String sql = "select * from preson_message";
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String iccid = rs.getString("iccid");
				String IDCardNo = rs.getString("IDCardNo");
				String deposit = rs.getString("deposit");
				list.add(new preson_Message(username, IDCardNo, iccid,  password,  deposit));
			}
			rs.close();
			stat.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//添加用户
	public void write(preson_Message pm){
		try {
			Connection con = Test.getConnection();
			Statement stat = con.createStatement();
			String insert = "insert into preson_message values("+"'"+pm.username+"'"+","+"'"+pm.IDCardNo+"'"+","+"'"+pm.iccid+"'"+","+"'"+pm.password+"'"+","+"'"+pm.deposit+"'"+")";
			stat.executeUpdate(insert);
			stat.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	/*
     *   读取信息，将用户名信息返回（如果不存在返回null），和Check类配合使用  
     */
    public String[] read(String iccid) {
       List<preson_Message> list = getMessage();
       String []message = new String[3]; //姓名，身份证号，余额
       for(int i = 0;i<list.size();i++) {
    	   if(list.get(i).iccid.equals(iccid)) {
    		   message[0] = list.get(i).username;
    		   message[1] = list.get(i).IDCardNo;
    		   message[2] = list.get(i).deposit;
    		   System.out.println(message[1]);
    		   return message;
    	   }
       }
       return null;
    }
    
    /*在存款取款操作 时 更新金额
    * 
    */
   public String updatemoney(String iccid,int saving)  {
	   List<preson_Message> list = getMessage();
	   int i = 0;
	   for(;i<list.size();i++) {
    	   if(list.get(i).iccid.equals(iccid)) {
    		   int money = Integer.parseInt(list.get(i).deposit) + saving;
    		   try {
    			   Connection con = Test.getConnection();
    			   Statement stat = con.createStatement();
    			   if(money>=0) {
    				   list.get(i).deposit = money + "";
    				   String update = "update preson_message set deposit = "+"'"+list.get(i).deposit+"'"+" where iccid = "+"'"+list.get(i).iccid+"'";
    				   stat.executeUpdate(update);
    				   stat.close();
    				   con.close();
    				   return list.get(i).deposit;
    			   }
    		   } catch (SQLException e) {
    			   // TODO Auto-generated catch block
    			   e.printStackTrace();
    		   } catch (Exception e) {
    			   // TODO Auto-generated catch block
    			   e.printStackTrace();
    		   }
    		   break;
    	   }
       }
	   return "-1";
   }
    
  //更新密码
    public void updatepwd(String iccid,String pwd){
    	Scanner s = new Scanner(System.in);
    	List<preson_Message> list = getMessage();
    	for(int i = 0;i<list.size();i++) {
     	   if(list.get(i).iccid.equals(iccid)) {
     		  list.get(i).password = pwd;
     		  try {
   			   Connection con = Test.getConnection();
   			   Statement stat = con.createStatement();
   			   String update = "update preson_message set password = "+"'"+list.get(i).password+"'"+" where iccid = "+"'"+iccid+"'";
   			   stat.executeUpdate(update);
   			   stat.close();
   			   con.close();
	   		   } catch (SQLException e) {
	   			   // TODO Auto-generated catch block
	   			   e.printStackTrace();
	   		   } catch (Exception e) {
	   			   // TODO Auto-generated catch block
	   			   e.printStackTrace();
	   		   }
     	   }
        }
    }
}
