#include <bits/stdc++.h>
using namespace std;

bool comp(char a, char b)
{
  return a > b;
}

int main()
{
  string str;
  std::cout << "Enter String: " << '\n';
  getline(cin, str);

  sort(str.begin(), str.end(), comp);

  cout << str << "\n";

  vector<int> v(10, 5);

  for (auto x : v) {
      cout << x << "\n";
  }

  std::cout << "Enter the size of array: " << '\n';
  int n;
  std::cin >> n;
  int array[n];
  for(int i = 0; i < n; i++)
    cin >> array[i];

  sort(array, array + n);

  for(int i = 0; i < n; i++)
    std::cout << array[i] << '\n';
}
