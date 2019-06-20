#include<iostream>
using namespace std;

int main(){
    int x;
    int cnt = 1;
    while (true) {
        cin >> x;
        if (x == 0) {
            break;
        }
        cout << "Case " << cnt << ": " << x << endl;
        cnt++;
    }
    return 0;
}
