import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FeatureSave_All_Ori{
	private ArrayList<String> isaList;//�n�^�����S�x
	private ArrayList<String[]> TwoD = new ArrayList<String[]>();//��l�ɮפ��e
	private ArrayList<Integer> FeatureCheck;//�S�x�b�ɮפ������ޭ�
	private String Target = "�E�����s"; //�ؼ�
	private String FileInPath;//��l�ɮ׸��|
	private String FileoutPath = "";//��X�ɮ׸��|
	private String FileName;//�ɮצW��
	private String aDelimiter = ",";
	private String line = null;
	private String NowTime = "";
	private File file;
	private String ctojava = "ctojava";
	private String EndofFIle = ".txt";
	private String[] FeatureFileName;//�Ҧ��S�x�ɮצW��
	private String Path;
	private ArrayList<Integer> Feature = new ArrayList<Integer>();
	private String[] FeatureNumber = {"�ݶE�P��", "�f�w�~��", "�Z�O���ȶE_�ഫ", "��ڬݶE����", "�������O_�ഫ", "�f�w�ʧO_�ഫ", "�e���O�_�}������_�ഫ", "��ƶE_�ഫ"};//�����S�x���X
	private String FeaturePath;
	private String FeatureYear = "";
	private int LastPosition;
	private File dir;
	
	public FeatureSave_All_Ori(){
		//System.out.println("�S�x---��l");
		//System.out.println("�պնǶi�Ӫ�"+Feature);
		//System.out.println(Path);
		//System.out.println(Name);
		
		try{
			InputStreamReader ctoj = new InputStreamReader(new FileInputStream(ctojava));//Ū���M�~�P�ഫ��Ƨ����|
			BufferedReader ctojavaReader = new BufferedReader(ctoj);
			Path = ctojavaReader.readLine();
			
		}catch(IOException e){}
		
		
		file = new File(Path);//�C�X�Ҧ��M�~�P�ഫ�ɮצW��
		FeatureFileName = file.list();
		
		for(String Name:FeatureFileName){
			if(Name.endsWith(EndofFIle)){//�L�o�M�~�P�S�x���ɮ�
				continue;
			}
			
			for(int i = 0; i < 8; i++){//�[�J�S�x���X
				Feature.add(i);
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat();//�榡
			sdf.applyPattern("MMdd_HHmm");//�ɶ����榡  
			Date date = new Date();//�o���e�ɶ�
			NowTime = sdf.format(date);
			
			LastPosition = Path.lastIndexOf("\\");//��o�ɮצ~��
			for(int i = LastPosition + 1; i <= LastPosition + 4; i++){
				FeatureYear = FeatureYear + Path.charAt(i);
			}
			
			FeaturePath = "Hos_Data\\Doc_Train\\Feature\\"+ FeatureYear + "\\" + "All_" + NowTime + "_Ori\\";//�إ߿�X���|
			dir = new File(FeaturePath);
			dir.mkdirs();
			
			FileoutPath = FeaturePath;
			//System.out.println(FeaturePath);
			if(Feature.contains(36)){
				
				Feature.remove(Feature.get(Feature.indexOf(36)));
				
			}
			for(int i =0;i<Feature.size();i++){
				Feature.set(i, Feature.get(i)+37);//���s���N(�ҭn�����b��37��)
			}
			//System.out.println("�պ�+37�᪺"+Feature);
			
			/*�x�s�ҿ�S�x��츹�X*/
			try{
			BufferedWriter TTC = new BufferedWriter(new FileWriter(FileoutPath + Name.replace(".csv",".txt")));
				for(int i =0;i<Feature.size();i++){
					//System.out.println("write "+Feature);
					TTC.write(Feature.get(i).toString());
					TTC.write("\n");
				}
				TTC.close();
			}catch(IOException e){}
			/*�x�s�ҿ�S�x��츹�X*/
			FeatureCheck = Feature;
			FeatureCheck.add(36);
			//Collections.sort(FeatureCheck);
			//System.out.println("�a����"+Feature);
			
			FileInPath = Path + '\\' + Name;
			//System.out.println(FileInPath);
			FileName = Name;
			try{
				WriteFile();
			}catch(IOException  e){
				//System.out.println("File not found");
			}
			Feature.clear();
			FeatureYear = "";
		}
		
	}



	private void WriteFile() throws java.io.IOException{

		InputStreamReader DocFile = new InputStreamReader(new FileInputStream(FileInPath));//�ɮ�Ū�����|
		BufferedReader reader = new BufferedReader(DocFile);
		
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(FileoutPath + FileName));//�ɮ׿�X���|
			
		
			
		while((line = reader.readLine()) != null){
			String[] temp = line.split(",");
			for(int i = 0; i < temp.length; i++){
				temp[i] = temp[i].trim();
			}
			TwoD.add(temp);
		}//�N�ɮפ��eŪ�J
		
		for(int i = 0; i < TwoD.size(); i++){
			for(int j = 0; j < FeatureCheck.size(); j++){
				bw.write(TwoD.get(i)[FeatureCheck.get(j)]);
				if (j != FeatureCheck.size() - 1)
					bw.write(aDelimiter);
			}
			bw.write("\n");
		}//�g��
		TwoD.clear();
		bw.close();
	}
	
	public String getOutPath(){
		//System.out.println("���a�����̫��ɮ׸��|"+FileoutPath);
		return FileoutPath;
	}
}