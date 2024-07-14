#include <iostream>
#include <string> 
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	string s;
	int n;
	int count = 0;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> s;
		char check;
		check = s[0];
		int slen = s.length();
		bool isgropup = true;
		for (int i = 0; i < slen; i++) {
			if (s[i] == check) {
				continue;
			}
			else {
				for (int j = 0; j < i; j++) {
					if (s[j] == s[i]) {
						isgropup = false;
					}
				}
				check = s[i];
			}
		}
		//cout << isgropup<<endl;
		count += isgropup;

	}
	cout << count;

}
