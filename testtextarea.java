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
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.*;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.util.Timer;
import java.io.IOException;


public class testtextarea {
	public static JPanel panel;
	public static JTextArea jTextArea;
	public static JScrollPane jScrollPane;
	public testtextarea(String filename){
	//public static void main(String[] args)throws InterruptedException {
		//JFrame frame = new JFrame("");
		panel = new JPanel();
		//Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize(); // ���o�ù��ؤo
		//frame.setSize(screenSize.width,screenSize.height);//�]�w������ܤj�p�P�ù��ؤo�ۦP
		//frame.setLayout(new BorderLayout());
		jTextArea = new JTextArea();
		int x=0;
		try{
			BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filename))));
			String line = null;
			//line = bf.readLine();
		
			while((line = bf.readLine()) != null){
				jTextArea.append(line+"\n");
				
				x++;
				//System.out.println(line);
				//System.out.println("�r"+x);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
			
			
			
					 
		
	
		jScrollPane = new JScrollPane(jTextArea);
		//jTextArea.setLineWrap(true);//�۰ʴ���
		Font textareaFont=new Font(jTextArea.getFont().getName(),jTextArea.getFont().getStyle(),20);  //�N�r��j�p�]��50
		jTextArea.setFont(textareaFont);
		jTextArea.setEditable(false);
		//panel.add(jScrollPane);
		//frame.add(jScrollPane);
		//frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//�NX�]�w�������Ҧ��{��
		//frame.setVisible(true);//��ܵ���
	}
	
	public JScrollPane CALLTEXTAREA(){
		return jScrollPane;
	}
}