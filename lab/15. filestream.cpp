#include <iostream>
#include <fstream>
#include <string>

using namespace std;

void f()
{
    string line;
    while(getline(cin, line))  //input from the file in.txt
    {
        cout << line << "\n";   //output to the file out.txt
    }
}

int main()
{
    ifstream in("in.txt");
    streambuf *cinbuf = cin.rdbuf(); //save old buf
    cin.rdbuf(in.rdbuf()); //redirect cin to in.txt!

    ofstream out("out.txt");
    streambuf *coutbuf = cout.rdbuf(); //save old buf
    cout.rdbuf(out.rdbuf()); //redirect cout to out.txt!

    string word;
    cin >> word;           //input from the file in.txt
    cout << word << "  ";  //output to the file out.txt

    f(); //call function


    cin.rdbuf(cinbuf);   //reset to standard input again
    cout.rdbuf(coutbuf); //reset to standard output again

    cin >> word;   //input from the standard input
    cout << word;  //output to the standard input

    return 0;
}
