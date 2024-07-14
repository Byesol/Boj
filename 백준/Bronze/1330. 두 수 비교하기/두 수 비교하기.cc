#include <iostream>
#include <cstring> // strcpy 함수를 사용하기 위해 추가
using namespace std;

int main() {
	int a, b;
	cin >> a >> b; // 사용자로부터 a와 b 입력 받음
	char c[10]; // 문자열을 저장할 배열

	if (a > b)
		strcpy(c, ">"); // 문자열을 배열에 복사
	else if (a == b)
		strcpy(c, "==");
	else
		strcpy(c, "<");

	cout << c; // 결과 출력
	return 0;
}