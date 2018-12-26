package test_duy_Connection_jdbc.copy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class choiceModifyWindows extends JFrame implements ActionListener{
	JButton jb1, jb2;  //创建按钮
    JLabel jlb1;   //标签
    String countname;
    public choiceModifyWindows(String countname) 
    {
    	this.countname = countname;
        jb1 = new JButton("修改密码");
        jb2 = new JButton("修改电话");
        

        jlb1 = new JLabel("选择你想要修改");
        jlb1.setFont(new   java.awt.Font("Dialog",   1,   14)); //设置字体类型， 是否加粗，字号
        

        jb1.addActionListener(this);   //事件监听
        jb2.addActionListener(this);
        

        //设置按钮的位置和大小
        jb1.setBounds( 50,150,100,80);   
        jb2.setBounds( 150,150,100,80);
        
        //设置标签的位置和大小
        jlb1.setBounds(50,100,80,50);
        

        this.add(jb1);   //加入窗体
        this.add(jb2);
        this.add(jlb1);

        //设置布局
        this.setTitle("用户修改");
        this.setSize(300, 300);   //设置窗体大小
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)  
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口
        this.setVisible(true);  //设置可见
        this.setResizable(false);	//设置不可拉伸大小
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "修改密码") {
			new Modify(countname,"密码");
		}else if(e.getActionCommand() == "修改电话") {
			new Modify(countname,"电话");
		}
		
	}
}
