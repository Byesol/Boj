#include <iostream>
#include <string> 
#include <iomanip> 
using namespace std;

int main() {	
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	string s;
	cin >> s;
	int string_num[26] = { 0 };
	int slength = s.length();
	for (int i = 0; i < slength; i++) {
		int index = s[i] - 'a';
		//cout << index<< " ";
		string_num[index]++;
	}
	for (int i = 0; i < 26; i++) {
		cout << string_num[i] << " ";
	
	}
	return 0;
}
