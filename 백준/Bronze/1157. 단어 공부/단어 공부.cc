#include <iostream>
#include <string> 
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	string s;
	cin >> s;
	int num1;
	num1 = ((int)'Z' - (int)'A'+1)*2;
	
	int* nums = new int[num1]();

	for (int i = 0; i < s.length(); i++) {
		if (s[i] <= 'Z') {
			int index = s[i] - 'A';
			nums[index]++;
			
		}
		else {
			int index = s[i] - 'a';
			nums[index]++;
		}
	}
	//max 찾기
	int max = -1;
	int mindex=-1;
	int issame=0;
	for (int i = 0; i < num1; i++) {
		if (max < nums[i]) {
			max = nums[i];
			mindex = i;
			issame = 0;
		}
		else if (max == nums[i]) {
			issame = 1;
		}
	}
	if (issame == 1) {
		cout << '?';
	}
	else {
		char a;
		mindex += 'A';
		cout << (char)mindex;
	}
	return 0;
}
