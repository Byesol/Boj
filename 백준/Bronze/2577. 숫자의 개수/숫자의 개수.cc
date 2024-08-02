#include <iostream>
#include <string> 
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int array[9] = {0};
	int a, b, c;
	int multi;
	cin >> a >> b >> c;
	multi = a * b*c;
	string s;
	int nfreq[10] = {};
	s = to_string(multi);
	for (int i = 0; i < s.length(); i++) {
		nfreq[s[i] - '0']++;
	}
	for (int i = 0; i < 10; i++) {
		cout << nfreq[i] << endl;
	}


	return 0;
}
