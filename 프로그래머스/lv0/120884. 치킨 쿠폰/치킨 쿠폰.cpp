#include <string>
#include <vector>

using namespace std;

int ChickenByCoupon = 0;
int coupon = 0;
void Count_Chicken(int chic)
{
    if(chic < 10)
        return;
    ChickenByCoupon += chic / 10;
    coupon = chic / 10;
    coupon += chic % 10;
    Count_Chicken(coupon);
    
}

// chic: 108
// coupo: 108 + 1
    
// chic 10
// couoon 10 +9


int solution(int chicken) {

    Count_Chicken(chicken);
    return ChickenByCoupon;
}


// 쿠폰으로 계산하는건 따로하면 될것 같은데..
