import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.awt.Font; 
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import java.awt.event.*;





public class layouttest7{
	private static JFrame frame;
	public static JPanel panel=new JPanel();
	private static JButton button0=new JButton();
	private static JButton button1=new JButton();
	private static JTextField jtextfield0=new JTextField();
	private static JTextField jtextfield1=new JTextField();
	private static JLabel label0=new JLabel("��l�ɮ׿���G");
	private static JLabel label1=new JLabel("�S�x��k����G",SwingConstants.RIGHT);
	private static JLabel label2=new JLabel("�ҫ�����G",SwingConstants.RIGHT);
	private static JLabel label3=new JLabel("�w���ɮ׿���G");
	private static ButtonGroup buttonGroup0 = new ButtonGroup();
	private static ButtonGroup buttonGroup1 = new ButtonGroup();
    private static JRadioButton radiobtn0 = new JRadioButton("�d������");
	private static JRadioButton radiobtn1 = new JRadioButton("��t�L�o");
	private static JRadioButton radiobtn2 = new JRadioButton("�H��l��Ƭ��D");
	private static JRadioButton radiobtn3 = new JRadioButton("�H���˪L");
	private static JRadioButton radiobtn4 = new JRadioButton("�l�s�ձ��ɲέp��k���R");
	private static GridBagConstraints c;
	private static File oporfile1,oporfile2;
	private RadioButtonListener radioButtonListener = new RadioButtonListener();
	public static String SRadioB="";
	public static String SRadioB2="";
	public static String ORIfile="";
	public static String PREfile="";
	
	

	public layouttest7(){
		//JFrame.setDefaultLookAndFeelDecorated(true);//�N�����]���[��
		//Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize(); // ���o�ù��ؤo
		//JFrame frame = new JFrame("");
        //frame.setSize(screenSize.width,screenSize.height);//�]�w������ܤj�p�P�ù��ؤo�ۦP
        //frame.setLayout(new BorderLayout());
		panel.setLayout(new GridBagLayout());
		panel.setBackground(new Color(100,100,100));
		label0.setBackground(new Color(100,100,100));
		label1.setBackground(new Color(100,100,100));
		label2.setBackground(new Color(100,100,100));
		label3.setBackground(new Color(100,100,100));
		radiobtn0.setBackground(new Color(100,100,100));
		radiobtn1.setBackground(new Color(100,100,100));
		radiobtn2.setBackground(new Color(100,100,100));
		radiobtn3.setBackground(new Color(100,100,100));
		radiobtn4.setBackground(new Color(100,100,100));
		
		buttonGroup0.add(radiobtn0);
		buttonGroup0.add(radiobtn1);
		buttonGroup0.add(radiobtn2);
		buttonGroup1.add(radiobtn3);
		buttonGroup1.add(radiobtn4);
		radiobtn0.setSelected(true);
		radiobtn3.setSelected(true);
		
		ImageIcon pic_btn0=new ImageIcon("image\\allinone_ori.png");
		button0.setIcon(pic_btn0);
		button0.setBorderPainted(false);//BUTTON��u�]���z��
		button0.setContentAreaFilled(false);//�NBUTTON�I���]���z����
		button0.setPreferredSize(new Dimension(120,120));
		button0.addActionListener(new buttonhandler());
		
		ImageIcon pic_btn1=new ImageIcon("image\\allinone_pre.png");
		button1.setIcon(pic_btn1);
		button1.setBorderPainted(false);//BUTTON��u�]���z��
		button1.setContentAreaFilled(false);//�NBUTTON�I���]���z����
		button1.setPreferredSize(new Dimension(120,120));
		button1.addActionListener(new buttonhandler());
		
		
		Font font = new Font("�L�n������", Font.PLAIN, 32);
		jtextfield0.setFont(font);
		jtextfield1.setFont(font);
		jtextfield0.setEditable(false);
		jtextfield1.setEditable(false);
		label0.setFont(font);
		label0.setForeground(Color.white);
		label1.setFont(font);
		label1.setForeground(Color.white);
		label2.setFont(font);
		label2.setForeground(Color.white);
		label3.setFont(font);
		label3.setForeground(Color.white);
		radiobtn0.setFont(font);
		radiobtn0.setForeground(Color.white);
		radiobtn0.setPreferredSize(new Dimension(300,120));
		radiobtn0.addActionListener(radioButtonListener);
		radiobtn1.setFont(font);
		radiobtn1.setForeground(Color.white);
		radiobtn1.setPreferredSize(new Dimension(400,120));
		radiobtn1.addActionListener(radioButtonListener);
		radiobtn2.setFont(font);
		radiobtn2.setForeground(Color.white);
		radiobtn2.setPreferredSize(new Dimension(400,120));
		radiobtn2.addActionListener(radioButtonListener);
		radiobtn3.setFont(font);
		radiobtn3.setForeground(Color.white);
		radiobtn3.setPreferredSize(new Dimension(300,120));
		radiobtn3.addActionListener(radioButtonListener);
		radiobtn4.setFont(font);
		radiobtn4.setForeground(Color.white);
		radiobtn4.setPreferredSize(new Dimension(400,120));
		radiobtn4.addActionListener(radioButtonListener);
		
		button0.setPreferredSize(new Dimension(190,88));
		button1.setPreferredSize(new Dimension(190,88));
		
		
		
        c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 10;
		c.fill = GridBagConstraints.BOTH;		
		panel.add(label0,c);
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1; 
		c.fill = GridBagConstraints.BOTH;
		panel.add(Box.createRigidArea(new Dimension(50, 45)),c);
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1; 
		c.fill = GridBagConstraints.BOTH;
		panel.add(button0,c);
		
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 4; 
		c.fill = GridBagConstraints.HORIZONTAL;
		panel.add(jtextfield0,c);
		
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 1; 
		c.fill = GridBagConstraints.BOTH;
		panel.add(label1,c);
		
		/*c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 6;
		c.gridwidth = 1; 
		c.fill = GridBagConstraints.BOTH;
		panel.add(Box.createRigidArea(new Dimension(50, 100)),c);*/
		
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 6;
		c.gridwidth = 1; 
		c.fill = GridBagConstraints.BOTH;
		panel.add(radiobtn0,c);
		
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 3;
		c.gridy = 6;
		c.gridwidth = 1; 
		c.fill = GridBagConstraints.BOTH;
		panel.add(radiobtn1,c);
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 4;
		c.gridy = 6;
		c.gridwidth = 1; 
		c.fill = GridBagConstraints.BOTH;
		panel.add(radiobtn2,c);
		
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 4;
		c.gridy = 6;
		c.gridwidth = 1; 
		c.fill = GridBagConstraints.BOTH;
		panel.add(Box.createRigidArea(new Dimension(700, 100)),c);
		
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 8;
		c.gridwidth = 1; 
		c.fill = GridBagConstraints.BOTH;
		panel.add(label2,c);
		
		
		/*c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 8;
		c.gridwidth = 1; 
		c.fill = GridBagConstraints.BOTH;
		panel.add(Box.createRigidArea(new Dimension(50, 100)),c);*/
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 8;
		c.gridwidth = 1; 
		c.fill = GridBagConstraints.BOTH;
		panel.add(radiobtn3,c);
		
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 3;
		c.gridy = 8;
		c.gridwidth = 1; 
		c.fill = GridBagConstraints.BOTH;
		panel.add(radiobtn4,c);
		
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 4;
		c.gridy = 8;
		c.gridwidth = 1; 
		c.fill = GridBagConstraints.BOTH;
		panel.add(Box.createRigidArea(new Dimension(700, 100)),c);
		
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 10;
		c.gridwidth = 5; 
		c.fill = GridBagConstraints.BOTH;
		panel.add(label3,c);
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 12;
		c.gridwidth = 1; 
		c.fill = GridBagConstraints.BOTH;
		panel.add(Box.createRigidArea(new Dimension(50, 45)),c);
		
		
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 14;
		c.gridwidth = 1; 
		c.fill = GridBagConstraints.BOTH;
		panel.add(button1,c);
		
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 14;
		c.gridwidth = 4; 
		c.fill = GridBagConstraints.HORIZONTAL;
		panel.add(jtextfield1,c);
        
		//frame.add(panel);
		//frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//�NX�]�w�������Ҧ��{��
		//frame.setVisible(true);//��ܵ���
		
	}
	public JPanel AllInOne(){
		return panel;
	}
	
	
	public static class buttonhandler implements ActionListener {
		public void actionPerformed(ActionEvent e){
			//Font.BOLD
			//UIManager.put("OptionPane.messageFont",new Font("�L�n������", Font.PLAIN, 20));
			//UIManager.put("OptionPane.buttonFont",new Font("�L�n������", Font.PLAIN, 16));
			
			if((JButton)e.getSource()==button0){
				
				JFileChooser chooser1=new JFileChooser(".");//����ɮסA�åB�w�]��m���{�b��m
				int returnVal = chooser1.showOpenDialog(panel);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					oporfile1 = chooser1.getSelectedFile();//���o�ϥΪ̩ҿ��ɮ�
					
					
					try {
					  BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(oporfile1)));
					  jtextfield0.setText("");
					  jtextfield0.setText(oporfile1.toString());
					  System.out.println(oporfile1.toString());//���աA�L�X�ɮ׸��|�r��
					  ORIfile=oporfile1.toString();
					} catch (Exception v) {
					  System.out.println("�ɮפ��s�b,���ˬd�ɮצW��.");
					  
					}	
				}else{
					System.out.println("Operation is CANCELLED :(");
				}
				
