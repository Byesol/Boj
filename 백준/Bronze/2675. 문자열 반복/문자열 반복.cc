#include <iostream>
#include <string> 
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		int rnum;
		string s;
		cin >> rnum >> s;
		for (int j = 0; j < s.length(); j++) {
			for (int k = 0; k < rnum; k++) {
				cout << s[j];
			}
		}
		cout << "\n";
	}
	


	return 0;
}