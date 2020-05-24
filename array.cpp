#include <bits/stdc++.h>
using namespace std;


bool compare(int a , int b)
{
  return a > b;
}

int main()
{
  int n;
  std::cout << "Enter the size of array : " << '\n';
  std::cin >> n;
  int array[n];
  std::cout << "Enter elements in array : " << '\n';
  for(int i = 0; i < n; i++)
  {
    std::cin >> array[i];
  }
  sort(array, array + n);
  std::cout << "Sorting in array gives : " << '\n';
  for(int i = 0; i < n; i++)
    std::cout << array[i] << ", ";
  std::cout << "" << '\n';

  sort(array, array + n, compare);
  std::cout << "Reverse Sorting in array gives : " << '\n';
  for(int i = 0; i < n; i++)
    std::cout << array[i] << ", ";
  std::cout << "" << '\n';


}
