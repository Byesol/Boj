#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	int year;
	scanf("%d", &year);
	int isyear;
	int c1 = (year % 4 == 0) & (year % 100 != 0);
	int c2 = (year % 400 == 0);
	if (c1 | c2) {
		printf("1");
	}

	else {
		printf("0");
	}
	return 0;
}