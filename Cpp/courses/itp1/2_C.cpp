#include<iostream>

using namespace std;

int main(){
    int a, b, c;
    cin >> a >> b >> c;
    if (a > b) {
        swap(a, b);
    }
    if (b > c) {
        swap(b, c);
    }
    if (a > b) {
        swap(a, b);
    }
    std::cout << a << ' ' << b << ' ' << c <<std::endl;
    return 0;
}
