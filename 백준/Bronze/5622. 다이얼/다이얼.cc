#include <iostream>
#include <string> 
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	string s;
	int result = 0;
	getline(cin, s);
	for (int i = 0; i < s.length(); i++) {
		if (s[i] >= 'A' && s[i] <= 'R') { // 'S' 전까지
			result += (s[i] - 'A') / 3 + 3;
		}
		else if (s[i] == 'S') {
			result += 8;
		}
		else if (s[i] >= 'T' && s[i] <= 'V') {
			result += 9;
		}
		else if (s[i] >= 'W' && s[i] <= 'Z') {
			result += 10;
		}
	}
	cout << result;

	return 0;
}
