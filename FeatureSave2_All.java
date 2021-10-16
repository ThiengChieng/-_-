import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.nio.*;

public class FeatureSave2_All{
	private ArrayList<String> isaList;//�n�^�����S�x
	private ArrayList<String[]> TwoD = new ArrayList<String[]>();//��l�ɮפ��e
	private ArrayList<Integer> FeatureCheck = new ArrayList<Integer>();//�S�x�b�ɮפ������ޭ�
	private String Target = "�E�����s"; //�ؼ�
	private String FileInPath;//��l�ɮ׸��|
	private String FileoutPath = "";//��X�ɮ׸��|
	private String FileName;//�ɮצW��
	private String aDelimiter = ",";
	private String line = null;
	private String[] FeatureFileName;//�Ҧ��S�x�ɮצW��
	private String EndofFIle = ".csv";
	private String ctojava = "javatoc";
	private String Path = ""; //�ǤJ�����|(�V�m�����S�x�ɮצ�m)
	private String TestYear = "";//���ն��~��
	private String TrainYear = "";//�V�m���~��
	
	public FeatureSave2_All(String Path){
		this.Path = Path;
		FileoutPath = Path.replace("Doc_Train", "Doc_Test");
		
		
		try{
			InputStreamReader ctoj = new InputStreamReader(new FileInputStream(ctojava));//Ū���M�~�P�ഫ��Ƨ����|
			BufferedReader ctojavaReader = new BufferedReader(ctoj);
			FileInPath = ctojavaReader.readLine();
		}catch(IOException e){}
		
		int position = FileInPath.lastIndexOf("\\");
		TestYear = FileInPath.substring(position+1);
		//System.out.println("TestYear:" + TestYear);
		
		position = Path.lastIndexOf("Feature");
		TrainYear = Path.substring(position+8,position+12);
		//System.out.println(TrainYear);
		FileoutPath = FileoutPath.replace(TrainYear, TestYear);
		//System.out.println("out:" + FileoutPath);
		
		File mkDic = new File(FileoutPath); //�إ߿�X��Ƨ�
		mkDic.mkdirs();
		File fileNameList = new File(Path); //�C�XTrain���S�x�ɮצW��
		FeatureFileName = fileNameList.list();
		for(String Name:FeatureFileName){
			if(Name.endsWith(EndofFIle) || Name.length() > 9){
				continue;
			}
			FileName = Name; //�ɮצW��
			try{
				//System.out.println("In:" + FileInPath + "\\" + FileName.replace(".txt",".csv"));
				ReadFile();
				WriteFile();
			}catch(IOException  e){
				//System.out.println("File not found");
			}
			TwoD.clear();
			FeatureCheck.clear();
		}
		
	}



	private void WriteFile() throws java.io.IOException{

		InputStreamReader DocFile = new InputStreamReader(new FileInputStream(FileInPath + "\\" + FileName.replace(".txt",".csv")));//�ɮ�Ū�����|
		BufferedReader reader = new BufferedReader(DocFile);
		BufferedWriter bw = new BufferedWriter(new FileWriter(FileoutPath + "\\" + FileName.replace(".txt",".csv")));//�ɮ׿�X���|
		//System.out.println(FileoutPath);
		
			
		while((line = reader.readLine()) != null){
			String[] temp = line.split(",");
			for(int i = 0; i < temp.length; i++){
				temp[i] = temp[i].trim();
			}
			TwoD.add(temp);
		}//�N�ɮפ��eŪ�J
		//System.out.println(TwoD.get(0)[0]);
		for(int i = 0; i < TwoD.size(); i++){
			for(int j = 0; j < FeatureCheck.size(); j++){
				bw.write(TwoD.get(i)[FeatureCheck.get(j)]);
				if (j != FeatureCheck.size() - 1)
					bw.write(aDelimiter);
			}
			bw.write("\n");
		}//�g��
		
		bw.close();
	}
	
	private void ReadFile() throws java.io.IOException{

		InputStreamReader DocFile = new InputStreamReader(new FileInputStream(Path + FileName));//�ɮ�Ū�����|
		BufferedReader reader = new BufferedReader(DocFile);		
			
		while((line = reader.readLine()) != null){
			//System.out.println(line);
			int temp = Integer.valueOf(line);
			
			FeatureCheck.add(temp);
		}//�N�ɮפ��eŪ�J
		FeatureCheck.add(36);
	}
	
	public String getOutPath(){
		return FileoutPath;
	}
}