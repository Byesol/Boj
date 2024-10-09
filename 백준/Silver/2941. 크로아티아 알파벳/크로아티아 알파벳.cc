#include <iostream>
#include <string> 
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	string s;
	cin >> s;
	string scro[8] = { "c=","c-","dz=","d-","lj","nj","s=","z=" };
	int snum[8] = { 1,1,1,1,1,1,1,1 };
	int clength = 0;
	int ccount = 0;
	for (int i = 0; i < s.length(); i++) {
		
		for (int j = 0; j < 8; j++) {
			int k;
			int icopy = i;
			for ( k = 0; k < scro[j].length(); k++) {
				
				if (scro[j][k] != s[icopy]) {
					break;
				}
				icopy++;
				
			}
			if (k == scro[j].length()) {
				ccount += snum[j];
				clength += scro[j].length();
				i += scro[j].length()-1 ;
				break; //dz에 대해
			}
		}
	}
	cout<<s.length() - clength + ccount<<endl;
	//cout << ccount <<" " << clength << endl;
	return 0;
}
