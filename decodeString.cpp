#include <bits/stdc++.h>
using namespace std;

void decoding(string str, int m, int n);
void print(string c);
int main()
{
  std::cout << "Enter your data string : ";
  string str;
  std::cin >> str;
  int n = str.length();
  decoding(str, 0, n);
  return 0;
}

void decoding(string str, int m, int n)
{
  if(m >= n)
    return;
  else
  {
    print(to_string(str[m]));
    decoding(str, m + 1, n);
  }

}

void print(string c)
{
  if(strcmp(c,"1"))
    std::cout << "a" << '\n';
  else if( c == "2")
    std::cout << "b" << '\n';
  else
    std::cout << "c" << '\n';
}
