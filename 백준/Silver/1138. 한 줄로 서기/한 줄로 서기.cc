#include <iostream>
#include <vector>
using namespace std;


int main(void)
{
	int val1, arr[10] = { 0 };
	cin >> val1;
	for (int i = 0; i < val1; i++) {
		int count;
		cin >> count;

		for (int j = 0; j < val1; j++) {

			if (count == 0 && arr[j] == 0) {
				arr[j] = i + 1;
				break;
			}
			else if (arr[j] == 0)
				count--;
		}
	}
	for(int i=0; i<val1;i++)
	cout << arr[i]<< " ";

}