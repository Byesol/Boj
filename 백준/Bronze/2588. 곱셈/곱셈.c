#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>


int main() {
	int a, b;
	int b1, b2, b3;
	scanf("%d", &a);
	scanf("%d", &b);
	b1 = b / 100;
	b2 = (b - b1 * 100) / 10;
	b3 = b - b1 * 100 - b2 * 10;
	//printf("%d %d %d\n", b1, b2, b3);
	printf("%d\n", a*b3);
	printf("%d\n", a*b2);
	printf("%d\n", a*b1);
	printf("%d\n", a*b);
	return 0;
}