#include<iostream>
using namespace std;
int main(void)
{
	int val1, A, B;
	bool boola = true, boolb = true;
	std::cin >> val1;

	for (int i = (val1 / 5) ; i >0 ; i--)
	{
		if (val1 % 5 == 0 && boolb == true) {
			std::cout << (val1 / 5);
			boolb = false;
			boola = false;
			
		}
		else if ((val1 - 5 * i) % 3 == 0 && boolb == true){
			{
				std::cout << i + ((val1 - 5 * i) / 3);
				boola = false;
				boolb = false;
			}
		}
	}

	if (boola) {



		if (val1 % 3 == 0) {
			std::cout << (val1 / 3);
		}
		else 
		{
			std::cout << -1;
		}


	}
}