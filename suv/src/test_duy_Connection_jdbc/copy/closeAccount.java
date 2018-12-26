package test_duy_Connection_jdbc.copy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class closeAccount extends JFrame implements ActionListener{
	JLabel jlb1, jlb2, jlb3,jlb4,jlb5,jlb6;  //标签
    JTextField jtf1,jtf2,jtf3,jtf4,jtf5;   //文本框
    JPasswordField jpf; //密码框
    JPanel jp1,jp2,jp3,jp4,jp5;     //面板
    JButton jb1,jb2;
    String countname;
    public closeAccount(String countname)  {
        this.countname = countname;
        //标签信息
    	jb1 = new JButton("确认");
    	jb2 = new JButton("取消");
    	
    	//设置按钮监听
    	jb1.addActionListener( this);
    	jb2.addActionListener( this);
    	
    	 //确定和重置按钮
        jb1.setBounds(60, 260, 62, 28);
        jb2.setBounds(160, 260, 62, 28);
    	
        jlb1 = new JLabel("        姓名");
        jlb2 = new JLabel("身份证号");
        jlb3 = new JLabel("		      账号");
        jlb4 = new JLabel("        余额");
        jlb5 = new JLabel("      手机号");
        jlb6 = new JLabel("账户信息如下");
        jlb6.setFont(new   java.awt.Font("Dialog",   1,   15));
        //文本框
        jtf1 = new JTextField(13);
        jtf2 = new JTextField(13);
        jtf3 = new JTextField(13);
        jtf4 = new JTextField(13);
        jtf5 = new JTextField(13);
        

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();

        jp1.add(jlb1);
        jp1.add(jtf1);
        jp2.add(jlb2);
        jp2.add(jtf2);
        jp3.add(jlb3);
        jp3.add(jtf3);
        jp4.add(jlb4);
        jp4.add(jtf4);
        jp5.add(jlb5);
        jp5.add(jtf5);
        
        jlb6.setBounds(65, 20, 300 ,50);
        jp1.setBounds(-10, 40, 300 ,50);   
        jp2.setBounds(-10, 90, 300 ,50);
        jp3.setBounds(-10, 130, 300 ,50);
        jp4.setBounds(-10, 180, 300 ,50);
        jp5.setBounds(-10, 230, 300 ,50);

        //将JPane加入JFrame中  
        this.add(jb1);
        this.add(jb2);
        this.add(jp1);  
        this.add(jp2);  
        this.add(jp3); 
        this.add(jp4); 
        this.add(jp5); 
        this.add(jlb6);
        
        this.setSize(300, 400);   //设置窗体大小
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)  
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口

        this.setVisible(true);  //设置可见
        this.setResizable(false);   //设置不可拉伸大小

        ArrayList<String> list = new UserMessage().read(countname);

        //将姓名的第一个字变为*
        list.set(0, "*"+list.get(0).substring(1,list.get(0).length()));
        //将身份证号第6到12位变成*
        list.set(1,list.get(1).substring(0,6)+"*******"+list.get(1).substring(13,list.get(1).length()));
        //将手机号中间四位变成*
        list.set(4,list.get(4).substring(0, 3)+"****"+list.get(4).substring(7, list.get(4).length()));
        
        jtf1.setText(list.get(0));   //将信息显示在文本框中
        jtf2.setText(list.get(1));
        jtf3.setText(list.get(2));
        jtf4.setText(list.get(3));
        jtf5.setText(list.get(4));
    }
    
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    	if(e.getActionCommand() == "确认") {
    		new UserMessage().logout(countname);
    		JOptionPane.showMessageDialog(null, "注销成功","温馨提示",JOptionPane.WARNING_MESSAGE);
    		dispose();
    	}else if(e.getActionCommand() == "取消") {
    		dispose();
    	}
    }
}
