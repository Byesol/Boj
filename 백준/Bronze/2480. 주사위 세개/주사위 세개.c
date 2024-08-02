#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	int d1, d2, d3;
	scanf("%d %d %d", &d1, &d2, &d3);

	if ((d1 == d2) & (d2 ==d3)) {
		printf("%d", 10000 + d2 * 1000);
	}
	else if ((d1 == d2) | (d2 == d3)) {
		printf("%d", 1000 + d2 * 100);
	}
	else if (d1 == d3) {
		printf("%d", 1000 + d1 * 100);
	}
	else {
		if ((d1 > d2)&(d1>d3)) {
			printf("%d", d1 * 100);

		}
		else if ((d2 > d1) & (d2 > d3)) {
			printf("%d", d2 * 100);

		}
		else {
			printf("%d", d3 * 100);
		}
	}
	return 0;
}