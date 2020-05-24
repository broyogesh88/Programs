#include <bits/stdc++.h>
using namespace std;

int main()
{
  int n;
  std::cout << "Enter the size of vector: " << '\n';
  std::cin >> n;
  vector<int> v;
  std::cout << "Enter elements in vetor : " << '\n';
  for(int i = 0; i < n; i++)
  {
    int num;
    std::cin >> num;
    v.push_back(num);
  }


  sort(v.begin(), v.end());
  std::cout << "Sorting in vector gives : " << '\n';
  for(int i = 0; i < n; i++)
    std::cout << v[i] << ", ";

  sort(v.rbegin(), v.rend());
  std::cout << "\nReverse Sort in vector gives : " << '\n';
  for(int i = 0; i < n; i++)
    std::cout << v[i] << ", ";
  std::cout << "" << '\n';
}
