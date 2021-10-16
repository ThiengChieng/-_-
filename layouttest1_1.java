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


public class layouttest1_1{
	private static JFrame frame;
	public static JPanel panel0=new JPanel();
	public static JPanel panel1=new JPanel();
	public static JPanel panel2=new JPanel();
	private static TestFileRadio6 fileradiob3;
	private static TestFileRadio5 fileradiob4;
	private static String foldername;
	//public static JPanel returnpanel=new JPanel();
	public static JScrollPane jScrollPane;
	public static JScrollPane jScrollPane2;
	//Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize(); // ���o�ù��ؤo
	public static int jud=0;
	public static int judfile=0;

	public layouttest1_1(int judfile){
		jud=0;
		panel0.removeAll();
		panel1.removeAll();
		panel2.removeAll();

		if(judfile<=3){
			jud=judfile;
			fileradiob3 = new TestFileRadio6(judfile);
			jScrollPane = new JScrollPane(fileradiob3.panel);
			jScrollPane2 = new JScrollPane(fileradiob3.panel2);
		}else{
			jud=judfile;
			judfile=judfile-4;
			
			fileradiob4 = new TestFileRadio5(judfile);
			jScrollPane = new JScrollPane(fileradiob4.panel);
			jScrollPane2 = new JScrollPane(fileradiob4.panel2);
		}
		
		

		System.out.println("TTTTTTTTTTTTTT");
		
		panel1.add(jScrollPane);
		panel2.add(jScrollPane2);
		panel1.revalidate();
		panel1.repaint();
		panel2.revalidate();
		panel2.repaint();

		panel1.setBackground(new Color(100,100,100));
		panel2.setBackground(new Color(110,110,110));
		//panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 20,20));
		//panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 20,20));
		//panel1.setPreferredSize(new Dimension(200,screenSize.height));
		panel0.setLayout(new BorderLayout());
	
		panel0.add(jScrollPane,BorderLayout.WEST);
		panel0.add(jScrollPane2,BorderLayout.CENTER);
		
		//returnpanel.setLayout(new BorderLayout());
		//returnpanel.add(panel0,BorderLayout.CENTER);
		
	}
	
	public JPanel CALLFILECH(){
		return panel0;
		
	}
	
	public String CALLFILPATH(){
		System.out.println("Success2");
		
		if(jud<=3){
			//jud=0;
			return fileradiob3.getRadioB();
		}else{
			//jud=0;
			return fileradiob4.getRadioB();
		}
		
	
		
	}
	public String CALLOnlyName(){
		System.out.println("Success3");
		if(jud<=3){
			jud=0;
			return fileradiob3.getOnlyName();
		}else{
			jud=0;
			return fileradiob4.getOnlyName();
		}
		
	
		
	}
	
	
	public String[] getfoldersize(){
		if(jud<=3){
			return fileradiob3.getfoldersize();
		}else{
			return fileradiob4.getfoldersize();
		}
	
	}

	public String[] getfilesize(){
		if(jud<=3){
			return fileradiob3.getfilesize();
		}else{
			return fileradiob4.getfilesize();
		}
	}

	public int IsClick(){
		if(jud<=3){
			System.out.println("�O�_�����U"+fileradiob3.click);
			return fileradiob3.click;
		}else{
			System.out.println("�O�_�����U"+fileradiob4.click);
			return fileradiob4.click;
		}
	}

}