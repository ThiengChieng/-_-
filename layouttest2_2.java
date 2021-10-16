import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.awt.Font; //��r��import
import java.io.*;//�}���ɮת�import

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.awt.Component; 
import javax.swing.border.EmptyBorder;
import java.util.*;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.util.ArrayList;









public class layouttest2_2{
	private static String imageArray[]={"image\\add.png","image\\del.png","image\\addall.png","image\\delall.png"};
	private static JPanel panel0=new JPanel();
	private static JPanel panel1=new JPanel();
	private static JPanel panel2=new JPanel();
	private static JPanel panel3=new JPanel();
	private static JPanel panel4=new JPanel();
	private static JPanel panel5=new JPanel();
	private static JButton button[] = new JButton[4];
	private static ArrayList<String> KEVIN = new ArrayList<String>();
	private static JList<String> addlist = new JList<String>();
	private static JList<String> list = new JList<String>();
	private static JScrollPane scrollPane = new JScrollPane(list);;
	private static JScrollPane scrollPane2 = new JScrollPane(addlist);;
	
	private static String FeatureArray[] ={"�ݶE�P��","�f�w�~��","�Z�O���ȶE�ഫ","��ڬݶE����","�������O�ഫ","�f�w�ʧO�ഫ","�e���O�_�}�������ഫ","��ƶE�ഫ"};
	public static ArrayList<Integer> addFeaturenum = new ArrayList<Integer>();
	public static ArrayList<Integer> defaFeaturenum = new ArrayList<Integer>();
	public static ArrayList<Integer> redfontfea = new ArrayList<Integer>();

