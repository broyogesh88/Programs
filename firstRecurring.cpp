#include <bits/stdc++.h>
using namespace std;

int main()
{
  string str;
  cin >> str;
  bool array[128];

  for(int i = 0; i < str.length(); i++)
  {
    if(array[str[i]])
    {
      std::cout << str[i] << '\n';
      break;
    }
    else
      array[str[i]] = true;
    if(i == str.length() - 1)
      std::cout << "-1" << '\n';
  }


}
