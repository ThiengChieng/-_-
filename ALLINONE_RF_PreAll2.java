import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
import java.lang.ProcessBuilder;
 
public class ALLINONE_RF_PreAll2{
	
	public ALLINONE_RF_PreAll2() {
	
		  try {
			System.out.println("������w���H���˪L");
			ProcessBuilder builder = new ProcessBuilder("python", "RF_PredictAll3.py");
			builder.redirectErrorStream(true);
			Process proc = builder.start();
			
			InputStream fis=proc.getInputStream();
			//���~�y

			InputStreamReader isr=new InputStreamReader(fis);
			//�νw�R��Ū��
			BufferedReader br=new BufferedReader(isr);
			String line=null;
			//����Ū������
			while((line=br.readLine())!=null) {
			//���i��o�ͪ��몺���D
					//System.out.println("return input Str:" + line);
			}

			int exitVal = proc.waitFor();
			System.out.println("exitVal:" + exitVal);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
