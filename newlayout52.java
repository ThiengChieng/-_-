import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.awt.Font; //��r��import
import java.io.*;//�}���ɮת�import
//C:\Windows\Fonts\msjh.ttc
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
import javax.swing.UIManager; 
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.filechooser.FileNameExtensionFilter;


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
------------------------------------------------------------------
Sta_Flag-----�P�_�e�@����FLAG
Cho_Flag-----�P�_�������L���L�����l�ɤ�FLAG
Dacu_Flag-----�P�_�������L���L��Ƥ��Τ�FLAG
Watr_Flag-----�P�_�������L���L��ƲM�~�P�ഫ��FLAG

Fet_Flag-----�P�_�������L���L�S�x�����FLAG
Mod_Flag-----�P�_�������L���L�Ыؼҫ���FLAG
Eva_Flag-----�P�_�������L���L�w���̨Ψ�E�ɶ���FLAG
Com_Flag-----�P�_�������L���L�į�����FLAG

*/



public class newlayout52{
	/*�X��*/
	private static int Sta_Flag=0;
	private static int Cho_Flag=0;
	private static int Dacu_Flag=0;
	private static int Watr_Flag=0;
	private static int Fet_Flag=0;
	private static int FetSav_Flag=0;
	private static int Mod_Flag=0;
	private static int Eva_Flag=0;
	private static int Com_Flag=0;

	
	
