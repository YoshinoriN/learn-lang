#include<iostream>
#include<string>

using namespace std;

int main(){
    int h, m, s, input;
    cin >> input;

    h = input / 3600;
    m = (input - h * 3600) / 60;
    s = (input - h * 3600) % 60;

    string x = to_string(h) + ":" + to_string(m) + ":" + to_string(s);
    std::cout << x <<std::endl;
    return 0;
}
