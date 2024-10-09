#include <iostream>
#include <cstring> 
using namespace std;
#define student 30
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int array[student] = { 0 };
	int input;
	while(cin>>input){
		array[input-1]=1;
	}

	for (int i = 0; i < student; i++) {
		if (array[i] == 0) {
			cout << i+1 << "\n";
		}
	}


	return 0;
}