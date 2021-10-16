import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.nio.*;

public class FeatureSave2{
	private ArrayList<String> isaList;//�n�^�����S�x
	private ArrayList<String[]> TwoD = new ArrayList<String[]>();//��l�ɮפ��e
	private ArrayList<Integer> FeatureCheck = new ArrayList<Integer>();//�S�x�b�ɮפ������ޭ�
	private String Target = "�E�����s"; //�ؼ�
	private String FileInPath;//��l�ɮ׸��|
	private String FileoutPath = "Hos_Data\\Doc_Test\\Wa_Ch\\";//��X�ɮ׸��|
	private String mkFile = "Hos_Data\\Doc_Test\\Feature\\";//��X�ɮ׸��|
	private String FileName;//�ɮצW��
	private String aDelimiter = ",";
	private String line = null;
	
	private String NumPath;
	
	public FeatureSave2(String Path, String NumPath){
		FileoutPath = Path.replace("Wa_Ch", "Feature");
		System.out.println(FileoutPath);
		FileInPath = Path;
		this.NumPath = NumPath;
		System.out.println(this.NumPath);
		int position = Path.lastIndexOf("\\");
		FileName = Path.substring(position+1);
		mkFile = mkFile + Path.substring(position-4,position) + "\\";
		File mkFile2 = new File(mkFile);
		System.out.println("    " + mkFile);
		mkFile2.mkdirs();
		try{
			ReadFile();
			WriteFile();
		}catch(IOException  e){
			System.out.println("File not found");
		}
	}



	private void WriteFile() throws java.io.IOException{

		InputStreamReader DocFile = new InputStreamReader(new FileInputStream(FileInPath));//�ɮ�Ū�����|
		BufferedReader reader = new BufferedReader(DocFile);
		BufferedWriter bw = new BufferedWriter(new FileWriter(FileoutPath));//�ɮ׿�X���|
		System.out.println(FileoutPath);
		
			
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
	
	private void ReadFile() throws java.io.IOException{

		InputStreamReader DocFile = new InputStreamReader(new FileInputStream(NumPath));//�ɮ�Ū�����|
		BufferedReader reader = new BufferedReader(DocFile);		
			
		while((line = reader.readLine()) != null){
			System.out.println(line);
			int temp = Integer.valueOf(line);
			
			FeatureCheck.add(temp);
		}//�N�ɮפ��eŪ�J
		FeatureCheck.add(36);
	}
	
	public String getOutPath(){
		return FileoutPath;
	}
}