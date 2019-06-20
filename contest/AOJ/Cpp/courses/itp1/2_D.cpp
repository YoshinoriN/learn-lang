#include<iostream>

using namespace std;

int main(){
    int w, h, x, y ,r;
    cin >> w >> h >> x >> y >> r;
    if (x - r < 0 || x + r > w) {
        std::cout << "No" <<std::endl;
        return 0;
    }
    if (y - r < 0 || y + r > h) {
        std::cout << "No" <<std::endl;
        return 0;
    }
    std::cout << "Yes" <<std::endl;
    return 0;
}
