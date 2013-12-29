#include <iostream>
#include <string>
#include <fstream>
using namespace std;

int main()
{
	cout << "hello";
	ofstream myfile;
	myfile.open("example.txt");
	myfile << "hello there";
	myfile.close();
	return 0;
}
