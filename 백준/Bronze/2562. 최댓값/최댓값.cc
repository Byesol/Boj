#include <iostream>
#include <cstring> 
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	int max;
	//cin >> n;
	int index=-1;
	n = 9;
	int *array = new int[n];

	for (int i = 0; i < n; i++) {
		cin >> array[i];
	}
	max = array[0];
	index = 0;
	for (int i = 1; i < n; i++) {
		if (array[i] > max) {
			max = array[i];
			index = i;
		}
	
	}
	cout << max << "\n" << index+1;

	return 0;
}