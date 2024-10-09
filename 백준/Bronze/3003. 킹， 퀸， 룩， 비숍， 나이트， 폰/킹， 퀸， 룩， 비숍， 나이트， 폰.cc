#include <iostream>
#include <string> 
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int chess[] = { 1,1,2,2,2,8 };
	int chess2[6] = {};
	for (int i = 0; i < 6; i++) {
		cin >> chess2[i];
		cout << chess[i] - chess2[i] << " ";
	}


	return 0;
}