	/*�ɮקP�_�W��*/
	private static String JUD_FILE[] = {"Cut","Wa_Ch","Feature","Model"};
	
	
	/*�����ܼ�*/
	private static int PP = 6;
	private static int BB = 8;
	private static int CP = 50;
	private static int DP = 50;
	private static String CPArray[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","45","47","48","49","50"};
	private static String UPArray[] = {"51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99","100"};
	private static String imageArray[] = {"image\\file.png","image\\scissor.png","image\\washchange.png","image\\feature.png","image\\model.png","image\\predict.png","image\\compare.png","image\\super.png"};
	private static String ClickbtArray[] = {"image\\file2.png","image\\scissor2.png","image\\washchange2.png","image\\feature2.png","image\\model2.png","image\\predict2.png","image\\compare2.png","image\\super2.png"};
	private static JLabel logo = new JLabel("");
	private static CardLayout cardlayout1 = new CardLayout();
	private static CardLayout cardlayout2 = new CardLayout();
	private static JPanel panel[]=new JPanel[PP];
	private static JPanel Cpanel[]=new JPanel[CP];
	private static JPanel Upanel[]=new JPanel[CP];
	private static JPanel CDpanel[]=new JPanel[DP];
	private static JPanel Dopanel[]=new JPanel[DP];
	private static JButton button[] = new JButton[BB];
	private static File oporfile1,oporfile2;
	private static JTextArea tarea;
	private static JFrame frame;
	private static String HintArray[] = {"�T�{�����Ы���Ƥ���","�T�{�ɮ׵L�~��A�Ы��U��ƲM�~�P�ഫ","�T�{�ɮ׵L�~��A�Ы��U��ƲM�~�P�ഫ","�T�{�����Ы��S�x���","�T�{�����Ы��S�x���","�T�{�����Ы��U�@�B","�T�{�S�x�L�~��A�Ы��x�s�S�x�ɮ�","�T�{�ɮ׵L�~��A�Ы��U��ƲM�~�P�ഫ","�T�{�����Ы��U�@�B","�U�@�B�Ы������̨Ψ�E�ɶ�","�U�@�B�Ы������̨Ψ�E�ɶ�","�U�@�B�Ы������̨Ψ�E�ɶ�","�T�{�����Ы���ܼҫ�","�T�{�����Ы��i�����","���t�ΩұĥΤ�k���Ω�Ӯ���|���į���","�T�{�����Ы��i��B�z","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
	private static String HintArray2[] = {"�T�{�ɮ׵L�~��A�Ы��U��ƲM�~�P�ഫ","�T�{�ɮ׵L�~��A�Ы��U��ƲM�~�P�ഫ","�T�{�����Ы��S�x���","�T�{�ɮ׵L�~��A�Ы��U��ƲM�~�P�ഫ","�T�{�����Ы��S�x���","�T�{�ɮ׵L�~��A�Ы��U��ƲM�~�P�ഫ","�T�{�ɮ׵L�~��A�Ы��U��ƲM�~�P�ഫ","�T�{�ɮ׵L�~��A�Ы��U��ƲM�~�P�ഫ","�T�{�ɮ׵L�~��A�Ы��U��ƲM�~�P�ഫ","�T�{�����Ы��S�x���","�T�{�ɮ׵L�~��A�Ы��U��ƲM�~�P�ഫ","�T�{�ɮ׵L�~��A�Ы��U��ƲM�~�P�ഫ","�T�{�����Ы��S�x���","�T�{�ɮ׵L�~��A�Ы��U��ƲM�~�P�ഫ","�T�{�ɮ׵L�~��A�Ы��U��ƲM�~�P�ഫ","�T�{�����Ы��U�@�B","�T�{�S�x�L�~��A�Ы��x�s�S�x�ɮ�","�T�{�ɮ׵L�~��A�Ы��U�Ыؼҫ��C","�T�{�ɮ׵L�~��A�Ы��U�Ыؼҫ��C","�T�{�ɮ׵L�~��A�Ы��U��ƲM�~�P�ഫ","�T�{�ɮ׵L�~��A�Ы��U�W�@�B","�U�@�B�Ы������̨Ψ�E�ɶ�","�T�{�����Ы���ܼҫ�","�T�{�����Ы��i�����","�T�{�����Ы��i�����","�T�{�����Ы��į���","�T�{�����Ы��į���","�T�{�����Ы��i�����","�T�{�����Ы��i�����","�T�{�����Ы��į���","�T�{�����Ы��į���","�T�{�����Ы��W�@�B","���t�ΩұĥΤ�k���Ω�Ӯ���|���į���","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
	private static int Hint_num=50;
	private static JLabel Hint_Label[]=new JLabel[Hint_num];
	private static JLabel Hint_Label2[]=new JLabel[Hint_num];
	private static String HiBuArray[] = {"image\\view.png","image\\view.png","image\\view.png","image\\chooseof.png","image\\chooseof.png","image\\view.png","image\\view.png","image\\next.png","image\\view.png","image\\save.png","image\\view.png","image\\view.png","image\\next.png","image\\view.png","image\\choosemo.png","image\\view.png","image\\comparepic.png","image\\allinone.png","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
	private static String D_HiBuArray[] = {"image\\Previous.png","image\\Previous.png","image\\chooseof.png","image\\viewof.png","image\\view.png","image\\view.png","image\\view.png","image\\Previous.png","image\\view.png","image\\Previous.png","image\\chooseof.png","image\\viewof.png","image\\view.png","image\\Previous.png","image\\chooseof.png","image\\view.png","image\\view.png","image\\Previous.png","image\\viewof.png","image\\next.png","image\\view.png","image\\save.png","image\\Previous.png","image\\Previous.png","image\\Previous.png","image\\Previous.png","image\\Previous.png","image\\choosemo.png","image\\view.png","image\\predicting.png","image\\Previous.png","image\\predicting.png","image\\view.png","image\\predicting.png","image\\Previous.png","image\\predicting.png","image\\Previous.png","","","","","","","","","","","","",""};
    private static JButton HiBuArraybutton[] = new JButton[DP];
	private static JButton D_HiBuArraybutton[] = new JButton[DP];
	private static String MesArray[]={"�|�������l�ɡA�Х������l�ɡC","�|�������l�ɡA�Х�����ɮץH�i��M�~�P�ഫ�C","�Х������l�ɶi����ΡC","�S�x�ɮ��x�s�����A�Ы��U�Ыؼҫ��C","�Х��i���ƲM�~�P���ΡC","�Х������l�ɶi����ΡC","�ҫ��Ыا����I","�Х��i��S�x���","�Х��i���ƲM�~�P�ഫ","�Х���ܭ�l�ɶi�����","�Х��i��Ыؼҫ�","�Х��i��S�x���","�Х��i���ƲM�~�P�ഫ","�Х������l�ɶi����ΡC","��������","��������","��������","��������","�|��������ҫ����G"};
	private static String ProMesArray[]={"��Ƥ��ζi�椤\n�еy��...","��ƲM�~�P�ഫ�i�椤\n�еy��...","���b�M��S�x\n�еy��...","�Ыؼҫ��i�椤\n�еy��...","���ն���ƥ��b�i����ΡB�M�~�P�ഫ��\n�еy��...","���bø�s�����\n�еy��...","�����{�Ƕi�椤\n�еy��...","�}�ɵ{�Ƕi�椤�еy��..."};
	private static String ProEndMesArray[]={"��Ƥ��ζi�槹��","��ƲM�~�P�ഫ�i�槹��","�Ыؼҫ��i�槹��","���βM�~�ഫ�i�槹��","�S�x�M��i�槹��","�����ø�s�i�槹��"};
	private static Font softfont[]=new Font[5];
	private static String OriFileName[] = {"�ݶE���","�ݶE��O","�ݶE�E��","�f����","��v�d��","��E�@�z�v�d��","�f�w�ʧO","�f�w�X�ͤ��","�������O","��ƶE","�����Ǹ�","�Z�O���ȶE","�e���O�_�}������","�E�_�X1","�E�_�X2","�E�_�X3","�E�_�X4","�E�_�X5","�E�_�X6","�E�_�X7","�E�_�X8","�E�_�X9","�E�_�X10","�ۧU���촡�d�ɶ�","��v���d�ɶ�","��v����ɶ�1","��v����ɶ�2","��v����ɶ�3","��v����ɶ�4","��v����ɶ�5","��v����ɶ�6","��v����ɶ�7","��v����ɶ�8","��v����ɶ�9","�w���ݶE�ɶ�"};
	
	/*�~���{���ŧi*/
	private static readtxt_3 readtxt1,readtxt2,readtxt3,readtxt4,readtxt5,readtxt6,readtxt7,readtxt8,readtxt9,readtxt10,readtxt11,readtxt12,readtxt13,readtxt14,readtxt15,readtxt16,readtxt18,readtxt19,readtxt20,readtxt21,readtxt22,readtxt23; 
	private static layouttest1 FileCH;
	private static layouttest1_1 FileCH2;
	private static String NOWChFile="";
	private static layouttest2_2 listpanel;
	private static FeatureSave featuresave;
	private static FeatureSave2 featuresave2;
	private static layouttest6_6_2 piclayout,piclayout2;
	private static String data_cuwachfe_path;
	private static int opt1;
	private static Cortana cortana;
	private static Cortana2 cortana2;
	private static testtextarea fetxarea;
	private static int isclick=0;
	private static layouttest9 allinone = new layouttest9();
	
	public static void main(String[] args)throws InterruptedException {
		
		
		/*�P�_��Ƨ��O�_�s�b(Sta_Flag) START*/
		for(int i=3;i>=0;i--){
			File jud_file =new File("Hos_Data/Doc_Train/"+JUD_FILE[i]); 
			if  (!jud_file .exists()){       
				System.out.println(jud_file.toString()+"���s�b"+Sta_Flag); //��Ƨ����s�b
			}else{  
				Sta_Flag=i+1;
				System.out.println(jud_file.toString()+"�ؿ��s�b  "+Sta_Flag);//��Ƨ��s�b 
				break;				
			} 
		}
		/*�P�_��Ƨ��O�_�s�b(Sta_Flag) END*/
		try{
			FileWriter fw = new FileWriter("javatoc");
			
			fw.write("");
			fw.flush();
			fw.close();
		}catch (Exception v) {
			System.out.println("javatoc�M�������\");
					  
		}
		
		
		/*�D�e��Layout�]�wSTART*/
		JFrame.setDefaultLookAndFeelDecorated(true);//�N�����]���[��
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize(); // ���o�ù��ؤo
		JFrame frame = new JFrame("");
        frame.setSize(screenSize.width,screenSize.height);//�]�w������ܤj�p�P�ù��ؤo�ۦP
        frame.setLayout(new BorderLayout());
		
		
		/*�N����JPanel�s�W�X�Өó]�w�C�� START*/
		for(int i=0;i<PP;i++){
			panel[i]=new JPanel();
			panel[i].setBackground(new Color(100+(2*i),100+(2*i),100+(2*i)));
		}
		/*�N����JPanel�s�W�X�Өó]�w�C�� END*/
		
		
		/*������s����START*/
		panel[0].setLayout(new BorderLayout());
		panel[0].add(panel[1],BorderLayout.NORTH);
		panel[0].add(panel[2],BorderLayout.CENTER);
		panel[1].setLayout(new GridLayout(1,1));
		panel[2].setLayout(new GridLayout(BB,1));
		panel[2].setPreferredSize(new Dimension(210,150));
		/*������s����END*/
		
		
		/*��������START*/
		
		panel[3].setLayout(new BorderLayout());
		panel[3].add(panel[4],BorderLayout.CENTER);
		panel[3].add(panel[5],BorderLayout.SOUTH);
		panel[4].setLayout(cardlayout1);
		panel[5].setLayout(cardlayout2);
		panel[5].setPreferredSize(new Dimension(200,130));
		
		
		/*�N�Ω�CardLayout��JPanel�s�W�X�Өó]�w�C��B�N�䪩���]�w��BorderLayout�̫�[�Jpanel[4](�D�����) START*/
		for(int i=0;i<CP;i++){
			Cpanel[i]=new JPanel();
			Upanel[i]=new JPanel();
			Cpanel[i].setBackground(new Color(100,100,100));
			Upanel[i].setBackground(new Color(100,100,100));
			//Cpanel[i].setBackground(new Color(100+(2*i),100+(2*i),100+(2*i)));
			//Upanel[i].setBackground(new Color(100+(2*i),100+(2*i),100+(2*i)));
			Cpanel[i].setLayout(new BorderLayout());
			Upanel[i].setLayout(new BorderLayout());
			panel[4].add(Cpanel[i],CPArray[i]);
			panel[4].add(Upanel[i],UPArray[i]);	
		}
		/*�N�Ω�CardLayout��JPanel�s�W�X�Өó]�w�C��B�N�䪩���]�w��BorderLayout�̫�[�Jpanel[4](�D�����) END*/
		
		
		/*�N�Ω�CardLayout��JPanel�s�W�X�Өó]�w�C��B�N�䪩���]�w��BorderLayout�̫�[�Jpanel[5](���ܰT��) START*/
		for(int i=0;i<DP;i++){
			CDpanel[i]=new JPanel();
			Dopanel[i]=new JPanel();
			CDpanel[i].setBackground(new Color(100,100,100));
			Dopanel[i].setBackground(new Color(100,100,100));
			//CDpanel[i].setBackground(new Color(100+(2*i),100+(2*i),100+(2*i)));
			//Dopanel[i].setBackground(new Color(100+(2*i),100+(2*i),100+(2*i)));
			CDpanel[i].setLayout(new FlowLayout(FlowLayout.LEFT, 20, 25));
			Dopanel[i].setLayout(new FlowLayout(FlowLayout.LEFT, 20, 25));
			panel[5].add(CDpanel[i],CPArray[i]);
			panel[5].add(Dopanel[i],UPArray[i]);
			HiBuArraybutton[i] = new JButton();
			D_HiBuArraybutton[i] = new JButton();
			
			ImageIcon hintbuimage=new ImageIcon(HiBuArray[i]);
			HiBuArraybutton[i].setIcon(hintbuimage);
			HiBuArraybutton[i].setBorderPainted(false);//BUTTON��u�]���z��
			HiBuArraybutton[i].setContentAreaFilled(false);//�NBUTTON�I���]���z����
			ImageIcon D_hintbuimage=new ImageIcon(D_HiBuArray[i]);
			D_HiBuArraybutton[i].setIcon(D_hintbuimage);
			//D_HiBuArraybutton[i].setBorderPainted(false);//BUTTON��u�]���z��
			D_HiBuArraybutton[i].setContentAreaFilled(false);//�NBUTTON�I���]���z����
			
			HiBuArraybutton[i].addActionListener(new buttonhandler2());
			D_HiBuArraybutton[i].addActionListener(new buttonhandler2());
		}
		/*�N�Ω�CardLayout��JPanel�s�W�X�Өó]�w�C��B�N�䪩���]�w��BorderLayout�̫�[�Jpanel[5](���ܰT��) END*/
		
		/*���ܰT�� START*/
		softfont[0]=new Font("�L�n������", Font.PLAIN, 50);
		for(int i=0;i<Hint_num;i++){
			Hint_Label[i]=new JLabel(HintArray[i]);
			Hint_Label[i].setFont(softfont[0]);
			Hint_Label2[i]=new JLabel(HintArray2[i]);
			Hint_Label2[i].setFont(softfont[0]);
			Hint_Label[i].setBackground(new Color(100,100,100));
			Hint_Label2[i].setBackground(new Color(100,100,100));
			
			//Hint_Label[i].setBackground(new Color(100+(2*i),100+(2*i),100+(2*i)));
			//Hint_Label2[i].setBackground(new Color(100+(2*i),100+(2*i),100+(2*i)));
						
			Hint_Label[i].setForeground(Color.white);
			Hint_Label2[i].setForeground(Color.white);
			
			
		}
		/*���ܰT�� END*/
		
		
		/*��������END*/
		
		
		frame.add(panel[0],BorderLayout.WEST);
		frame.add(panel[3],BorderLayout.CENTER);
		/*Panel Layout �]�wEND*/
		
		
		/*logo�[�J����start*/
		ImageIcon logoimage=new ImageIcon("image\\logo.png");//�s�W�Ϥ�
		logo.setHorizontalAlignment(SwingConstants.CENTER);//�NJLabel��������]���m��
		logo.setVerticalAlignment(SwingConstants.CENTER);//�NJLabel��������]���m��
		Image img = logoimage.getImage();//���o�Ϥ�
		img = img.getScaledInstance(150, 113, Image.SCALE_DEFAULT);//�վ�Ϥ��j�p
		logoimage.setImage(img);
		logo.setIcon(logoimage);//�NJLabel�[�JLOGO
		panel[1].add(logo);//�NLOGO�[�Jpanel[1]
		/*logo�[�J����end*/
		
		
		
		/*����Button START*/
		for(int i=0;i<BB;i++){//�N����B�J���s�s�W�X�ӨñN�j�p�]���e100,��100�A�B�N�Ϥ���J�A���۱NButton�̧ǥ[��panel[2]�A�̫�NButton�[��buttonhandler��@
			button[i]=new JButton();
			button[i].setPreferredSize(new Dimension(100,100));
			ImageIcon image=new ImageIcon(imageArray[i]);
			button[i].setIcon(image);
			button[i].setBorderPainted(false);//BUTTON��u�]���z��
			button[i].setContentAreaFilled(false);//�NBUTTON�I���]���z����
			panel[2].add(button[i]);
			
			button[i].addActionListener(new buttonhandler());
		}
		/*����Button END*/
		
	
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//�NX�]�w�������Ҧ��{��
		frame.setVisible(true);//��ܵ���
    }
	
	
	
	/*implement START*/
	public static class buttonhandler implements ActionListener {
		public void actionPerformed(ActionEvent e){
			//Font.BOLD
			UIManager.put("OptionPane.messageFont",new Font("�L�n������", Font.PLAIN, 20));
			UIManager.put("OptionPane.buttonFont",new Font("�L�n������", Font.PLAIN, 16));
			/*�Ĥ@�B�I������l�� START*/
			if((JButton)e.getSource()==button[0]){//�Y���U�����l��
				JFileChooser chooser1=new JFileChooser(".");//����ɮסA�åB�w�]��m���{�b��m
				FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV file", "csv");
				chooser1.setFileFilter(filter);
				int returnVal = chooser1.showOpenDialog(panel[4]);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					oporfile1 = chooser1.getSelectedFile();//���o�ϥΪ̩ҿ��ɮ�
					if(oporfile1.toString().contains(".csv")){
						/*���X���ݵ��� START*/
						JOptionPane WaitPanel3 =new JOptionPane(ProMesArray[7], JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
						JDialog Waitdialog3 = new JDialog();
						Waitdialog3.setModal(true);
						Waitdialog3.setContentPane(WaitPanel3);
							
						Waitdialog3.pack();
						Dimension screenSize3 = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
						Dimension GIFdialogSize = Waitdialog3.getSize();
						Waitdialog3.setLocation(screenSize3.width/2-GIFdialogSize.width/2,screenSize3.height/2-GIFdialogSize.height/2);
						Waitdialog3.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
						
						
						
						
						/*���X���ݵ��� END*/
						try {
						  Cho_Flag=1;//�NCho_Flag�]��1��ܦ������L�����l��
						  BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(oporfile1)));
						  new Thread(new Runnable() {
							  @Override
							  public void run() {
								try {
									//process.waitFor();
									CDpanel[0].removeAll();//�N���e�ҦbCDpanel[0]������i��M��
									CDpanel[0].add(Hint_Label[0]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��CDpanel[0]
									readtxt1 = new readtxt_3(oporfile1.toString());//�N�ϥΪ̿���ɮ׸��|�ର�r��éI�sreadtxt_3
									System.out.println(oporfile1.toString());//���աA�L�X�ɮ׸��|�r��
									ArrayList<Integer> judFileNameSame=new ArrayList<Integer>();
									judFileNameSame.clear();
									for(int i = 0;i<readtxt1.ColumnCount();i++){
										if(readtxt1.getColumnName(i).equals(OriFileName[i])){
											judFileNameSame.add(0);
										}else{
											judFileNameSame.add(1);
										}
										//System.out.println(judFileNameSame.get(i));
									}
									if(judFileNameSame.contains(1)){
										Waitdialog3.setVisible(false);
										JOptionPane.showMessageDialog(frame,"�ҿ��ɮפ��ŦX�t�Ωҭn�D���e(���E����)");
										ImageIcon image=new ImageIcon(imageArray[0]);
										button[0].setIcon(image);
										Cpanel[0].removeAll();
										CDpanel[0].removeAll();
										
									}else{
										Cpanel[0].removeAll();//�N���e�ҦbCpanel[0]������i��M��
										Cpanel[0].add(readtxt1.CALLTABLE());//�Nreadtxt_3�Ҧ^�Ǥ�JScrollPane�[��Cpanel[0]
										Cpanel[0].revalidate();//Cpanel[0]�������s����
										Cpanel[0].repaint();//Cpanel[0]�������sø�s 
										ImageIcon image=new ImageIcon(ClickbtArray[0]);
										button[0].setIcon(image);
										//tarea.read(input, "READING FILE :-)");
																  
										cardlayout1.show(panel[4],CPArray[0]);//�NCpanel[0]���(JTabel)
										cardlayout2.show(panel[5],CPArray[0]);//�NCDpanel[0]���(���ܰT��"�T�{�����Ы���Ƥ���")										
									}
									judFileNameSame.clear();  
								  
								  
								} catch (Exception v) {
									System.out.println(v);
								}
								Waitdialog3.setVisible(false);
							  }
							}).start();
							Waitdialog3.setVisible(true);
						  
						} catch (Exception v) {
						  System.out.println("�ɮפ��s�b,���ˬd�ɮצW��.");
						  
						}	
					}else{
						JOptionPane.showMessageDialog(frame,"�ҿ��ɮפ��ŦX�t�Ωһݮ榡(.csv)");
					}
					
					
					
					
					
					
					
				} else {
					System.out.println("Operation is CANCELLED :(");
				}
				
				
				System.out.println("STEP1---�����l��");//���աA�L�X"STEP1---�����l��"
			/*�Ĥ@�B�I������l�� END*/
				
				
			/*�ĤG�B�I���Ƥ��� START*/
			}else if((JButton)e.getSource()==button[1]){//�Y���U��Ƥ���
				
				if(Cho_Flag==1){//�p�G�������L�����l��

					/*��Ƥ��ΩI�s�~���{���g��*/
					try{
						FileWriter fw = new FileWriter("javatoc");
						data_cuwachfe_path=oporfile1.toString();//s�O�ɮ׸��|
						fw.write(data_cuwachfe_path);
						fw.flush();
						fw.close();
						
						//�I�s�~���{��
						Runtime runtime=Runtime.getRuntime();             
						Process process = runtime.exec("Data_Cut_End.exe");//file������~���{�����ɮצW��             
						System.out.println("���ΰ��椤--------------------");
						
						
						/*���X���ݵ��� START*/
						//OptionPane.font.getDefault()
						
						JOptionPane WaitPanel =new JOptionPane(ProMesArray[0], JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
						//WaitPanel.setFont(softfont[0]);
						JDialog Waitdialog = new JDialog();
						Waitdialog.setModal(true);
						Waitdialog.setContentPane(WaitPanel);
						
						Waitdialog.pack();
						Dimension screenSize2 = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
						Dimension GIFdialogSize = Waitdialog.getSize();
						Waitdialog.setLocation(screenSize2.width/2-GIFdialogSize.width/2,screenSize2.height/2-GIFdialogSize.height/2);
						Waitdialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
						System.out.println("���ΰ��椤--------------------");
						
						new Thread(new Runnable() {
						  @Override
						  public void run() {
							try {
							  process.waitFor();
							  //Thread.sleep(5000);
							} catch (InterruptedException e) {
							  e.printStackTrace();
							}
							Waitdialog.setVisible(false);
						  }
						}).start();
						Waitdialog.setVisible(true);
						/*���X���ݵ��� END*/
						
						JOptionPane.showMessageDialog(frame,ProEndMesArray[0]);
						ImageIcon image=new ImageIcon(ClickbtArray[1]);
						button[1].setIcon(image);
						Dacu_Flag=1;//�NDacu_Flag�]��1��ܦ������L��Ƥ���
					}catch(Exception v){
						System.out.println("���ΰ�����~");
					}
					
					
					FileCH=new layouttest1(0);//�N���Φn���~�����ɮצW�����(0�����ܤ��Ϊ���Ƨ�)
					Cpanel[1].removeAll();//�N���e�ҦbCpanel[1]������i��M��
					Cpanel[1].add(FileCH.CALLFILECH());//�N�^�Ǥ��θ�Ƨ����e�[�J��Cpanel[1]
					
					Cpanel[1].revalidate();//Cpanel[1]�������s����
					Cpanel[1].repaint();//Cpanel[1]�������sø�s
					CDpanel[1].removeAll();//�N���e�ҦbCDpanel[1]������i��M��
					CDpanel[1].add(Hint_Label[1]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��CDpanel[1]	
					HiBuArraybutton[0].setPreferredSize(new Dimension(190,88));//�N"�˵�"���s�]�w�j�p�e150�A��60
					CDpanel[1].add(HiBuArraybutton[0]);//�N"�˵�"���s�[�J��CDpanel[1]
										
					CDpanel[1].revalidate();//CDpanel[1]�������s����
					CDpanel[1].repaint();//CDpanel[1]�������sø�s
					cardlayout1.show(panel[4],CPArray[1]);//�NCpanel[1]���
					cardlayout2.show(panel[5],CPArray[1]);//�NCDpanel[1]���
					
					System.out.println("�w���");
					System.out.println("STEP2---��Ƥ���");//���աA�L�X"STEP2---��Ƥ���"
					
				}else if(Cho_Flag==0){//�p�G�����S�������l��
					System.out.println("�����");
					JOptionPane.showMessageDialog(frame,MesArray[0]);//���X�p�������"�|�������l�ɡA�Х������l��"
					
				}else{
					System.out.println("ERROR");
				}				
			/*�ĤG�B�I���Ƥ��� END*/
				
				
			/*�ĤT�B�I���ƲM�~�P�ഫ START*/
			}else if((JButton)e.getSource()==button[2]){//�Y���U��ƲM�~�P�ഫ
				
				if(Sta_Flag>=1 || Dacu_Flag==1){//�p�G���e���L��Ƥ��ΩάO��ƲM�~�P�ഫ�A�άO���������L��Ƥ���
					
					if(Dacu_Flag==0){//�Y�O�����S�����L��Ƥ���
						JOptionPane.showMessageDialog(frame,MesArray[1]);//���X�p�������"�|�������l�ɡA�Х������l�ɥH�i��M�~�P�ഫ"
						
						FileCH=new layouttest1(0);//�N���Φn���~�����ɮצW�����(0�����ܤ��Ϊ���Ƨ�)
						
						Cpanel[2].removeAll();//�N���e�ҦbCpanel[2]������i��M��
					
						Cpanel[2].add(FileCH.CALLFILECH());//�N�^�Ǥ��θ�Ƨ����e�[�J��Cpanel[2]
						Cpanel[2].revalidate();//Cpanel[2]�������s����
						Cpanel[2].repaint();//Cpanel[2]�������sø�s
						
						CDpanel[2].removeAll();//�N���e�ҦbCDpanel[2]������i��M��
						CDpanel[2].add(Hint_Label[2]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��CDpanel[2]	
						
						HiBuArraybutton[1].setPreferredSize(new Dimension(190,88));//�N"�˵�"���s�]�w�j�p�e150�A��60
						CDpanel[2].add(HiBuArraybutton[1]);//�N"�˵�"���s�[�J��CDpanel[2]
						CDpanel[2].revalidate();//CDpanel[2]�������s����
						CDpanel[2].repaint();//CDpanel[2]�������sø�s
							
						cardlayout1.show(panel[4],CPArray[2]);//�NCpanel[2]���
						cardlayout2.show(panel[5],CPArray[2]);//�NCDanel[2]���
						System.out.println("STEP3---��ܤ�����");//���աA���\����L�X"1"
						Dacu_Flag=1;
						
						
						
					}else{
						if(FileCH.IsClick()==1){
							System.out.println("Time to wash");
							if(Watr_Flag != 1){
								/*��ƲM�~�P�ഫ�I�s�~���{���g��*/
								try{
									
									FileWriter fw = new FileWriter("javatoc");
									if(FileCH.CALLFILPATH().contains("Wa_Ch")){
										data_cuwachfe_path=FileCH.CALLFILPATH().replace("Wa_Ch", "Cut");
									}else{
										data_cuwachfe_path=FileCH.CALLFILPATH();//s�O�ɮ׸��|
									}
									System.out.println("�����ɦW���|��"+data_cuwachfe_path);
									fw.write(data_cuwachfe_path);
									fw.flush();
									fw.close();
										
									//�I�s�~���{��
									Runtime runtime=Runtime.getRuntime();             
									Process process = runtime.exec("Data_TransForm_Final.exe");//file������~���{�����ɮצW��             
									System.out.println("�M�~�P�ഫ���椤--------------------");
									/*���X���ݵ��� START*/
									JOptionPane WaitPanel2 =new JOptionPane(ProMesArray[1], JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
									JDialog Waitdialog2 = new JDialog();
									Waitdialog2.setModal(true);
									Waitdialog2.setContentPane(WaitPanel2);
									
									Waitdialog2.pack();
									Dimension screenSize2 = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
									Dimension GIFdialogSize = Waitdialog2.getSize();
									Waitdialog2.setLocation(screenSize2.width/2-GIFdialogSize.width/2,screenSize2.height/2-GIFdialogSize.height/2);
									Waitdialog2.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
									System.out.println("���ΰ��椤--------------------");
									
									new Thread(new Runnable() {
									  @Override
									  public void run() {
										try {
										  process.waitFor();
										  Thread.sleep(1000);
										} catch (InterruptedException e) {
										  e.printStackTrace();
										}
										Waitdialog2.setVisible(false);
									  }
									}).start();
									Waitdialog2.setVisible(true);
									/*���X���ݵ��� END*/
									ImageIcon image=new ImageIcon(ClickbtArray[2]);
									button[2].setIcon(image);
									Watr_Flag=1;
								}catch(Exception v){
									System.out.println("�M�~�P�ഫ���~");
								}
								JOptionPane.showMessageDialog(frame,ProEndMesArray[1]);
							}
							FileCH=new layouttest1(1);//�N���Φn���~�����ɮצW�����(0�����ܤ��Ϊ���Ƨ�)
							
							Cpanel[3].removeAll();//�N���e�ҦbCpanel[3]������i��M��
							Cpanel[3].add(FileCH.CALLFILECH());//�N�^�Ǥ��θ�Ƨ����e�[�J��Cpanel[3]
								
							
							Cpanel[3].revalidate();//Cpanel[3]�������s����
							Cpanel[3].repaint();//Cpanel[3]�������sø�s
								
							CDpanel[3].removeAll();//�N���e�ҦbCDpanel[3]������i��M��
							CDpanel[3].add(Hint_Label[3]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��CDpanel[3]	
							HiBuArraybutton[3].setPreferredSize(new Dimension(200,100));//�N"��ܲM�~��L�ɮ�"���s�]�w�j�p�e150�A��60
							HiBuArraybutton[2].setPreferredSize(new Dimension(190,88));//�N"�˵�"���s�]�w�j�p�e150�A��60
							CDpanel[3].add(HiBuArraybutton[3]);//�N"��ܲM�~��L�ɮ�"���s�[�J��CDpanel[3]
							CDpanel[3].add(HiBuArraybutton[2]);//�N"�˵�"���s�[�J��CDpanel[3]					
							CDpanel[3].revalidate();//CDpanel[3]�������s����
							CDpanel[3].repaint();//CDpanel[3]�������sø�s
									
							cardlayout1.show(panel[4],CPArray[3]);//�NCpanel[3]���
							cardlayout2.show(panel[5],CPArray[3]);//�NCDpanel[3]���
							System.out.println("STEP4---��ܲM�~�P�ഫ��");//���աA���\����L�X"1"
							Dacu_Flag=0;
						}else{
							JOptionPane.showMessageDialog(frame,"�|������ɮ�");
						}
					
	/*-----------------------------------------------------------------------------------------------------------------------------*/
					
					}
				}else{
					JOptionPane.showMessageDialog(frame,MesArray[2]);//���X�p�������"�Х������l�ɶi�����"
					Cpanel[4].removeAll();//�N���e�ҦbCpanel[3]������i��M��
					Cpanel[4].revalidate();//Cpanel[3]�������s����
					Cpanel[4].repaint();//Cpanel[3]�������sø�s
					CDpanel[4].removeAll();//�N���e�ҦbCpanel[3]������i��M��
					//CDpanel[4].setBackground(new Color (108,108,108));
					CDpanel[4].revalidate();//Cpanel[3]�������s����
					CDpanel[4].repaint();//Cpanel[3]�������sø�s
					cardlayout1.show(panel[4],CPArray[4]);//�NCpanel[3]���
					cardlayout2.show(panel[5],CPArray[4]);//�NCDpanel[3]���
					System.out.println("STEP5---��ܿ����l��");//���աA���\����L�X"1"
				}
				/*�ĤT�B�I���ƲM�~�P�ഫ END*/
				
				/*�ĥ|�B�I��S�x��� START*/
			}else if((JButton)e.getSource()==button[3]){
				
				String ChFile="";
				String ChFile2="";
				Object[] options = {"�d������","��t�L�o","����L�ɮ�"};
				
				
				if(Sta_Flag>=2 || Watr_Flag==1){
					
					if(Watr_Flag==0){
						
						FileCH=new layouttest1(1);//�N���Φn���~�����ɮצW�����(0�����ܤ��Ϊ���Ƨ�)
						
						Cpanel[5].removeAll();//�N���e�ҦbCpanel[3]������i��M��
						Cpanel[5].add(FileCH.CALLFILECH());//�N�^�Ǥ��θ�Ƨ����e�[�J��Cpanel[3]
						Cpanel[5].revalidate();//Cpanel[3]�������s����
						Cpanel[5].repaint();//Cpanel[3]�������sø�s
						
						CDpanel[5].removeAll();//�N���e�ҦbCDpanel[3]������i��M��
						CDpanel[5].add(Hint_Label[4]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��CDpanel[3]	
						HiBuArraybutton[4].setPreferredSize(new Dimension(200,100));//�N"��ܲM�~��L�ɮ�"���s�]�w�j�p�e150�A��60
						HiBuArraybutton[5].setPreferredSize(new Dimension(190,88));//�N"�˵�"���s�]�w�j�p�e150�A��60
						CDpanel[5].add(HiBuArraybutton[4]);//�N"��ܲM�~��L�ɮ�"���s�[�J��CDpanel[3]
						CDpanel[5].add(HiBuArraybutton[5]);//�N"�˵�"���s�[�J��CDpanel[3]					
						CDpanel[5].revalidate();//CDpanel[3]�������s����
						CDpanel[5].repaint();//CDpanel[3]�������sø�s
						
						
						cardlayout1.show(panel[4],CPArray[5]);//�NCpanel[3]���
						cardlayout2.show(panel[5],CPArray[5]);//�NCDpanel[3]���
						System.out.println("STEP6---��ܤw�M�~�P�ഫ��");//���աA���\����L�X"1"
						Watr_Flag=1;
						
					}else{
						if(FileCH.IsClick()==1){
							if(Fet_Flag==1){
								FileCH=new layouttest1(1);//�N���Φn���~�����ɮצW�����(0�����ܤ��Ϊ���Ƨ�)
							
								Cpanel[5].removeAll();//�N���e�ҦbCpanel[3]������i��M��
								Cpanel[5].add(FileCH.CALLFILECH());//�N�^�Ǥ��θ�Ƨ����e�[�J��Cpanel[3]
								Cpanel[5].revalidate();//Cpanel[3]�������s����
								Cpanel[5].repaint();//Cpanel[3]�������sø�s
								
								CDpanel[5].removeAll();//�N���e�ҦbCDpanel[3]������i��M��
								CDpanel[5].add(Hint_Label[4]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��CDpanel[3]	
								HiBuArraybutton[4].setPreferredSize(new Dimension(200,100));//�N"��ܲM�~��L�ɮ�"���s�]�w�j�p�e150�A��60
								HiBuArraybutton[5].setPreferredSize(new Dimension(190,88));//�N"�˵�"���s�]�w�j�p�e150�A��60
								CDpanel[5].add(HiBuArraybutton[4]);//�N"��ܲM�~��L�ɮ�"���s�[�J��CDpanel[3]
								CDpanel[5].add(HiBuArraybutton[5]);//�N"�˵�"���s�[�J��CDpanel[3]					
								CDpanel[5].revalidate();//CDpanel[3]�������s����
								CDpanel[5].repaint();//CDpanel[3]�������sø�s
								
								
								cardlayout1.show(panel[4],CPArray[5]);//�NCpanel[3]���
								cardlayout2.show(panel[5],CPArray[5]);//�NCDpanel[3]���
								System.out.println("STEP6---��ܤw�M�~�P�ഫ��xxx");//���աA���\����L�X"1"
								Watr_Flag=1;
								Fet_Flag=0;
							}else{
								ChFile=FileCH.CALLOnlyName();
								ChFile2=FileCH.CALLFILPATH();
								System.out.println(ChFile);//���աA���\����L�X"1"
								System.out.println(ChFile2);
								
								opt1=JOptionPane.showOptionDialog(panel[3], "�ثe��ܪ��ɮ׬�"+ChFile+"\n�п�ܯS�x�����k","�п��",JOptionPane.YES_OPTION,JOptionPane.PLAIN_MESSAGE,null, options, options[2] ) ;
								if(opt1==2){
									NOWChFile="";
									FileCH=new layouttest1(1);//�N���Φn���~�����ɮצW�����(0�����ܤ��Ϊ���Ƨ�)
									
									Cpanel[6].removeAll();//�N���e�ҦbCpanel[3]������i��M��
									Cpanel[6].add(FileCH.CALLFILECH());//�N�^�Ǥ��θ�Ƨ����e�[�J��Cpanel[3]
									Cpanel[6].revalidate();//Cpanel[3]�������s����
									Cpanel[6].repaint();//Cpanel[3]�������sø�s
										
									CDpanel[6].removeAll();//�N���e�ҦbCDpanel[3]������i��M��
									CDpanel[6].add(Hint_Label[5]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��CDpanel[3]	
									HiBuArraybutton[6].setPreferredSize(new Dimension(190,88));//�N"��ܲM�~��L�ɮ�"���s�]�w�j�p�e150�A��60
									HiBuArraybutton[7].setPreferredSize(new Dimension(190,88));//�N"�˵�"���s�]�w�j�p�e150�A��60
									CDpanel[6].add(HiBuArraybutton[6]);//�N"��ܲM�~��L�ɮ�"���s�[�J��CDpanel[3]
									CDpanel[6].add(HiBuArraybutton[7]);//�N"�˵�"���s�[�J��CDpanel[3]					
									CDpanel[6].revalidate();//CDpanel[3]�������s����
									CDpanel[6].repaint();//CDpanel[3]�������sø�s
										
										
									cardlayout1.show(panel[4],CPArray[6]);//�NCpanel[3]���
									cardlayout2.show(panel[5],CPArray[6]);//�NCDpanel[3]���
									System.out.println("STEP6---��ܤw�M�~�P�ഫ��");//���աA���\����L�X"1"
								}else if(opt1==0||opt1==1){
									
									try{
										FileWriter fw = new FileWriter("javatoc");
										data_cuwachfe_path=FileCH.CALLFILPATH();//s�O�ɮ׸��|
										fw.write(data_cuwachfe_path);
										fw.flush();
										fw.close();
										System.out.println("�S�x����Ƽg�ɤ�--------------------");
										/*���X���ݵ��� START*/
											JOptionPane WaitPanel3 =new JOptionPane(ProMesArray[2], JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
											JDialog Waitdialog3 = new JDialog();
											Waitdialog3.setModal(true);
											Waitdialog3.setContentPane(WaitPanel3);
											
											Waitdialog3.pack();
											Dimension screenSize2 = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
											Dimension GIFdialogSize = Waitdialog3.getSize();
											Waitdialog3.setLocation(screenSize2.width/2-GIFdialogSize.width/2,screenSize2.height/2-GIFdialogSize.height/2);
											Waitdialog3.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
											System.out.println("�S�x���椤--------------------");
											
											new Thread(new Runnable() {
											  @Override
											  public void run() {
												try {
												 // process.waitFor();
													cortana = new Cortana(FileCH.CALLFILPATH());
													if(opt1==0){
														listpanel=new layouttest2_2(FileCH.CALLFILPATH().replace("Wa_Ch", "Feature").replace(".csv", "_CHi2.txt"),0,cortana.getPath());	
														
													}else if(opt1==1){
														listpanel=new layouttest2_2(FileCH.CALLFILPATH().replace("Wa_Ch", "Feature").replace(".csv", "_FT.txt"),1,cortana.getPath());	
													}
									
												} catch (Exception e) {
												 System.out.println(e);
												}
												Waitdialog3.setVisible(false);
											  }
											}).start();
											Waitdialog3.setVisible(true);
											JOptionPane.showMessageDialog(frame,ProEndMesArray[4]);
											/*���X���ݵ��� END*/
											Cpanel[7].removeAll();//�N���e�ҦbUpanel[0]������i��M��
											Cpanel[7].setBackground(new Color(100,100,100));
											Cpanel[7].add(listpanel.CALLLISTPANEL());//�Nreadtxt_3�Ҧ^�Ǥ�JScrollPane�[��Upanel[0]
											Cpanel[7].add(Box.createRigidArea(new Dimension(15, 15)), BorderLayout.WEST);
											Cpanel[7].revalidate();//Upanel[0]�������s����
											Cpanel[7].repaint();//Upanel[0]�������sø�s
											CDpanel[7].removeAll();//�N���e�ҦbDopanel[0]������i��M��
											CDpanel[7].add(Hint_Label[6]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��Dopanel[0]
											HiBuArraybutton[8].setPreferredSize(new Dimension(190,88));//�N"�W�@�B"���s�]�w�j�p�e150�A��60
											HiBuArraybutton[8].setEnabled(false);
											HiBuArraybutton[9].setPreferredSize(new Dimension(190,88));
											CDpanel[7].add(HiBuArraybutton[8]);//�N"�W�@�B"���s�[�J��Dopanel[0]
											CDpanel[7].add(HiBuArraybutton[9]);
											CDpanel[7].revalidate();//Dopanel[0]�������s����
											CDpanel[7].repaint();//Dopanel[0]�������sø�s
											cardlayout1.show(panel[4],CPArray[7]);//�NUpanel[0]���
											cardlayout2.show(panel[5],CPArray[7]);//�NDopanel[0]���
											FetSav_Flag=1;
									}catch(Exception v){
										System.out.println("�S�x������~");
									}	
								}
							}
						}else{
							JOptionPane.showMessageDialog(frame,"�|������ɮ�");
						}
						
					
					}
				
				
				}else if(Sta_Flag==1 || Dacu_Flag==1){
					JOptionPane.showMessageDialog(frame,MesArray[4]);//���X�p�������"�Х��i���ƲM�~�P����"
					FileCH=new layouttest1(0);//�N���Φn���~�����ɮצW�����(0�����ܤ��Ϊ���Ƨ�)
						
					Cpanel[8].removeAll();//�N���e�ҦbCpanel[3]������i��M��
					Cpanel[8].add(FileCH.CALLFILECH());//�N�^�Ǥ��θ�Ƨ����e�[�J��Cpanel[3]
					Cpanel[8].revalidate();//Cpanel[3]�������s����
					Cpanel[8].repaint();//Cpanel[3]�������sø�s
						
					CDpanel[8].removeAll();//�N���e�ҦbCDpanel[3]������i��M��
					CDpanel[8].add(Hint_Label[7]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��CDpanel[3]	
					HiBuArraybutton[10].setPreferredSize(new Dimension(190,88));//�N"��ܲM�~��L�ɮ�"���s�]�w�j�p�e150�A��60
					CDpanel[8].add(HiBuArraybutton[10]);//�N"��ܲM�~��L�ɮ�"���s�[�J��CDpanel[3]
					CDpanel[8].revalidate();//CDpanel[3]�������s����
					CDpanel[8].repaint();//CDpanel[3]�������sø�s
						
						
					cardlayout1.show(panel[4],CPArray[8]);//�NCpanel[3]���
					cardlayout2.show(panel[5],CPArray[8]);//�NCDpanel[3]���
					
					
				}else{
					JOptionPane.showMessageDialog(frame,MesArray[5]);
					Cpanel[9].removeAll();//�N���e�ҦbCpanel[3]������i��M��
					Cpanel[9].revalidate();//Cpanel[3]�������s����
					Cpanel[9].repaint();//Cpanel[3]�������sø�s
					Cpanel[9].setBackground(new Color(100+(10*4),100+(10*4),100+(10*4)));
					CDpanel[9].removeAll();//�N���e�ҦbCpanel[3]������i��M��
					CDpanel[9].setBackground(new Color(100+(10*4),100+(10*4),100+(10*4)));
					CDpanel[9].revalidate();//Cpanel[3]�������s����
					CDpanel[9].repaint();//Cpanel[3]�������sø�s
					cardlayout1.show(panel[4],CPArray[9]);//�NCpanel[3]���
					cardlayout2.show(panel[5],CPArray[9]);//�NCDpanel[3]���
				}
				
				/*�ĥ|�B�I��S�x��� END*/
				
				/*�Ĥ��B�I��Ыؼҫ� START*/
			}else if((JButton)e.getSource()==button[4]){
				if(FetSav_Flag==1){
					Object[] options2 = {"�O","�_"};
						
					int mType2=JOptionPane.QUESTION_MESSAGE;
					int oType2=JOptionPane.YES_NO_CANCEL_OPTION;
					int opt3=JOptionPane.showOptionDialog(panel[3], "�|���x�s�S�x�A�O�_���}�������H","�п��",oType2,mType2,null,options2,options2[0]);
					if(opt3==0){
						if(Sta_Flag >= 3 || Fet_Flag == 1){
							if(Fet_Flag == 0){
								FileCH=new layouttest1(2);
								
								Cpanel[10].removeAll();
								Cpanel[10].add(FileCH.CALLFILECH());
								Cpanel[10].revalidate();
								Cpanel[10].repaint();
								
								CDpanel[10].removeAll();
								CDpanel[10].add(Hint_Label[8]);	
								HiBuArraybutton[11].setPreferredSize(new Dimension(190,88));
								HiBuArraybutton[12].setPreferredSize(new Dimension(190,88));
								CDpanel[10].add(HiBuArraybutton[11]);
								CDpanel[10].add(HiBuArraybutton[12]);			
								CDpanel[10].revalidate();
								CDpanel[10].repaint();
								
								
								cardlayout1.show(panel[4],CPArray[10]);
								cardlayout2.show(panel[5],CPArray[10]);
								System.out.println("---��ܯS�x����ɮ�");
								
							}else{
								if(Mod_Flag == 1){
									FileCH=new layouttest1(2);
								
									Cpanel[10].removeAll();
									Cpanel[10].add(FileCH.CALLFILECH());
									Cpanel[10].revalidate();
									Cpanel[10].repaint();
									
									CDpanel[10].removeAll();
									CDpanel[10].add(Hint_Label[8]);	
									HiBuArraybutton[11].setPreferredSize(new Dimension(190,88));
									HiBuArraybutton[12].setPreferredSize(new Dimension(190,88));
									CDpanel[10].add(HiBuArraybutton[11]);
									CDpanel[10].add(HiBuArraybutton[12]);			
									CDpanel[10].revalidate();
									CDpanel[10].repaint();
									
									
									cardlayout1.show(panel[4],CPArray[10]);
									cardlayout2.show(panel[5],CPArray[10]);
									System.out.println("---��ܯS�x����ɮ�");
									Mod_Flag = 0;
								}else{
									//if()
									//Object[] options = {"�H���˪L","�˶ǻ����g����","�l�s�ձ��ɲέp��k���R"};
									Object[] options = {"�H���˪L","�l�s�ձ��ɲέp��k���R"};
								
									int mType=JOptionPane.QUESTION_MESSAGE;
									int oType=JOptionPane.YES_NO_CANCEL_OPTION;
									int opt2=JOptionPane.showOptionDialog(panel[3], "�п�ܭn�Ыت��ҫ�","�п��",oType,mType,null,options,options[0]);
									
									if(opt2==0){
										try{
											FileWriter fw = new FileWriter("javatoc");
											data_cuwachfe_path=featuresave.getOutPath();//s�O�ɮ׸��|
											fw.write(data_cuwachfe_path);
											fw.flush();
											fw.close();
											
											//�I�s�~���{��
											
											/*���X���ݵ��� START*/
											JOptionPane WaitPanel3 =new JOptionPane(ProMesArray[3], JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
											JDialog Waitdialog3 = new JDialog();
											Waitdialog3.setModal(true);
											Waitdialog3.setContentPane(WaitPanel3);
												
											Waitdialog3.pack();
											Dimension screenSize3 = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
											Dimension GIFdialogSize = Waitdialog3.getSize();
											Waitdialog3.setLocation(screenSize3.width/2-GIFdialogSize.width/2,screenSize3.height/2-GIFdialogSize.height/2);
											Waitdialog3.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
											System.out.println("�ؼҰ��椤--------------------");
											
											new Thread(new Runnable() {
											  @Override
											  public void run() {
												try {
												  //process.waitFor();
												  RF_Cexe Rf_C_exe= new RF_Cexe();
												  Thread.sleep(500);
												} catch (InterruptedException e) {
												  e.printStackTrace();
												}
												Waitdialog3.setVisible(false);
											  }
											}).start();
											Waitdialog3.setVisible(true);
											/*���X���ݵ��� END*/
											
											BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(new File("ctojava"))));
											String line = null;
											line = bf.readLine();
											fetxarea = new testtextarea (line);
											JOptionPane.showMessageDialog(frame,ProEndMesArray[2]);
											ImageIcon image=new ImageIcon(ClickbtArray[4]);
											button[4].setIcon(image);
										}catch(Exception v){
											System.out.println(v);
										}
										
										
										ImageIcon image=new ImageIcon(ClickbtArray[4]);
										button[4].setIcon(image);
										Mod_Flag=1;	
										Cpanel[11].removeAll();//�N���e�ҦbUpanel[0]������i��M��
										
										Cpanel[11].add(Box.createRigidArea(new Dimension(15, 15)), BorderLayout.NORTH);
										Cpanel[11].add(Box.createRigidArea(new Dimension(15, 15)), BorderLayout.EAST);
										Cpanel[11].add(Box.createRigidArea(new Dimension(15, 15)), BorderLayout.SOUTH);
										Cpanel[11].add(Box.createRigidArea(new Dimension(15, 15)), BorderLayout.WEST);
										Cpanel[11].add(fetxarea.CALLTEXTAREA(), BorderLayout.CENTER);
										Cpanel[11].revalidate();//Upanel[0]�������s����
										Cpanel[11].repaint();//Upanel[0]�������sø�s
											
										CDpanel[11].removeAll();//�N���e�ҦbDopanel[0]������i��M��
										CDpanel[11].add(Hint_Label[9]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��Dopanel[0]
										CDpanel[11].revalidate();//Dopanel[0]�������s����
										CDpanel[11].repaint();//Dopanel[0]�������sø�s
											
											
										cardlayout1.show(panel[4],CPArray[11]);
										cardlayout2.show(panel[5],CPArray[11]);
											
										
												
										
									}else if(opt2==1){
										System.out.println("���a���ؼҪ����|--------------------"+FileCH.CALLFILPATH().replace("Feature","Wa_Ch"));
										
										cortana2 = new Cortana2(FileCH.CALLFILPATH().replace("Feature","Wa_Ch"));
										try{
											FileWriter fw = new FileWriter("javatoc");
											data_cuwachfe_path=featuresave.getOutPath();//s�O�ɮ׸��|
											fw.write(data_cuwachfe_path);
											fw.flush();
											fw.close();
											
											//�I�s�~���{��
											
											/*���X���ݵ��� START*/
											JOptionPane WaitPanel3 =new JOptionPane(ProMesArray[3], JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
											JDialog Waitdialog3 = new JDialog();
											Waitdialog3.setModal(true);
											Waitdialog3.setContentPane(WaitPanel3);
												
											Waitdialog3.pack();
											Dimension screenSize3 = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
											Dimension GIFdialogSize = Waitdialog3.getSize();
											Waitdialog3.setLocation(screenSize3.width/2-GIFdialogSize.width/2,screenSize3.height/2-GIFdialogSize.height/2);
											Waitdialog3.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
											System.out.println("�ؼ�2���椤--------------------");
											
											
											new Thread(new Runnable() {
											  @Override
											  public void run() {
												try {
												  //process.waitFor();
												  
												  Thread.sleep(500);
												} catch (InterruptedException e) {
												  e.printStackTrace();
												}
												Waitdialog3.setVisible(false);
											  }
											}).start();
											Waitdialog3.setVisible(true);
											/*���X���ݵ��� END*/
											fetxarea = new testtextarea (cortana2.getPath());
											JOptionPane.showMessageDialog(frame,ProEndMesArray[2]);
											ImageIcon image=new ImageIcon(ClickbtArray[4]);
											button[4].setIcon(image);
											Mod_Flag=1;
											Cpanel[13].removeAll();//�N���e�ҦbUpanel[0]������i��M��
											
											Cpanel[13].add(Box.createRigidArea(new Dimension(15, 15)), BorderLayout.NORTH);
											Cpanel[13].add(Box.createRigidArea(new Dimension(15, 15)), BorderLayout.EAST);
											Cpanel[13].add(Box.createRigidArea(new Dimension(15, 15)), BorderLayout.SOUTH);
											Cpanel[13].add(Box.createRigidArea(new Dimension(15, 15)), BorderLayout.WEST);
											Cpanel[13].add(fetxarea.CALLTEXTAREA(), BorderLayout.CENTER);
											Cpanel[13].revalidate();//Upanel[0]�������s����
											Cpanel[13].repaint();//Upanel[0]�������sø�s
											
											CDpanel[13].removeAll();//�N���e�ҦbDopanel[0]������i��M��
											CDpanel[13].add(Hint_Label[11]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��Dopanel[0]
											CDpanel[13].revalidate();//Dopanel[0]�������s����
											CDpanel[13].repaint();//Dopanel[0]�������sø�s
											
											
											cardlayout1.show(panel[4],CPArray[13]);
											cardlayout2.show(panel[5],CPArray[13]);
											
											System.out.println(FileCH.CALLFILPATH());
											
										}catch(Exception v){
											System.out.println(v);
										}
												
									}
								}
							}
							
							
						}else if(Sta_Flag == 2 || Watr_Flag == 1){
							Cpanel[14].removeAll();
							Cpanel[14].revalidate();
							Cpanel[14].repaint();
							CDpanel[14].removeAll();
							CDpanel[14].revalidate();
							CDpanel[14].repaint();
							cardlayout1.show(panel[4],CPArray[14]);
							cardlayout2.show(panel[5],CPArray[14]);
							JOptionPane.showMessageDialog(frame,MesArray[7]);
						}else if(Sta_Flag == 1 || Dacu_Flag == 1){
							Cpanel[15].removeAll();
							Cpanel[15].revalidate();
							Cpanel[15].repaint();
							CDpanel[15].removeAll();
							CDpanel[15].revalidate();
							CDpanel[15].repaint();
							cardlayout1.show(panel[4],CPArray[15]);
							cardlayout2.show(panel[5],CPArray[15]);
							JOptionPane.showMessageDialog(frame,MesArray[8]);
						}else{
							Cpanel[16].removeAll();
							Cpanel[16].revalidate();
							Cpanel[16].repaint();
							CDpanel[16].removeAll();
							CDpanel[16].revalidate();
							CDpanel[16].repaint();
							cardlayout1.show(panel[4],CPArray[16]);
							cardlayout2.show(panel[5],CPArray[16]);
							JOptionPane.showMessageDialog(frame,MesArray[9]);
						}
					}
					//JOptionPane.showMessageDialog(frame,"�S�x�|���Q�x�s");
				}else{
					if(Sta_Flag >= 3 || Fet_Flag == 1){
							if(Fet_Flag == 0){
								FileCH=new layouttest1(2);
								
								Cpanel[10].removeAll();
								Cpanel[10].add(FileCH.CALLFILECH());
								Cpanel[10].revalidate();
								Cpanel[10].repaint();
								
								CDpanel[10].removeAll();
								CDpanel[10].add(Hint_Label[8]);	
								HiBuArraybutton[11].setPreferredSize(new Dimension(190,88));
								HiBuArraybutton[12].setPreferredSize(new Dimension(190,88));
								CDpanel[10].add(HiBuArraybutton[11]);
								CDpanel[10].add(HiBuArraybutton[12]);			
								CDpanel[10].revalidate();
								CDpanel[10].repaint();
								
								
								cardlayout1.show(panel[4],CPArray[10]);
								cardlayout2.show(panel[5],CPArray[10]);
								System.out.println("---��ܯS�x����ɮ�");
								
							}else{
								if(Mod_Flag == 1){
									FileCH=new layouttest1(2);
								
									Cpanel[10].removeAll();
									Cpanel[10].add(FileCH.CALLFILECH());
									Cpanel[10].revalidate();
									Cpanel[10].repaint();
									
									CDpanel[10].removeAll();
									CDpanel[10].add(Hint_Label[8]);	
									HiBuArraybutton[11].setPreferredSize(new Dimension(190,88));
									HiBuArraybutton[12].setPreferredSize(new Dimension(190,88));
									CDpanel[10].add(HiBuArraybutton[11]);
									CDpanel[10].add(HiBuArraybutton[12]);			
									CDpanel[10].revalidate();
									CDpanel[10].repaint();
									
									
									cardlayout1.show(panel[4],CPArray[10]);
									cardlayout2.show(panel[5],CPArray[10]);
									System.out.println("---��ܯS�x����ɮ�");
									Mod_Flag = 0;
								}else{
									//if()
									//Object[] options = {"�H���˪L","�˶ǻ����g����","�l�s�ձ��ɲέp��k���R"};
									Object[] options = {"�H���˪L","�l�s�ձ��ɲέp��k���R"};
								
									int mType=JOptionPane.QUESTION_MESSAGE;
									int oType=JOptionPane.YES_NO_CANCEL_OPTION;
									int opt2=JOptionPane.showOptionDialog(panel[3], "�п�ܭn�Ыت��ҫ�","�п��",oType,mType,null,options,options[0]);
									
									if(opt2==0){
										try{
											FileWriter fw = new FileWriter("javatoc");
											data_cuwachfe_path=featuresave.getOutPath();//s�O�ɮ׸��|
											fw.write(data_cuwachfe_path);
											fw.flush();
											fw.close();
											
											//�I�s�~���{��
											
											/*���X���ݵ��� START*/
											JOptionPane WaitPanel3 =new JOptionPane(ProMesArray[3], JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
											JDialog Waitdialog3 = new JDialog();
											Waitdialog3.setModal(true);
											Waitdialog3.setContentPane(WaitPanel3);
												
											Waitdialog3.pack();
											Dimension screenSize3 = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
											Dimension GIFdialogSize = Waitdialog3.getSize();
											Waitdialog3.setLocation(screenSize3.width/2-GIFdialogSize.width/2,screenSize3.height/2-GIFdialogSize.height/2);
											Waitdialog3.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
											System.out.println("�ؼҰ��椤--------------------");
											
											new Thread(new Runnable() {
											  @Override
											  public void run() {
												try {
												  //process.waitFor();
												  RF_Cexe Rf_C_exe= new RF_Cexe();
												  Thread.sleep(500);
												} catch (InterruptedException e) {
												  e.printStackTrace();
												}
												Waitdialog3.setVisible(false);
											  }
											}).start();
											Waitdialog3.setVisible(true);
											/*���X���ݵ��� END*/
											
											BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(new File("ctojava"))));
											String line = null;
											line = bf.readLine();
											fetxarea = new testtextarea (line);
											JOptionPane.showMessageDialog(frame,ProEndMesArray[2]);
											ImageIcon image=new ImageIcon(ClickbtArray[4]);
											button[4].setIcon(image);
										}catch(Exception v){
											System.out.println(v);
										}
										
										
										ImageIcon image=new ImageIcon(ClickbtArray[4]);
										button[4].setIcon(image);
										Mod_Flag=1;	
										Cpanel[11].removeAll();//�N���e�ҦbUpanel[0]������i��M��
										
										Cpanel[11].add(Box.createRigidArea(new Dimension(15, 15)), BorderLayout.NORTH);
										Cpanel[11].add(Box.createRigidArea(new Dimension(15, 15)), BorderLayout.EAST);
										Cpanel[11].add(Box.createRigidArea(new Dimension(15, 15)), BorderLayout.SOUTH);
										Cpanel[11].add(Box.createRigidArea(new Dimension(15, 15)), BorderLayout.WEST);
										Cpanel[11].add(fetxarea.CALLTEXTAREA(), BorderLayout.CENTER);
										Cpanel[11].revalidate();//Upanel[0]�������s����
										Cpanel[11].repaint();//Upanel[0]�������sø�s
											
										CDpanel[11].removeAll();//�N���e�ҦbDopanel[0]������i��M��
										CDpanel[11].add(Hint_Label[9]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��Dopanel[0]
										CDpanel[11].revalidate();//Dopanel[0]�������s����
										CDpanel[11].repaint();//Dopanel[0]�������sø�s
											
											
										cardlayout1.show(panel[4],CPArray[11]);
										cardlayout2.show(panel[5],CPArray[11]);
											
										
												
										
									}else if(opt2==1){
										System.out.println("���a���ؼҪ����|--------------------"+FileCH.CALLFILPATH().replace("Feature","Wa_Ch"));
										
										cortana2 = new Cortana2(FileCH.CALLFILPATH().replace("Feature","Wa_Ch"));
										try{
											FileWriter fw = new FileWriter("javatoc");
											data_cuwachfe_path=featuresave.getOutPath();//s�O�ɮ׸��|
											fw.write(data_cuwachfe_path);
											fw.flush();
											fw.close();
											
											//�I�s�~���{��
											
											/*���X���ݵ��� START*/
											JOptionPane WaitPanel3 =new JOptionPane(ProMesArray[3], JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
											JDialog Waitdialog3 = new JDialog();
											Waitdialog3.setModal(true);
											Waitdialog3.setContentPane(WaitPanel3);
												
											Waitdialog3.pack();
											Dimension screenSize3 = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
											Dimension GIFdialogSize = Waitdialog3.getSize();
											Waitdialog3.setLocation(screenSize3.width/2-GIFdialogSize.width/2,screenSize3.height/2-GIFdialogSize.height/2);
											Waitdialog3.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
											System.out.println("�ؼ�2���椤--------------------");
											
											
											new Thread(new Runnable() {
											  @Override
											  public void run() {
												try {
												  //process.waitFor();
												  
												  Thread.sleep(500);
												} catch (InterruptedException e) {
												  e.printStackTrace();
												}
												Waitdialog3.setVisible(false);
											  }
											}).start();
											Waitdialog3.setVisible(true);
											/*���X���ݵ��� END*/
											fetxarea = new testtextarea (cortana2.getPath());
											JOptionPane.showMessageDialog(frame,ProEndMesArray[2]);
											ImageIcon image=new ImageIcon(ClickbtArray[4]);
											button[4].setIcon(image);
											Mod_Flag=1;
											Cpanel[13].removeAll();//�N���e�ҦbUpanel[0]������i��M��
											
											Cpanel[13].add(Box.createRigidArea(new Dimension(15, 15)), BorderLayout.NORTH);
											Cpanel[13].add(Box.createRigidArea(new Dimension(15, 15)), BorderLayout.EAST);
											Cpanel[13].add(Box.createRigidArea(new Dimension(15, 15)), BorderLayout.SOUTH);
											Cpanel[13].add(Box.createRigidArea(new Dimension(15, 15)), BorderLayout.WEST);
											Cpanel[13].add(fetxarea.CALLTEXTAREA(), BorderLayout.CENTER);
											Cpanel[13].revalidate();//Upanel[0]�������s����
											Cpanel[13].repaint();//Upanel[0]�������sø�s
											
											CDpanel[13].removeAll();//�N���e�ҦbDopanel[0]������i��M��
											CDpanel[13].add(Hint_Label[11]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��Dopanel[0]
											CDpanel[13].revalidate();//Dopanel[0]�������s����
											CDpanel[13].repaint();//Dopanel[0]�������sø�s
											
											
											cardlayout1.show(panel[4],CPArray[13]);
											cardlayout2.show(panel[5],CPArray[13]);
											
											System.out.println(FileCH.CALLFILPATH());
											
										}catch(Exception v){
											System.out.println(v);
										}
												
									}
								}
							}
							
							
						}else if(Sta_Flag == 2 || Watr_Flag == 1){
							Cpanel[14].removeAll();
							Cpanel[14].revalidate();
							Cpanel[14].repaint();
							CDpanel[14].removeAll();
							CDpanel[14].revalidate();
							CDpanel[14].repaint();
							cardlayout1.show(panel[4],CPArray[14]);
							cardlayout2.show(panel[5],CPArray[14]);
							JOptionPane.showMessageDialog(frame,MesArray[7]);
						}else if(Sta_Flag == 1 || Dacu_Flag == 1){
							Cpanel[15].removeAll();
							Cpanel[15].revalidate();
							Cpanel[15].repaint();
							CDpanel[15].removeAll();
							CDpanel[15].revalidate();
							CDpanel[15].repaint();
							cardlayout1.show(panel[4],CPArray[15]);
							cardlayout2.show(panel[5],CPArray[15]);
							JOptionPane.showMessageDialog(frame,MesArray[8]);
						}else{
							Cpanel[16].removeAll();
							Cpanel[16].revalidate();
							Cpanel[16].repaint();
							CDpanel[16].removeAll();
							CDpanel[16].revalidate();
							CDpanel[16].repaint();
							cardlayout1.show(panel[4],CPArray[16]);
							cardlayout2.show(panel[5],CPArray[16]);
							JOptionPane.showMessageDialog(frame,MesArray[9]);
						}
				}
				
				
				
				/*�Ĥ��B�I��Ыؼҫ� END*/
				
				
				/*�Ĥ��B�I��w���̨Ψ�E�ɶ� START*/
			}else if((JButton)e.getSource()==button[5]){
				
				if(Sta_Flag==4 || Mod_Flag==1){
					JFileChooser chooser2=new JFileChooser(".");//����ɮסA�åB�w�]��m���{�b��m
					FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV file", "csv");
					chooser2.setFileFilter(filter);
					int returnVal = chooser2.showOpenDialog(panel[4]);
					
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						oporfile2 = chooser2.getSelectedFile();//���o�ϥΪ̩ҿ��ɮ�
						if(oporfile2.toString().contains(".csv")){
							readtxt_3 readtxt_oporfile2 = new readtxt_3(oporfile2.toString());
							try {
								/*��Ƥ��ΩI�s�~���{���g��*/
								FileWriter fw = new FileWriter("javatoc");
								data_cuwachfe_path=oporfile2.toString();//s�O�ɮ׸��|
								fw.write(data_cuwachfe_path);
								fw.flush();
								fw.close();
								ArrayList<Integer> judFileNameSame2=new ArrayList<Integer>();
								judFileNameSame2.clear();
								for(int i = 0;i<readtxt_oporfile2.ColumnCount();i++){
									if(readtxt_oporfile2.getColumnName(i).equals(OriFileName[i])){
										judFileNameSame2.add(0);
									}else{
										judFileNameSame2.add(1);
									}
									//System.out.println(judFileNameSame.get(i));
								}
								if(judFileNameSame2.contains(1)){
									JOptionPane.showMessageDialog(frame,"�ҿ��ɮפ��ŦX�t�Ωҭn�D���e(���E����)");
									Cpanel[17].removeAll();
									CDpanel[17].removeAll();
								}else{
									Object[] options = {"�T�w","����"};
						
									int mType=JOptionPane.QUESTION_MESSAGE;
									int oType=JOptionPane.YES_NO_CANCEL_OPTION;
									int opt=JOptionPane.showOptionDialog(frame,"�ҿ���w���ɮ׬��G\n"+oporfile2.toString(),"�нT�{",oType,mType,null,options,options[0]);
									if(opt==0){
										//�I�s�~���{��
										Runtime runtime=Runtime.getRuntime();             
										Process process = runtime.exec("Data_Cut_P2.exe");//file������~���{�����ɮצW��             
										System.out.println("���ΰ��椤2--------------------");
										/*���X���ݵ��� START*/
										JOptionPane WaitPanel2 =new JOptionPane(ProMesArray[4], JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
										JDialog Waitdialog2 = new JDialog();
										Waitdialog2.setModal(true);
										Waitdialog2.setContentPane(WaitPanel2);
												
										Waitdialog2.pack();
										Dimension screenSize2 = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
										Dimension GIFdialogSize = Waitdialog2.getSize();
										Waitdialog2.setLocation(screenSize2.width/2-GIFdialogSize.width/2,screenSize2.height/2-GIFdialogSize.height/2);
										Waitdialog2.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
										System.out.println("�������椤--------------------");
										
										new Thread(new Runnable() {
										  @Override
										  public void run() {
											try {
											  process.waitFor();
											  //Thread.sleep(500);
											} catch (InterruptedException e) {
											  e.printStackTrace();
											}
											Waitdialog2.setVisible(false);
										  }
										}).start();
										Waitdialog2.setVisible(true);
										/*���X���ݵ��� END*/
							
									
										/*��Ƥ��ΩI�s�~���{���g��*/
										JOptionPane.showMessageDialog(frame,ProEndMesArray[3]);	
										/*--------------------------------------------------------------------------------------------------------------------*/	
										
										FileCH2=new layouttest1_1(3);//�N���Φn���~�����ɮצW�����(0�����ܤ��Ϊ���Ƨ�)
										Cpanel[17].removeAll();//�N���e�ҦbCpanel[2]������i��M��
										Cpanel[17].add(FileCH2.CALLFILECH());//�N�^�Ǥ��θ�Ƨ����e�[�J��Cpanel[2]
										Cpanel[17].revalidate();//Cpanel[2]�������s����
										Cpanel[17].repaint();//Cpanel[2]�������sø�s
												
										CDpanel[17].removeAll();//�N���e�ҦbCDpanel[2]������i��M��
										CDpanel[17].add(Hint_Label2[27]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��CDpanel[2]	
										D_HiBuArraybutton[32].setPreferredSize(new Dimension(190,88));
										D_HiBuArraybutton[33].setPreferredSize(new Dimension(190,88));//�N"�˵�"���s�]�w�j�p�e150�A��60
										CDpanel[17].add(D_HiBuArraybutton[32]);//�N"�˵�"���s�[�J��CDpanel[2]
										CDpanel[17].add(D_HiBuArraybutton[33]);
										CDpanel[17].revalidate();//CDpanel[2]�������s����
										CDpanel[17].repaint();//CDpanel[2]�������sø�s
								
										cardlayout1.show(panel[4],CPArray[17]);//�NCpanel[2]���
										cardlayout2.show(panel[5],CPArray[17]);//�NCDanel[2]���
									}										
								}
								judFileNameSame2.clear();  
								  
								
								
							} catch (Exception k) {
								System.out.println(k);
							}
						}else{
							JOptionPane.showMessageDialog(frame,"�ҿ��ɮפ��ŦX�t�Ωһݮ榡(.csv)");
						}		
					} else {
						System.out.println("Operation is CANCELLED :(");
					}
					
					
					
						
				}else if(Sta_Flag==3||Fet_Flag==1){
					Cpanel[18].removeAll();//�N���e�ҦbCpanel[3]������i��M��
					Cpanel[18].revalidate();//Cpanel[3]�������s����
					Cpanel[18].repaint();//Cpanel[3]�������sø�s
					CDpanel[18].removeAll();//�N���e�ҦbCDpanel[3]������i��M��
					CDpanel[18].revalidate();//Cpanel[3]�������s����
					CDpanel[18].repaint();//Cpanel[3]�������sø�s
					cardlayout1.show(panel[4],CPArray[18]);//�NCpanel[3]���
					cardlayout2.show(panel[5],CPArray[18]);//�NCDpanel[3]���
					
					JOptionPane.showMessageDialog(frame,MesArray[10]);//���X�p�������"�Х��i���ƲM�~�P����"
				}else if(Sta_Flag==2||Watr_Flag==1){
					Cpanel[19].removeAll();//�N���e�ҦbCpanel[3]������i��M��
					Cpanel[19].revalidate();//Cpanel[3]�������s����
					Cpanel[19].repaint();//Cpanel[3]�������sø�s
					CDpanel[19].removeAll();//�N���e�ҦbCDpanel[3]������i��M��
					CDpanel[19].revalidate();//Cpanel[3]�������s����
					CDpanel[19].repaint();//Cpanel[3]�������sø�s
					cardlayout1.show(panel[4],CPArray[19]);//�NCpanel[3]���
					cardlayout2.show(panel[5],CPArray[19]);//�NCDpanel[3]���
					JOptionPane.showMessageDialog(frame,MesArray[11]);//���X�p�������"�Х��i���ƲM�~�P����"
				}else if(Sta_Flag==1||Dacu_Flag==1){
					Cpanel[20].removeAll();//�N���e�ҦbCpanel[3]������i��M��
					Cpanel[20].revalidate();//Cpanel[3]�������s����
					Cpanel[20].repaint();//Cpanel[3]�������sø�s
					CDpanel[20].removeAll();//�N���e�ҦbCDpanel[3]������i��M��
					CDpanel[20].revalidate();//Cpanel[3]�������s����
					CDpanel[20].repaint();//Cpanel[3]�������sø�s
					cardlayout1.show(panel[4],CPArray[20]);//�NCpanel[3]���
					cardlayout2.show(panel[5],CPArray[20]);//�NCDpanel[3]���
					JOptionPane.showMessageDialog(frame,MesArray[12]);//���X�p�������"�Х��i���ƲM�~�P����"
				}else{
					Cpanel[21].removeAll();//�N���e�ҦbCpanel[3]������i��M��
					Cpanel[21].revalidate();//Cpanel[3]�������s����
					Cpanel[21].repaint();//Cpanel[3]�������sø�s
					CDpanel[21].removeAll();//�N���e�ҦbCDpanel[3]������i��M��
					CDpanel[21].revalidate();//Cpanel[3]�������s����
					CDpanel[21].repaint();//Cpanel[3]�������sø�s
					cardlayout1.show(panel[4],CPArray[21]);//�NCpanel[3]���
					cardlayout2.show(panel[5],CPArray[21]);//�NCDpanel[3]���
					JOptionPane.showMessageDialog(frame,MesArray[13]);//���X�p�������"�Х��i���ƲM�~�P����"
				}
				/*�Ĥ��B�I��w���̨Ψ�E�ɶ� END*/
				
				
				/*�ĤC�B�I��į��� START*/
			}else if((JButton)e.getSource()==button[6]){
				String Queue=null;
				String waittime=null;
				String idle=null;
				String doctor_code=null;
				 
				ImageIcon image=new ImageIcon(ClickbtArray[6]);
				
				
				if(Eva_Flag==0 || (Eva_Flag==1&&Sta_Flag==4)){
					File Mod_re_file =new File("Hos_Data/Doc_Test/Mod_Re");
					
					//FileCH.getfilesize()==null
					//	||FileCH.getfoldersize()==null
					
					if(!Mod_re_file.exists()  && !Mod_re_file.isDirectory()){
						JOptionPane.showMessageDialog(frame,MesArray[18]);
					}else{
						FileCH=new layouttest1(6);//�N���Φn���~�����ɮצW�����(0�����ܤ��Ϊ���Ƨ�)
						Cpanel[22].removeAll();//�N���e�ҦbCpanel[3]������i��M��
						Cpanel[22].add(FileCH.CALLFILECH());//�N�^�Ǥ��θ�Ƨ����e�[�J��Cpanel[3]
						Cpanel[22].revalidate();//Cpanel[3]�������s����
						Cpanel[22].repaint();//Cpanel[3]�������sø�s
						CDpanel[22].removeAll();//�N���e�ҦbCDpanel[3]������i��M��
						CDpanel[22].add(Hint_Label[13]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��CDpanel[3]	
						HiBuArraybutton[15].setPreferredSize(new Dimension(190,88));//�N"��ܲM�~��L�ɮ�"���s�]�w�j�p�e150�A��60
						HiBuArraybutton[16].setPreferredSize(new Dimension(190,88));//�N"�˵�"���s�]�w�j�p�e150�A��60
						CDpanel[22].add(HiBuArraybutton[15]);//�N"��ܲM�~��L�ɮ�"���s�[�J��CDpanel[3]
						CDpanel[22].add(HiBuArraybutton[16]);//�N"�˵�"���s�[�J��CDpanel[3]
						
					}
			
					CDpanel[22].revalidate();//CDpanel[3]�������s����
					CDpanel[22].repaint();//CDpanel[3]�������sø�s
						
						
					cardlayout1.show(panel[4],CPArray[22]);//�NCpanel[3]���
					cardlayout2.show(panel[5],CPArray[22]);//�NCDpanel[3]���
					
					System.out.println("---�ĤC�B");//���աA���\����L�X"1"
					
					
					
					
				}else{
					
					try{
						String modelname=null;
						BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(new File("ctojava"))));          
										
					
						modelname = bf.readLine();
						FileWriter fw = new FileWriter("javatoc");
						
						System.out.println("2�ҫ����G�ɦW���|��"+modelname);
						
						
						fw.write(modelname);
						fw.flush();
						fw.close();
						
					}catch(Exception v){
						System.out.println(v);
					}	
					try {
						//�I�s�~���{��
						Runtime runtime=Runtime.getRuntime();             
						Process process = runtime.exec("Effect_Comparsion_Sys.exe");//file������~���{�����ɮצW��             
						System.out.println("�į���--------------------");
						/*���X���ݵ��� START*/
							
							
						JOptionPane WaitPanel =new JOptionPane(ProMesArray[5], JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
						//WaitPanel.setFont(softfont[0]);
						JDialog Waitdialog = new JDialog();
						Waitdialog.setModal(true);
						Waitdialog.setContentPane(WaitPanel);
							
						Waitdialog.pack();
						Dimension screenSize2 = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
						Dimension GIFdialogSize = Waitdialog.getSize();
						Waitdialog.setLocation(screenSize2.width/2-GIFdialogSize.width/2,screenSize2.height/2-GIFdialogSize.height/2);
						Waitdialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
						System.out.println("�e�ϰ��椤--------------------");
							
						new Thread(new Runnable() {
						  @Override
						  public void run() {
							try {
							  process.waitFor();
							  //Thread.sleep(5000);
							} catch (InterruptedException e) {
							  e.printStackTrace();
							}
							Waitdialog.setVisible(false);
						  }
						}).start();
						Waitdialog.setVisible(true);
						JOptionPane.showMessageDialog(frame,ProEndMesArray[5]);
						/*���X���ݵ��� END*/
						BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(new File("ctojava2"))));          
										
					
						Queue = bf.readLine();
						System.out.println("��Ū��1 "+Queue);
						waittime = bf.readLine();
						System.out.println("��Ū��2 "+waittime);
						idle = bf.readLine();
						System.out.println("��Ū��3 "+idle);  
						doctor_code = bf.readLine();
						System.out.println("��Ū��4 "+doctor_code); 
					} catch (Exception k) {
							System.out.println(k);
					} 		
				
				
					piclayout = new layouttest6_6_2("test",Queue,waittime,idle,doctor_code);
				
					Cpanel[23].removeAll();//�N���e�ҦbUpanel[0]������i��M��
					Cpanel[23].setLayout(new BoxLayout(Cpanel[23], BoxLayout.Y_AXIS));
					Cpanel[23].add(piclayout.CALLPIC());//�Nreadtxt_3�Ҧ^�Ǥ�JScrollPane�[��Upanel[0]
					
					Cpanel[23].revalidate();//Upanel[0]�������s����
					Cpanel[23].repaint();//Upanel[0]�������sø�s
					
					CDpanel[23].removeAll();//�N���e�ҦbDopanel[0]������i��M��
					CDpanel[23].add(Hint_Label[14]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��Dopanel[0]
					
					
					CDpanel[23].revalidate();//Dopanel[0]�������s����
					CDpanel[23].repaint();//Dopanel[0]�������sø�s
					
					
					cardlayout1.show(panel[4],CPArray[23]);//�NCpanel[3]���
					cardlayout2.show(panel[5],CPArray[23]);//�NCDpanel[3]���
					
					button[6].setIcon(image);
				}
				/*�ĤC�B�I��į��� END*/
				
				/*�ĤK�B�I��@��B�z START*/
			}else if((JButton)e.getSource()==button[7]){
				System.out.println("��8�B");//���աA�L�X"��8�B"
				ImageIcon image=new ImageIcon(ClickbtArray[7]);
				Cpanel[24].removeAll();
				
				Cpanel[24].add(allinone.AllInOne());
				Cpanel[24].revalidate();//Cpanel[1]�������s����
				Cpanel[24].repaint();//Cpanel[1]�������sø�s
				CDpanel[24].removeAll();//�N���e�ҦbDopanel[0]������i��M��
				CDpanel[24].add(Hint_Label[15]);
				HiBuArraybutton[17].setPreferredSize(new Dimension(190,88));
				CDpanel[24].add(HiBuArraybutton[17]);
				
				CDpanel[24].revalidate();//Dopanel[0]�������s����
				CDpanel[24].repaint();//Dopanel[0]�������sø�s
				cardlayout1.show(panel[4],CPArray[24]);//�NCpanel[3]���
				cardlayout2.show(panel[5],CPArray[24]);//�NCDpanel[3]���
				//button[7].setIcon(image);
				/*�ĤK�B�I��@��B�z END*/
			}else{
				System.out.println("���աA����");//���աA���ѦL�X"����"
			}
		}
	}
	
	public static class buttonhandler2 implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if((JButton)e.getSource()==HiBuArraybutton[0]){//�Y���U��Ƥ��Τ���"�˵�"���s
				if(FileCH.IsClick()==1){
					readtxt2 = new readtxt_3(FileCH.CALLFILPATH());//�N�ϥΪ̿���ɮ׸��|�ର�r��éI�sreadtxt_3
					Upanel[0].removeAll();//�N���e�ҦbUpanel[0]������i��M��
					Upanel[0].add(readtxt2.CALLTABLE());//�Nreadtxt_3�Ҧ^�Ǥ�JScrollPane�[��Upanel[0]
					Upanel[0].revalidate();//Upanel[0]�������s����
					Upanel[0].repaint();//Upanel[0]�������sø�s
					
					Dopanel[0].removeAll();//�N���e�ҦbDopanel[0]������i��M��
					Dopanel[0].add(Hint_Label2[0]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��Dopanel[0]
					D_HiBuArraybutton[0].setPreferredSize(new Dimension(190,88));//�N"�W�@�B"���s�]�w�j�p�e150�A��60
					Dopanel[0].add(D_HiBuArraybutton[0]);//�N"�W�@�B"���s�[�J��Dopanel[0]
					Dopanel[0].revalidate();//Dopanel[0]�������s����
					Dopanel[0].repaint();//Dopanel[0]�������sø�s
					
					
					cardlayout1.show(panel[4],UPArray[0]);//�NUpanel[0]���
					cardlayout2.show(panel[5],UPArray[0]);//�NDopanel[0]���
					
					System.out.println(FileCH.CALLFILPATH());
					//System.out.println("�˵�---------");
				}else{
					JOptionPane.showMessageDialog(frame,"�|������ɮץH�P�L�k���");
				}
				
				
			}else if((JButton)e.getSource()==D_HiBuArraybutton[0]){//�Y���U��Ƥ��Τ���"�W�@��"���s
				cardlayout1.show(panel[4],CPArray[1]);//�NCpanel[1]���
				cardlayout2.show(panel[5],CPArray[1]);//�NCDpanel[1]���
				
			}else if((JButton)e.getSource()==HiBuArraybutton[1]){//�Y���U��ƲM�~�P�ഫ����"�˵�"���s
				if(FileCH.IsClick()==1){
					readtxt3 = new readtxt_3(FileCH.CALLFILPATH());//�N�ϥΪ̿���ɮ׸��|�ର�r��éI�sreadtxt_3
					Upanel[1].removeAll();//�N���e�ҦbCpanel[4]������i��M��
					Upanel[1].add(readtxt3.CALLTABLE());//�Nreadtxt_3�Ҧ^�Ǥ�JScrollPane�[��Cpanel[0]
					Upanel[1].revalidate();//Cpanel[4]�������s����
					Upanel[1].repaint();//Cpanel[4]�������sø�s
					
					Dopanel[1].removeAll();//�N���e�ҦbCDpanel[4]������i��M��
					Dopanel[1].add(Hint_Label2[1]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��CDpanel[4]
					D_HiBuArraybutton[1].setPreferredSize(new Dimension(190,88));//�N"�W�@�B"���s�]�w�j�p�e150�A��60
					Dopanel[1].add(D_HiBuArraybutton[1]);//�N"�W�@�B"���s�[�J��CDpanel[4]
					Dopanel[1].revalidate();//CDpanel[4]�������s����
					Dopanel[1].repaint();//CDpanel[4]�������sø�s
					
					
					cardlayout1.show(panel[4],UPArray[1]);//�NCpanel[4]���
					cardlayout2.show(panel[5],UPArray[1]);//�NCDpanel[4]���
					
					System.out.println(FileCH.CALLFILPATH());
					System.out.println("�˵�---------22222");
				}else{
					JOptionPane.showMessageDialog(frame,"�|������ɮץH�P�L�k���");
				}
			}else if((JButton)e.getSource()==D_HiBuArraybutton[1]){//�Y���U��ƲM�~�P�ഫ����"�W�@��"���s
				cardlayout1.show(panel[4],CPArray[2]);//�NCpanel[2]���
				cardlayout2.show(panel[5],CPArray[2]);//�NCDpanel[2]���
			}else if((JButton)e.getSource()==HiBuArraybutton[2]){
				if(FileCH.IsClick()==1){
					readtxt4 = new readtxt_3(FileCH.CALLFILPATH());//�N�ϥΪ̿���ɮ׸��|�ର�r��éI�sreadtxt_3
					Upanel[3].removeAll();//�N���e�ҦbUpanel[0]������i��M��
					Upanel[3].add(readtxt4.CALLTABLE());//�Nreadtxt_3�Ҧ^�Ǥ�JScrollPane�[��Upanel[0]
					Upanel[3].revalidate();//Upanel[0]�������s����
					Upanel[3].repaint();//Upanel[0]�������sø�s
					
					Dopanel[3].removeAll();//�N���e�ҦbDopanel[0]������i��M��
					Dopanel[3].add(Hint_Label2[2]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��Dopanel[0]
					D_HiBuArraybutton[2].setPreferredSize(new Dimension(190,88));//�N"�W�@�B"���s�]�w�j�p�e150�A��60
					D_HiBuArraybutton[3].setPreferredSize(new Dimension(190,88));
					Dopanel[3].add(D_HiBuArraybutton[2]);//�N"�W�@�B"���s�[�J��Dopanel[0]
					Dopanel[3].add(D_HiBuArraybutton[3]);
					Dopanel[3].revalidate();//Dopanel[0]�������s����
					Dopanel[3].repaint();//Dopanel[0]�������sø�s
					
					
					cardlayout1.show(panel[4],UPArray[3]);//�NUpanel[0]���
					cardlayout2.show(panel[5],UPArray[3]);//�NDopanel[0]���
					
					System.out.println(FileCH.CALLFILPATH());
					//System.out.println("�˵�---------");
				}else{
					JOptionPane.showMessageDialog(frame,"�|������ɮץH�P�L�k���");
				}
			}else if((JButton)e.getSource()==D_HiBuArraybutton[2]){
				//---------------------------------------------------------------------------
				FileCH=new layouttest1(0);//�N���Φn���~�����ɮצW�����(0�����ܤ��Ϊ���Ƨ�)
				Upanel[4].removeAll();//�N���e�ҦbCpanel[2]������i��M��
				Upanel[4].add(FileCH.CALLFILECH());//�N�^�Ǥ��θ�Ƨ����e�[�J��Cpanel[2]
				Upanel[4].revalidate();//Cpanel[2]�������s����
				Upanel[4].repaint();//Cpanel[2]�������sø�s
						
				Dopanel[4].removeAll();//�N���e�ҦbCDpanel[2]������i��M��
				Dopanel[4].add(Hint_Label2[3]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��CDpanel[2]	
						
				D_HiBuArraybutton[4].setPreferredSize(new Dimension(190,88));//�N"�˵�"���s�]�w�j�p�e150�A��60
				Dopanel[4].add(D_HiBuArraybutton[4]);//�N"�˵�"���s�[�J��CDpanel[2]
				Dopanel[4].revalidate();//CDpanel[2]�������s����
				Dopanel[4].repaint();//CDpanel[2]�������sø�s
			
				cardlayout1.show(panel[4],UPArray[4]);//�NCpanel[2]���
				cardlayout2.show(panel[5],UPArray[4]);//�NCDanel[2]���
			}else if((JButton)e.getSource()==D_HiBuArraybutton[4]){
				if(FileCH.IsClick()==1){
					readtxt5 = new readtxt_3(FileCH.CALLFILPATH());//�N�ϥΪ̿���ɮ׸��|�ର�r��éI�sreadtxt_3
					Upanel[5].removeAll();//�N���e�ҦbUpanel[0]������i��M��
					Upanel[5].add(readtxt5.CALLTABLE());//�Nreadtxt_3�Ҧ^�Ǥ�JScrollPane�[��Upanel[0]
					Upanel[5].revalidate();//Upanel[0]�������s����
					Upanel[5].repaint();//Upanel[0]�������sø�s
					
					Dopanel[5].removeAll();//�N���e�ҦbDopanel[0]������i��M��
					Dopanel[5].add(Hint_Label2[4]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��Dopanel[0]
					D_HiBuArraybutton[5].setPreferredSize(new Dimension(190,88));//�N"�W�@�B"���s�]�w�j�p�e150�A��60
					Dopanel[5].add(D_HiBuArraybutton[5]);//�N"�W�@�B"���s�[�J��Dopanel[0]
					Dopanel[5].revalidate();//Dopanel[0]�������s����
					Dopanel[5].repaint();//Dopanel[0]�������sø�s
					
					
					cardlayout1.show(panel[4],UPArray[5]);//�NUpanel[0]���
					cardlayout2.show(panel[5],UPArray[5]);//�NDopanel[0]���
					
					System.out.println(FileCH.CALLFILPATH());
					//System.out.println("�˵�---------");
				}else{
					JOptionPane.showMessageDialog(frame,"�|������ɮץH�P�L�k���");
				}
			}else if((JButton)e.getSource()==D_HiBuArraybutton[5]){
				cardlayout1.show(panel[4],UPArray[4]);//�NCpanel[2]���
				cardlayout2.show(panel[5],UPArray[4]);//�NCDanel[2]���
			}else if((JButton)e.getSource()==D_HiBuArraybutton[3]){
				cardlayout1.show(panel[4],CPArray[3]);//�NCpanel[3]���
				cardlayout2.show(panel[5],CPArray[3]);//�NCDpanel[3]���
			}else if((JButton)e.getSource()==HiBuArraybutton[3]){
				
				FileCH=new layouttest1(0);//�N���Φn���~�����ɮצW�����(0�����ܤ��Ϊ���Ƨ�)
				Upanel[2].removeAll();//�N���e�ҦbCpanel[2]������i��M��
				Upanel[2].add(FileCH.CALLFILECH());//�N�^�Ǥ��θ�Ƨ����e�[�J��Cpanel[2]
				Upanel[2].revalidate();//Cpanel[2]�������s����
				Upanel[2].repaint();//Cpanel[2]�������sø�s
						
				Dopanel[2].removeAll();//�N���e�ҦbCDpanel[2]������i��M��
				Dopanel[2].add(Hint_Label2[5]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��CDpanel[2]	
						
				D_HiBuArraybutton[6].setPreferredSize(new Dimension(190,88));//�N"�˵�"���s�]�w�j�p�e150�A��60
				Dopanel[2].add(D_HiBuArraybutton[6]);//�N"�˵�"���s�[�J��CDpanel[2]
				Dopanel[2].revalidate();//CDpanel[2]�������s����
				Dopanel[2].repaint();//CDpanel[2]�������sø�s
			
				cardlayout1.show(panel[4],UPArray[2]);//�NCpanel[2]���
				cardlayout2.show(panel[5],UPArray[2]);//�NCDanel[2]���
				
			}else if((JButton)e.getSource()==D_HiBuArraybutton[6]){
				if(FileCH.IsClick()==1){
					readtxt6 = new readtxt_3(FileCH.CALLFILPATH());//�N�ϥΪ̿���ɮ׸��|�ର�r��éI�sreadtxt_3
					Upanel[6].removeAll();//�N���e�ҦbUpanel[0]������i��M��
					Upanel[6].add(readtxt6.CALLTABLE());//�Nreadtxt_3�Ҧ^�Ǥ�JScrollPane�[��Upanel[0]
					Upanel[6].revalidate();//Upanel[0]�������s����
					Upanel[6].repaint();//Upanel[0]�������sø�s
					
					Dopanel[6].removeAll();//�N���e�ҦbDopanel[0]������i��M��
					Dopanel[6].add(Hint_Label2[6]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��Dopanel[0]
					D_HiBuArraybutton[7].setPreferredSize(new Dimension(190,88));//�N"�W�@�B"���s�]�w�j�p�e150�A��60
					Dopanel[6].add(D_HiBuArraybutton[7]);//�N"�W�@�B"���s�[�J��Dopanel[0]
					Dopanel[6].revalidate();//Dopanel[0]�������s����
					Dopanel[6].repaint();//Dopanel[0]�������sø�s
					
					
					cardlayout1.show(panel[4],UPArray[6]);//�NUpanel[0]���
					cardlayout2.show(panel[5],UPArray[6]);//�NDopanel[0]���
					
					System.out.println(FileCH.CALLFILPATH());
					//System.out.println("�˵�---------");
				}else{
					JOptionPane.showMessageDialog(frame,"�|������ɮץH�P�L�k���");
				}
				
			}else if((JButton)e.getSource()==D_HiBuArraybutton[7]){
				cardlayout1.show(panel[4],UPArray[2]);//�NCpanel[2]���
				cardlayout2.show(panel[5],UPArray[2]);//�NCDanel[2]���
			}else if((JButton)e.getSource()==HiBuArraybutton[4]){
				FileCH=new layouttest1(0);//�N���Φn���~�����ɮצW�����(0�����ܤ��Ϊ���Ƨ�)
				Upanel[7].removeAll();//�N���e�ҦbCpanel[2]������i��M��
				Upanel[7].add(FileCH.CALLFILECH());//�N�^�Ǥ��θ�Ƨ����e�[�J��Cpanel[2]
				Upanel[7].revalidate();//Cpanel[2]�������s����
				Upanel[7].repaint();//Cpanel[2]�������sø�s
						
				Dopanel[7].removeAll();//�N���e�ҦbCDpanel[2]������i��M��
				Dopanel[7].add(Hint_Label2[7]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��CDpanel[2]	
						
				D_HiBuArraybutton[8].setPreferredSize(new Dimension(190,88));//�N"�˵�"���s�]�w�j�p�e150�A��60
				Dopanel[7].add(D_HiBuArraybutton[8]);//�N"�˵�"���s�[�J��CDpanel[2]
				Dopanel[7].revalidate();//CDpanel[2]�������s����
				Dopanel[7].repaint();//CDpanel[2]�������sø�s
			
				cardlayout1.show(panel[4],UPArray[7]);//�NCpanel[2]���
				cardlayout2.show(panel[5],UPArray[7]);//�NCDanel[2]���
			}else if((JButton)e.getSource()==D_HiBuArraybutton[8]){
				if(FileCH.IsClick()==1){
					readtxt7 = new readtxt_3(FileCH.CALLFILPATH());//�N�ϥΪ̿���ɮ׸��|�ର�r��éI�sreadtxt_3
					Upanel[8].removeAll();//�N���e�ҦbUpanel[0]������i��M��
					Upanel[8].add(readtxt7.CALLTABLE());//�Nreadtxt_3�Ҧ^�Ǥ�JScrollPane�[��Upanel[0]
					Upanel[8].revalidate();//Upanel[0]�������s����
					Upanel[8].repaint();//Upanel[0]�������sø�s
					
					Dopanel[8].removeAll();//�N���e�ҦbDopanel[0]������i��M��
					Dopanel[8].add(Hint_Label2[8]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��Dopanel[0]
					D_HiBuArraybutton[9].setPreferredSize(new Dimension(190,88));//�N"�W�@�B"���s�]�w�j�p�e150�A��60
					Dopanel[8].add(D_HiBuArraybutton[9]);//�N"�W�@�B"���s�[�J��Dopanel[0]
					Dopanel[8].revalidate();//Dopanel[0]�������s����
					Dopanel[8].repaint();//Dopanel[0]�������sø�s
					
					
					cardlayout1.show(panel[4],UPArray[8]);//�NUpanel[0]���
					cardlayout2.show(panel[5],UPArray[8]);//�NDopanel[0]���
					
					System.out.println(FileCH.CALLFILPATH());
					//System.out.println("�˵�---------");
				}else{
					JOptionPane.showMessageDialog(frame,"�|������ɮץH�P�L�k���");
				}
				
			}else if((JButton)e.getSource()==D_HiBuArraybutton[9]){
				cardlayout1.show(panel[4],UPArray[7]);//�NCpanel[2]���
				cardlayout2.show(panel[5],UPArray[7]);//�NCDanel[2]���
			}else if((JButton)e.getSource()==HiBuArraybutton[5]){
				if(FileCH.IsClick()==1){
					readtxt8 = new readtxt_3(FileCH.CALLFILPATH());//�N�ϥΪ̿���ɮ׸��|�ର�r��éI�sreadtxt_3
					Upanel[9].removeAll();//�N���e�ҦbUpanel[0]������i��M��
					Upanel[9].add(readtxt8.CALLTABLE());//�Nreadtxt_3�Ҧ^�Ǥ�JScrollPane�[��Upanel[0]
					Upanel[9].revalidate();//Upanel[0]�������s����
					Upanel[9].repaint();//Upanel[0]�������sø�s
					
					Dopanel[9].removeAll();//�N���e�ҦbDopanel[0]������i��M��
					Dopanel[9].add(Hint_Label2[9]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��Dopanel[0]
					D_HiBuArraybutton[10].setPreferredSize(new Dimension(190,88));//�N"�W�@�B"���s�]�w�j�p�e150�A��60
					D_HiBuArraybutton[11].setPreferredSize(new Dimension(190,88));
					Dopanel[9].add(D_HiBuArraybutton[10]);//�N"�W�@�B"���s�[�J��Dopanel[0]
					Dopanel[9].add(D_HiBuArraybutton[11]);
					Dopanel[9].revalidate();//Dopanel[0]�������s����
					Dopanel[9].repaint();//Dopanel[0]�������sø�s
					
					
					cardlayout1.show(panel[4],UPArray[9]);//�NUpanel[0]���
					cardlayout2.show(panel[5],UPArray[9]);//�NDopanel[0]���
					
					System.out.println(FileCH.CALLFILPATH());
					//System.out.println("�˵�---------");*/
				}else{
					JOptionPane.showMessageDialog(frame,"�|������ɮץH�P�L�k���");
				}
				
				
				
			}else if((JButton)e.getSource()==D_HiBuArraybutton[10]){
				FileCH=new layouttest1(0);//�N���Φn���~�����ɮצW�����(0�����ܤ��Ϊ���Ƨ�)
				Upanel[10].removeAll();//�N���e�ҦbCpanel[2]������i��M��
				Upanel[10].add(FileCH.CALLFILECH());//�N�^�Ǥ��θ�Ƨ����e�[�J��Cpanel[2]
				Upanel[10].revalidate();//Cpanel[2]�������s����
				Upanel[10].repaint();//Cpanel[2]�������sø�s
						
				Dopanel[10].removeAll();//�N���e�ҦbCDpanel[2]������i��M��
				Dopanel[10].add(Hint_Label2[10]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��CDpanel[2]	
						
				D_HiBuArraybutton[12].setPreferredSize(new Dimension(190,88));//�N"�˵�"���s�]�w�j�p�e150�A��60
				Dopanel[10].add(D_HiBuArraybutton[12]);//�N"�˵�"���s�[�J��CDpanel[2]
				Dopanel[10].revalidate();//CDpanel[2]�������s����
				Dopanel[10].repaint();//CDpanel[2]�������sø�s
			
				cardlayout1.show(panel[4],UPArray[10]);//�NCpanel[2]���
				cardlayout2.show(panel[5],UPArray[10]);//�NCDanel[2]���
			}else if((JButton)e.getSource()==D_HiBuArraybutton[12]){
				if(FileCH.IsClick()==1){
					readtxt9 = new readtxt_3(FileCH.CALLFILPATH());//�N�ϥΪ̿���ɮ׸��|�ର�r��éI�sreadtxt_3
					Upanel[11].removeAll();//�N���e�ҦbUpanel[0]������i��M��
					Upanel[11].add(readtxt9.CALLTABLE());//�Nreadtxt_3�Ҧ^�Ǥ�JScrollPane�[��Upanel[0]
					Upanel[11].revalidate();//Upanel[0]�������s����
					Upanel[11].repaint();//Upanel[0]�������sø�s
					
					Dopanel[11].removeAll();//�N���e�ҦbDopanel[0]������i��M��
					Dopanel[11].add(Hint_Label2[11]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��Dopanel[0]
					D_HiBuArraybutton[13].setPreferredSize(new Dimension(190,88));//�N"�W�@�B"���s�]�w�j�p�e150�A��60
					Dopanel[11].add(D_HiBuArraybutton[13]);//�N"�W�@�B"���s�[�J��Dopanel[0]
					Dopanel[11].revalidate();//Dopanel[0]�������s����
					Dopanel[11].repaint();//Dopanel[0]�������sø�s
					
					
					cardlayout1.show(panel[4],UPArray[11]);//�NUpanel[0]���
					cardlayout2.show(panel[5],UPArray[11]);//�NDopanel[0]���
					
					System.out.println(FileCH.CALLFILPATH());
					//System.out.println("�˵�---------");*/
				}else{
					JOptionPane.showMessageDialog(frame,"�|������ɮץH�P�L�k���");
				}
				
			}else if((JButton)e.getSource()==D_HiBuArraybutton[13]){
				cardlayout1.show(panel[4],UPArray[10]);//�NCpanel[2]���
				cardlayout2.show(panel[5],UPArray[10]);//�NCDanel[2]���
			}else if((JButton)e.getSource()==D_HiBuArraybutton[11]){
				FileCH=new layouttest1(1);//�N���Φn���~�����ɮצW�����(0�����ܤ��Ϊ���Ƨ�)
				Upanel[12].removeAll();//�N���e�ҦbCpanel[2]������i��M��
				Upanel[12].add(FileCH.CALLFILECH());//�N�^�Ǥ��θ�Ƨ����e�[�J��Cpanel[2]
				Upanel[12].revalidate();//Cpanel[2]�������s����
				Upanel[12].repaint();//Cpanel[2]�������sø�s
						
				Dopanel[12].removeAll();//�N���e�ҦbCDpanel[2]������i��M��
				Dopanel[12].add(Hint_Label2[12]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��CDpanel[2]	
						
				D_HiBuArraybutton[14].setPreferredSize(new Dimension(190,88));//�N"�˵�"���s�]�w�j�p�e150�A��60
				D_HiBuArraybutton[15].setPreferredSize(new Dimension(190,88));
				Dopanel[12].add(D_HiBuArraybutton[14]);//�N"�˵�"���s�[�J��CDpanel[2]
				Dopanel[12].add(D_HiBuArraybutton[15]);
				Dopanel[12].revalidate();//CDpanel[2]�������s����
				Dopanel[12].repaint();//CDpanel[2]�������sø�s
			
				cardlayout1.show(panel[4],UPArray[12]);//�NCpanel[2]���
				cardlayout2.show(panel[5],UPArray[12]);//�NCDanel[2]���
			}else if((JButton)e.getSource()==D_HiBuArraybutton[14]){
				FileCH=new layouttest1(0);//�N���Φn���~�����ɮצW�����(0�����ܤ��Ϊ���Ƨ�)
				Upanel[13].removeAll();//�N���e�ҦbCpanel[2]������i��M��
				Upanel[13].add(FileCH.CALLFILECH());//�N�^�Ǥ��θ�Ƨ����e�[�J��Cpanel[2]
				Upanel[13].revalidate();//Cpanel[2]�������s����
				Upanel[13].repaint();//Cpanel[2]�������sø�s
						
				Dopanel[13].removeAll();//�N���e�ҦbCDpanel[2]������i��M��
				Dopanel[13].add(Hint_Label2[13]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��CDpanel[2]	
						
				D_HiBuArraybutton[16].setPreferredSize(new Dimension(190,88));//�N"�˵�"���s�]�w�j�p�e150�A��60
				Dopanel[13].add(D_HiBuArraybutton[16]);//�N"�˵�"���s�[�J��CDpanel[2]
				Dopanel[13].revalidate();//CDpanel[2]�������s����
				Dopanel[13].repaint();//CDpanel[2]�������sø�s
			
				cardlayout1.show(panel[4],UPArray[13]);//�NCpanel[2]���
				cardlayout2.show(panel[5],UPArray[13]);//�NCDanel[2]���
			}else if((JButton)e.getSource()==D_HiBuArraybutton[16]){
				if(FileCH.IsClick()==1){
					readtxt10 = new readtxt_3(FileCH.CALLFILPATH());//�N�ϥΪ̿���ɮ׸��|�ର�r��éI�sreadtxt_3
					Upanel[14].removeAll();//�N���e�ҦbUpanel[0]������i��M��
					Upanel[14].add(readtxt10.CALLTABLE());//�Nreadtxt_3�Ҧ^�Ǥ�JScrollPane�[��Upanel[0]
					Upanel[14].revalidate();//Upanel[0]�������s����
					Upanel[14].repaint();//Upanel[0]�������sø�s
					
					Dopanel[14].removeAll();//�N���e�ҦbDopanel[0]������i��M��
					Dopanel[14].add(Hint_Label2[14]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��Dopanel[0]
					D_HiBuArraybutton[17].setPreferredSize(new Dimension(190,88));//�N"�W�@�B"���s�]�w�j�p�e150�A��60
					Dopanel[14].add(D_HiBuArraybutton[17]);//�N"�W�@�B"���s�[�J��Dopanel[0]
					Dopanel[14].revalidate();//Dopanel[0]�������s����
					Dopanel[14].repaint();//Dopanel[0]�������sø�s
					
					
					cardlayout1.show(panel[4],UPArray[14]);//�NUpanel[0]���
					cardlayout2.show(panel[5],UPArray[14]);//�NDopanel[0]���
					
					System.out.println(FileCH.CALLFILPATH());
					//System.out.println("�˵�---------");*/
				}else{
					JOptionPane.showMessageDialog(frame,"�|������ɮץH�P�L�k���");
				}
				
			}else if((JButton)e.getSource()==D_HiBuArraybutton[17]){
				cardlayout1.show(panel[4],UPArray[13]);//�NCpanel[2]���
				cardlayout2.show(panel[5],UPArray[13]);//�NCDanel[2]���
			}else if((JButton)e.getSource()==D_HiBuArraybutton[15]){
				cardlayout1.show(panel[4],UPArray[9]);//�NUpanel[0]���
				cardlayout2.show(panel[5],UPArray[9]);//�NDopanel[0]���
			}else if((JButton)e.getSource()==HiBuArraybutton[6]){
				if(FileCH.IsClick()==1){
					NOWChFile="";
					readtxt11 = new readtxt_3(FileCH.CALLFILPATH());//�N�ϥΪ̿���ɮ׸��|�ର�r��éI�sreadtxt_3
					Upanel[15].removeAll();//�N���e�ҦbUpanel[0]������i��M��
					Upanel[15].add(readtxt11.CALLTABLE());//�Nreadtxt_3�Ҧ^�Ǥ�JScrollPane�[��Upanel[0]
					Upanel[15].revalidate();//Upanel[0]�������s����
					Upanel[15].repaint();//Upanel[0]�������sø�s
					
					Dopanel[15].removeAll();//�N���e�ҦbDopanel[0]������i��M��
					Dopanel[15].add(Hint_Label2[15]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��Dopanel[0]
					D_HiBuArraybutton[18].setPreferredSize(new Dimension(190,88));//�N"�W�@�B"���s�]�w�j�p�e150�A��60
					D_HiBuArraybutton[19].setPreferredSize(new Dimension(190,88));
					Dopanel[15].add(D_HiBuArraybutton[18]);//�N"�W�@�B"���s�[�J��Dopanel[0]
					Dopanel[15].add(D_HiBuArraybutton[19]);
					Dopanel[15].revalidate();//Dopanel[0]�������s����
					Dopanel[15].repaint();//Dopanel[0]�������sø�s
					
					
					cardlayout1.show(panel[4],UPArray[15]);//�NUpanel[0]���
					cardlayout2.show(panel[5],UPArray[15]);//�NDopanel[0]���
					NOWChFile=FileCH.CALLOnlyName();
					System.out.println(FileCH.CALLOnlyName()+"�}�}�}");
					//System.out.println("�˵�---------");*/
				}else{
					JOptionPane.showMessageDialog(frame,"�|������ɮץH�P�L�k���");
				}
				
				
			}else if((JButton)e.getSource()==D_HiBuArraybutton[18]){
				cardlayout1.show(panel[4],CPArray[6]);//�NCpanel[3]���
				cardlayout2.show(panel[5],CPArray[6]);//�NCDpanel[3]���
			}else if((JButton)e.getSource()==HiBuArraybutton[7]||(JButton)e.getSource()==D_HiBuArraybutton[19]){
				if(FileCH.IsClick()==1){
					NOWChFile=FileCH.CALLOnlyName();
					Object[] options = {"�d������","��t�L�o"};
					
					int mType=JOptionPane.QUESTION_MESSAGE;
					int oType=JOptionPane.YES_NO_CANCEL_OPTION;
					opt1=JOptionPane.showOptionDialog(panel[3], "�ثe��ܪ��ɮ׬�"+NOWChFile+"\n�п�ܯS�x�����k","�п��",oType,mType,null,options,options[0]) ;
					Upanel[16].removeAll();//�N���e�ҦbUpanel[0]������i��M��
					
					try{
						FileWriter fw = new FileWriter("javatoc");
						data_cuwachfe_path=FileCH.CALLFILPATH();//s�O�ɮ׸��|
						fw.write(data_cuwachfe_path);
						fw.flush();
						fw.close();
						System.out.println("�S�x����Ƽg�ɤ�--------------------");
						cortana = new Cortana(FileCH.CALLFILPATH());
						if(opt1==0){
							listpanel=new layouttest2_2(FileCH.CALLFILPATH().replace("Wa_Ch", "Feature").replace(".csv", "_CHi2.txt"),0,cortana.getPath());	
							/*���X���ݵ��� START*/
							JOptionPane WaitPanel3 =new JOptionPane(ProMesArray[2], JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
							JDialog Waitdialog3 = new JDialog();
							Waitdialog3.setModal(true);
							Waitdialog3.setContentPane(WaitPanel3);
							
							Waitdialog3.pack();
							Dimension screenSize2 = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
							Dimension GIFdialogSize = Waitdialog3.getSize();
							Waitdialog3.setLocation(screenSize2.width/2-GIFdialogSize.width/2,screenSize2.height/2-GIFdialogSize.height/2);
							Waitdialog3.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
							System.out.println("�S�x���椤--------------------");
							
							new Thread(new Runnable() {
							  @Override
							  public void run() {
								try {
								 // process.waitFor();
								 Thread.sleep(1000);
								} catch (Exception e) {
								 System.out.println(e);
								}
								Waitdialog3.setVisible(false);
							  }
							}).start();
							Waitdialog3.setVisible(true);
							JOptionPane.showMessageDialog(frame,ProEndMesArray[4]);	
							
							Upanel[16].add(listpanel.CALLLISTPANEL());//�Nreadtxt_3�Ҧ^�Ǥ�JScrollPane�[��Upanel[0]
							Upanel[16].revalidate();//Upanel[0]�������s����
							Upanel[16].repaint();//Upanel[0]�������sø�s
							Dopanel[16].removeAll();//�N���e�ҦbDopanel[0]������i��M��
							Dopanel[16].add(Hint_Label2[16]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��Dopanel[0]
							D_HiBuArraybutton[20].setPreferredSize(new Dimension(190,88));//�N"�W�@�B"���s�]�w�j�p�e150�A��60
							D_HiBuArraybutton[21].setPreferredSize(new Dimension(190,88));
							Dopanel[16].add(D_HiBuArraybutton[20]);//�N"�W�@�B"���s�[�J��Dopanel[0]
							D_HiBuArraybutton[20].setEnabled(false);
							Dopanel[16].add(D_HiBuArraybutton[21]);
							Dopanel[16].revalidate();//Dopanel[0]�������s����
							Dopanel[16].repaint();//Dopanel[0]�������sø�s
							cardlayout1.show(panel[4],UPArray[16]);//�NUpanel[0]���
							cardlayout2.show(panel[5],UPArray[16]);//�NDopanel[0]���
							/*���X���ݵ��� END*/					
						}else if(opt1==1){
							listpanel=new layouttest2_2(FileCH.CALLFILPATH().replace("Wa_Ch", "Feature").replace(".csv", "_FT.txt"),1,cortana.getPath());	
							/*���X���ݵ��� START*/
							JOptionPane WaitPanel3 =new JOptionPane(ProMesArray[2], JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
							JDialog Waitdialog3 = new JDialog();
							Waitdialog3.setModal(true);
							Waitdialog3.setContentPane(WaitPanel3);
							
							Waitdialog3.pack();
							Dimension screenSize2 = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
							Dimension GIFdialogSize = Waitdialog3.getSize();
							Waitdialog3.setLocation(screenSize2.width/2-GIFdialogSize.width/2,screenSize2.height/2-GIFdialogSize.height/2);
							Waitdialog3.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
							System.out.println("�S�x���椤--------------------");
							
							new Thread(new Runnable() {
							  @Override
							  public void run() {
								try {
								 // process.waitFor();
									Thread.sleep(1000);
								} catch (Exception e) {
								 System.out.println(e);
								}
								Waitdialog3.setVisible(false);
							  }
							}).start();
							Waitdialog3.setVisible(true);
							JOptionPane.showMessageDialog(frame,ProEndMesArray[4]);	
							Upanel[16].add(listpanel.CALLLISTPANEL());//�Nreadtxt_3�Ҧ^�Ǥ�JScrollPane�[��Upanel[0]
							Upanel[16].revalidate();//Upanel[0]�������s����
							Upanel[16].repaint();//Upanel[0]�������sø�s
							Dopanel[16].removeAll();//�N���e�ҦbDopanel[0]������i��M��
							Dopanel[16].add(Hint_Label2[16]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��Dopanel[0]
							D_HiBuArraybutton[20].setPreferredSize(new Dimension(190,88));//�N"�W�@�B"���s�]�w�j�p�e150�A��60
							D_HiBuArraybutton[21].setPreferredSize(new Dimension(190,88));
							Dopanel[16].add(D_HiBuArraybutton[20]);//�N"�W�@�B"���s�[�J��Dopanel[0]
							D_HiBuArraybutton[20].setEnabled(false);
							Dopanel[16].add(D_HiBuArraybutton[21]);
							Dopanel[16].revalidate();//Dopanel[0]�������s����
							Dopanel[16].repaint();//Dopanel[0]�������sø�s
							cardlayout1.show(panel[4],UPArray[16]);//�NUpanel[0]���
							cardlayout2.show(panel[5],UPArray[16]);//�NDopanel[0]���	
						}
						
						
						
						}catch(Exception v){
							System.out.println("�S�x������~");
						}
	/*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
					//cortana = new Cortana(FileCH.CALLFILPATH());
				}else{
					JOptionPane.showMessageDialog(frame,"�|������ɮ�");
				}	
				
				
			}else if((JButton)e.getSource()==HiBuArraybutton[9]||(JButton)e.getSource()==D_HiBuArraybutton[21]){
				ImageIcon image=new ImageIcon(ClickbtArray[3]);
				button[3].setIcon(image);
				D_HiBuArraybutton[20].setEnabled(true);
				HiBuArraybutton[8].setEnabled(true);
				JOptionPane.showMessageDialog(frame,MesArray[3]);
				Fet_Flag=1;
				FetSav_Flag=0;
				System.out.println(listpanel.CALLFEATURENUM()+"---------------------------------123");
				ArrayList<Integer> Feature=new ArrayList<Integer>();
				Collections.sort(listpanel.addFeaturenum);
				Collections.sort(listpanel.defaFeaturenum);
				
				featuresave= new FeatureSave(listpanel.CALLFEATURENUM(),FileCH.CALLFILPATH(),FileCH.CALLOnlyName());
				
				//---------------------------------------------------------------------------------------------------------------
				
			}else if((JButton)e.getSource()==HiBuArraybutton[8]){
				
				Upanel[17].removeAll();//�N���e�ҦbUpanel[0]������i��M��
				readtxt12 = new readtxt_3(featuresave.getOutPath());//�N�ϥΪ̿���ɮ׸��|�ର�r��éI�sreadtxt_3
				Upanel[17].add(readtxt12.CALLTABLE());//�Nreadtxt_3�Ҧ^�Ǥ�JScrollPane�[��Upanel[0]
				Upanel[17].revalidate();//Upanel[0]�������s����
				Upanel[17].repaint();//Upanel[0]�������sø�s
				
				Dopanel[17].removeAll();//�N���e�ҦbDopanel[0]������i��M��
				Dopanel[17].add(Hint_Label2[17]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��Dopanel[0]
				D_HiBuArraybutton[22].setPreferredSize(new Dimension(190,88));//�N"�W�@�B"���s�]�w�j�p�e150�A��60
				Dopanel[17].add(D_HiBuArraybutton[22]);//�N"�W�@�B"���s�[�J��Dopanel[0]
				Dopanel[17].revalidate();//Dopanel[0]�������s����
				Dopanel[17].repaint();//Dopanel[0]�������sø�s
				
				
				cardlayout1.show(panel[4],UPArray[17]);//�NUpanel[0]���
				cardlayout2.show(panel[5],UPArray[17]);//�NDopanel[0]���
				
				System.out.println(FileCH.CALLFILPATH());
			}else if((JButton)e.getSource()==D_HiBuArraybutton[22]){
				HiBuArraybutton[8].setEnabled(true);
				
				cardlayout1.show(panel[4],CPArray[7]);//�NUpanel[0]���
				cardlayout2.show(panel[5],CPArray[7]);//�NDopanel[0]���
			}else if((JButton)e.getSource()==D_HiBuArraybutton[20]){
				readtxt13 = new readtxt_3(featuresave.getOutPath());//�N�ϥΪ̿���ɮ׸��|�ର�r��éI�sreadtxt_3
				Upanel[18].removeAll();//�N���e�ҦbUpanel[0]������i��M��
				Upanel[18].add(readtxt13.CALLTABLE());//�Nreadtxt_3�Ҧ^�Ǥ�JScrollPane�[��Upanel[0]
				Upanel[18].revalidate();//Upanel[0]�������s����
				Upanel[18].repaint();//Upanel[0]�������sø�s
				
				Dopanel[18].removeAll();//�N���e�ҦbDopanel[0]������i��M��
				Dopanel[18].add(Hint_Label2[18]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��Dopanel[0]
				D_HiBuArraybutton[23].setPreferredSize(new Dimension(190,88));//�N"�W�@�B"���s�]�w�j�p�e150�A��60
				Dopanel[18].add(D_HiBuArraybutton[23]);//�N"�W�@�B"���s�[�J��Dopanel[0]
				Dopanel[18].revalidate();//Dopanel[0]�������s����
				Dopanel[18].repaint();//Dopanel[0]�������sø�s
				
				
				cardlayout1.show(panel[4],UPArray[18]);//�NUpanel[0]���
				cardlayout2.show(panel[5],UPArray[18]);//�NDopanel[0]���
				
				System.out.println(FileCH.CALLFILPATH());
			}else if((JButton)e.getSource()==D_HiBuArraybutton[23]){
				D_HiBuArraybutton[20].setEnabled(true);
				cardlayout1.show(panel[4],UPArray[16]);//�NUpanel[0]���
				cardlayout2.show(panel[5],UPArray[16]);//�NDopanel[0]���
			}else if((JButton)e.getSource()==HiBuArraybutton[10]){
				readtxt14 = new readtxt_3(FileCH.CALLFILPATH());//�N�ϥΪ̿���ɮ׸��|�ର�r��éI�sreadtxt_3
				Upanel[19].removeAll();//�N���e�ҦbUpanel[0]������i��M��
				Upanel[19].add(readtxt14.CALLTABLE());//�Nreadtxt_3�Ҧ^�Ǥ�JScrollPane�[��Upanel[0]
				Upanel[19].revalidate();//Upanel[0]�������s����
				Upanel[19].repaint();//Upanel[0]�������sø�s
				
				Dopanel[19].removeAll();//�N���e�ҦbDopanel[0]������i��M��
				Dopanel[19].add(Hint_Label2[19]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��Dopanel[0]
				D_HiBuArraybutton[24].setPreferredSize(new Dimension(190,88));//�N"�W�@�B"���s�]�w�j�p�e150�A��60
				Dopanel[19].add(D_HiBuArraybutton[24]);//�N"�W�@�B"���s�[�J��Dopanel[0]
				Dopanel[19].revalidate();//Dopanel[0]�������s����
				Dopanel[19].repaint();//Dopanel[0]�������sø�s
				
				
				cardlayout1.show(panel[4],UPArray[19]);//�NUpanel[0]���
				cardlayout2.show(panel[5],UPArray[19]);//�NDopanel[0]���
				
				System.out.println(FileCH.CALLFILPATH());
				
			}else if((JButton)e.getSource()==D_HiBuArraybutton[24]){
				cardlayout1.show(panel[4],CPArray[8]);//�NCpanel[3]���
				cardlayout2.show(panel[5],CPArray[8]);//�NCDpanel[3]���
				
			}else if((JButton)e.getSource()==HiBuArraybutton[11]){
				if(FileCH.IsClick()==1){
					readtxt15 = new readtxt_3(FileCH.CALLFILPATH());//�N�ϥΪ̿���ɮ׸��|�ର�r��éI�sreadtxt_3
					Upanel[20].removeAll();//�N���e�ҦbUpanel[0]������i��M��
					Upanel[20].add(readtxt15.CALLTABLE());//�Nreadtxt_3�Ҧ^�Ǥ�JScrollPane�[��Upanel[0]
					Upanel[20].revalidate();//Upanel[0]�������s����
					Upanel[20].repaint();//Upanel[0]�������sø�s
					
					Dopanel[20].removeAll();//�N���e�ҦbDopanel[0]������i��M��
					Dopanel[20].add(Hint_Label2[20]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��Dopanel[0]
					D_HiBuArraybutton[25].setPreferredSize(new Dimension(190,88));//�N"�W�@�B"���s�]�w�j�p�e150�A��60
					Dopanel[20].add(D_HiBuArraybutton[25]);//�N"�W�@�B"���s�[�J��Dopanel[0]
					Dopanel[20].revalidate();//Dopanel[0]�������s����
					Dopanel[20].repaint();//Dopanel[0]�������sø�s
					
					
					cardlayout1.show(panel[4],UPArray[20]);//�NUpanel[0]���
					cardlayout2.show(panel[5],UPArray[20]);//�NDopanel[0]���
					
					System.out.println(FileCH.CALLFILPATH());
				}else{
					JOptionPane.showMessageDialog(frame,"�|������ɮץH�P�L�k���");
				}
				
			}else if((JButton)e.getSource()==D_HiBuArraybutton[25]){
				cardlayout1.show(panel[4],CPArray[10]);//�NCpanel[3]���
				cardlayout2.show(panel[5],CPArray[10]);//�NCDpanel[3]���
				
			}else if((JButton)e.getSource()==HiBuArraybutton[12]){
				if(FileCH.IsClick()==1){
					//Object[] options = {"�H���˪L","�˶ǻ����g����","�l�s�ձ��ɲέp��k���R"};
					Object[] options = {"�H���˪L","�l�s�ձ��ɲέp��k���R"};
					
					int mType=JOptionPane.QUESTION_MESSAGE;
					int oType=JOptionPane.YES_NO_CANCEL_OPTION;
					
					int opt2=JOptionPane.showOptionDialog(panel[3], "�п�ܭn�Ыت��ҫ�","�п��",oType,mType,null,options,options[0]);
					System.out.println("���ո��|--------------------"+FileCH.CALLFILPATH());
					
					if(opt2==0){
						try{
							FileWriter fw = new FileWriter("javatoc");
							data_cuwachfe_path=FileCH.CALLFILPATH();//s�O�ɮ׸��|
							fw.write(data_cuwachfe_path);
							fw.flush();
							fw.close();
								
							//�I�s�~���{��
								
							/*���X���ݵ��� START*/
							JOptionPane WaitPanel3 =new JOptionPane(ProMesArray[3], JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
							JDialog Waitdialog3 = new JDialog();
							Waitdialog3.setModal(true);
							Waitdialog3.setContentPane(WaitPanel3);
									
							Waitdialog3.pack();
							Dimension screenSize3 = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
							Dimension GIFdialogSize = Waitdialog3.getSize();
							Waitdialog3.setLocation(screenSize3.width/2-GIFdialogSize.width/2,screenSize3.height/2-GIFdialogSize.height/2);
							Waitdialog3.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
							System.out.println("�ؼҰ��椤--------------------");
								
							new Thread(new Runnable() {
								@Override
								public void run() {
								try {
									 //process.waitFor();
									RF_Cexe Rf_C_exe= new RF_Cexe();
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								Waitdialog3.setVisible(false);
								}
							}).start();
							Waitdialog3.setVisible(true);
								/*���X���ݵ��� END*/
							JOptionPane.showMessageDialog(frame,ProEndMesArray[2]);
							ImageIcon image=new ImageIcon(ClickbtArray[4]);
							button[4].setIcon(image);
							BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(new File("ctojava")))); 
							fetxarea = new testtextarea (bf.readLine());
						}catch(Exception v){
							System.out.println(v);
						}
									
									
							
					}else if(opt2==1){
						System.out.println("���a���ؼҪ����|--------------------"+FileCH.CALLFILPATH().replace("Feature","Wa_Ch"));
							
						cortana2 = new Cortana2(FileCH.CALLFILPATH().replace("Feature","Wa_Ch"));
						try{
							//FileWriter fw = new FileWriter("javatoc");
							//data_cuwachfe_path=featuresave.getOutPath();//s�O�ɮ׸��|
							//fw.write(data_cuwachfe_path);
							//fw.flush();
							//fw.close();
								
							//�I�s�~���{��
								
							/*���X���ݵ��� START*/
							JOptionPane WaitPanel3 =new JOptionPane(ProMesArray[3], JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
							JDialog Waitdialog3 = new JDialog();
							Waitdialog3.setModal(true);
							Waitdialog3.setContentPane(WaitPanel3);
									
							Waitdialog3.pack();
							Dimension screenSize3 = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
							Dimension GIFdialogSize = Waitdialog3.getSize();
							Waitdialog3.setLocation(screenSize3.width/2-GIFdialogSize.width/2,screenSize3.height/2-GIFdialogSize.height/2);
							Waitdialog3.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
							System.out.println("�ؼ�2���椤--------------------");
								
								
							new Thread(new Runnable() {
								@Override
								public void run() {
								try {
									//process.waitFor();
									  
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								Waitdialog3.setVisible(false);
								}
							}).start();
							Waitdialog3.setVisible(true);
							/*���X���ݵ��� END*/
							JOptionPane.showMessageDialog(frame,ProEndMesArray[2]);
							ImageIcon image=new ImageIcon(ClickbtArray[4]);
							button[4].setIcon(image);
							//System.out.println("�̫�a���^�Ǹ��|---"+cortana2.getPath());
							fetxarea = new testtextarea (cortana2.getPath());
						}catch(Exception v){
							System.out.println(v);
						}
									
					}
					//JOptionPane.showMessageDialog(frame,MesArray[6]);
					 
					
					Upanel[21].removeAll();//�N���e�ҦbUpanel[0]������i��M��
					
					Upanel[21].add(Box.createRigidArea(new Dimension(30, 30)), BorderLayout.NORTH);
					Upanel[21].add(Box.createRigidArea(new Dimension(30, 30)), BorderLayout.EAST);
					Upanel[21].add(Box.createRigidArea(new Dimension(30, 30)), BorderLayout.SOUTH);
					Upanel[21].add(Box.createRigidArea(new Dimension(30, 30)), BorderLayout.WEST);
					Upanel[21].add(fetxarea.CALLTEXTAREA(), BorderLayout.CENTER);
					Upanel[21].revalidate();//Upanel[0]�������s����
					Upanel[21].repaint();//Upanel[0]�������sø�s
					
					Dopanel[21].removeAll();//�N���e�ҦbDopanel[0]������i��M��
					Dopanel[21].add(Hint_Label2[21]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��Dopanel[0]
					Dopanel[21].revalidate();//Dopanel[0]�������s����
					Dopanel[21].repaint();//Dopanel[0]�������sø�s
					
					
					cardlayout1.show(panel[4],UPArray[21]);//�NUpanel[0]���
					cardlayout2.show(panel[5],UPArray[21]);//�NDopanel[0]���
					
					System.out.println(FileCH.CALLFILPATH());
					Mod_Flag=1;
				}else{
					JOptionPane.showMessageDialog(frame,"�|������ɮ�");
				}
					
			
				
			}else if((JButton)e.getSource()==D_HiBuArraybutton[26]){
				cardlayout1.show(panel[4],CPArray[17]);//�NCpanel[3]���
				cardlayout2.show(panel[5],CPArray[17]);//�NCDpanel[3]���
			}else if((JButton)e.getSource()==D_HiBuArraybutton[27]){
				FileCH=new layouttest1(4);//�N���Φn���~�����ɮצW�����(0�����ܤ��Ϊ���Ƨ�)
				Upanel[23].removeAll();//�N���e�ҦbCpanel[2]������i��M��
				Upanel[23].add(FileCH.CALLFILECH());//�N�^�Ǥ��θ�Ƨ����e�[�J��Cpanel[2]
				Upanel[23].revalidate();//Cpanel[2]�������s����
				Upanel[23].repaint();//Cpanel[2]�������sø�s
						
				Dopanel[23].removeAll();//�N���e�ҦbCDpanel[2]������i��M��
				Dopanel[23].add(Hint_Label2[23]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��CDpanel[2]	
				D_HiBuArraybutton[28].setPreferredSize(new Dimension(190,88));
				D_HiBuArraybutton[29].setPreferredSize(new Dimension(190,88));//�N"�˵�"���s�]�w�j�p�e150�A��60
				Dopanel[23].add(D_HiBuArraybutton[28]);//�N"�˵�"���s�[�J��CDpanel[2]
				Dopanel[23].add(D_HiBuArraybutton[29]);
				Dopanel[23].revalidate();//CDpanel[2]�������s����
				Dopanel[23].repaint();//CDpanel[2]�������sø�s
			
				cardlayout1.show(panel[4],UPArray[23]);//�NCpanel[2]���
				cardlayout2.show(panel[5],UPArray[23]);//�NCDanel[2]���
			}else if((JButton)e.getSource()==D_HiBuArraybutton[28]){
				if(FileCH.IsClick()==1){
					readtxt18 = new readtxt_3(FileCH.CALLFILPATH());//�N�ϥΪ̿���ɮ׸��|�ର�r��éI�sreadtxt_3
					Upanel[24].removeAll();//�N���e�ҦbUpanel[0]������i��M��
					Upanel[24].add(readtxt18.CALLTABLE());//�Nreadtxt_3�Ҧ^�Ǥ�JScrollPane�[��Upanel[0]
					Upanel[24].revalidate();//Upanel[0]�������s����
					Upanel[24].repaint();//Upanel[0]�������sø�s
					
					Dopanel[24].removeAll();//�N���e�ҦbDopanel[0]������i��M��
					Dopanel[24].add(Hint_Label2[24]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��Dopanel[0]
					D_HiBuArraybutton[30].setPreferredSize(new Dimension(190,88));//�N"�W�@�B"���s�]�w�j�p�e150�A��60
					D_HiBuArraybutton[31].setPreferredSize(new Dimension(190,88));
					Dopanel[24].add(D_HiBuArraybutton[30]);//�N"�W�@�B"���s�[�J��Dopanel[0]
					Dopanel[24].add(D_HiBuArraybutton[31]);
					Dopanel[24].revalidate();//Dopanel[0]�������s����
					Dopanel[24].repaint();//Dopanel[0]�������sø�s
					
					
					cardlayout1.show(panel[4],UPArray[24]);//�NUpanel[0]���
					cardlayout2.show(panel[5],UPArray[24]);//�NDopanel[0]���
					
					System.out.println(FileCH.CALLFILPATH());
				}else{
					JOptionPane.showMessageDialog(frame,"�|������ɮץH�P�L�k���");
				}
				
				
			}else if((JButton)e.getSource()==D_HiBuArraybutton[30]){
				cardlayout1.show(panel[4],UPArray[23]);//�NCpanel[2]���
				cardlayout2.show(panel[5],UPArray[23]);//�NCDanel[2]���
				
			}else if((JButton)e.getSource()==D_HiBuArraybutton[31]){
				
				/*���X���ݵ��� START*/
				JOptionPane WaitPanel3 =new JOptionPane(ProMesArray[6], JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
				JDialog Waitdialog3 = new JDialog();
				Waitdialog3.setModal(true);
				Waitdialog3.setContentPane(WaitPanel3);
					
				Waitdialog3.pack();
				Dimension screenSize3 = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
				Dimension GIFdialogSize = Waitdialog3.getSize();
				Waitdialog3.setLocation(screenSize3.width/2-GIFdialogSize.width/2,screenSize3.height/2-GIFdialogSize.height/2);
				Waitdialog3.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
				
				
				
				new Thread(new Runnable() {
				  @Override
				  public void run() {
					try {
					  //process.waitFor();
					  
					  Thread.sleep(5000);
					} catch (InterruptedException e) {
					  e.printStackTrace();
					}
					Waitdialog3.setVisible(false);
				  }
				}).start();
				Waitdialog3.setVisible(true);
				/*���X���ݵ��� END*/
			/*----------------------------------------------------------------------------------------------------------------*/	
				JOptionPane.showMessageDialog(frame,MesArray[14]);
				Eva_Flag=1;
				
				readtxt19 = new readtxt_3(FileCH.CALLFILPATH());//�N�ϥΪ̿���ɮ׸��|�ର�r��éI�sreadtxt_3
				Upanel[25].removeAll();//�N���e�ҦbUpanel[0]������i��M��
				Upanel[25].add(readtxt19.CALLTABLE());//�Nreadtxt_3�Ҧ^�Ǥ�JScrollPane�[��Upanel[0]
				Upanel[25].revalidate();//Upanel[0]�������s����
				Upanel[25].repaint();//Upanel[0]�������sø�s
				
				Dopanel[25].removeAll();//�N���e�ҦbDopanel[0]������i��M��
				Dopanel[25].add(Hint_Label2[25]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��Dopanel[0]
				
				
				Dopanel[25].revalidate();//Dopanel[0]�������s����
				Dopanel[25].repaint();//Dopanel[0]�������sø�s
				
				
				cardlayout1.show(panel[4],UPArray[25]);//�NUpanel[0]���
				cardlayout2.show(panel[5],UPArray[25]);//�NDopanel[0]���
				
				System.out.println(FileCH.CALLFILPATH());
			}else if((JButton)e.getSource()==D_HiBuArraybutton[29]){
				/*���X���ݵ��� START*/
				JOptionPane WaitPanel3 =new JOptionPane(ProMesArray[6], JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
				JDialog Waitdialog3 = new JDialog();
				Waitdialog3.setModal(true);
				Waitdialog3.setContentPane(WaitPanel3);
					
				Waitdialog3.pack();
				Dimension screenSize3 = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
				Dimension GIFdialogSize = Waitdialog3.getSize();
				Waitdialog3.setLocation(screenSize3.width/2-GIFdialogSize.width/2,screenSize3.height/2-GIFdialogSize.height/2);
				Waitdialog3.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
				
				
				
				new Thread(new Runnable() {
				  @Override
				  public void run() {
					try {
					  //process.waitFor();
					  
					  Thread.sleep(5000);
					} catch (InterruptedException e) {
					  e.printStackTrace();
					}
					Waitdialog3.setVisible(false);
				  }
				}).start();
				Waitdialog3.setVisible(true);
				/*���X���ݵ��� END*/
				/*----------------------------------------------------------------------------------------------------------------*/	
				JOptionPane.showMessageDialog(frame,MesArray[15]);
				Eva_Flag=1;
				readtxt20 = new readtxt_3(FileCH.CALLFILPATH());//�N�ϥΪ̿���ɮ׸��|�ର�r��éI�sreadtxt_3
				Upanel[26].removeAll();//�N���e�ҦbUpanel[0]������i��M��
				Upanel[26].add(readtxt20.CALLTABLE());//�Nreadtxt_3�Ҧ^�Ǥ�JScrollPane�[��Upanel[0]
				Upanel[26].revalidate();//Upanel[0]�������s����
				Upanel[26].repaint();//Upanel[0]�������sø�s
				
				Dopanel[26].removeAll();//�N���e�ҦbDopanel[0]������i��M��
				Dopanel[26].add(Hint_Label2[26]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��Dopanel[0]
				
				
				Dopanel[26].revalidate();//Dopanel[0]�������s����
				Dopanel[26].repaint();//Dopanel[0]�������sø�s
				
				
				cardlayout1.show(panel[4],UPArray[26]);//�NUpanel[0]���
				cardlayout2.show(panel[5],UPArray[26]);//�NDopanel[0]���
				
				System.out.println(FileCH.CALLFILPATH());
	
			}else if((JButton)e.getSource()==D_HiBuArraybutton[32]){
				if(FileCH2.IsClick()==1){
					fetxarea = new testtextarea (FileCH2.CALLFILPATH());//�N�ϥΪ̿���ɮ׸��|�ର�r��éI�sreadtxt_3
					Upanel[28].removeAll();//�N���e�ҦbUpanel[0]������i��M��
					Upanel[28].add(Box.createRigidArea(new Dimension(15, 15)), BorderLayout.NORTH);
					Upanel[28].add(Box.createRigidArea(new Dimension(15, 15)), BorderLayout.EAST);
					Upanel[28].add(Box.createRigidArea(new Dimension(15, 15)), BorderLayout.SOUTH);
					Upanel[28].add(Box.createRigidArea(new Dimension(15, 15)), BorderLayout.WEST);
					Upanel[28].add(fetxarea.CALLTEXTAREA());//�Nreadtxt_3�Ҧ^�Ǥ�JScrollPane�[��Upanel[0]
					Upanel[28].revalidate();//Upanel[0]�������s����
					Upanel[28].repaint();//Upanel[0]�������sø�s
					
					Dopanel[28].removeAll();//�N���e�ҦbDopanel[0]������i��M��
					Dopanel[28].add(Hint_Label2[28]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��Dopanel[0]
					D_HiBuArraybutton[34].setPreferredSize(new Dimension(190,88));//�N"�W�@�B"���s�]�w�j�p�e150�A��60
					D_HiBuArraybutton[35].setPreferredSize(new Dimension(190,88));
					Dopanel[28].add(D_HiBuArraybutton[34]);//�N"�W�@�B"���s�[�J��Dopanel[0]
					Dopanel[28].add(D_HiBuArraybutton[35]);
					Dopanel[28].revalidate();//Dopanel[0]�������s����
					Dopanel[28].repaint();//Dopanel[0]�������sø�s
					
					
					cardlayout1.show(panel[4],UPArray[28]);//�NUpanel[0]���
					cardlayout2.show(panel[5],UPArray[28]);//�NDopanel[0]���
					
					//System.out.println(FileCH.CALLFILPATH());
				}else{
					JOptionPane.showMessageDialog(frame,"�|������ɮץH�P�L�k���");
				}
				
			}else if((JButton)e.getSource()==D_HiBuArraybutton[34]){
				cardlayout1.show(panel[4],CPArray[17]);//�NCpanel[2]���
				cardlayout2.show(panel[5],CPArray[17]);//�NCDanel[2]���
				
			}else if((JButton)e.getSource()==D_HiBuArraybutton[35]){
				System.out.println("ru.4g45k4u4");
				/*���X���ݵ��� START*/
				JOptionPane WaitPanel3 =new JOptionPane(ProMesArray[6], JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
				JDialog Waitdialog3 = new JDialog();
				Waitdialog3.setModal(true);
				Waitdialog3.setContentPane(WaitPanel3);
					
				Waitdialog3.pack();
				Dimension screenSize3 = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
				Dimension GIFdialogSize = Waitdialog3.getSize();
				Waitdialog3.setLocation(screenSize3.width/2-GIFdialogSize.width/2,screenSize3.height/2-GIFdialogSize.height/2);
				Waitdialog3.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
				
				
				new Thread(new Runnable() {
				  @Override
				  public void run() {
					try {
					  //process.waitFor();
					  
					  //Thread.sleep(5000);
					  /*�N�ϥΪ̩ҿ��ɮ��ন�ҫ��ɼg�Jjavatoc2*/
						String predicttofun=null;
						String predictosee=null;
						predicttofun=FileCH2.CALLFILPATH();
						predictosee=FileCH2.CALLFILPATH();
						if(predicttofun.contains("_RF")){
							predicttofun=predicttofun.replace(".txt", ".pkl");
						}else if(predicttofun.contains("_SubDisc")){
							predicttofun=predicttofun.replace(".txt", ".txt");
						}else if(predicttofun.contains("_BPNN")){
							predicttofun=predicttofun.replace(".txt", ".h5");
						}
						
						
						FileWriter fw = new FileWriter("javatoc2");
						fw.write(predicttofun);
						fw.flush();
						fw.close();
						
						
						//System.out.println("�ǵ��U�쪺���|�W��1 �G "+predicttofun);
						
						/*�N�ϥΪ̩ҿ��ɮ��ন�ҫ��ɼg�Jjavatoc2*/
						
						/*��ƲM�~�P�ഫ�I�s�~���{���g��*/
						BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(new File("ctojava"))));  
						String cuttowa = bf.readLine();
						//System.out.println("��ܶǵ��U�쪺���|�W��2 �G "+cuttowa);
						String Modeljud=cuttowa+FileCH2.CALLOnlyName();
						
						//String Modeljud="Hos_Data\\Doc_Test\\Cut\\2020\\"+FileCH2.CALLOnlyName();
						FileWriter fw2 = new FileWriter("javatoc");
						if(Modeljud.contains("_RF")){
							data_cuwachfe_path=Modeljud.replace("_RF.txt", ".csv");
						}else if(Modeljud.contains("_SubDisc")){
							data_cuwachfe_path=Modeljud.replace("_SubDisc.txt", ".csv");
						}else if(Modeljud.contains("_BPNN")){
							data_cuwachfe_path=Modeljud.replace("_BPNN.txt", ".csv");
						}
						//System.out.println("�����ɦW���|��3"+data_cuwachfe_path);
							
						fw2.write(data_cuwachfe_path);
						fw2.flush();
						fw2.close();
										
						//�I�s�~���{��
						Runtime runtime=Runtime.getRuntime();             
						Process process = runtime.exec("Data_TransForm_P2_1.exe");//file������~���{�����ɮצW��             
						//System.out.println("�M�~�P�ഫ2���椤--------------------");
						process.waitFor();
							
						
						/*�S�x����x�s�ɮ�*/
						String FeaTuresave1=null;
						String FeaTuresave2=null;
						if(predicttofun.contains("_RF.pkl")){
							FeaTuresave1=predicttofun.replace("Model", "Feature").replace("_RF.pkl", ".txt");
						}else if(predicttofun.contains("_SubDisc.txt")){
							FeaTuresave1=predicttofun.replace("Model", "Feature").replace("_SubDisc.txt", ".txt");
						}else if(predicttofun.contains("_BPNN.h5")){
							FeaTuresave1=predicttofun.replace("Model", "Feature").replace("_BPNN.h5", ".txt");
						}
						
						FeaTuresave2=data_cuwachfe_path.replace("Cut", "Wa_Ch");
						//System.out.println("�ǵ�FEATURESAVE14 "+FeaTuresave1);
						//System.out.println("�ǵ�FEATURESAVE25 "+FeaTuresave2);
						featuresave2 = new FeatureSave2(FeaTuresave2,FeaTuresave1);
						
						
						FileWriter fw3 = new FileWriter("javatoc");
						//System.out.println("FEATURESAVE2�Ǧ^�Ӫ����|6 "+featuresave2.getOutPath());
						fw3.write(featuresave2.getOutPath());
						fw3.flush();
						fw3.close();
						
						/*�S�x����x�s�ɮ�*/
						if(Modeljud.contains("_RF")){
							RFPredictexe Rfpredict = new RFPredictexe();
						}else if(Modeljud.contains("_SubDisc")){
							Runtime runtime2=Runtime.getRuntime();             
							Process process2 = runtime2.exec("SubGroup_Analysis_Sys.exe");							
						}else if(Modeljud.contains("_BPNN")){
							BPNN_Lexe BPpredict= new BPNN_Lexe();
						}
						
						
					} catch (Exception i) {
						System.out.println(i);
					  //e.printStackTrace();
					}
					Waitdialog3.setVisible(false);
				  }
				}).start();
				Waitdialog3.setVisible(true);
				/*���X���ݵ��� END*/
				
				/*----------------------------------------------------------------------------------------------------------------*/	
				JOptionPane.showMessageDialog(frame,MesArray[16]);
				Eva_Flag=1;
				String predict_file=null;
				try{
					BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(new File("ctojava"))));  
					//System.out.println("�ҫ�ctojava "+bf.readLine());
					predict_file=bf.readLine().toString();
					

				}catch(Exception i){
					System.out.println(i);
				}
				readtxt21 = new readtxt_3(predict_file);//�N�ϥΪ̿���ɮ׸��|�ର�r��éI�sreadtxt_3
				Upanel[29].removeAll();//�N���e�ҦbUpanel[0]������i��M��
				Upanel[29].add(readtxt21.CALLTABLE());//�Nreadtxt_3�Ҧ^�Ǥ�JScrollPane�[��Upanel[0]
				Upanel[29].revalidate();//Upanel[0]�������s����
				Upanel[29].repaint();//Upanel[0]�������sø�s
				
				Dopanel[29].removeAll();//�N���e�ҦbDopanel[0]������i��M��
				Dopanel[29].add(Hint_Label2[29]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��Dopanel[0]
				
				
				Dopanel[29].revalidate();//Dopanel[0]�������s����
				Dopanel[29].repaint();//Dopanel[0]�������sø�s
				ImageIcon image=new ImageIcon(ClickbtArray[5]);
				button[5].setIcon(image);
				
				cardlayout1.show(panel[4],UPArray[29]);//�NUpanel[0]���
				cardlayout2.show(panel[5],UPArray[29]);//�NDopanel[0]���
				
				System.out.println(FileCH.CALLFILPATH());
				
			}else if((JButton)e.getSource()==D_HiBuArraybutton[33]){
				/*���X���ݵ��� START*/
				if(FileCH2.IsClick()==1){
					JOptionPane WaitPanel3 =new JOptionPane(ProMesArray[6], JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
					JDialog Waitdialog3 = new JDialog();
					Waitdialog3.setModal(true);
					Waitdialog3.setContentPane(WaitPanel3);
						
					Waitdialog3.pack();
					Dimension screenSize3 = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
					Dimension GIFdialogSize = Waitdialog3.getSize();
					Waitdialog3.setLocation(screenSize3.width/2-GIFdialogSize.width/2,screenSize3.height/2-GIFdialogSize.height/2);
					Waitdialog3.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
					
					
					
					new Thread(new Runnable() {
					  @Override
					  public void run() {
						try {
						  //process.waitFor();
						  
						  //Thread.sleep(5000);
						  /*�N�ϥΪ̩ҿ��ɮ��ন�ҫ��ɼg�Jjavatoc2*/
							String predicttofun=null;
							String predictosee=null;
							predicttofun=FileCH2.CALLFILPATH();
							predictosee=FileCH2.CALLFILPATH();
							if(predicttofun.contains("_RF")){
								predicttofun=predicttofun.replace(".txt", ".pkl");
							}else if(predicttofun.contains("_SubDisc")){
								predicttofun=predicttofun.replace(".txt", ".txt");
							}else if(predicttofun.contains("_BPNN")){
								predicttofun=predicttofun.replace(".txt", ".h5");
							}
							
							
							FileWriter fw = new FileWriter("javatoc2");
							fw.write(predicttofun);
							fw.flush();
							fw.close();
							
							
							//System.out.println("�ǵ��U�쪺���|�W��1 �G "+predicttofun);
							
							/*�N�ϥΪ̩ҿ��ɮ��ন�ҫ��ɼg�Jjavatoc2*/
							
							/*��ƲM�~�P�ഫ�I�s�~���{���g��*/
							BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(new File("ctojava"))));  
							String cuttowa = bf.readLine();
							//System.out.println("��ܶǵ��U�쪺���|�W��2 �G "+cuttowa);
							String Modeljud=cuttowa+FileCH2.CALLOnlyName();
							
							//String Modeljud="Hos_Data\\Doc_Test\\Cut\\2020\\"+FileCH2.CALLOnlyName();
							FileWriter fw2 = new FileWriter("javatoc");
							if(Modeljud.contains("_RF")){
								data_cuwachfe_path=Modeljud.replace("_RF.txt", ".csv");
							}else if(Modeljud.contains("_SubDisc")){
								data_cuwachfe_path=Modeljud.replace("_SubDisc.txt", ".csv");
							}else if(Modeljud.contains("_BPNN")){
								data_cuwachfe_path=Modeljud.replace("_BPNN.txt", ".csv");
							}
							//System.out.println("�����ɦW���|��3"+data_cuwachfe_path);
								
							fw2.write(data_cuwachfe_path);
							fw2.flush();
							fw2.close();
											
							//�I�s�~���{��
							Runtime runtime=Runtime.getRuntime();             
							Process process = runtime.exec("Data_TransForm_P2_1.exe");//file������~���{�����ɮצW��             
							//System.out.println("�M�~�P�ഫ2���椤--------------------");
							process.waitFor();
								
							
							/*�S�x����x�s�ɮ�*/
							String FeaTuresave1=null;
							String FeaTuresave2=null;
							if(predicttofun.contains("_RF.pkl")){
								FeaTuresave1=predicttofun.replace("Model", "Feature").replace("_RF.pkl", ".txt");
							}else if(predicttofun.contains("_SubDisc.txt")){
								FeaTuresave1=predicttofun.replace("Model", "Feature").replace("_SubDisc.txt", ".txt");
							}else if(predicttofun.contains("_BPNN.h5")){
								FeaTuresave1=predicttofun.replace("Model", "Feature").replace("_BPNN.h5", ".txt");
							}
							
							FeaTuresave2=data_cuwachfe_path.replace("Cut", "Wa_Ch");
							//System.out.println("�ǵ�FEATURESAVE14 "+FeaTuresave1);
							//System.out.println("�ǵ�FEATURESAVE25 "+FeaTuresave2);
							featuresave2 = new FeatureSave2(FeaTuresave2,FeaTuresave1);
							
							
							FileWriter fw3 = new FileWriter("javatoc");
							//System.out.println("FEATURESAVE2�Ǧ^�Ӫ����|6 "+featuresave2.getOutPath());
							fw3.write(featuresave2.getOutPath());
							fw3.flush();
							fw3.close();
							
							/*�S�x����x�s�ɮ�*/
							if(Modeljud.contains("_RF")){
								RFPredictexe Rfpredict = new RFPredictexe();
							}else if(Modeljud.contains("_SubDisc")){
								Runtime runtime2=Runtime.getRuntime();             
								Process process2 = runtime2.exec("SubGroup_Analysis_Sys.exe");							
							}else if(Modeljud.contains("_BPNN")){
								BPNN_Lexe BPpredict= new BPNN_Lexe();
							}
							
							
						} catch (Exception i) {
							System.out.println(i);
						  //e.printStackTrace();
						}
						Waitdialog3.setVisible(false);
					  }
					}).start();
					Waitdialog3.setVisible(true);
					/*���X���ݵ��� END*/
					
					
					
					JOptionPane.showMessageDialog(frame,MesArray[17]);
					Eva_Flag=1;
					
					
					/*----------------------------------------------------------------------------------------------------------------*/	
					String predict_file=null;
					try{
						BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(new File("ctojava"))));  
						//System.out.println("�ҫ�ctojava "+bf.readLine());
						predict_file=bf.readLine().toString();
						
			
					}catch(Exception i){
						System.out.println(i);
					}
					
					//�N�ϥΪ̿���ɮ׸��|�ର�r��éI�sreadtxt_3
					//System.out.println("�C�L "+predict_file);
					ImageIcon image=new ImageIcon(ClickbtArray[5]);
					button[5].setIcon(image);
					readtxt22 = new readtxt_3(predict_file); 
					Upanel[30].removeAll();//�N���e�ҦbUpanel[0]������i��M��
					Upanel[30].add(readtxt22.CALLTABLE());//�Nreadtxt_3�Ҧ^�Ǥ�JScrollPane�[��Upanel[0]
					Upanel[30].revalidate();//Upanel[0]�������s����
					Upanel[30].repaint();//Upanel[0]�������sø�s
					
					Dopanel[30].removeAll();//�N���e�ҦbDopanel[0]������i��M��
					Dopanel[30].add(Hint_Label2[30]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��Dopanel[0]
					
					
					Dopanel[30].revalidate();//Dopanel[0]�������s����
					Dopanel[30].repaint();//Dopanel[0]�������sø�s
					
					
					cardlayout1.show(panel[4],UPArray[30]);//�NUpanel[0]���
					cardlayout2.show(panel[5],UPArray[30]);//�NDopanel[0]���
				}else{
					JOptionPane.showMessageDialog(frame,"�|������ɮ�");
				}
			
			}else if((JButton)e.getSource()==HiBuArraybutton[15]){
				if(FileCH.IsClick()==1){
					readtxt23 = new readtxt_3(FileCH.CALLFILPATH());//�N�ϥΪ̿���ɮ׸��|�ର�r��éI�sreadtxt_3
					Upanel[31].removeAll();//�N���e�ҦbUpanel[0]������i��M��
					Upanel[31].add(readtxt23.CALLTABLE());//�Nreadtxt_3�Ҧ^�Ǥ�JScrollPane�[��Upanel[0]
					Upanel[31].revalidate();//Upanel[0]�������s����
					Upanel[31].repaint();//Upanel[0]�������sø�s
					
					Dopanel[31].removeAll();//�N���e�ҦbDopanel[0]������i��M��
					Dopanel[31].add(Hint_Label2[31]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��Dopanel[0]
					
					D_HiBuArraybutton[36].setPreferredSize(new Dimension(190,88));
					Dopanel[31].add(D_HiBuArraybutton[36]);//�N"�W�@�B"���s�[�J��Dopanel[0]
					Dopanel[31].revalidate();//Dopanel[0]�������s����
					Dopanel[31].repaint();//Dopanel[0]�������sø�s
					
					
					cardlayout1.show(panel[4],UPArray[31]);//�NUpanel[0]���
					cardlayout2.show(panel[5],UPArray[31]);//�NDopanel[0]���
					
					System.out.println(FileCH.CALLFILPATH());
				}else{
					JOptionPane.showMessageDialog(frame,"�|������ɮץH�P�L�k���");
				}
			}else if((JButton)e.getSource()==D_HiBuArraybutton[36]){
				cardlayout1.show(panel[4],CPArray[22]);//�NCpanel[3]���
				cardlayout2.show(panel[5],CPArray[22]);//�NCDpanel[3]���
			}else if((JButton)e.getSource()==HiBuArraybutton[16]){
				if(FileCH.IsClick()==1){
					String Queue=null;
					String waittime=null;
					String idle=null;
					String doctor_code=null;
					try{
						
						FileWriter fw = new FileWriter("javatoc");
						
						System.out.println("�ҫ����G�ɦW���|��"+FileCH.CALLFILPATH());
						
						
						fw.write(FileCH.CALLFILPATH());
						fw.flush();
						fw.close();
						
					}catch(Exception v){
						System.out.println(v);
					}
					try {
						//�I�s�~���{��
						Runtime runtime=Runtime.getRuntime();             
						Process process = runtime.exec("Effect_Comparsion_Sys.exe");//file������~���{�����ɮצW��             
						System.out.println("�į���--------------------");
						/*���X���ݵ��� START*/
							
							
						JOptionPane WaitPanel =new JOptionPane(ProMesArray[5], JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
						//WaitPanel.setFont(softfont[0]);
						JDialog Waitdialog = new JDialog();
						Waitdialog.setModal(true);
						Waitdialog.setContentPane(WaitPanel);
							
						Waitdialog.pack();
						Dimension screenSize2 = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
						Dimension GIFdialogSize = Waitdialog.getSize();
						Waitdialog.setLocation(screenSize2.width/2-GIFdialogSize.width/2,screenSize2.height/2-GIFdialogSize.height/2);
						Waitdialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
						System.out.println("�e�ϰ��椤--------------------");
							
						new Thread(new Runnable() {
						  @Override
						  public void run() {
							try {
							  process.waitFor();
							  //Thread.sleep(5000);
							} catch (InterruptedException e) {
							  e.printStackTrace();
							}
							Waitdialog.setVisible(false);
						  }
						}).start();
						Waitdialog.setVisible(true);
						JOptionPane.showMessageDialog(frame,ProEndMesArray[5]);
						/*���X���ݵ��� END*/
						BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(new File("ctojava2"))));          
										
					
						Queue = bf.readLine();
						System.out.println("��Ū��1 "+Queue);
						waittime = bf.readLine();
						System.out.println("��Ū��2 "+waittime);
						idle = bf.readLine();
						System.out.println("��Ū��3 "+idle);
						doctor_code= bf.readLine();
						System.out.println("��Ū��4 "+doctor_code);
				  
					} catch (Exception k) {
							System.out.println(k);
					} 		
					
					piclayout2 = new layouttest6_6_2("test",Queue,waittime,idle,doctor_code);
					
					Upanel[32].removeAll();//�N���e�ҦbUpanel[0]������i��M��
					Upanel[32].setLayout(new BoxLayout(Upanel[32], BoxLayout.Y_AXIS));
					Upanel[32].add(piclayout2.CALLPIC());//�Nreadtxt_3�Ҧ^�Ǥ�JScrollPane�[��Upanel[0]
					
					Upanel[32].revalidate();//Upanel[0]�������s����
					Upanel[32].repaint();//Upanel[0]�������sø�s
					
					Dopanel[32].removeAll();//�N���e�ҦbDopanel[0]������i��M��
					Dopanel[32].add(Hint_Label2[32]);//�N���ܰT��"�T�{�����Ы���Ƥ���"�[�J��Dopanel[0]
					
					
					Dopanel[32].revalidate();//Dopanel[0]�������s����
					Dopanel[32].repaint();//Dopanel[0]�������sø�s
					
					
					cardlayout1.show(panel[4],UPArray[32]);//�NUpanel[0]���
					cardlayout2.show(panel[5],UPArray[32]);//�NDopanel[0]���
					ImageIcon image=new ImageIcon(ClickbtArray[6]);
					button[6].setIcon(image);
				}else{
					JOptionPane.showMessageDialog(frame,"�|������ɮ�");
				}
				
				
			}else if((JButton)e.getSource()==HiBuArraybutton[17]){
				
				System.out.println(allinone.getRadioB());
				System.out.println(allinone.getRadioB2());
				System.out.println(allinone.getORIFILE());
				System.out.println(allinone.getPREFILE());
				Object[] options = {"�T�w","����"};
					
				int mType=JOptionPane.QUESTION_MESSAGE;
				int oType=JOptionPane.YES_NO_CANCEL_OPTION;
				int opt=JOptionPane.showOptionDialog(frame,"��l�ɮסG"+allinone.getORIFILE()+"\n�ҫ���k�G"+allinone.getRadioB()+"\n�S�x��k�G"+allinone.getRadioB2()+"\n�w���ɮסG"+allinone.getPREFILE(),"�нT�{",oType,mType,null,options,options[0]);
				if(opt==0){
					
					JOptionPane AllWaitPanel =new JOptionPane("���b�i��@��B�z��\n�еy��...",JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
					AllWaitPanel.setFont(softfont[0]);
					JDialog AllWaitdialog = new JDialog();
					AllWaitdialog.setModal(true);
					AllWaitdialog.setContentPane(AllWaitPanel);
							
					AllWaitdialog.pack();
					Dimension screenSize2 = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
					Dimension GIFdialogSize = AllWaitdialog.getSize();
					AllWaitdialog.setLocation(screenSize2.width/2-GIFdialogSize.width/2,screenSize2.height/2-GIFdialogSize.height/2);
					AllWaitdialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
					
					/*��Ƥ��ΩI�s�~���{���g��*/
					try{
						FileWriter fw = new FileWriter("javatoc");
						data_cuwachfe_path=allinone.getORIFILE();//s�O�ɮ׸��|
						fw.write(data_cuwachfe_path);
						fw.flush();
						fw.close();
							
						//�I�s�~���{��
						Runtime runtime=Runtime.getRuntime();             
						Process process = runtime.exec("Data_Cut_End2.exe");//file������~���{�����ɮצW��             
						System.out.println("���ΰ��椤--------------------");
						
						
						
						Thread threadA = new Thread(new Runnable() { 
							@Override
							public void run() {
								try {
									process.waitFor();
									//Thread.sleep(5000);
									System.out.println("���ΰ��槹��--------------------");
																
								}catch(Exception v){
									System.out.println("���ΰ�����~");
								}
								//AllWaitdialog.setVisible(false);
								//ImageIcon image=new ImageIcon(ClickbtArray[7]);
								//button[7].setIcon(image);
								AllWaitdialog.setVisible(false);
							}
						});
						
						threadA.start();
						AllWaitdialog.setVisible(true);
						//AllWaitdialog.setVisible(true);
						//JOptionPane.showMessageDialog(frame,"�@��B�z�y�{�i�槹��");
						
						try{
							System.out.println("Current Thread: "+ Thread.currentThread().getName());
							
							threadA.join();
							Dacu_Flag=1;	
						}catch(Exception ex){
							System.out.println("Exception has " +"been caught" + ex);
						}
						
	 
	
						BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(new File("ctojava"))));
						FileWriter fw2 = new FileWriter("javatoc");
						fw2.write(bf.readLine().toString());
						bf.close();
						fw2.flush();
						fw2.close();
							
						//�I�s�~���{��
						Runtime runtime2=Runtime.getRuntime();             
						Process process2 = runtime2.exec("Data_TransForm_All_1.exe");//file������~���{�����ɮצW��             
						System.out.println("�M�~�P�ഫ���椤--------------------");
						
						Thread threadB = new Thread(new Runnable() { 
							@Override
							public void run() {
								try {
									InputStream stderr = process2.getErrorStream();
									InputStreamReader isr = new InputStreamReader(stderr);
									BufferedReader br = new BufferedReader(isr);
									String line = null;
									while((line = br.readLine()) != null){
										//System.out.println(line);
										
									}
									process2.waitFor();
									//Thread.sleep(5000);
									br.close();
									
								}catch(Exception v){
									System.out.println("�M�~�P�ഫ������~");
								}
								AllWaitdialog.setVisible(false);
							}
						});
						
						
						threadB.start();
						AllWaitdialog.setVisible(true);
						try{
							System.out.println("Current Thread2: "+ Thread.currentThread().getName());
							threadB.join();
							System.out.println("�M�~�P�ഫ���槹��--------------------");
							Watr_Flag=1;
							
						}
				  
						catch(Exception ex){
							System.out.println("Exception has " +"been caught" + ex);
						}	
						BufferedReader bf2 = new BufferedReader(new InputStreamReader(new FileInputStream(new File("ctojava"))));
						FileWriter fw3 = new FileWriter("javatoc");
						fw3.write(bf2.readLine().toString());
						bf2.close();
						fw3.flush();
						fw3.close();
						if(allinone.getRadioB2()=="�d������"){
							System.out.println("�S�x���(�d������)���椤--------------------");
							Thread threadC = new Thread(new Runnable() { 
							@Override
								public void run() {
									try {	
										ALLINONE_CHi2_All_javatoc CHi2_All_javatoc = new ALLINONE_CHi2_All_javatoc();
		
									} catch (Exception i) {
										System.out.println(i);
									  
									}
									AllWaitdialog.setVisible(false);
								}
							});
							threadC.start();
							AllWaitdialog.setVisible(true);
							try{
								System.out.println("Current Thread3: "+ Thread.currentThread().getName());
								threadC.join();
								System.out.println("�S�x���(�d������)���槹��--------------------");
								
							}
					  
							catch(Exception ex){
								System.out.println("Exception has " +"been caught" + ex);
							}	
							
						}else if(allinone.getRadioB2()=="��t�L�o"){
							System.out.println("�S�x���(��t�L�o)���椤--------------------");
							Thread threadC = new Thread(new Runnable() { 
							@Override
								public void run() {
									try {	
										ALLINONE_VarianceThresholdall_Test3 VarianceThresholdall_Test3 = new ALLINONE_VarianceThresholdall_Test3();
									} catch (Exception i) {
										System.out.println(i);
									  
									}
									AllWaitdialog.setVisible(false);
								}
							});
							threadC.start();
							AllWaitdialog.setVisible(true);
							try{
								System.out.println("Current Thread3: "+ Thread.currentThread().getName());
								threadC.join();
								System.out.println("�S�x���(��t�L�o)���槹��--------------------");
								
								
							}
					  
							catch(Exception ex){
								System.out.println("Exception has " +"been caught" + ex);
							}	
							
						
						}else if(allinone.getRadioB2()=="�H��l��Ƭ��D"){
							System.out.println("�S�x���(�H��l��Ƭ��D)");
							
						}else{
							System.out.println("�S�x�����");
							
						}
						
						String Pre_FeaturesaveAll_Path=null;
						if(allinone.getRadioB2()=="�H��l��Ƭ��D"){
							FeatureSave_All_Ori FeaturesaveAll_Ori = new FeatureSave_All_Ori();
							System.out.println("featuresave�^�Ǫ����|"+FeaturesaveAll_Ori.getOutPath());
							Pre_FeaturesaveAll_Path = FeaturesaveAll_Ori.getOutPath();
							FileWriter fw4 = new FileWriter("javatoc");
							fw4.write(FeaturesaveAll_Ori.getOutPath());
							fw4.flush();
							fw4.close();
							Fet_Flag=1;
						}else if(allinone.getRadioB2()=="�L�����"){
							System.out.println("�S�x�L�����");
							Fet_Flag=1;
						}else{
							FeatureSave_All FeaturesaveAll = new FeatureSave_All();
							System.out.println("featuresave�^�Ǫ����|"+FeaturesaveAll.getOutPath());
							Pre_FeaturesaveAll_Path = FeaturesaveAll.getOutPath();
							FileWriter fw4 = new FileWriter("javatoc");
							fw4.write(FeaturesaveAll.getOutPath());
							fw4.flush();
							fw4.close();
							Fet_Flag=1;
						}
						
						
						
						
						//-------------------------------------------------------------------------------------------------------------------
						
						
						if(allinone.getRadioB()=="�H���˪L"){
							System.out.println("�إ߼ҫ�(�H���˪L)���椤--------------------");
							Thread threadD = new Thread(new Runnable() { 
							@Override
								public void run() {
									try {	
										
										ALLINONE_RF_CeeatAll RF_CeeatAll = new ALLINONE_RF_CeeatAll();
									
									} catch (Exception i) {
										System.out.println(i);
									  
									}
									AllWaitdialog.setVisible(false);
								}
							});
							threadD.start();
							AllWaitdialog.setVisible(true);
							try{
								System.out.println("Current Thread4: "+ Thread.currentThread().getName());
								threadD.join();
								System.out.println("�إ߼ҫ�(�H���˪L)���槹��--------------------");
								Mod_Flag=1;
								Sta_Flag=4;
								
							}
					  
							catch(Exception ex){
								System.out.println("Exception has " +"been caught" + ex);
							}	
	
						}else if(allinone.getRadioB()=="�l�s�ձ��ɲέp��k���R"){
							System.out.println("�إ߼ҫ�(�l�s��)���椤--------------------");
							Thread threadD = new Thread(new Runnable() { 
							@Override
								public void run() {
									try {	
										
										ALLINONE_Cortana2_All Cortana_All = new ALLINONE_Cortana2_All();
									
									} catch (Exception i) {
										System.out.println(i);
									  
									}
									AllWaitdialog.setVisible(false);
								}
							});
							threadD.start();
							AllWaitdialog.setVisible(true);
							try{
								System.out.println("Current Thread4: "+ Thread.currentThread().getName());
								threadD.join();
								System.out.println("�إ߼ҫ�(�l�s��)���槹��--------------------");
								Mod_Flag=1;
								Sta_Flag=4;
								
							}
					  
							catch(Exception ex){
								System.out.println("Exception has " +"been caught" + ex);
							}	
							
						}else{
							System.out.println("�ҫ���k�����");
						}
						
						FileWriter fw5 = new FileWriter("javatoc");
						data_cuwachfe_path=allinone.getPREFILE();//s�O�ɮ׸��|
						fw5.write(data_cuwachfe_path.toString());
						fw5.flush();
						fw5.close();
						
						//�I�s�~���{��
						Runtime runtime3=Runtime.getRuntime();             
						Process process3 = runtime3.exec("Data_Cut_End3.exe");//file������~���{�����ɮצW��             
						System.out.println("�w���ɤ��ΰ��椤--------------------");
						
						
						
						Thread threadE = new Thread(new Runnable() { 
							@Override
							public void run() {
								try {
									process3.waitFor();
									//Thread.sleep(5000);
									System.out.println("�w���ɤ��ΰ��槹��--------------------");
																	
								}catch(Exception v){
									System.out.println("�w���ɤ��ΰ�����~");
								}
								AllWaitdialog.setVisible(false);
							}
						});
						threadE.start();
						AllWaitdialog.setVisible(true);
						
						try{
							System.out.println("Current Thread5: "+ Thread.currentThread().getName());
							
							threadE.join();
						}catch(Exception ex){
							System.out.println("Exception has " +"been caught" + ex);
						}
						
						BufferedReader bf3 = new BufferedReader(new InputStreamReader(new FileInputStream(new File("ctojava"))));
						FileWriter fw6 = new FileWriter("javatoc");
						fw6.write(bf3.readLine().toString());
						bf3.close();
						fw6.flush();
						fw6.close();
						
						//�I�s�~���{��
						Runtime runtime4=Runtime.getRuntime();             
						Process process4 = runtime4.exec("Data_TransForm_All2_1.exe");//file������~���{�����ɮצW��             
						System.out.println("�w���ɲM�~�P�ഫ���椤--------------------");
						
						Thread threadF = new Thread(new Runnable() { 
							@Override
							public void run() {
								try {
									InputStream stderr2 = process4.getErrorStream();
									InputStreamReader isr2 = new InputStreamReader(stderr2);
									BufferedReader br2 = new BufferedReader(isr2);
									String line = null;
									while((line = br2.readLine()) != null){
										//System.out.println(line);
										
									}
									process4.waitFor();
									//Thread.sleep(5000);
									br2.close();
									
								}catch(Exception v){
									System.out.println("�w���ɲM�~�P�ഫ������~");
								}
								AllWaitdialog.setVisible(false);
							}
						});
						
						
						threadF.start();
						AllWaitdialog.setVisible(true);
						
						try{
							System.out.println("Current Thread6: "+ Thread.currentThread().getName());
							threadF.join();
							System.out.println("�w���ɲM�~�P�ഫ���槹��--------------------");
							
						}
				  
						catch(Exception ex){
							System.out.println("Exception has " +"been caught" + ex);
						}	
						
						BufferedReader bf4 = new BufferedReader(new InputStreamReader(new FileInputStream(new File("ctojava"))));
						FileWriter fw7 = new FileWriter("javatoc");
						//System.out.println("�M�~���S�x "+bf4.readLine().toString());
						fw7.write(bf4.readLine().toString());
						bf4.close();
						fw7.flush();
						fw7.close();
						if(allinone.getRadioB2()!="�L�����"){
							
							System.out.println("�ᵹFeatureSave2_All "+Pre_FeaturesaveAll_Path);
							FeatureSave2_All featureSave2All = new FeatureSave2_All(Pre_FeaturesaveAll_Path);
							
							FileWriter fw8 = new FileWriter("javatoc");
							System.out.println("featureSave2All�^�ǵ��G "+featureSave2All.getOutPath());
							fw8.write(featureSave2All.getOutPath());
							fw8.flush();
							fw8.close();
						}

		
						if(allinone.getRadioB()=="�H���˪L"){
							System.out.println("�����w��(�H���˪L)���椤--------------------");
							Thread threadG = new Thread(new Runnable() { 
							@Override
								public void run() {
									
									
									try {	
										
										ALLINONE_RF_PreAll2 RF_PreAll = new ALLINONE_RF_PreAll2();
									
									} catch (Exception i) {
										System.out.println(i);
									  
									}
									AllWaitdialog.setVisible(false);
								}
							});
							threadG.start();
							AllWaitdialog.setVisible(true);
							try{
								System.out.println("Current Thread7: "+ Thread.currentThread().getName());
								threadG.join();
								System.out.println("�����w��(�H���˪L)���槹��--------------------");
								Eva_Flag=1;
								ImageIcon image=new ImageIcon(ClickbtArray[7]);
								button[7].setIcon(image);
								JOptionPane.showMessageDialog(frame,"�@��B�z�i�槹��");
								
							}
					  
							catch(Exception ex){
								System.out.println("Exception has " +"been caught" + ex);
							}
						
						}else if(allinone.getRadioB()=="�l�s�ձ��ɲέp��k���R"){
							
							Runtime runtime5=Runtime.getRuntime();             
							Process process5 = runtime5.exec("ALLINONE_SubGroup_Analysis_All.exe");//file������~���{�����ɮצW��             
							System.out.println("�����w��(�l�s��)���椤--------------------");
							Thread threadG = new Thread(new Runnable() { 
							@Override
								public void run() {
									
									try {	
										InputStream stderr3 = process5.getErrorStream();
										InputStreamReader isr3 = new InputStreamReader(stderr3);
										BufferedReader br3 = new BufferedReader(isr3);
										String line = null;
										while((line = br3.readLine()) != null){
											//System.out.println(line);
											
										}
										process5.waitFor();
										//Thread.sleep(5000);
										br3.close();
									
									} catch (Exception i) {
										System.out.println(i);
									  
									}
									AllWaitdialog.setVisible(false);
								}
							});
							threadG.start();
							AllWaitdialog.setVisible(true);
							try{
								System.out.println("Current Thread7: "+ Thread.currentThread().getName());
								threadG.join();
								System.out.println("�����w��(�l�s��)���槹��--------------------");
								Eva_Flag=1;
								ImageIcon image=new ImageIcon(ClickbtArray[7]);
								button[7].setIcon(image);
								JOptionPane.showMessageDialog(frame,"�@��B�z�i�槹��");
								
								
							}
					  
							catch(Exception ex){
								System.out.println("Exception has " +"been caught" + ex);
							}
						}else{
							System.out.println("�ҫ���k�����");
						}
						
						
						
					} catch (Exception v) {
					  v.printStackTrace();
					}
				
				}else if(opt==1){
					allinone.erroedeal();
				}
					
				
			}else{
				System.out.println("ERROR");
			}
		
		}
	}
	
	/*implement END*/
	
	
}