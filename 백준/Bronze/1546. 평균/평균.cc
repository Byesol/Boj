#include <iostream>
#include <cstring> 
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;
	float* array = new float[n];
	float max = -1;
	float result=0;
	for (int i = 0; i < n; i++) {
		cin >> array[i];
		if (max < array[i]) {
			max = array[i];
		}
	}
	for (int i = 0; i < n; i++) {
		array[i] = array[i] / max * 100;
		result += array[i];
	}
	result = result / n;
	cout << result;
	


	return 0;
}