#include <iostream>
#include <vector>
#include <string>
#include <direct.h>
#include <fstream>
using namespace std;
string datadate;
class doctor {
	private:
		string doctorname;
		vector<string> doctordata;

	public:
		bool nameequal(string comparename) {
			return doctorname == comparename ? true : false;
		}
		void adddoctordata(string PatientRow) {
			doctordata.push_back(PatientRow);
		}
		string getdoctorname() {
			return doctorname;
		}
		void setname(string name) {
			doctorname = name;
		}
		void writefile(string filepath) {
			ofstream out((filepath + doctorname + ".csv").c_str());
			for (int i = 0; i < doctordata.size(); i++) {
				out << doctordata[i] << endl;
			}
			out.close();
			doctordata.clear();
		}
};
void readfile(string filepath) {
	int doctorindex; //?�Z?P?_?O?_???s???
	vector<doctor> doctorlist;
	doctorlist.clear(); //??l??

	ifstream in(filepath.c_str()); //?Nfilepath?????e??in(in???Vfilepath)

	if (!in) {
		//file not exist
		return;
	}
	string readline, name; //readline=???????? , name=?????W??
	string year;
	int posfirst, poslast, circle = 0;
	int ypostfirst = -1, yposlast = -1;
	string title = "�ݶE���,�ݶE��O,�ݶE�E��,�f����,��v�d��,��E�@�z�v�d��,�f�w�ʧO,�f�w�X�ͤ��,�������O,��ƶE,�����Ǹ�,�Z�O���ȶE,�e���O�_�}������,�E�_�X1,�E�_�X2,�E�_�X3,�E�_�X4,�E�_�X5,�E�_�X6,�E�_�X7,�E�_�X8,�E�_�X9,�E�_�X10,�ۧU���촡�d�ɶ�,��v���d�ɶ�,��v����ɶ�1,��v����ɶ�2,��v����ɶ�3,��v����ɶ�4,��v����ɶ�5,��v����ɶ�6,��v����ɶ�7,��v����ɶ�8,��v����ɶ�9,�w���ݶE�ɶ�";

	getline(in,readline);
	while (getline(in, readline)) {
		posfirst = 0, poslast = 0;
		if (ypostfirst == -1 && yposlast == -1) {
			ypostfirst = 0;
			yposlast = readline.find_first_of("-", ypostfirst + 1);
			year = readline.substr(ypostfirst, yposlast - ypostfirst);
		}
		for (int i = 0; i < 4; i++) {
			posfirst = readline.find_first_of(",", posfirst + 1); //�qposfirst+1����m�}�l�����','����m���ĥ|����쪺��m
		}
		poslast = readline.find_first_of(",", posfirst + 1);		  //�qposfirst+1����m�}�l�����','�����ު�
		name = readline.substr(posfirst + 1, poslast - posfirst - 1); //���ΦW�r
		doctorindex = -1;
		for (int i = 0; i < doctorlist.size(); i++) {
			if (doctorlist[i].getdoctorname() == name) {
				doctorlist[i].adddoctordata(readline);
				doctorindex = i;
				break;
			}
		}
		if (doctorindex == -1) {
			doctor d;
			d.setname(name);
			doctorindex = doctorlist.size();
			doctorlist.push_back(d);

			//?s?W
			doctorlist[doctorindex].adddoctordata(title);
			doctorlist[doctorindex].adddoctordata(readline);
		}
	}
	cout << year << endl;
	in.close();
	//string outfilepath = filepath.substr(0, filepath.find_last_of("\\")) + "\\V00\\";
	//string outfilepath = filepath.substr(0, filepath.find_last_of("\\")) + "\\Doc_Train\\Cut\\"+ year + "\\";
	string outfilepath = filepath.substr(0, filepath.find_last_of("\\")) + "\\Doc_Test\\";
	_mkdir(outfilepath.c_str());
	outfilepath += "Cut\\";
	_mkdir(outfilepath.c_str());
	outfilepath += year + "\\";
	_mkdir(outfilepath.c_str());
	
	fstream pathForJava("ctojava", ios::out);
	pathForJava<<outfilepath<<endl;
	pathForJava.close();
	
	for (int i = 0; i < doctorlist.size(); i++) {
		doctorlist[i].writefile(outfilepath);
	}
}
int main() {
	string input = "javatoc"; //input?�[????java???c?????
	fstream javatoc(input, ios::in);					   //???javatoc?o?????
	string filepath;
	javatoc >> filepath;
	cout << filepath << endl;

	readfile(filepath);
	//system("pause");
	//cout<<filepath;
	return 0;
}

