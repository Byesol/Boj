#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<string.h>
#define MAX 15000
typedef struct {
	int key;
	int iserror;
} element;

element stack[MAX];

int top = -1;
void push(element item) {
	if (top >= MAX - 1){
		//printf("stackfull\n");
		return;  // 스택이 가득 찼을 때 함수를 종료합니다.
	}
	stack[++top] = item;
}
element pop() {
	element error;
	error.key = 0;
	error.iserror = -1;
	if (top == -1) {
		return error;
	}
	return stack[top--];
}
int main() {
	int ordernum=0;
	int num;
	scanf("%d", &ordernum);
	
	for (int i = 0; i < ordernum; i++) {
		char order[50];

		scanf("%s", order);
		
		//printf("%s", order);
		//printf("%d\n", strcmp(order, "top"));
		if (!strcmp(order, "push")) {
			scanf("%d", &num);
			
			element pu;
			pu.key = num;
			pu.iserror = 0;
			push(pu);

		}
		else if (!strcmp(order, "pop")) {
			element output;
			output = pop();
			if (output.iserror == -1) {
				printf("-1\n");
			}
			else{
				printf("%d\n", output.key);
			}


		}
		else if (!strcmp(order, "top")) {
			if (top == -1) {
				printf("-1\n");
			}
			else {
				printf("%d\n", stack[top].key);
			}

		}
		else if (!strcmp(order, "size")) {
			printf("%d\n", top+1);

		}
		else if (!strcmp(order, "empty")) {
			//printf("%d", top);
			if (top == -1) {
				printf("1\n");
			}
			else {
				printf("0\n");
			}
			

		}
	}
	return 0;
}