#include <iostream>
#include <cstring> 
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	int findn;
	int countn = 0;
	cin >> n;
	int *array = new int[n];
	
	for (int i = 0; i < n; i++) {
		cin >> array[i];
		
	}
	cin >> findn;
	for (int i = 0; i < n; i++) {
		if (findn == array[i]) {
			countn++;
		}
	}
	cout << countn;




	return 0;
}