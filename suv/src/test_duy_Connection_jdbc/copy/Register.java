package test_duy_Connection_jdbc.copy;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
  此类完成对开户页面的编写， 用户需填写 姓名，身份证号， 账户，密码，开户金额信息
  并且会进行验证操作， 如姓名是否合法（中文）， 身份证号是否合法等等
 */
public class Register extends JFrame implements ActionListener{
	
	JButton jb1, jb2;  //按钮
	JLabel jlb1, jlb2, jlb3,jlb4,jlb5, jlb6, jlb7;  //标签
	JTextField jtf1,jtf2,jtf3,jtf4, jtf5, jtf6;   //文本框
	JPasswordField jpf; //密码框
	JPanel jp1,jp2,jp3, jp4,jp5,jp6,jp7,jp8;		//面板
	
	public Register() {
		// TODO Auto-generated constructor stub
		//按钮
		jb1 = new JButton("确定");
		jb2 = new JButton("重置");
		//设置按钮监听
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		//标签信息
		
		jlb1 = new JLabel("        姓名");
		jlb2 = new JLabel("身份证号");
		jlb3 = new JLabel("        账号");
		jlb4 = new JLabel("        密码");
		jlb7 = new JLabel("注册信息");
		jlb5 = new JLabel("开户金额");
		jlb6 = new JLabel("手机号");
		
		jlb7.setFont(new   java.awt.Font("Dialog",   1,   20));   //设置字体类型，加粗，大小为20
		//文本信息
		jtf1 = new JTextField(13);
		jtf2 = new JTextField(13);
		jtf3 = new JTextField(13);
		jtf4 = new JTextField(13);
		jtf5 = new JTextField(13);
		jtf6 = new JTextField(13);
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();
		jp6 = new JPanel();
		jp7 = new JPanel();
		jp8 = new JPanel();
		//将对应信息加入面板中
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
		
		jp6.add(jlb6);
		jp6.add(jtf6);
		
		jp7.add(jb1);
		jp7.add(jb2);
		
		jp8.add(jlb7);
		
		//将JPane加入JFrame中  
		this.add(jp8);  //先加入提示语
		
        this.add(jp1);  
        this.add(jp2);  
        this.add(jp3); 
        this.add(jp4);
        this.add(jp5);
        this.add(jp6);
        this.add(jp7);
        //设置布局
        this.setTitle("注册信息");
        this.setLayout(new GridLayout(8, 1));
        this.setSize(400, 400);   //设置窗体大小
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)  
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口
        
        this.setVisible(true);  //设置可见
        this.setResizable(false);	//设置不可拉伸大小
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand()=="确定")
		{
			register();
			
		}
		else if (e.getActionCommand()=="重置")
		{
			clear();
		}
		
	}
	
	
	//验证注册信息，并做处理
	public void register() 
	{
		//判断信息是否补全
		if (jtf1.getText().isEmpty()||jtf2.getText().isEmpty()||
				jtf3.getText().isEmpty()||jtf4.getText().isEmpty()||jtf5.getText().isEmpty()||jtf6.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "信息有空缺，请补全！","温馨提示",JOptionPane.WARNING_MESSAGE);
		}
		//判断身份证号是合法
		else if (!new Check().check_IDcard(jtf2.getText()))
		{
			JOptionPane.showMessageDialog(null, "非法身份证号，请重新输入！","温馨提示",JOptionPane.WARNING_MESSAGE);
		}
		//判断密码是否合法
		else if (jtf4.getText().length()<6)
		{
			JOptionPane.showMessageDialog(null, "密码为6位，请重新输入！","温馨提示",JOptionPane.WARNING_MESSAGE);
		}
		//判断金额是否合法
		else if (!new Check().checkmoney(jtf5.getText()))
		{  
			JOptionPane.showMessageDialog(null, "存入金额不合法!","温馨提示",JOptionPane.WARNING_MESSAGE);
		}
		//判断手机号是否合法
		else if (!new Check().check_Phone(jtf6.getText()))
		{
			JOptionPane.showMessageDialog(null, "非法手机号，请重新输入！","温馨提示",JOptionPane.WARNING_MESSAGE);
		}
		//判断姓名是否为全中文
		else if (!new Check().checkname(jtf1.getText()))
		{
			JOptionPane.showMessageDialog(null, "姓名不合法！","温馨提示",JOptionPane.WARNING_MESSAGE);
		}
		//判断账户名和密码是否包含中文
		else if (new Check().checkcountname(jtf3.getText())||new Check().checkcountname(jtf4.getText()))
		{
			JOptionPane.showMessageDialog(null, "用户名或密码存在中文，不合法!","温馨提示",JOptionPane.WARNING_MESSAGE);
		}
		//满足要求
		else if (!jtf1.getText().isEmpty()&&!jtf2.getText().isEmpty()&&
				!jtf3.getText().isEmpty()&&!jtf4.getText().isEmpty()&&!jtf5.getText().isEmpty()&&!jtf6.getText().isEmpty())
		{
			//注册成功， 打包为信息数组传递给UserMessage进行更新操作
			String []message = new String[6]; 
			//获取输入的文本信息
			message[0] = jtf1.getText();    //姓名
			message[1] = jtf2.getText();	//身份证号
			message[2] = jtf3.getText();	//账号
			message[3] = jtf4.getText();	//密码
			message[4] = jtf5.getText();	//存储金额
			message[5] = jtf6.getText();	//电话号码
			preson_Message pm = new preson_Message(message[0],message[1],message[2],message[3],message[4],message[5]);
			if (!new Check().check2(message[2]))   //调用Check的check方法检测用户是否存在， 如果不存在执行
			{
				new UserMessage().write(pm);   //调用UserMseeage的write方法进行写操作， 将信息格式化存入
				JOptionPane.showMessageDialog(null,"注册成功！","温馨提示",JOptionPane.WARNING_MESSAGE);
				dispose();  //使窗口消失
			}
			else 
			{
				JOptionPane.showMessageDialog(null,"账号已存在，请重新输入！","温馨提示",JOptionPane.WARNING_MESSAGE);
				//dispose();
			}
		}
	}
	
	//清空账号和密码框
	private void clear() {
		jtf1.setText("");    //设置为空
	    jtf2.setText("");  
	    jtf3.setText("");  
	    jtf4.setText("");  
	    jtf5.setText("");  
			
	}
	

}

