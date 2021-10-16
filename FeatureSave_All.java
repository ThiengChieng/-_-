import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.nio.charset.Charset;

public class FeatureSave_All{
	private ArrayList<String> isaList;//�n�^�����S�x
	private ArrayList<String[]> TwoD = new ArrayList<String[]>();//��l�ɮפ��e
	private ArrayList<Integer> FeatureCheck;//�S�x�b�ɮפ������ޭ�
	private String Target = "�E�����s"; //�ؼ�
	private String FileInPath;//��l�ɮ׸��|
	private String FileoutPath = "";//��X�ɮ׸��|
	private String FileName;//�ɮצW��
	private String aDelimiter = ",";
	private String line = null;
	private String Name2 = "";
	private File file;
	private String ctojava = "ctojava";
	private String ctojava2 = "ctojava2";
	private String[] FeatureFileName;//�Ҧ��S�x�ɮצW��
	private String Path;
	private ArrayList<Integer> Feature = new ArrayList<Integer>();
	private String[] FeatureNumber = {"�ݶE�P��", "�f�w�~��", "�Z�O���ȶE_�ഫ", "��ڬݶE����", "�������O_�ഫ", "�f�w�ʧO_�ഫ", "�e���O�_�}������_�ഫ", "��ƶE_�ഫ"};//�����S�x���X
	private String FeaturePath;
	
	public FeatureSave_All(){
		//System.out.println("�պնǶi�Ӫ�"+Feature);
		//System.out.println(Path);
		//System.out.println(Name);
		
		try{
			InputStreamReader ctoj = new InputStreamReader(new FileInputStream(ctojava));//Ū���M�~�P�ഫ��Ƨ����|
			BufferedReader ctojavaReader = new BufferedReader(ctoj);
			Path = ctojavaReader.readLine();
			
			InputStreamReader ctoj2 = new InputStreamReader(new FileInputStream(ctojava2));//Ū���S�x��Ƨ����|
			BufferedReader ctojava2Reader = new BufferedReader(ctoj2);
			FeaturePath = ctojava2Reader.readLine();
		}catch(IOException e){}
		
		
		file = new File(FeaturePath);//�C�X�Ҧ��S�x�ɮצW��
		FeatureFileName = file.list();
		
		for(String Name:FeatureFileName){
			if(Name.charAt(5) == 'C'){//�B�z�d��S�x
				String line2;
				try{
					InputStreamReader featureFileIn = new InputStreamReader(new FileInputStream(FeaturePath + "\\" + Name));//Ū���d��S�x�ɮ�
					BufferedReader featureFileIn2 = new BufferedReader(featureFileIn);
					while((line2 = featureFileIn2.readLine()) != null){//��J�S�x���X
						char tempC = line2.charAt(0);
						int tempI = tempC - '0';
						//System.out.println(tempI);
						Feature.add(tempI);
					}
				}catch(IOException e){}
				
			}else if(Name.charAt(5) == 'F'){//�B�z��t�S�x
				String line2;
				String[] line3;
				String tempS;
				try{
					InputStreamReader featureFileIn = new InputStreamReader(new FileInputStream(FeaturePath + "\\" + Name),"UTF-8");//Ū����t�S�x�ɮ�
					BufferedReader featureFileIn2 = new BufferedReader(featureFileIn);
					line2 = featureFileIn2.readLine();
					line3 = line2.split(",");
					//System.out.println("--------------------");
					for(int i = 0; i < line3.length; i++){
						for(int j = 0; j < FeatureNumber.length; j++){
							if(line3[i].equals(FeatureNumber[j])){
								Feature.add(j);
								//System.out.println("+++++++++");
								break;
							}
						}
					}
				}catch(IOException e){}
			}
			
			
			if(Name.charAt(5) == 'C'){
				Name = Name.replace("_CHi2.txt",".csv");
				//System.out.println(Name);
			}else if(Name.charAt(5) == 'F'){
				Name = Name.replace("_FT.txt",".csv");
			}
			FileoutPath = FeaturePath + "\\";
			Name2 = Name.replace(".txt",".csv");
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
			
			FileInPath = Path + '\\' + Name2;
			//System.out.println(FileInPath);
			FileName = Name;
			try{
				WriteFile();
			}catch(IOException  e){
				//System.out.println("File not found");
			}
			Feature.clear();
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