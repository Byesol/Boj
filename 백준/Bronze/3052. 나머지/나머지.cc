#include <iostream>
#include <cstring> 
using namespace std;
#define length 42
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int array[length] = { 0 };
	int input;
	int count = 0;
	while (cin >> input) {
		int i = 0;
		array[input % 42] = 1;
	}	
	for (int i = 0; i < length; i++) {
		if (array[i] == 1) {
			count++;
		}
	}
	cout << count;
	
	return 0;
}