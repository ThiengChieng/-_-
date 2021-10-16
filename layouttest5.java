import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.awt.Font; //��r��import
import java.io.*;//�}���ɮת�import

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;

/*
PP-----��Ӫ�����Panel��(���tCardlayout)(int)
panel[]-----��Ӫ�����Panel���}�C(JPanel)
BB-----����B�J���s��(int)
button[]-----����B�J���s���}�C(JButton)
CP-----CardLayout Panel��(int)
Cpanel[]-----CardLayout Panel���}�C(CardLayout)
DP-----������CardLayout Panel��(int)
CDpanel[]-----������CardLayout Panel���}�C(CardLayout)
HintArray[]-----������T�����}�C(String)
CPArray[]-----CardLayout Panel�N�����}�C(String)
imageArray[]-----������s�Ϥ��ɮצ�m���}�C(String)
logo-----��|��LOGO(JLable)
cardlayout1-----����������CardLayout(CardLayout)
cardlayout2-----���ܰT��������CardLayout(CardLayout)
oporfile-----�}�ҭ�l��(File)
readtxt1-----�Nreadtxt_3�s�W�X������W��(readtxt_3)
tarea-----���JTable������(JTextArea)
frame-----�����W��(JFrame)

HiBuArray[]-----��������s�W�٤��}�C(String)


*/



public class layouttest5{
	private static JFrame frame;
	public static JPanel panel;
	private static layouttest3 layout,layout2,layout3,layout4;
	
	
	
	public static void main(String[] args){
		JFrame.setDefaultLookAndFeelDecorated(true);//�N�����]���[��
		
		/*Panel Layout �]�wSTART*/
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize(); // ���o�ù��ؤo
		JFrame frame = new JFrame("");//�~��̤j����
        frame.setSize(screenSize.width,screenSize.height);//�]�w������ܤj�p�P�ù��ؤo�ۦP
        frame.setLayout(new BorderLayout());//�N�����ƪ��]�w��BorderLayout
	
		panel=new JPanel();
		
		panel.setLayout(new FlowLayout());
		panel.setBackground(new Color(100,100,100));
		
		frame.add(panel,BorderLayout.CENTER);
		

		layout = new layouttest3("test");
		layout2 = new layouttest3("test2");
		layout3 = new layouttest3("test3");
		layout4 = new layouttest3("test4");
		
		
		//panel.add(layout.CALLPIC());//�Nreadtxt_3�Ҧ^�Ǥ�JScrollPane�[��Upanel[0]
		panel.add(layout2.CALLPIC());
		panel.add(layout3.CALLPIC());
		//panel.add(layout4.CALLPIC());
		
		
		
		
		
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//�NX�]�w�������Ҧ��{��
		frame.setVisible(true);//��ܵ���
    }
	
	
	
	/*implement START*/
	public static class buttonhandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}
	/*implement END*/
	
	
}