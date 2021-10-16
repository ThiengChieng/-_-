#include<iostream>
#include<fstream>
#include<vector>
#include<string>
#include<sstream>
#include<algorithm>
#include<cmath>
using namespace std;

bool cmp1(const vector<string> &a, const vector<string> &b){
	if(a[0] != b[0]){
		return a[0] < b[0];
	}
	if(a[24] != b[24]){
		return a[24] < b[24];
	}
}

long double average(long double sum, int n){
	return sum/n;
}

long double sd(long double ave, vector<long double> SDTime){
	
	long double sum = 0.0;
	
	for(int i = 0; i < SDTime.size(); i++){
		sum += ((SDTime[i] - ave) * (SDTime[i] - ave));
	}
	sum = sum / SDTime.size();
	sum = sqrt(sum);
	return sum;
}

int CaculateWeekDay(int y, int m, int d){
	if (m == 1 || m == 2){
		m += 12;
		y--;
	}
	int iWeek = (d + 2 * m + 3 * (m + 1) / 5 + y + y / 4 - y / 100 + y / 400) % 7;
	return iWeek+1;
}

int main(int argc, char const *argv[]){
	string CutPath = "";//�n�M�~���ɮ׸��|
	string FileYear = "";//�ɮצ~��
	vector<string> FileName;//�ɮצW��
	
    fstream SourceTxt("javatoc", ios::in);//�}��txtŪ���ɮ׸��| 
	getline(SourceTxt, CutPath);//��o���| 
	cout<<CutPath<<endl;
	int Position = CutPath.rfind('\\', CutPath.size());
	for(int i = Position - 4; i < Position; i++){
		FileYear += CutPath[i];
	}
	
	
	string listPath ="dir " + CutPath + " /b /on >list.txt";//�C�X�nŪ�����ɮצW��
	cout<<listPath.c_str()<<endl;
	system(listPath.c_str());
    fstream f("list.txt", ios::in);//�}�ҭnŪ���ɮצW�٪��ɮ� 
    
    for(string s;f >> s;) {
        FileName.push_back(s);
    }//�[�JFileName����C
    
    for(int ii = 0; ii < FileName.size(); ii++){
    	string FilePath = CutPath + "\\" + FileName[ii];
		fstream Doc(FilePath, ios::in);//�}�Ҹ��ɮ�
		stringstream ss;
		string TempContent;
		vector<vector<string>> FileContent;
		
		while(getline(Doc, TempContent)){
			ss << TempContent;
			vector<string> RowContent;
			string s;
			//cout<<TempContent<<endl;
			for(int i = 0; getline(ss, s, ','); i++){
				RowContent.push_back(s);
			}
			FileContent.push_back(RowContent);
			ss.str("");
			ss.clear();
			
		}//�v��Ū��Doc�ɮפ��e�A�N�C��Column���}��A�[�JFileContent
		
		if(FileContent.size() != 1){
			
			vector<vector<string>>::iterator it;
			for(it = FileContent.begin(); it < FileContent.end(); it++){
				if(it == FileContent.begin() && (*it)[0] != (*(it+1))[0]){
					FileContent.erase(it);
					it == FileContent.begin();
					if(FileContent.size() == 1){
						FileContent.erase(it);
						break;
					}
					it--;
				}else if(it == FileContent.end()-1 && (*it)[0] != (*(it-1))[0]){
					FileContent.erase(it);
					
				}else if(it != FileContent.end()-1 && (*it)[0] != (*(it+1))[0] && (*it)[0] != (*(it-1))[0]){
					FileContent.erase(it);
					it--;
				}
			}
		}else{
			vector<vector<string>>::iterator it = FileContent.begin();
			FileContent.erase(it);			
		}/*�Y�ɮפ��e�u���@���A�h�����R��
			�Y�W�L�@���A�}�l�P�_�O�_�����ݶE�A
			�Y�Ĥ@���Y�����ݶE�A�h�R���᭫�Y�}�l
			��l�h�R�����~��C*/ 
		if(FileContent.size() == 0){
			continue;
		}
		
		sort(FileContent.begin(), FileContent.end(), cmp1);//�ƧǬݶE��� 
		
		/*long double SumForAve = 0.0;
		long double AverageTime = 0.0;
		long double SD;
		vector<long double> SDTime;
		for(int i = 0; i < FileContent.size(); i++){
		
			if(FileContent[i][34] >  FileContent[i][24]){
				FileContent[i].push_back("0");
				SDTime.push_back(0.0);
				continue;
			}
			stringstream DtoS,AP,AC;
			string APT,ACT,STotalTime;
			long double APA[3] = {0.0};
			long double ACA[3] = {0.0};
			long double DTotalTime;
			AP << FileContent[i][34];
			AC << FileContent[i][24];
			
			for(int j = 0; j < 3; j++){
				getline(AP, APT, ':');
				getline(AC, ACT, ':');
				APA[j] = stod(APT);
				ACA[j] = stod(ACT);
			}
			
			DTotalTime = (ACA[0] - APA[0]) * 60 + (ACA[1] - APA[1]) + (ACA[2] - APA[2]) / 60;
			DtoS << DTotalTime;
			DtoS >> STotalTime;
			FileContent[i].push_back(STotalTime);
			
			SumForAve += DTotalTime;
			SDTime.push_back(DTotalTime);
		}//�p�ⵥ�ݮɶ�&������ 
		AverageTime = average(SumForAve,FileContent.size());//������ 
		SD = sd(AverageTime, SDTime);//�зǮt*/ 
		
		//�E���ɶ��p��}�l 
		vector<long double> DocTime;
		long double SumOfDoc = 0.0;
		long double DocAverageTime = 0.0;
		long double DocSD = 0.0;
		for(int i = 0; i < FileContent.size(); i++){
			
			string DocIn, DocOut, NextDoc, DocWriteString;//DocIn = ���d DocOut = ��� NextDoc = �U�@�쪺���d 
			stringstream SDO,SDI,DocWrite;
			long double DO[3] = {0.0};//�����ഫ�᪺ DocOut
			long double DI[3] = {0.0};//�����ഫ�᪺ DocIn 
			long double DocTotal;
			
			if(i == FileContent.size()-1){
				FileContent[i].push_back("0");
				DocTime.push_back(0);
				break;
			}
			
			if(FileContent[i][0] == FileContent[i+1][0]){
				for(int j = 25; j < 34; j++){
					if(FileContent[i][j] == "00:00:00"){
						if(j == 25){
							DocOut = FileContent[i+1][24];
							break;
						}
						DocOut = FileContent[i][j-1];
						break;
					}else{
						DocOut = FileContent[i][33];
					}
				}
				
				DocIn = FileContent[i][24];
				NextDoc = FileContent[i+1][24];
				
				if(NextDoc <= DocOut){
					DocOut = NextDoc;
				}
				if(DocOut <= DocIn){
					DocOut = FileContent[i+1][24];
				}
				
				SDO << DocOut;
				SDI << DocIn;
				//cout<<"DocOut : "<<DocOut<<" DocIn : "<<DocIn<<endl;
				for(int j = 0; j < 3; j++){
					string I, O;
					getline(SDO, O, ':');
					getline(SDI, I, ':');
					//cout<<"O : "<<O<<" I : "<<I<<endl;
					DO[j] = stod(O);
					DI[j] = stod(I);
				}
				DocTotal = (DO[0] - DI[0]) * 60 + (DO[1] - DI[1]) + (DO[2] - DI[2]) / 60;
				DocWrite << DocTotal;
				DocWrite >> DocWriteString;
				FileContent[i].push_back(DocWriteString);
				DocTime.push_back(DocTotal);
				SumOfDoc += DocTotal;
			}else{
				FileContent[i].push_back("0");
				DocTime.push_back(0);
			}
		}
		
		DocAverageTime = average(SumOfDoc, FileContent.size());
		DocSD = sd(DocAverageTime, DocTime);
		//cout<<"�����G"<<DocAverageTime<<" �зǮt�G"<<DocSD<<endl; 
		long double Cluster[10] = {0.0};
		for(int i = 0; i < 10; i++){
			Cluster[i] = DocAverageTime + ((-2 + (i / 2.0)) * DocSD);
			//cout<<"Cluster "<<i<<" :"<<Cluster[i]<<endl;
		}
		for(int i = 0; i < FileContent.size(); i++){
			bool Flag = false;
			for(int j = 0; j < 9; j++){
				if(DocTime[i] <= Cluster[j]){
					FileContent[i].push_back(to_string(j+1));
					Flag = true;
					break;
				}
			}
			if(!Flag){
				FileContent[i].push_back(to_string(10));
			}
		}
		//�E���p�⵲��
		
		//�P���p��
		for(int i = 0; i < FileContent.size(); i++){
			int Week[3] = {0};
			int Age[3] = {0};
			int TheDay, year, month, day;
			stringstream WeekTrans, AgeTrans,tempS;
			WeekTrans << FileContent[i][0];
			AgeTrans << FileContent[i][7];
			for(int j = 0; j < 3; j++){
				string Wtemp = "";
				string Atemp = "";
				getline(WeekTrans, Wtemp, '-');
				getline(AgeTrans, Atemp, '-');
				tempS<<Wtemp;
				tempS>>Week[j];
				tempS.str("");
				tempS.clear();
				tempS<<Atemp;
				tempS>>Age[j];
				tempS.str("");
				tempS.clear();
			}
			TheDay = CaculateWeekDay(Week[0], Week[1], Week[2]);
			FileContent[i].push_back(to_string(TheDay));
			
			year = Week[0] - Age[0];
			month = Week[1] - Age[1];
			day = Week[2] - Age[2];
			
			if(month < 0){
				year -= 1; 
			}else if(month == 0){
				if(day < 0){
					year -= 1;
				}
			}
			
			if(year <= 6){
				FileContent[i].push_back("1");
			}else if(year >= 7 && year <= 17){
				FileContent[i].push_back("2");
			}else if(year >= 18 && year <= 65){
				FileContent[i].push_back("3");
			}else if(year >= 66 && year <= 79){
				FileContent[i].push_back("4");
			}else if(year >= 80 && year <= 99){
				FileContent[i].push_back("5");
			}else if(year >= 100){
				FileContent[i].push_back("6");
			}	 
		} 
		
		//���ȶE&��ڬݶE����&�������O 
		double SeeDocOrder = 0.1;
		for(int i = 0; i < FileContent.size(); i++){
			//���ȶE 
			if(FileContent[i][11] == "A"){
				FileContent[i].push_back("1");
			}else{
				FileContent[i].push_back("2");
			}
			
			//�ݶE����
			FileContent[i].push_back(to_string(SeeDocOrder));
			SeeDocOrder += 0.1;
			if(i+1 != FileContent.size() && FileContent[i][0] != FileContent[i+1][0]){
				SeeDocOrder = 1;
			}
			
			//�������O 
			char Oringin = FileContent[i][8][0];
			switch(Oringin){
				
				case 'W':
					FileContent[i].push_back("9");
					break;
				
				case 'E':
					FileContent[i].push_back("10");
					break;
				
				case 'O':
					FileContent[i].push_back("11");
					break;
					
				case 'G':
					FileContent[i].push_back("12");
					break;
				
				case 'S':
					FileContent[i].push_back("13");
					break;
				
				case 'I':
					FileContent[i].push_back("14");
					break;
				
				case 'J':
					FileContent[i].push_back("15");
					break;
				
				case 'K':
					FileContent[i].push_back("16");
					break;
				
				case 'U':
					FileContent[i].push_back("17");
					break;
				
				case 'H':
					FileContent[i].push_back("18");
					break;
				
				case 'F':
					FileContent[i].push_back("19");
					break;
					
				case 'V':
					FileContent[i].push_back("20");
					break;
				
				case 'X':
					FileContent[i].push_back("21");
					break;
				
				case 'Y':
					FileContent[i].push_back("22");
					break;
				
				case 'Z':
					FileContent[i].push_back("23");
					break;
				
				case 'C':
					FileContent[i].push_back("24");
					break;
					
				case 'Q':
					FileContent[i].push_back("25");
					break;
				
				default:
					FileContent[i].push_back(FileContent[i][8]);
			}
			
			//�ʧO
			if(FileContent[i][6] == "M"){
				FileContent[i].push_back("0");
			}else{
				FileContent[i].push_back("1");
			}
			
			//�e���O�_�ݶE
			if(FileContent[i][12] == "Y"){
				FileContent[i].push_back("1");
			}else{
				FileContent[i].push_back("0");
			}
			
			//��ƶE 
			if(FileContent[i][9] == "Y"){
				FileContent[i].push_back("1");
			}else{
				FileContent[i].push_back("0");
			}  
		} 
		 
		string name = FileName[ii];
		string C_name = FileName[ii];
		string OutPath = "Hos_Data\\Doc_Train\\Wa_Ch\\" + FileYear;
		string DirPath = "mkdir " + OutPath;
		system(DirPath.c_str());
		C_name.replace(4,C_name.size(),"_Cluster.txt");
		//����ɮצW��
		 
		string OutFilePath = OutPath + "\\" + name;
		string C_OutFilePath = OutPath + "\\" + C_name;
		
		fstream OutFile(OutFilePath, ios::out);
		fstream C_OutFile(C_OutFilePath, ios::out);
		
		
		string Title = "�ݶE���,�ݶE��O,�ݶE�E��,�f����,��v�d��,��E�@�z�v�d��,�f�w�ʧO,�f�w�X�ͤ��,�������O,��ƶE,�����Ǹ�,�Z�O���ȶE,�e���O�_�}������,�E�_�X1,�E�_�X2,�E�_�X3,�E�_�X4,�E�_�X5,�E�_�X6,�E�_�X7,�E�_�X8,�E�_�X9,�E�_�X10,�ۧU���촡�d�ɶ�,��v���d�ɶ�,��v����ɶ�1,��v����ɶ�2,��v����ɶ�3,��v����ɶ�4,��v����ɶ�5,��v����ɶ�6,��v����ɶ�7,��v����ɶ�8,��v����ɶ�9,�w���ݶE�ɶ�,�E���ɶ�,�E�����s,�ݶE�P��,�f�w�~��,�Z�O���ȶE_�ഫ,��ڬݶE����,�������O_�ഫ,�f�w�ʧO_�ഫ,�e���O�_�}������_�ഫ,��ƶE_�ഫ";
		
		OutFile << Title << '\n';
		for(int i = 0; i < FileContent.size(); i++){
			string out ="";
			for(int j = 0; j < FileContent[i].size(); j++){
				if(j == FileContent[i].size()-1){
					out += FileContent[i][j];
				}else{
					out = out + FileContent[i][j] +',';
				}
			}
			OutFile << out << '\n';
		}
		OutFile.close();
		
		for(int i = 0; i < sizeof(Cluster)/sizeof(Cluster[0]); i++){
			C_OutFile<<Cluster[i]<<endl;
		}
		C_OutFile.close();
		
		//�N�M�~�n�����e���V01 
		//cout<<FileName[ii]<<" Done"<<" Ave: "<<DocAverageTime<<" SD: "<<DocSD<<endl;
	}
	//cout<<"123";
	
	
	//��ܤw�������ɮ�
	string OutPath = "Hos_Data\\Doc_Train\\Wa_Ch\\" + FileYear; 
	fstream CtoJava("ctojava",ios::out);
	CtoJava<<OutPath<<"\n";
	CtoJava.close();
	//cout<<OutPath;
    return 0;
}
