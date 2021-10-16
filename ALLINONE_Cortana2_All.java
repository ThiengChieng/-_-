import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.nio.*;
import nl.liacs.subdisc.*;
import nl.liacs.subdisc.gui.*;
import nl.liacs.subdisc.gui.MiningWindow;
import nl.liacs.subdisc.FileHandler.Action;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ALLINONE_Cortana2_All{
	private String saveFilePath;
	private String ctojava = "ctojava";
	private String FilePath;
	private String UrlPath;
	private File file;
	private String[] FileName;//�Ҧ��M�~�P�ഫ�ɮצW��
	private String EndofFile = ".csv";
	
	public ALLINONE_Cortana2_All(){
		int wa = 0,fa = 0,last = 0;
		
		try{
			InputStreamReader ctoj = new InputStreamReader(new FileInputStream(ctojava));//Ū���M�~�P�ഫ��Ƨ����|
			BufferedReader ctojavaReader = new BufferedReader(ctoj);
			UrlPath = ctojavaReader.readLine();
			
		}catch(IOException e){}
		
		file = new File(UrlPath);//�C�X�Ҧ��M�~�P�ഫ�ɮצW��
		FileName = file.list();
		FilePath = UrlPath + "\\";
		String year = "";
		String OutFilePath = "";
		last = FilePath.lastIndexOf("\\");
		year = FilePath.substring(last-4, last);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("_MMdd_HHmm_");
		OutFilePath = "Hos_Data\\Doc_Train\\Model\\" + year + "\\All" + dtf.format(LocalDateTime.now()) + "SubDisc\\";
//		wa = FilePath.indexOf("Wa_Ch");
//		fa = FilePath.indexOf("Feature");
		for(String Name:FileName){
			if(!(Name.endsWith(EndofFile))){
				continue;
			}
			File f1 = new File(FilePath + Name);
			//�]�w�ɮצ�m
			FileHandler aLoader = new FileHandler(f1);
			Table aTable = aLoader.getTable();
			SearchParameters aSearchParameters = aLoader.getSearchParameters();
			MiningWindow miningWindow;
			ResultWindow resultWindow;
			XMLAutoRun xmlAutoRun = new XMLAutoRun();
			//�ŧiŪ�ɡB�ت�B�j�M�ѼƻP�]�w�e��
			
			
			
			
			File OutPath = new File(OutFilePath);
			OutPath.mkdirs();
			
			
	//		File OutPath = new File("Hos_Data\\Doc_Train\\Model\\SubDisc\\");
	//		OutPath.mkdirs();
			
			saveFilePath = OutFilePath;
			//System.out.println(saveFilePath);

			boolean enable = false;
			for (int i = 0; i < aTable.getNrColumns(); i++)
				aTable.getColumn(i).setIsEnabled(enable);
			
			int[] ChangeAble = {36, 37, 38, 39, 40, 41, 42, 43, 44};
			enable = true;
			for (int i : ChangeAble)
				aTable.getColumn(i).setIsEnabled(enable);
			
			int[] ChangeType = {36, 37, 38, 39, 41, 42, 43, 44};
			for (int i : ChangeType)
				aTable.getColumn(i).setType(AttributeType.fromString("nominal"));
			
			if (aTable == null){
				System.out.println("1");
				miningWindow = new MiningWindow();
			}else if (aSearchParameters == null){
				System.out.println("T2");
				miningWindow = new MiningWindow(aTable);
			}else{
				System.out.println("T3");
				miningWindow = new MiningWindow(aTable, aSearchParameters);
			}	
			new MetaDataWindow(miningWindow, aTable);
			
			
			miningWindow.setQualityMeasureMinimum("0.002");
			miningWindow.setTargetAttribute("�E�����s");
			miningWindow.setMiscFieldName("10.0");
			xmlAutoRun.setClassValue(miningWindow.getMiscFieldName());
			System.out.println(miningWindow.getTargetAttributeName());
			
			miningWindow.subgroupDiscoveryActionPerformed();
			resultWindow = nl.liacs.subdisc.Process.getResultWindow();
			resultWindow.setPath(OutFilePath);
			resultWindow.jButtonSaveActionPerformed();
			
			miningWindow.setMiscFieldName("9.0");
			xmlAutoRun.setClassValue(miningWindow.getMiscFieldName());
			miningWindow.subgroupDiscoveryActionPerformed();
			resultWindow = nl.liacs.subdisc.Process.getResultWindow();
			resultWindow.setPath(OutFilePath);
			resultWindow.jButtonSaveActionPerformed();
			miningWindow.setMiscFieldName("8.0");
			xmlAutoRun.setClassValue(miningWindow.getMiscFieldName());
			miningWindow.subgroupDiscoveryActionPerformed();
			resultWindow = nl.liacs.subdisc.Process.getResultWindow();
			resultWindow.setPath(OutFilePath);
			resultWindow.jButtonSaveActionPerformed();
			xmlAutoRun.setFw(0);
		}
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter("javatoc2"));
			bw.write(OutFilePath);
			bw.close();
		}catch(IOException  e){}
		
	}
	public String getPath(){
		return saveFilePath;
	}

}