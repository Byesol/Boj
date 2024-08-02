#include <iostream>
#include <cstring> 
using namespace std;

int main() {
	int a, b;
	cin >> a >> b; 
	int c;
	cin >> c;
	if (b + c >= 60) {
		int moc;
		moc = (b + c )/ 60;
		//cout << moc<<endl;
		a += moc;
		b = b + c - moc * 60;
	}
	else
		b += c;
	if (a > 23)
		a = a-24;

	cout << a << " " <<b; 
	return 0;
}