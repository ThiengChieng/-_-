import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.*;
 
public class featureexe {
	public featureexe(){
		System.out.println("���i�J�I�s");
		Process proc;
		try {
			//"python ./TARGET.py"         
			proc = Runtime.getRuntime().exec("python VarianceThreshold_ex.py");
			System.out.println("����I�s");
			BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String line = null;	
			while ((line = in.readLine()) != null) {
				System.out.println(line);
				
			}
			
			in.close();
			
			proc.waitFor();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	
	
	}
}