				System.out.println("STEP1---�����l��");//���աA�L�X"STEP1---�����l��"
			
			}else if((JButton)e.getSource()==button1){
					JFileChooser chooser2=new JFileChooser(".");//����ɮסA�åB�w�]��m���{�b��m
					int returnVal2 = chooser2.showOpenDialog(panel);
					if (returnVal2 == JFileChooser.APPROVE_OPTION){
						oporfile2 = chooser2.getSelectedFile();//���o�ϥΪ̩ҿ��ɮ�
						
					try {
					  BufferedReader input2 = new BufferedReader(new InputStreamReader(new FileInputStream(oporfile2)));
					  jtextfield1.setText("");
					  jtextfield1.setText(oporfile2.toString());
					  System.out.println(oporfile2.toString());//���աA�L�X�ɮ׸��|�r��
					  PREfile=oporfile2.toString();
					} catch (Exception v) {
					  System.out.println("�ɮפ��s�b,���ˬd�ɮצW��.");
					  
					}		
						
	
				}
			}
		}
	}
	
	
	
	public class RadioButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
            JRadioButton temp=(JRadioButton)arg0.getSource();
            if(temp.isSelected() && (temp==radiobtn0 || temp==radiobtn1||temp==radiobtn2)){
                //System.out.println(temp.getText());
				SRadioB=temp.getText();	
            }else if(temp.isSelected() && (temp==radiobtn3 || temp==radiobtn4)){
				SRadioB2=temp.getText();	
			}
        }
	}
	
	
	
	public String getRadioB(){
		return SRadioB;
	}
	
	public String getRadioB2(){
		return SRadioB2;
	}
	
	public String getORIFILE(){
		return ORIfile;
	}
	
	public String getPREFILE(){
		return PREfile;
	}
}