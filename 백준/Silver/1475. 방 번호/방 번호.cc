#include <iostream>
#include <string> 
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	string s;
	cin >> s;
	int freq[9] = {};
	for (int i = 0; i < s.size(); i++) {
		if (s[i] != '9') {
			freq[s[i] - '0']++;
		}
		else freq[6]++;		

		
	}
	int max = 0;
	freq[6] = (freq[6]+1) / 2;
	for (int i = 0; i < 9; i++) {
		//cout << freq[i] << " ";
		if (freq[i] > max) {
			max = freq[i];
		}
	}
	cout << max;


	return 0;
}