	public layouttest2_2(String Path,int whichmethod,String cortana){//�ҿ��ɮ׸��|
		//UIManager.put("OptionPane.messageFont",new Font("�L�n������", Font.PLAIN, 20));
		
		//System.out.println(Path);
		if(whichmethod==0){
			CHi2exe chi2_exe= new CHi2exe();
		}else if(whichmethod==1){
			featureexe featurepic= new featureexe();
		}
		addFeaturenum.clear();
		redfontfea.clear();
		defaFeaturenum.clear();
		
		panel0.removeAll();
		panel1.removeAll();
		panel2.removeAll();
		panel3.removeAll();
		panel4.removeAll();
		panel5.removeAll();
		KEVIN.removeAll(KEVIN);
		

		
		DefaultListModel<String> defaultListModel = new DefaultListModel<String>();
		
		
		

		list.setModel(defaultListModel);
		
		list.setFont(new Font("�L�n������", Font.BOLD, 24));
		//list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		//list.setVisibleRowCount(0);
		
		//scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		//list.setPreferredSize(new Dimension(400, 200));
		//scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		   
		   
		DefaultListModel<String> addListModel = new DefaultListModel<String>();
		
		addlist.setModel(addListModel);
		//Font addlistFont=new Font(addlist.getFont().getName(),addlist.getFont().getStyle(),24);  //�N�r��j�p�]��50
		//addlist.setFont(addlistFont);
		addlist.setFont(new Font("�L�n������", Font.BOLD, 24));
		
		//scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		//scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		try{
			//BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(Path.replace(".csv", "_FT.txt"))));
			
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(Path)));
			String str = null;
			int strint;
			
			
			while((str = in.readLine()) != null){
				strint = Integer.parseInt(str.substring(0,1));
				addFeaturenum.add(strint);
				redfontfea.add(strint);
				
				
			}
			
			for(int i=0;i<=7;i++){
				if (!addFeaturenum.contains(i)){
					defaFeaturenum.add(i);
					//defaultListModel.addElement(FeatureArray[i]);
				}
			}
			

			//System.out.println("�o�O�ѤU��"+defaFeaturenum);
			//System.out.println("�o�O�{���諸"+addFeaturenum);
			//System.out.println("�]�����⪺"+redfontfea);
			

			
		}catch (IOException e){
			//System.out.println("�N�O�A��");
			System.out.println(e);

		}
		for(int i = 0 ;i<defaFeaturenum.size();i++){
			defaultListModel.addElement(FeatureArray[defaFeaturenum.get(i)]);
			
		}
		for(int i = 0 ;i<addFeaturenum.size();i++){
			
			addListModel.addElement(FeatureArray[addFeaturenum.get(i)]);
			
			
		}
		for(int i = 0 ;i<addFeaturenum.size();i++){
			if(addListModel.contains(FeatureArray[redfontfea.get(i)])){
				//addlist.setSelectedIndex(i);
				
				//int x = addlist.getSelectedIndex();
				//System.out.println("x"+x);
				//addlist.getSelectedIndex().setFont(list.getFont().deriveFont(Font.PLAIN));
				//addlist.getSelectedIndex().setForeground(Color.red);
				//int x= addlist.getModel().getElementAt(i);
				//System.out.println("x"+x);
				//addlist.setText(0,FeatureArray[redfontfea.get(i)]).setForeground(Color.red);
				//addlist.set(i,FeatureArray[redfontfea.get(i)]).setForeground(Color.red);
				//addListModel.set(i,FeatureArray[redfontfea.get(i)]).setForeground(Color.red);
				//addListModel.setElementAt(FeatureArray[redfontfea.get(i)], i);
				//list[pos].getItemNumber()
				//addlist.getItemNumber().setFont(addlist.getFont().getName(),addlist.getFont().getStyle(),24);
				//addlist.setForeground(Color.red);
			}
		}
		panel4.add(Box.createRigidArea(new Dimension(30, 85)));  
		for(int i=0;i<4;i++){
			
			button[i]=new JButton();
			button[i].setAlignmentX(Component.CENTER_ALIGNMENT); 
			button[i].setPreferredSize(new Dimension(100,100));
			ImageIcon image=new ImageIcon(imageArray[i]);
			button[i].setIcon(image);
			button[i].setBorderPainted(false);//BUTTON��u�]���z��
			button[i].setContentAreaFilled(false);//�NBUTTON�I���]���z����
			panel4.add(button[i]);
			panel4.add(Box.createRigidArea(new Dimension(30, 20)));  
			
		}
		
		
		button[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(addFeaturenum.contains(36)){
							
					addFeaturenum.remove(addFeaturenum.get(addFeaturenum.indexOf(36)));
							
				}
				if(defaFeaturenum.contains(36)){
							
					defaFeaturenum.remove(defaFeaturenum.get(defaFeaturenum.indexOf(36)));
							
				}
				if(!defaFeaturenum.isEmpty()&&defaFeaturenum.get(defaFeaturenum.size() - 1)>7){
					
					for(int i = 0 ;i<defaFeaturenum.size();i++){
						defaFeaturenum.set(i,defaFeaturenum.get(i)-37);
					}
					
				}
				if(!addFeaturenum.isEmpty()&&addFeaturenum.get(addFeaturenum.size() - 1)>7){
					
					for(int i = 0 ;i<addFeaturenum.size();i++){
						addFeaturenum.set(i,addFeaturenum.get(i)-37);
					}
					
				}
				addFeaturenum.add(defaFeaturenum.get(list.getSelectedIndex()));
				defaFeaturenum.remove(list.getSelectedIndex());
				
				Collections.sort(addFeaturenum);
				Collections.sort(defaFeaturenum);
				
				//System.out.println("�o�O�ѤU��"+defaFeaturenum);
			    //System.out.println("�o�O�{���諸"+addFeaturenum);
				addListModel.clear();
				defaultListModel.clear();
				for(int i = 0 ;i<defaFeaturenum.size();i++){
					
					defaultListModel.addElement(FeatureArray[defaFeaturenum.get(i)]);
				}
				for(int i = 0 ;i<addFeaturenum.size();i++){
					
					addListModel.addElement(FeatureArray[addFeaturenum.get(i)]);
				}
				
			}
		});
		   
		
		button[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(addFeaturenum.contains(36)){
							
					addFeaturenum.remove(addFeaturenum.get(addFeaturenum.indexOf(36)));
							
				}
				if(defaFeaturenum.contains(36)){
							
					defaFeaturenum.remove(defaFeaturenum.get(defaFeaturenum.indexOf(36)));
							
				}
				if(!defaFeaturenum.isEmpty()&&defaFeaturenum.get(defaFeaturenum.size() - 1)>7){
					
					for(int i = 0 ;i<defaFeaturenum.size();i++){
						defaFeaturenum.set(i,defaFeaturenum.get(i)-37);
					}
					
				}
				if(!addFeaturenum.isEmpty()&&addFeaturenum.get(addFeaturenum.size() - 1)>7){
					
					for(int i = 0 ;i<addFeaturenum.size();i++){
						addFeaturenum.set(i,addFeaturenum.get(i)-37);
					}
					
				}
				Collections.sort(addFeaturenum);
				Collections.sort(defaFeaturenum);
				
				defaFeaturenum.add(addFeaturenum.get(addlist.getSelectedIndex()));
				addFeaturenum.remove(addlist.getSelectedIndex());
				
				Collections.sort(addFeaturenum);
				Collections.sort(defaFeaturenum);
				//System.out.println("�o�O�ѤU��"+defaFeaturenum);
			    //System.out.println("�o�O�{���諸"+addFeaturenum);
				addListModel.clear();
				defaultListModel.clear();
				for(int i = 0 ;i<defaFeaturenum.size();i++){
					
					defaultListModel.addElement(FeatureArray[defaFeaturenum.get(i)]);
				}
				for(int i = 0 ;i<addFeaturenum.size();i++){
					
					addListModel.addElement(FeatureArray[addFeaturenum.get(i)]);
				}
			}
		});
		   
		
		button[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(addFeaturenum.contains(36)){
							
					addFeaturenum.remove(addFeaturenum.get(addFeaturenum.indexOf(36)));
							
				}
				if(defaFeaturenum.contains(36)){
							
					defaFeaturenum.remove(defaFeaturenum.get(defaFeaturenum.indexOf(36)));
							
				}
				if(!defaFeaturenum.isEmpty()&&defaFeaturenum.get(defaFeaturenum.size() - 1)>7){
					
					for(int i = 0 ;i<defaFeaturenum.size();i++){
						defaFeaturenum.set(i,defaFeaturenum.get(i)-37);
					}
					
				}
				if(!addFeaturenum.isEmpty()&&addFeaturenum.get(addFeaturenum.size() - 1)>7){
					
					for(int i = 0 ;i<addFeaturenum.size();i++){
						addFeaturenum.set(i,addFeaturenum.get(i)-37);
					}
					
				}
				Collections.sort(defaFeaturenum);
				Collections.sort(addFeaturenum);
				
				addFeaturenum.addAll(defaFeaturenum);
				defaFeaturenum.clear();
				
				Collections.sort(addFeaturenum);
				Collections.sort(defaFeaturenum);
				//System.out.println("�o�O�ѤU��"+defaFeaturenum);
			    //System.out.println("�o�O�{���諸"+addFeaturenum);
				addListModel.clear();
				defaultListModel.clear();
				for(int i = 0 ;i<defaFeaturenum.size();i++){
					
					defaultListModel.addElement(FeatureArray[defaFeaturenum.get(i)]);
				}
				for(int i = 0 ;i<addFeaturenum.size();i++){
					
					addListModel.addElement(FeatureArray[addFeaturenum.get(i)]);
				}
			}
		});
		   
		   
		
		button[3].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				if(addFeaturenum.contains(36)){
							
					addFeaturenum.remove(addFeaturenum.get(addFeaturenum.indexOf(36)));
							
				}
				if(defaFeaturenum.contains(36)){
							
					defaFeaturenum.remove(defaFeaturenum.get(defaFeaturenum.indexOf(36)));
							
				}
				if(!defaFeaturenum.isEmpty()&&defaFeaturenum.get(defaFeaturenum.size() - 1)>7){
					
					for(int i = 0 ;i<defaFeaturenum.size();i++){
						defaFeaturenum.set(i,defaFeaturenum.get(i)-37);
					
					}
				}
				if(!addFeaturenum.isEmpty()&&addFeaturenum.get(addFeaturenum.size() - 1)>7){
					
					for(int i = 0 ;i<addFeaturenum.size();i++){
						addFeaturenum.set(i,addFeaturenum.get(i)-37);
					}
					
				}
				
				Collections.sort(addFeaturenum);
				Collections.sort(defaFeaturenum);
				
				defaFeaturenum.addAll(addFeaturenum);
				addFeaturenum.clear();
				
				Collections.sort(addFeaturenum);
				Collections.sort(defaFeaturenum);
				//System.out.println("�o�O�ѤU��"+defaFeaturenum);
			    //System.out.println("�o�O�{���諸"+addFeaturenum);
				addListModel.clear();
				defaultListModel.clear();
				for(int i = 0 ;i<defaFeaturenum.size();i++){
					
					defaultListModel.addElement(FeatureArray[defaFeaturenum.get(i)]);
				}
				for(int i = 0 ;i<addFeaturenum.size();i++){
					
					addListModel.addElement(FeatureArray[addFeaturenum.get(i)]);
				}
			}
		});
		
		
		panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
		panel4.setBackground(new Color(100,100,100));
		
		//button.setAlignmentX(Component.CENTER_ALIGNMENT); 
		//button2.setAlignmentX(Component.CENTER_ALIGNMENT); 
		//button3.setAlignmentX(Component.CENTER_ALIGNMENT); 
		//button4.setAlignmentX(Component.CENTER_ALIGNMENT); 
		
		//panel4.add(Box.createRigidArea(new Dimension(60, 120)));  
		//panel4.add(button);
		//panel4.add(Box.createRigidArea(new Dimension(30, 30)));
		//panel4.add(button2);
		//panel4.add(Box.createRigidArea(new Dimension(30, 30)));
		//panel4.add(button3);
		//panel4.add(Box.createRigidArea(new Dimension(30, 30)));
		//panel4.add(button4);
		
		
		panel2.setBackground(new Color(100,100,100));
		panel2.setLayout(new BorderLayout());
		
		Font reruFont2 = new Font("�L�n������", Font.BOLD, 36);
        Color reruFontColor2 = Color.white;
        panel2.setBorder(new TitledBorder(new LineBorder(Color.ORANGE, 0,false),"�Կ�S�x�G", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, reruFont2, reruFontColor2));
  
		panel2.add(Box.createRigidArea(new Dimension(30, 30)), BorderLayout.NORTH);
		panel2.add(Box.createRigidArea(new Dimension(30, 30)), BorderLayout.EAST);		
		panel2.add(Box.createRigidArea(new Dimension(50, 30)), BorderLayout.WEST); 
		panel2.add(Box.createRigidArea(new Dimension(30, 30)), BorderLayout.SOUTH); 
		panel2.add(scrollPane, BorderLayout.CENTER);
		
		panel3.setBackground(new Color(100,100,100));
		panel3.setLayout(new BorderLayout());
		
		Font reruFont1 = new Font("�L�n������", Font.BOLD, 36);
        Color reruFontColor1 = Color.white;
        panel3.setBorder(new TitledBorder(new LineBorder(Color.ORANGE, 0,false),"�w��S�x�G", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, reruFont1, reruFontColor1));
		
		panel3.add(Box.createRigidArea(new Dimension(30, 30)), BorderLayout.NORTH);
		panel3.add(Box.createRigidArea(new Dimension(30, 30)), BorderLayout.WEST);
		panel3.add(Box.createRigidArea(new Dimension(30, 30)), BorderLayout.EAST);
		panel3.add(Box.createRigidArea(new Dimension(30, 30)), BorderLayout.SOUTH); 
		panel3.add(scrollPane2, BorderLayout.CENTER);
		

		panel0.setLayout(new BorderLayout());
		JTextArea jTextArea = new JTextArea();
		try{
			BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(new File(cortana))));
			String line = null;
			//line = bf.readLine();
		
			while((line = bf.readLine()) != null){
				jTextArea.append(line+"\n");
			
				//System.out.println("cortana�r"+line);
			
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
        //jTextArea.setLineWrap(true);//�۰ʴ���
		Font textareaFont=new Font(jTextArea.getFont().getName(),jTextArea.getFont().getStyle(),24);  //�N�r��j�p�]��50
		jTextArea.setFont(textareaFont);
		jTextArea.setEditable(false);
		jTextArea.setFont(new Font("�L�n������", Font.BOLD, 24));
		
		Font reruFont = new Font("�L�n������", Font.BOLD, 36);
        Color reruFontColor = Color.white;
		panel0.setBorder(new TitledBorder(new LineBorder(Color.ORANGE, 0,false),"���p�W�h���ɵ��G�G", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, reruFont, reruFontColor));
        //�N�h���r�ءA�[��u�ʱ��b���O��
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
		
		
		panel0.add(Box.createRigidArea(new Dimension(30, 30)), BorderLayout.NORTH);
		panel0.add(Box.createRigidArea(new Dimension(30, 30)), BorderLayout.EAST);
		panel0.add(Box.createRigidArea(new Dimension(30, 30)), BorderLayout.SOUTH);
		panel0.add(Box.createRigidArea(new Dimension(50, 30)), BorderLayout.WEST);
		panel0.add(jScrollPane, BorderLayout.CENTER);
		
		
		panel0.setBackground(new Color(100,100,100));		
		panel1.setLayout(new BorderLayout());
		panel1.setPreferredSize(new Dimension(800,800));
		panel2.setPreferredSize(new Dimension(800,800));
		panel3.setPreferredSize(new Dimension(800,800));
		panel1.add(panel2,BorderLayout.WEST);
		panel1.add(panel4,BorderLayout.CENTER);
		panel1.add(panel3,BorderLayout.EAST);
		
		panel0.setPreferredSize(new Dimension(400,400));
		panel5.setLayout(new BorderLayout());
		panel5.setBackground(new Color(100,100,100));
		panel5.add(Box.createRigidArea(new Dimension(15, 15)), BorderLayout.NORTH);
		
		panel5.add(panel0, BorderLayout.SOUTH);
		panel5.add(panel1, BorderLayout.CENTER);
		
		//frame.setLayout(new BorderLayout());
		//frame.add(panel5, BorderLayout.CENTER);
		
		
		   

		//frame.setVisible(true);
    }
    public JPanel CALLLISTPANEL(){
		
		return panel5;
	}
	
	public ArrayList CALLARRAYLIST(){
		//System.out.println(KEVIN);
		return KEVIN;
	}
	
	public ArrayList<Integer> CALLFEATURENUM(){
		
		return addFeaturenum;
	}
}

