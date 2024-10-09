#include <iostream>
#include <string> 
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	string s;
	string s1, s2;
	
	getline(cin, s);
	int index;
	index = s.find(' ');
	s1 = s.substr( 0,3);
	s2 = s.substr(index + 1);
	//ut << s1 << s2;
	
	swap(s1[0], s1[2]);
	swap(s2[0], s2[2]);
	int num1 = stoi(s1);
	int num2 = stoi(s2);
	int result;
	result = (num1 > num2) ? num1 : num2;
	cout << result;
	

	return 0;
}