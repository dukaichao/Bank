package test_duy_Connection_jdbc.copy;

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
			Connection con = Connections.getConnection();
			Statement stat = con.createStatement();
			//要执行的SQL语句
			String sql = "select * from preson_message1";
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
				String username = rs.getString("username");
				String IDCardNo = rs.getString("IDCardNo");
				String iccid = rs.getString("iccid");
				String password = rs.getString("password");
				String deposit = rs.getString("deposit");
				String telephone = rs.getString("telephone");
				list.add(new preson_Message(username, IDCardNo, iccid,  password,  deposit, telephone));
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
			Connection con = Connections.getConnection();
			Statement stat = con.createStatement();
			String insert = "insert into preson_message1 values("+"'"+pm.username+"'"+
			","+"'"+pm.IDCardNo+"'"+","+"'"+pm.iccid+"'"+","+"'"+pm.password+"'"+","
					+"'"+pm.deposit+"'"+","+"'"+pm.telephone+"'"+")";
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
    public ArrayList<String> read(String iccid) {
       List<preson_Message> list = getMessage();
       ArrayList<String> l = new ArrayList<String>();
        //姓名，身份证号，账号余额，电话号码
       for(int i = 0;i<list.size();i++) {
    	   if(list.get(i).iccid.equals(iccid)) {
    		  l.add(list.get(i).username);
    		  l.add(list.get(i).IDCardNo);
    		  l.add(list.get(i).iccid);
    		  l.add(list.get(i).deposit);
    		  l.add(list.get(i).telephone);
    		  return l;
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
    			   Connection con = Connections.getConnection();
    			   Statement stat = con.createStatement();
    			   if(money>=0) {
    				   list.get(i).deposit = money + "";
    				   String update = "update preson_message1 set deposit = "+"'"+list.get(i).deposit+"'"+" where iccid = "+"'"+list.get(i).iccid+"'";
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
    
  //修改数据
	public void updatepwd(String iccid,String data,String s){
		List<preson_Message> list = getMessage();
		if(s.equals("密码")) {
			for(int i = 0;i<list.size();i++) {
				if(list.get(i).iccid.equals(iccid)) {
					list.get(i).password = data;
					try {
						Connection con = Connections.getConnection();
						Statement stat = con.createStatement();
						String update = "update preson_message1 set password = "+"'"+list.get(i).password+"'"+" where iccid = "+"'"+iccid+"'";
						stat.executeUpdate(update);
						stat.close();
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}else {
			for(int i = 0;i<list.size();i++) {
				if(list.get(i).iccid.equals(iccid)) {
					list.get(i).telephone = data;
					try {
						Connection con = Connections.getConnection();
						Statement stat = con.createStatement();
						String update = "update preson_message1 set telephone = "+"'"+list.get(i).telephone+"'"+" where iccid = "+"'"+iccid+"'";
						stat.executeUpdate(update);
						stat.close();
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
    }
    
    //注销账户
    public void logout(String iccid) {
    	List<preson_Message> list = getMessage();
    		for(int i = 0;i<list.size();i++) {
    			if(list.get(i).iccid.equals(iccid)) {
    				try {
    					Connection con = Connections.getConnection();
    					Statement stat = con.createStatement();
    					String delete = "delete from preson_message1 where iccid = "+"'"+iccid+"'";
    					stat.executeUpdate(delete);
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
