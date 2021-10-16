import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class FeatureSave{
	private ArrayList<String> isaList;//�n�^�����S�x
	private ArrayList<String[]> TwoD = new ArrayList<String[]>();//��l�ɮפ��e
	private ArrayList<Integer> FeatureCheck;//�S�x�b�ɮפ������ޭ�
	private String Target = "�E�����s"; //�ؼ�
	private String FileInPath;//��l�ɮ׸��|
	private String FileoutPath = "Hos_Data\\Doc_Train\\Feature\\";//��X�ɮ׸��|
	private String FileName;//�ɮצW��
	private String aDelimiter = ",";
	private String line = null;
	
	
	public FeatureSave(ArrayList<Integer> Feature, String Path, String Name){
		System.out.println("�պնǶi�Ӫ�"+Feature);
		System.out.println(Path.substring(25,Path.length()));
		System.out.println(Path);
		
		FileoutPath = FileoutPath + Path.substring(25,30);
		if(Feature.contains(36)){
			
			Feature.remove(Feature.get(Feature.indexOf(36)));
			
		}
		for(int i =0;i<Feature.size();i++){
			Feature.set(i, Feature.get(i)+37);//���s���N(�ҭn�����b��37��)
		}
		System.out.println("�պ�+37�᪺"+Feature);
		
		/*�x�s�ҿ�S�x��츹�X*/
		try{
		BufferedWriter TTC = new BufferedWriter(new FileWriter(FileoutPath + Name.replace(".csv",".txt")));
			for(int i =0;i<Feature.size();i++){
				System.out.println("write "+Feature);
				TTC.write(Feature.get(i).toString());
				TTC.write("\n");
			}
			TTC.close();
		}catch(IOException e){}
		/*�x�s�ҿ�S�x��츹�X*/
		FeatureCheck = Feature;
		FeatureCheck.add(36);
		//Collections.sort(FeatureCheck);
		System.out.println("�a����"+Feature);
		
		FileInPath = Path;
		FileName = Name;
		try{
			WriteFile();
		}catch(IOException  e){
			System.out.println("File not found");
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
		
		bw.close();
	}
	
	public String getOutPath(){
		System.out.println("���a�����̫��ɮ׸��|"+FileoutPath+FileName);
		return FileoutPath+FileName;
	}
}