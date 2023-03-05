#include <string>
#include <vector>
#include <cmath>
#include <iostream>
using namespace std;

string solution(string bin1, string bin2) {
    string answer = "";
    int idx1 = bin1.size()-1;
    int idx2 = bin2.size()-1;
    bool counter = false;
    
    while(idx1 >= 0 && idx2 >= 0)
    {
        if(bin1[idx1]== bin2[idx2])
        {
            if(counter) answer = "1" + answer;
            else        answer = "0" + answer;
            
            if(bin1[idx1]-'0' == 1 || bin2[idx2]-'0' == 1) counter = true;
            else counter = false;
        }
        else
        {
            if(counter) 
            {
                answer = "0" + answer;
                counter = true;
            }
            else
            {
                answer = "1" + answer;
                counter = false;
            }
        }
        idx1--;
        idx2--;
    }
    while(idx1 >=0)
    {
        if(counter)
        {
            if(bin1[idx1] - '0' == 0)
            {
                answer = "1" + answer;
                counter = false;
            }
            else
            {
                answer = "0" + answer;
                counter = true;
            }
        }
        else
        {
            answer = bin1[idx1]+ answer;
        }
        idx1--;
    }
    while(idx2 >=0)
    {
        if(counter)
        {
            if(bin2[idx2] - '0' == 0)
            {
                answer = "1" + answer;
                counter = false;
            }
            else
            {
                answer = "0" + answer;
                counter = true;
            }        }
        else answer = bin2[idx2]+ answer;
            
        idx2--;
    }
    if(counter)
        answer = "1" + answer;
        
    return answer;
}


// int bin2dec(string bin)
// {
//     int dec = 0;
//     int size = bin.size()-1;
//     for(int i=size;i>=0;i--)
//     {
//         if(bin[i]=='1')
//             dec+=pow(2,size - i);
//     }
//     return dec;
// }

// string dec2bin(int dec)
// {
//     string bin = "";
//     while(dec > 0)
//     {
//         if(dec%2 != 0) bin = "1" + bin;
//         else bin = "0" + bin;
//         dec /= 2;
//     }
//     if(bin == "")
//         bin += "0";
//     return bin;
// }


// string solution(string bin1, string bin2) {
//     string answer = "";
//     answer += dec2bin(bin2dec(bin1) + bin2dec(bin2));
//     return answer;
// }


/*

9
1001

9 - 4 - 2 - 1 
    "1001"
*/