package test_duy_Connection_jdbc.copy;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

//  此类时对用户信息查询的编写，  我们将查询出用户的姓名身份证号和余额
public class Inquiry extends JFrame implements ActionListener{

	List list;
    JLabel jlb1, jlb2, jlb3,jlb4;  //标签
    JTextField jtf1,jtf2,jtf3,jtf4;   //文本框
    JPasswordField jpf; //密码框
    JPanel jp1,jp2,jp3,jp4;     //面板
    public Inquiry(String countname)  {
        // TODO Auto-generated constructor stub
        //标签信息

        jlb1 = new JLabel("        姓名");
        jlb2 = new JLabel("身份证号");
        jlb3 = new JLabel("        余额");
        jlb4 = new JLabel("      手机号");

        jtf1 = new JTextField(13);
        jtf2 = new JTextField(13);
        jtf3 = new JTextField(13);
        jtf4 = new JTextField(13);

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();

        jp1.add(jlb1);
        jp1.add(jtf1);
        jp2.add(jlb2);
        jp2.add(jtf2);
        jp3.add(jlb3);
        jp3.add(jtf3);
        jp4.add(jlb4);
        jp4.add(jtf4);

        //设置布局
        this.setTitle("查询");
        this.setLayout(null);   //采用空布局

        jp1.setBounds(-10, 40, 300 ,50);   
        jp2.setBounds(-10, 90, 300 ,50);
        jp3.setBounds(-10, 130, 300 ,50);
        jp4.setBounds(-10, 180, 300 ,50);

        //将JPane加入JFrame中  
        this.add(jp1);  
        this.add(jp2);  
        this.add(jp3); 
        this.add(jp4); 

        this.setSize(300, 300);   //设置窗体大小
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
        
        //将信息显示在文本框中
        jtf1.setText(list.get(0));   
        jtf2.setText(list.get(1));
        jtf3.setText(list.get(3));
        jtf4.setText(list.get(4));



    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}
