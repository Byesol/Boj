#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

int isCorrectFormat();
int calculate();

// 스택 정의
/*typedef struct {
    int data[31];
    int top;
} Stack;*/
typedef struct Node {
    int data;
    struct Node* link;
}Node;

typedef struct {
    Node* top;
}Stack;

int is_empty(Stack* s) {
    return (s->top == NULL);
}

void push(Stack* s, int item) {
    Node* temp = (Node*)malloc(sizeof(Node));
    temp->data = item;
    temp->link = s->top;
    s->top = temp;
}
int pop(Stack* s) {
    if (is_empty(s)) {

        return 0;
    }
    else {
        Node* temp = s->top;
        int data = temp->data;
        s->top = s->top->link;
        free(temp);
        return data;
    }
}
// 스택에 새로운 element를 넣는 함수
/*void push(Stack* stack, int bracket) {
    stack->elements[++(stack->top)] = bracket;
}

// 스택에서 제일 위에 위치한 element를 빼는 함수
int pop(Stack* stack) {
    return stack->elements[(stack->top)--];
}

Stack stack; // 계산을 위해 사용할 스택
char input[31];
int length; // 괄호열의 길이
*/

#define ROUND -1 // 둥근 괄호 ()
#define ANGLED -2 // 각진 괄호 []
Stack stack;
char input[100];
int length;
int  main() {

    stack.top = -1; // 스택을 초기화
    scanf("%s", input);
    length = strlen(input);

    if (isCorrectFormat(input, length) == 0) { // 입력 받은 괄호열이 올바른 형식이 아니면
        printf("0\n"); // 0를 출력
    }
    else { // 입력 받은 괄호열이 올바른 형식이라면
        printf("%d\n", calculate()); // 계산한 값을 출력
    }

    return 0;
}

// 괄호열이 올바른 형식인지 검사하는 함수
int isCorrectFormat() {
    for (int i = 0; i < length; i++) { // 괄호열 길이 만큼 반복
        switch (input[i]) {
        case '(': // 여는 둥근 괄호
            push(&stack, ROUND); // 스택에 넣는다
            break;
        case '[': // 여는 각진 괄호
            push(&stack, ANGLED); // 스택에 넣는다
            break;
        case ')': // 닫는 등근 괄호
            if (stack.top == -1) // 스택이 비었다면 ')' 괄호와 짝인 '(' 괄호가 없다는 것이기 때문에
                return 0; // 올바르지 않은 괄호열로 판단하고 검사 종료
            if (pop(&stack) != ROUND)
                return 0;
            break;
        case ']': // 닫는 각진 괄호
            if (stack.top == -1) // 스택이 비었다면 ']' 괄호와 짝인 '[' 괄호가 없다는 것이기 때문에
                return 0; // 올바르지 않은 괄호열로 판단하고 검사 종료
            if (pop(&stack) != ANGLED)
                return 0;
            break;
        }
    }
    if (stack.top != -1)  // 아직 남아있는 괄호열이 있다면 짝없는 괄호가 존재하는 것이기 때문에
        return 0; // 올바르지 않은 괄호열로 판단하고 검사 종료
    return 1; // 올바른 괄호열로 판단하고 검사 종료
}

// 괄호열의 값을 계산하는 함수
int calculate() {
    int sum, tem;
    for (int i = 0; i < length; i++) { // 괄호열 길이 만큼 반복
        sum = 0;
        switch (input[i]) {
        case '(': // 여는 둥근 괄호
            push(&stack, ROUND); // 스택에 넣는다
            break;
        case '[': // 여는 각진 괄호
            push(&stack, ANGLED); // 스택에 넣는다
            break;
        case ')': // 닫는 등근 괄호
            while ((tem = pop(&stack)) != ROUND) { // '(' 괄호가 나올 때까지 element를 빼서
                sum += tem; // 전부 더한다
            }
            if (sum == 0) // 숫자가 하나도 없었고 바로 '(' 괄호가 나왔다면
                push(&stack, 2); // 스택에 2를 넣는다
            else // 숫자가 있었다면
                push(&stack, sum * 2); // 숫자들의 합에 2을 곱한 값을 스택에 넣는다.
            break;
        case ']': // 닫는 각진 괄호
            while ((tem = pop(&stack)) != ANGLED) { // '[' 괄호가 나올 때까지 element를 빼서
                sum += tem; // 전부 더한다
            }
            if (sum == 0) // 숫자가 하나도 없었고 바로 '[' 괄호가 나왔다면
                push(&stack, 3); // 스택에 3를 넣는다
            else
                push(&stack, sum * 3); // 숫자들의 합에 3을 곱한 값을 스택에 넣는다.
            break;
        }
    }
    sum = 0;
    while (stack.top != -1) { // 스택에 모든 숫자들을
        sum += pop(&stack); // 더한다
    }
    return sum;
}