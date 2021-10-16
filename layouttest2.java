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
import java.awt.Component; 

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



public class layouttest2{
	private static String imageArray[]={"D:\\notepad++\\JAVA_program\\image\\add.png","D:\\notepad++\\JAVA_program\\image\\del.png","D:\\notepad++\\JAVA_program\\image\\addall.png","D:\\notepad++\\JAVA_program\\image\\delall.png"};
	private static JPanel panel1=new JPanel();
	private static JPanel panel2=new JPanel();
	private static JPanel panel3=new JPanel();
	private static JPanel panel4=new JPanel();
	private static JButton button = new JButton();
	private static JButton button2 = new JButton();
	private static JButton button3 = new JButton();
	private static JButton button4 = new JButton();
	public layouttest2() {
       //JFrame frame = new JFrame("Test");
	   
	   
	   //Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize(); // ���o�ù��ؤo
	   //frame.setSize(screenSize.width,screenSize.height);//�]�w������ܤj�p�P�ù��ؤo�ۦP
       //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       DefaultListModel<String> defaultListModel = new DefaultListModel<String>();
       defaultListModel.addElement("1");
       defaultListModel.addElement("2");
       defaultListModel.addElement("Blo blo blo");

       final JList<String> list = new JList<String>();
       list.setPreferredSize(new Dimension(400, 200));
       list.setModel(defaultListModel);
	   
	   
	   DefaultListModel<String> addListModel = new DefaultListModel<String>();
	   final JList<String> addlist = new JList<String>();
	   addlist.setPreferredSize(new Dimension(400, 200));
       addlist.setModel(addListModel);

       
	   ImageIcon image=new ImageIcon(imageArray[0]);
	   button.setIcon(image);
       button.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
			   
               ((DefaultListModel<String>)addlist.getModel()).addElement(list.getSelectedValue().toString());
			   defaultListModel.remove(list.getSelectedIndex());
           }
       });
	   
	   ImageIcon image2=new ImageIcon(imageArray[1]);
	   button2.setIcon(image2);
	   button2.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
			   ((DefaultListModel<String>)list.getModel()).addElement(addlist.getSelectedValue().toString());
               addListModel.remove(addlist.getSelectedIndex());
			   
           }
       });
	   
	   ImageIcon image3=new ImageIcon(imageArray[2]);
	   button3.setIcon(image3);
	   button3.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
			   int defsize = list.getModel().getSize();
			   for(int i =0;i<defsize;i++){
				   ((DefaultListModel<String>)addlist.getModel()).addElement(list.getModel().getElementAt(i));
			   }
               defaultListModel.clear();
			   
           }
       });
	   
	   
	   ImageIcon image4=new ImageIcon(imageArray[3]);
	   button4.setIcon(image4);
	   button4.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
			   int addsize = addlist.getModel().getSize();
			   for(int i =0;i<addsize;i++){
				   ((DefaultListModel<String>)list.getModel()).addElement(addlist.getModel().getElementAt(i));
			   }
               addListModel.clear();
			   
           }
       });
	  
	   panel4.setLayout(new GridLayout(4,1));
	   panel4.setLayout( new BoxLayout(panel4, BoxLayout.Y_AXIS));
	  
	  
	   button.setAlignmentX(Component.CENTER_ALIGNMENT); 
	   button2.setAlignmentX(Component.CENTER_ALIGNMENT); 
	   button3.setAlignmentX(Component.CENTER_ALIGNMENT); 
	   button4.setAlignmentX(Component.CENTER_ALIGNMENT); 
	   
	   panel4.add(button);
	   panel4.add(button2);
	   panel4.add(button3);
	   panel4.add(button4);
	   
	   
	   panel2.setBackground(new Color(100+(10*1),100+(10*1),100+(10*1)));
	   panel3.setBackground(new Color(100+(10*2),100+(10*2),100+(10*2)));
	   panel4.setBackground(new Color(100+(10*3),100+(10*3),100+(10*3)));
	   
	   panel2.add(new JScrollPane(list), BorderLayout.CENTER);
	   panel3.add(new JScrollPane(addlist), BorderLayout.CENTER);
	   
	   panel1.setLayout(new GridLayout(1,3));
	   panel1.add(panel2);
	   panel1.add(panel4);
	   panel1.add(panel3);
       //frame.setLayout(new FlowLayout());
	   //frame.add(panel1, BorderLayout.CENTER);
	   //frame.add(button4, BorderLayout.SOUTH);
	   //frame.add(button3, BorderLayout.SOUTH);
       //frame.add(button2, BorderLayout.SOUTH);
       //frame.add(button, BorderLayout.SOUTH);
	   

       //frame.setVisible(true);
   }
   public JPanel CALLLISTPANEL(){
		return panel1;
	}
}