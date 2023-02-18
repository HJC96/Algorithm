#include <string>
#include <vector>
#include <map>
#include <iostream>
using namespace std;

bool solution(vector<string> phone_book) {
    map<string, int> hash;
    // make hash
    for(int i=0;i<phone_book.size();i++)
        hash[phone_book[i]] = i+1;
    
    for(int i=0; i<phone_book.size();i++)
    {
        for(int j=0; j<phone_book[i].size()-1;j++)
        {
            string phone_number = phone_book[i].substr(0,j+1);
            //cout << "phone_number: " <<  phone_number << endl;
            //cout << hash[phone_number] ;
            if(hash[phone_number])
                return false;
        }
    }
    return true;
}

// #include <string>
// #include <vector>
// #include <map>
// #include <iostream>
// #include <algorithm>
// using namespace std;

// bool solution(vector<string> phone_book) {
//     map<int, string> hash;
//     // 1. make hash
//     sort(phone_book.begin(), phone_book.end());
//     for(int i=0; i<phone_book.size();i++)
//         hash.insert(make_pair(i, phone_book[i]));

//     char first_char = hash[0][0];
//     int i = 0;
//     while(1)
//     { 
//         if(i == hash.size()-1)
//             break;
//         for(int j=i+1; j<hash.size();j++)
//         {
//             if(first_char == hash[j][0] )
//             {
//                 if(hash[j].find(hash[i]) == 0) // hash[i]를 포함하는지
//                     return false;
//             }
//             else
//             {
//                 first_char = hash[j][0];
//                 i = j;
//             }
//         }
//     }
    
//     return true;
// }