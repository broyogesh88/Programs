#include <bits/stdc++.h>
using namespace std;

int main()
{
  int array[10];
  int countingArray[100];

  for(int i = 0; i < 100; i++)
    countingArray[i] = 0;

  cout << "Enter the elements of array : ";
  for(int i = 0; i < 10; i++)
    cin >> array[i];

  for(int i = 0; i < 10; i++)
    countingArray[array[i]]++;

  cout << "Sorted array is: ";
  for(int i = 0; i < 100; i++)
    while (countingArray[i] > 0) {
      cout << i << " ";
      countingArray[i]--;
    }


  return 0;
}
