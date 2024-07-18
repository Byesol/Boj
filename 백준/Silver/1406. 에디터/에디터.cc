#include <iostream>
#include <stack>
#include <string>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    string s;
    stack<char> left;
    stack<char> right;
    cin >> s;
    int n;
    cin >> n;
    for (char ch : s) {
        left.push(ch);
    }

    for (int i = 0; i < n; i++) {
        char command;
        cin >> command;
        if (command == 'L') {
            if (!left.empty()) { // 왼쪽 스택이 비어있지 않은 경우에만
                right.push(left.top());
                left.pop();
            }
        } else if (command == 'D') {
            if (!right.empty()) { // 오른쪽 스택이 비어있지 않은 경우에만
                left.push(right.top());
                right.pop();
            }
        } else if (command == 'B') {
            if (!left.empty()) { // 왼쪽 스택이 비어있지 않은 경우에만
                left.pop();
            }
        } else if (command == 'P') {
            char c;
            cin >> c;
            left.push(c);
        }
    }

    // left 스택의 요소들을 right 스택으로 옮기면서 순서를 반전시킵니다.
    while (!left.empty()) {
        right.push(left.top());
        left.pop();
    }

    // right 스택의 모든 요소를 출력합니다.
    while (!right.empty()) {
        cout << right.top();
        right.pop();
    }

    return 0;
}
