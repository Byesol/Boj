#include <iostream>
#include <string> 
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	string s;
	int count=0;
	getline(cin,s);
	
	for (int i = 0; i < s.length(); i++) {
		if (s[i] != ' ') {
			count++;
			while (s[i] != ' '&&i<s.length()) {
				i++;
			}
		}
	}
	cout << count;


	return 0;
}