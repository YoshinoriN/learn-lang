#include<iostream>

using namespace std;

int main(){
    int a, b;
    cin >> a >> b;

    if (a < b) {
        std::cout << "a < b" <<std::endl;
    } else if (a > b) {
        std::cout << "a > b" <<std::endl;
    } else {
        std::cout << "a == b" <<std::endl;
    }
    return 0;
}
