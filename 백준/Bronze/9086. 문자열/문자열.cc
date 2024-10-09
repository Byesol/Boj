#include <iostream>
#include <string>
using namespace std;


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		string s;
		cin >> s;
		int slen = s.length();
		cout << s[0] << s[slen - 1]<<"\n";
	}
	
	



	return 0;
}